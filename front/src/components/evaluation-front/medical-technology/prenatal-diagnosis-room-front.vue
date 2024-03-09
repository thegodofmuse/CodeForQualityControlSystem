<template>
  <div class="container">
    <div class="left">
      <form @submit.prevent="submitForm">
        <div class="form-group">
          <label for="selectInput">科室:</label>
          <select id="selectInput" v-model="form.select">
            <option disabled value="">请选择</option>
            <option value="产前诊断室">产前诊断室</option>
          </select>
        </div>

        <div class="form-group">
          <label for="dateInput">日期:</label>
          <input type="date" id="dateInput" v-model="form.date" required pattern="\d{4}-\d{2}-\d{2}">
        </div>

        <div class="form-group">
          <button type="submit">查询</button>
        </div>
      </form>

      <div class="form-group">
        <button @click="exportTable">导出到Excel</button>
      </div>
      <div class="form-group">
        <button @click="saveFinalScore">保存最终分数</button>
      </div>
      <div class="form-group">
        <button @click="saveFinalAppeal">保存最终申诉</button>
      </div>

      <div class="form-group">
        <button @click="copyTable">一键复制表格</button>
      </div>
    </div>

    <!-- 表格 -->

    <div class="right">
      <div id="tables">
        <div id="table-title">
          <table>
            <tr>
              <td></td>
              <td class="center">人民医院产前诊断室质控反馈单</td>
              <td>{{ formattedDate }}</td>
            </tr>
          </table>
        </div>
        <div id="table">
          <table>
            <!-- 表格内容 -->

            <tr>
              <td>最终得分</td>
              <td><input type="number" v-model="fscore.value"></td>
              <td></td>
            </tr>
            <tr>
              <td>评估得分</td>
              <td>{{ escore }}</td>
              <td></td>
            </tr>
            <tr>
              <td>质控考核项目</td>
              <td>考核结果</td>
              <td>扣分</td>
            </tr>
            <tr>
              <td>科室医疗质量管理小组工作</td>
              <td>
                质控资料上传：
                <span v-if="clinicData && clinicData.mqDataMessage1 && typeof clinicData.mqDataMessage1 !== 'undefined'">
            {{ clinicData.mqDataMessage1 }}
          </span>
                <span v-else>
            本月质控资料无缺陷
          </span><br>
                管理工具使用：
                <span v-if="clinicData && clinicData.mqDataMessage2&& typeof clinicData.mqDataMessage2 !== 'undefined'">
            {{ clinicData.mqDataMessage2 }}
          </span>
                <span v-else>
            本月质控资料无缺陷
          </span><br>
                持续改进效果评价:
                <span v-if="clinicData && clinicData.mqDataMessage3 && typeof clinicData.mqDataMessage3 !== 'undefined'">
            {{ clinicData.mqDataMessage3 }}
          </span>
                <span v-else>
            本月质控资料无缺陷
          </span><br>
              </td>
              <td>{{ clinicData && clinicData.mqData[0] && clinicData.mqData[0].pointsDeducted }}</td>
            </tr>
            <tr>
              <td>核心制度落实情况</td>
              <td>无明显质控缺陷</td>
              <td></td>
            </tr>


            <tr>
              <td>门急诊出勤考核</td>
              <!--        遍历-->
              <td>
                <template v-if="clinicData && clinicData.outpatientEmergencyAttendanceAssessmentData1">
                  <div v-for="(item, index) in clinicData.outpatientEmergencyAttendanceAssessmentData1" :key="index">
                    {{ item.doctorName }}，{{ item.outpatientEmergencyAttendance }}
                  </div>
                </template>
              </td>
              <td></td>
            </tr>

            <tr>
              <td>门诊病历书写</td>
              <td>
                <template v-if="clinicData && clinicData.outpatientMedicalRecordsData1">
                  <div v-for="(item, index) in clinicData.outpatientMedicalRecordsData1" :key="index">
                    {{ item.doctorName }}，{{ item.outpatientNumber }}，{{ item.summary }}，{{ item.totalDeductionPoints }}，
                  </div>
                </template>
              </td>
              <td>{{ clinicData && clinicData.outpatientMedicalRecordsData2[0] && clinicData.outpatientMedicalRecordsData2[0].totalPointsDeducted }}</td>
            </tr>
            <tr>
              <td>报告规范、及时性</td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>室间质评与室内质评</td>
              <td>无明显质控缺陷</td>
              <td></td>
            </tr>
            <tr>
              <td>各项质控指标上报</td>
              <td></td>
              <td></td>
            </tr>

            <tr>
              <td>合理用药</td>
              <td>
                详见OA传阅药学室本月质控反馈单
              </td>
              <td></td>
            </tr>

            <tr>
              <td>医患关系办</td>
              <td>
                患者权益:
                <template v-if="clinicData && clinicData.doctorPatientRelationshipData1">
                  <div v-for="(item, index) in clinicData.doctorPatientRelationshipData1" :key="index">
                    {{ item.assessee}}&nbsp;{{ item.patientNameNum }}&nbsp;{{ item.qualityControlDetails}}&nbsp;{{ item.assessmentResults}}
                  </div>
                </template>
                {{ clinicData && clinicData.doctorPatientRelationshipMessage1 }}<br>

                医疗质量安全不良事件:
                <template v-if="clinicData && clinicData.doctorPatientRelationshipData2">
                  <div v-for="(item, index) in clinicData.doctorPatientRelationshipData2" :key="index">
                    {{ item.assessee}}&nbsp;{{ item.patientNameNum }}&nbsp;{{ item.qualityControlDetails}}&nbsp;{{ item.assessmentResults}}
                  </div>
                </template>
                {{ clinicData && clinicData.doctorPatientRelationshipMessage2 }}<br>

                投诉:
                <template v-if="clinicData && clinicData.doctorPatientRelationshipData3">
                  <div v-for="(item, index) in clinicData.doctorPatientRelationshipData3" :key="index">
                    {{ item.assessee}}&nbsp;{{ item.patientNameNum }}&nbsp;{{ item.qualityControlDetails}}&nbsp;{{ item.assessmentResults}}
                  </div>
                </template>
                {{ clinicData && clinicData.doctorPatientRelationshipMessage3 }}
              </td>
              <td>{{ clinicData && clinicData.doctorPatientRelationshipData4[0] && clinicData.doctorPatientRelationshipData4[0].totalPointsDeducted }}</td>
            </tr>

            <tr>
              <td>质控科追踪上月整改情况</td>
              <td>{{ clinicData && clinicData.qcRectificationSituationData[0] && clinicData.qcRectificationSituationData[0].rectificationSituation }}</td>
              <td></td>
            </tr>
            <tr>
              <td>科室整改措施</td>
              <td>{{ clinicData && clinicData.rectificationMeasuresData[0] && clinicData.rectificationMeasuresData[0].measure }}</td>
              <td></td>
            </tr>
            <tr>
              <td>最终申诉</td>
              <td><textarea v-model="finalAppeal" class="final-appeal-input"></textarea></td>
              <td></td>
            </tr>
            <tr>
              <td>科室负责人签字</td>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td>注</td>
              <td>
                1、以上考核中各项目解释权分别为:门诊出勤考核归门诊部，合理用药考核归临床药学室，合理用血考核归输血科，不良事件上报及患者权益归医患关系办，其余项目归质控科。<br>
                2、部分考核结果已提前公示通知各科负责人并告知最后申诉时间，过期不再接受申诉。<br>
                3、未提前公示的内容在本质控单发放后下一个工作日下午17:00结束申诉。<br>
              </td>
              <td></td>
            </tr>

          </table>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
// import { ref } from 'vue';
import axios from 'axios';
import { toPercentage } from '@/utils/filters'
import { exportToExcel } from '@/utils/exportToExcel.js';
import evaluateScore from '@/utils/evaluateScore.js';
import { ref,reactive } from 'vue';
import { ElMessageBox } from 'element-plus';
import { tableToExcel } from '@/utils/tableToExcel';


export default {

  data() {
    return {
      form: {
        date: '',
        select: '',
        searchInput:''
      },
    };
  },
  computed: {
    formattedDate() {
      if (this.form.date) {
        const parts = this.form.date.split('-');
        const year = parts[0];
        const month = parts[1];
        return `${year}年${month}月`;
      }
      return '';
    }
  },

  setup() {
    const form = ref({
      select: '',
      date: '',
      searchInput:''
    });

    const clinicData = ref(null); // 声明一个响应式变量来存储获取到的数据

    const fscore = reactive({ value: null });  // 使用 ref 在 setup 中定义 fscore
    const escore = ref(0); // 声明一个新的响应式变量来存储得分
    const finalAppeal = ref(''); // 声明一个响应式变量 finalAppeal
    const submitForm = () => {
      //最终申诉的相关方法
      axios.get(`http://localhost:8998/api/export/form/finalAppeal?officeName=${form.value.select}&userTime=${form.value.date}`)
          .then(response => {
            console.log(response.data);
            finalAppeal.value = response.data.finalAppeal; // 使用服务器返回的 finalAppeal 更新 finalAppeal 的值
          })
          .catch(error => {
            console.error(error);
          });
      //最终分数的相关方法
      axios.get(`http://localhost:8998/api/export/form/fscore?officeName=${form.value.select}&userTime=${form.value.date}`)
          .then(response => {
            console.log(response.data);  // 打印出服务器返回的响应
            fscore.value = response.data.finalScore; // 使用服务器返回的 finalScore 更新 fscore.value
          })
          .catch(error => {
            console.error(error);
          });
      //查询其他分数
      axios.post(`http://localhost:8998/api/export/form/clinic?officeName=${form.value.select}&userTime=${form.value.date}`)
          .then(response => {
            // 处理成功响应
            console.log(response.data);
            clinicData.value = response.data; // 将获取到的数据存到响应式变量中
            escore.value = evaluateScore(clinicData.value); // 计算得分并存到响应式变量中

          })
          .catch(error => {
            // 处理错误
            console.error(error.response.data);
          });
    };
    //保存最终分数修改
    const saveFinalScore = () => {
      axios.post(`http://localhost:8998/api/export/form/fscore?officeName=${form.value.select}&userTime=${form.value.date}`, {
        finalScore: fscore.value // 将属性名修改为finalScore
      })
          .then(() => {
            console.log('Final score saved successfully');
            ElMessageBox.alert('最终分数保存成功',{
              confirmButtonText: '确定'
            });
          })
          .catch(error => {
            console.error(error);
            ElMessageBox.alert('最终分数保存失败' ,{
              confirmButtonText: '确定'
            });
          });
    };

    //保存最终申诉修改
    const saveFinalAppeal = () => {
      axios
          .post(`http://localhost:8998/api/export/form/finalAppeal?officeName=${form.value.select}&userTime=${form.value.date}`, {
            finalAppeal: finalAppeal.value // 使用 finalAppeal.value 作为请求体参数
          })
          .then(() => {
            console.log('Final appeal saved successfully');
            ElMessageBox.alert('最终申诉保存成功',{
              confirmButtonText: '确定'
            });
          })
          .catch(error => {
            console.error(error);
            ElMessageBox.alert('最终申诉保存失败' ,{
              confirmButtonText: '确定'
            });
          });
    };


    const exportTable = () => {
      const table = document.getElementById('table');
      const selectInput = document.getElementById('selectInput');
      const fileName = selectInput.value;

      // 获取所有的单元格
      const cells = Array.from(table.getElementsByTagName('td'));

      // 找到包含 <br> 的单元格
      const cellsWithBr = cells.filter(cell => cell.innerHTML.includes('<br>'));
      console.log(`包含 <br> 的单元格数量：${cellsWithBr.length}`);

      // 遍历这些单元格，将 <br> 替换为换行符
      cellsWithBr.forEach(cell => {
        cell.innerHTML = cell.innerHTML.replaceAll('<br>', '\n');
        const replacedText = cell.innerHTML;

      });

      exportToExcel(fscore.value, finalAppeal.value, table, fileName + '.xlsx');
    };

    const copyTable = () => {
      var range = document.createRange();
      var parentElement = document.getElementById('tables'); // 父元素包含两个表格
      range.selectNode(parentElement);
      window.getSelection().removeAllRanges();
      window.getSelection().addRange(range);
      try {
        var successful = document.execCommand('copy');
        var msg = successful ? 'successful' : 'unsuccessful';
        console.log('Copy command was ' + msg);

        var alertDiv = document.createElement('div');
        alertDiv.setAttribute('id', 'alertDiv');
        alertDiv.style.position = 'fixed';
        alertDiv.style.right = '20px';
        alertDiv.style.top = '20px';
        alertDiv.style.padding = '10px';
        alertDiv.style.background = '#2E8B57';
        alertDiv.style.color = 'white';
        document.body.appendChild(alertDiv);

        if(successful) {
          alertDiv.innerText = '表格复制成功！';
        } else {
          alertDiv.innerText = '复制失败，请重试。';
        }
        setTimeout(function() {
          alertDiv.style.display = 'none';
        }, 2000);
      } catch(err) {
        console.log('Oops, unable to copy');
      }
      window.getSelection().removeAllRanges();
    };

    //用文本框查询科室
    const submitInput = () => {
      //最终申诉的相关方法
      axios.get(`http://localhost:8998/api/export/form/finalAppeal?officeName=${form.value.searchInput}&userTime=${form.value.date}`)
          .then(response => {
            console.log(response.data);
            finalAppeal.value = response.data.finalAppeal; // 使用服务器返回的 finalAppeal 更新 finalAppeal 的值
          })
          .catch(error => {
            console.error(error);
          });
      //最终分数的相关方法
      axios.get(`http://localhost:8998/api/export/form/fscore?officeName=${form.value.searchInput}&userTime=${form.value.date}`)
          .then(response => {
            console.log(response.data);  // 打印出服务器返回的响应
            fscore.value = response.data.finalScore; // 使用服务器返回的 finalScore 更新 fscore.value
          })
          .catch(error => {
            console.error(error);
          });
      //查询其他分数
      axios.post(`http://localhost:8998/api/export/form/clinic?officeName=${form.value.searchInput}&userTime=${form.value.date}`)
          .then(response => {
            // 处理成功响应
            console.log(response.data);
            clinicData.value = response.data; // 将获取到的数据存到响应式变量中
            escore.value = evaluateScore(clinicData.value); // 计算得分并存到响应式变量中

          })
          .catch(error => {
            // 处理错误
            console.error(error.response.data);
          });
    };






    // 从 setup 返回这些方法，以便在模板中访问
    return {
      form,
      submitForm,
      saveFinalScore,
      saveFinalAppeal,
      clinicData,
      toPercentage,
      exportTable,
      copyTable,
      escore,
      fscore,
      finalAppeal,
      submitInput

    };
  }
};
</script>





<style scoped>
#table-title td:nth-child(1) {
  width: 100px;
}

#table-title td:nth-child(2) {
  width: 450px;
  text-align: center;
  font-weight: bold;
  font-size: 20px;
}
#table {
  border-collapse: collapse;
//background-color: #2E8B57;
  font-family: Arial, sans-serif;
}

#table th, #table td {
  border: 1px solid black;
  padding: 8px;
}

#table th {
  background-color: #f2f2f2;
  text-align: left;

}
#table td {
  color: black; /* 文字颜色为黑色 */
  font-size: 15px;
}
#table td:nth-child(2) {
  width: 500px;
}


#table td[colspan] {
  width: 500px; /* 第二列宽度 */
}
#table td:not([colspan]) {
  width: 100px;
}

.container {
  display: flex;
}

.left {
  flex-basis: 30%; /* 左边占据30%的宽度 */
  padding-right: 20px; /* 左边与右边的间距，根据需要进行调整 */
}

.right {
  flex-basis: 70%; /* 右边占据70%的宽度 */
}
.form-group select {
  width: 203px;
  height: 50px;
  font-size: 20px; /* 设置字体大小为20px */
  margin-bottom: 50px; /* 设置下方间距为10px */
}

.form-group input[type="date"] {
  width: 200px;
  height: 50px;
  margin-bottom: 50px; /* 设置下方间距为10px */
}

.form-group button {
  width: 100px;
  height: 30px;
  margin-bottom: 50px; /* 设置下方间距为10px */
  color:white;
  background-color: #2E8B57;
}
.search-input {
  /* 添加样式 */
  width: 200px;
  padding: 10px;
  border: 2px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
  margin-bottom: 50px; /* 设置下方间距为10px */
}

.final-appeal-input {
  width: 400px;
  height: 150px;
}
#table td {
  white-space: normal;
}
.center {
  text-align: center;
}


</style>
