<template>
  病案相关
  归档率是上一个月的

  <div class="box">全院病案归档率（月）</div><div class="box">各科室病案归档率（月）</div>
  <div class="box">各科室病案归档率（季度）</div><div class="box">各科室病案归档率（半年）</div><div class="box">各科室病案归档率（年）</div>

  <div class="box">门诊病历缺陷次数累计图（不包含急诊科）</div>
  <label for="outDefectYear">年份:</label>
  <input type="number" id="outDefectYear" v-model="input.outDefectYear" min="1900" max="9999">
  <button @click="outDefectPicture">查询</button>
  <div id="out-defect-year-chart" style="width: 800px; height: 600px;"></div>
  <div class="box">门诊病历缺陷累计分数表</div>
  <el-table :data="outDefectTable">
    <el-table-column prop="column1" label="医生姓名" width="100px"></el-table-column>
    <el-table-column prop="column2" label="门诊病历缺陷分数"></el-table-column>
  </el-table>


  <div class="box">运行病历缺陷次数累计图（彩虹图）</div>
  <div class="box">运行病历缺陷次数累计表</div>
  书写及时性系统有待矫正


  <div class="box">终末病历缺陷次数累计图（彩虹图）</div>
  <label for="finalDefectYear">年份:</label>
  <input type="number" id="finalDefectYear" v-model="input.finalDefectYear" min="1900" max="9999">
  <button @click="finalDefectPicture">查询</button>
  <div id="final-defect-year-chart" style="width: 800px; height: 600px;"></div>
  <div class="box">终末病历缺陷次数累计表</div>
  <el-table :data="finalDefectTable">
    <el-table-column prop="column1" label="医生姓名" width="100px"></el-table-column>
    <el-table-column prop="column2" label="终末病历总计罚款"></el-table-column>
  </el-table>
</template>

<script>
import { ref } from "vue";
import axios from "axios";
import * as echarts from "echarts";

export default {
  setup() {
    const input = ref({
      outDefectYear: null,
      finalDefectYear:null
    });


  //门诊病历缺陷次数
    const fetchOutDefectData = (outDefectYear) => {
      axios.post(`http://localhost:8998/api/export/view/medical/record/outDefectTable?year=${outDefectYear}`)
          .then((response) => {
            outDefectTable.value = response.data.map((item) => ({
              column1: item.doctorName,
              column2: item.point,
            }));
          })
          .catch((error) => {
            console.log(error);
          });
    };
    const outDefectTable = ref([]);

    const outDefectPicture = () => {
      const outDefectYear = input.value.outDefectYear;
      fetchOutDefectData(outDefectYear);

      // 初始化 echarts 实例
      const chartDom = document.getElementById('out-defect-year-chart');
      const myChart = echarts.init(chartDom);

      axios
          .post(`http://localhost:8998/api/export/view/medical/record/outDefectPicture?year=${outDefectYear}`)
          .then(response => {
            // 处理响应数据
            const data = response.data;

            // 设置 echarts 配置
            const option = {
              tooltip: {},
              xAxis: {
                type: "category",
                data: data.map((item) => item.doctorName),
              },
              yAxis: {
                type: "value",
              },
              series: [
                {
                  name: "评分",
                  type: "scatter",
                  data: data.map((item) => [item.doctorName, item.point]),
                  itemStyle: {
                    color: function(params) {
                      // 这个函数会为每个散点生成一个随机颜色
                      return 'rgb(' +
                          Math.round(Math.random() * 255) + ',' +
                          Math.round(Math.random() * 255) + ',' +
                          Math.round(Math.random() * 255) + ')';
                    }
                  },
                },
              ],
            };

            // 使用配置更新 echarts 实例
            myChart.setOption(option);

          })
          .catch(error => {
            // 处理错误
            console.log(error);
          });
    };

    //终末病历缺陷次数
    const fetchFinalDefectData = (finalDefectYear) => {
      axios.post(`http://localhost:8998/api/export/view/medical/record/finalDefectTable?year=${finalDefectYear}`)
          .then((response) => {
            finalDefectTable.value = response.data.map((item) => ({
              column1: item.doctorName,
              column2: item.fine,
            }));
          })
          .catch((error) => {
            console.log(error);
          });
    };
    const finalDefectTable = ref([]);

    const finalDefectPicture = () => {
      const finalDefectYear = input.value.finalDefectYear;
      fetchFinalDefectData(finalDefectYear);

      // 初始化 echarts 实例
      const chartDom = document.getElementById('final-defect-year-chart');
      const myChart = echarts.init(chartDom);

      axios
          .post(`http://localhost:8998/api/export/view/medical/record/finalDefectPicture?year=${finalDefectYear}`)
          .then(response => {
            // 处理响应数据
            const data = response.data;

            // 设置 echarts 配置
            const option = {
              tooltip: {},
              xAxis: {
                type: "category",
                data: data.map((item) => item.doctorName),
              },
              yAxis: {
                type: "value",
              },
              series: [
                {
                  name: "评分",
                  type: "scatter",
                  data: data.map((item) => [item.doctorName, item.fine]),
                  itemStyle: {
                    color: function(params) {
                      // 这个函数会为每个散点生成一个随机颜色
                      return 'rgb(' +
                          Math.round(Math.random() * 255) + ',' +
                          Math.round(Math.random() * 255) + ',' +
                          Math.round(Math.random() * 255) + ')';
                    }
                  },
                },
              ],
            };

            // 使用配置更新 echarts 实例
            myChart.setOption(option);

          })
          .catch(error => {
            // 处理错误
            console.log(error);
          });
    };


    return {
      input,
      outDefectTable,
      outDefectPicture,
      finalDefectTable,
      finalDefectPicture,
    };
  },
};
</script>




<style scoped>

</style>