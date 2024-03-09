<template>
  <div>
    <div class="score-label">临床通用科室</div>
    <el-button @click="copyTable1" class="green-button">复制临床科室表单</el-button><br><br>

    <label for="dateInput">日期:</label>
    <input type="date" id="dateInput" v-model="form.date" required pattern="\d{4}-\d{2}-\d{2}">
    <button type="submit" @click="submitClinicData">查询</button>

    <div class="white-box"></div>

    <el-table :data="tableData1" border ref="table1">
      <el-table-column prop="officeName" label="科室"></el-table-column>
      <el-table-column prop="sumGrades" label="本月得分（不含加分项）"></el-table-column>
      <el-table-column prop="medTechServiceCapabilities" label="医疗技术及服务能力"></el-table-column>
      <el-table-column prop="prescriptiveTasks" label="指令性任务"></el-table-column>
      <el-table-column prop="continuousImprovementMetrics" label="持续改进指标"></el-table-column>
      <el-table-column prop="medicalRecordPageScore" label="病案首页得分"></el-table-column>
      <el-table-column prop="finalOfficeScore" label="医疗质量与安全（质控反馈单）"></el-table-column>
      <el-table-column prop="bonusPoints" label="加分项"></el-table-column>
      <el-table-column prop="bonusReason" label="加分原因"></el-table-column>
    </el-table>


    <div class="white-box"></div>

    <div class="score-label">急诊</div>
    <el-button @click="copyTable2" class="green-button">复制急诊科室表单</el-button><br><br>

    <input type="date" id="dateInput" v-model="form.emergencyDate" required pattern="\d{4}-\d{2}-\d{2}">
    <button type="submit" @click="submitEmergency">查询</button>

    <div class="white-box"></div>

    <el-table :data="tableData2" border ref="table2">
      <el-table-column prop="officeName" label="科室"></el-table-column>
      <el-table-column prop="sumEmergencyGrades" label="本月得分（不含加分项）"></el-table-column>
      <el-table-column prop="medTechServiceCapabilities" label="医疗技术及服务能力"></el-table-column>
      <el-table-column prop="prescriptiveTasks" label="指令性任务"></el-table-column>
      <el-table-column prop="continuousImprovementMetrics" label="持续改进指标"></el-table-column>
      <el-table-column prop="medicalRecordPageScore" label="病案首页得分"></el-table-column>
      <el-table-column prop="emergencyFinalScore" label="医疗质量与安全（质控反馈单）"></el-table-column>
      <el-table-column prop="bonusPoints" label="加分项"></el-table-column>
      <el-table-column prop="bonusReason" label="加分原因"></el-table-column>
    </el-table>



  </div>
</template>

<script>
import axios from 'axios';
import { officeSort } from '@/utils/hrp/officeSort.js';


export default {
  data() {
    return {
      form: {
        date: null,
        emergencyDate:null
      },
      tableData1: [],
      tableData2: [] // 表格数据
    };
  },

  methods: {
    submitClinicData() {
      axios
          .get(`http://localhost:8998/api/hrp/query/gradesForm?userTime=${this.form.date}`)
          .then(response => {
            const data = response.data;
            const medicalServicesSectionData = data.medicalServicesSectionData;
            const medicalRecordsSectionData = data.medicalRecordsSectionData;
            const finalOfficeScores = data.finalOfficeScores;
            const sumGradesFormData = data.sumGradesFormData;
            const bonusPointsProjectData = data.bonusPointsProjectData;

            let tableDataObj = {};

            // 处理 medicalServicesSectionData 数据
            for (let serviceItem of medicalServicesSectionData) {
              tableDataObj[serviceItem.officeName] = {
                officeName: serviceItem.officeName,
                medTechServiceCapabilities: serviceItem.medTechServiceCapabilities,
                prescriptiveTasks: serviceItem.prescriptiveTasks,
                continuousImprovementMetrics: serviceItem.continuousImprovementMetrics,
              };
            }

            // 处理 medicalRecordsSectionData 数据
            for (let recordItem of medicalRecordsSectionData) {
              if (tableDataObj[recordItem.officeName]) {
                tableDataObj[recordItem.officeName].medicalRecordPageScore = recordItem.medicalRecordPageScore;
              } else {
                tableDataObj[recordItem.officeName] = {
                  officeName: recordItem.officeName,
                  medicalRecordPageScore: recordItem.medicalRecordPageScore,
                };
              }
            }
            //处理finalOfficeScores数据
            for(let finalItem of finalOfficeScores){
              if (tableDataObj[finalItem.officeName]) {
                tableDataObj[finalItem.officeName].finalOfficeScore = finalItem.finalOfficeScore;
              } else {
                tableDataObj[finalItem.officeName] = {
                  officeName: finalItem.officeName,
                  finalOfficeScore: finalItem.finalOfficeScore,
                };
              }
            }
            //处理sumGradesFormData数据
            for(let sumItem of sumGradesFormData){
              if (tableDataObj[sumItem.officeName]) {
                tableDataObj[sumItem.officeName].sumGrades = sumItem.sumGrades;
              } else {
                tableDataObj[sumItem.officeName] = {
                  officeName: sumItem.officeName,
                  sumGrades: sumItem.sumGrades,
                };
              }
            }
            //处理bonusPointsProjectData数据
            for(let bonusItem of bonusPointsProjectData){
              if (tableDataObj[bonusItem.officeName]) {
                tableDataObj[bonusItem.officeName].bonusPoints = bonusItem.bonusPoints;
                tableDataObj[bonusItem.officeName].bonusReason = bonusItem.bonusReason;
              } else {
                tableDataObj[bonusItem.officeName] = {
                  officeName: bonusItem.officeName,
                  bonusPoints: bonusItem.bonusPoints,
                  bonusReason: bonusItem.bonusReason,
                };
              }
            }


            this.tableData1 = Object.values(tableDataObj);
            this.tableData1 = officeSort(Object.values(tableDataObj));
          })
          .catch(error => {
            console.error(error);
          });
    },
    submitEmergency() {
      axios
          .get(`http://localhost:8998/api/hrp/query/emergencyGrades?userTime=${this.form.emergencyDate}`)
          .then(response => {
            const data = response.data;
            const emergencyMedicalServicesData = data.emergencyMedicalServicesData;
            const emergencyMedicalRecordsData = data.emergencyMedicalRecordsData;
            const emergencyFinalScores = data.emergencyFinalScores;
            const sumEmergencyGradesData = data.sumEmergencyGradesData;
            const emergencyBonusPointsData = data.emergencyBonusPointsData;

            let emTableDataObj = {};

            // 处理 emergencyMedicalServicesData 数据
            for (let serviceItem of emergencyMedicalServicesData) {
              emTableDataObj[serviceItem.officeName] = {
                officeName: serviceItem.officeName,
                medTechServiceCapabilities: serviceItem.medTechServiceCapabilities,
                prescriptiveTasks: serviceItem.prescriptiveTasks,
                continuousImprovementMetrics: serviceItem.continuousImprovementMetrics,
              };
            }

            // 处理 emergencyMedicalRecordsData 数据
            for (let recordItem of emergencyMedicalRecordsData) {
              if (emTableDataObj[recordItem.officeName]) {
                emTableDataObj[recordItem.officeName].medicalRecordPageScore = recordItem.medicalRecordPageScore;
              } else {
                emTableDataObj[recordItem.officeName] = {
                  officeName: recordItem.officeName,
                  medicalRecordPageScore: recordItem.medicalRecordPageScore,
                };
              }
            }
            //处理emergencyFinalScores数据
            for(let finalItem of emergencyFinalScores){
              if (emTableDataObj[finalItem.officeName]) {
                emTableDataObj[finalItem.officeName].emergencyFinalScore = finalItem.emergencyFinalScore;
              } else {
                emTableDataObj[finalItem.officeName] = {
                  officeName: finalItem.officeName,
                  emergencyFinalScore: finalItem.emergencyFinalScore,
                };
              }
            }
            //处理sumEmergencyGradesData数据
            for(let sumItem of sumEmergencyGradesData){
              if (emTableDataObj[sumItem.officeName]) {
                emTableDataObj[sumItem.officeName].sumEmergencyGrades = sumItem.sumEmergencyGrades;
              } else {
                emTableDataObj[sumItem.officeName] = {
                  officeName: sumItem.officeName,
                  sumEmergencyGrades: sumItem.sumEmergencyGrades,
                };
              }
            }
            //处理emergencyBonusPointsData数据
            for(let bonusItem of emergencyBonusPointsData){
              if (emTableDataObj[bonusItem.officeName]) {
                emTableDataObj[bonusItem.officeName].bonusPoints = bonusItem.bonusPoints;
                emTableDataObj[bonusItem.officeName].bonusReason = bonusItem.bonusReason;
              } else {
                emTableDataObj[bonusItem.officeName] = {
                  officeName: bonusItem.officeName,
                  bonusPoints: bonusItem.bonusPoints,
                  bonusReason: bonusItem.bonusReason,
                };
              }
            }



            this.tableData2 = Object.values(emTableDataObj);
          })
          .catch(error => {
            console.error(error);
          });
    },
    copyTable1() {
      this.copyTableToClipboard("table1");
    },
    copyTable2() {
      this.copyTableToClipboard("table2");
    },
    copyTableToClipboard(tableRef) {
      const table = this.$refs[tableRef];
      if (!table) return;

      const range = document.createRange();
      range.selectNodeContents(table.$el);
      const selection = window.getSelection();
      selection.removeAllRanges();
      selection.addRange(range);

      document.execCommand("copy");

      selection.removeAllRanges();
      this.$message.success("复制成功！");
    },

  },

};
</script>




<style scoped>
.score-label {
  font-size: 24px;
  text-align: center;
  color: #008000; /* 深绿色 */
  font-weight: bold;
}
.white-box {
  width: 50px;
  height: 50px;
  background-color: white;
}
.green-button {
  background-color: green;
  color: white;
}
</style>