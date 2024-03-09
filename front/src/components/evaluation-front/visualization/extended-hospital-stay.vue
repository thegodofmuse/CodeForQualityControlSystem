<template>
  <div class="box">全院住院超30天人数（年度）</div>
  <label for="yearInput">年份:</label>
  <input type="number" id="yearInput" v-model="input.year" min="1900" max="9999">
  <button @click="extendDay">查询</button>
  <div id="extend-chart" style="width: 800px; height: 400px;"></div>

  <div class="box">各科室住院超30天人数（年度）</div>
  <label for="OfficeInput">科室:</label>
  <input type="text" id="OfficeInput" v-model="input.office">
  <label for="officeYearInput">年份:</label>
  <input type="number" id="officeYearInput" v-model="input.officeYear" min="1900" max="9999">
  <button type="submit" @click="officeExtendDay">查询</button>
  <div id="office-extend-chart" style="width: 800px; height: 400px;"></div>

  <div class="box">同期比较科室月度住院超30天人数</div>
  <label for="compareInput">科室:</label>
  <input type="text" id="compareInput" v-model="input.compare">
  <label for="compareYearInput">年份:</label>
  <input type="number" id="compareYearInput" v-model="input.compareYear" min="1900" max="9999">
  <button type="submit" @click="compareExtendDay">查询</button><br><br>
  <span class="color-block" style="background-color: #003366;"></span>头一年
  <span class="color-block" style="background-color: #4cabce;"></span>今年
  <div id="compare-extend-chart" style="width: 800px; height: 400px;"></div>

  <div class="box">住院超30天上报情况（季度）</div>
  应上报>已上报说明该科室漏报例数较多（应上报=已上报+漏报）。绿色部分多，说明做得好<br>
  <label for="yearSeasonInput">年份:</label>
  <input type="number" id="yearInput" v-model="input.yearSeason" min="1900" max="9999">
  <label for="quarterInput">季度:</label>
  <input type="number" id="quarterInput" v-model="input.quarter" min="1" max="4">
  <button @click="seasonForm">查询</button>
  <div id="extend-quarterly-chart" style="width: 1600px; height: 600px;"></div>

  <div class="box">住院超30天上报情况（半年）</div>
  <div>
    <form @submit.prevent="halfForm">
      <label for="yearHalfInput">年份：</label>
      <input type="number" id="yearHalf" v-model="input.yearHalf" required><br>
      <label for="halfYear">上半年/下半年：</label>
      <select id="halfYear" v-model="input.halfYear" required>
        <option value="上半年">上半年</option>
        <option value="下半年">下半年</option>
      </select>
      <br>
      <button type="submit">查询</button>
    </form>
    <div id="extend-half-year-chart" style="width: 1600px; height: 600px;"></div>
  </div>

  <div class="box">住院超30天上报情况（年度）</div>
  <label for="yearAllInput">年份:</label>
  <input type="number" id="yearAllInput" v-model="input.yearAll" min="1900" max="9999">
  <button @click="allForm">查询</button>
  <div id="extend-year-all-chart" style="width: 1600px; height: 600px;"></div>

  <div class="box">同一病种31天内非计划再住院率（按月）</div>柱状图
  <div class="box">在指定季度下同一病种31天内非计划再住院率与目标值对比</div>柱状图
</template>

<script>
import axios from "axios";
import * as echarts from "echarts";
import { ref } from "vue";

export default {
  setup() {
    const input = ref({
      year: null,
      office:null,
      compare:null,
      compareYear:null,
      yearSeason:null,
      quarter:null,
      yearHalf:null,
      halfYear:null,
      yearAll:null
    });

    const extendDay = () => {
      axios
          .post(`http://localhost:8998/api/export/view/extend/hospital?year=${input.value.year}`)
          .then((response) => {
            if (!response.data) {
              console.log("未获取到数据");
              return;
            }
            const data = response.data;
            const month = data.map((item) => item.month);
            const extendNum = data.map((item) => item.extendNum);

            const myChartHospital = echarts.init(document.getElementById('extend-chart'));
            myChartHospital.setOption({
              xAxis: {
                type: 'category',
                data: month,
              },
              yAxis: {
                type: 'value',
              },
              series: [{
                data: extendNum,
                type: 'bar',
                label: {
                  show: true,
                  position: 'top',
                  formatter: '{c}',
                },
                lineStyle: {},
              }],
            });
          })
          .catch((error) => {
            console.error(error);
          });
    };

    const officeExtendDay = () => {
      axios
          .post(`http://localhost:8998/api/export/view/extend/office?year=${input.value.officeYear}&officeName=${input.value.office}`)
          .then((response) => {
            if (!response.data) {
              console.log("未获取到数据");
              return;
            }
            const data = response.data;
            console.log(data); // 打印data变量的值
            const month = data.map((item) => item.month);
            const extendNum = data.map((item) => item.extendNum);

            const myChartHospital = echarts.init(document.getElementById('office-extend-chart'));
            myChartHospital.setOption({
              xAxis: {
                type: 'category',
                data: month,
              },
              yAxis: {
                type: 'value',
              },
              series: [{
                data: extendNum,
                type: 'bar',
                label: {
                  show: true,
                  position: 'top',
                  formatter: '{c}',
                },
                lineStyle: {},
              }],
            });
          })
          .catch((error) => {
            console.error(error);
          });
    };

    const compareExtendDay = () => {
      axios
          .post(`http://localhost:8998/api/export/view/extend/compare?year=${input.value.compareYear}&officeName=${input.value.compare}`)
          .then(response => {
            const data = response.data;
            const months = data.map(item => item.month);
            const countList = data.map(item => item.countList);
            console.log(data);

            const myChartSeason = echarts.init(document.getElementById('compare-extend-chart'));
            const colors = ['#003366', '#006699', '#4cabce'];
            const series = [];
            for (let i = 0; i < 2; i++) {
              series.push({
                type: 'bar',
                data: countList.map(rates => rates[i] || 0),
                itemStyle: {
                  color: colors[i] // 设置不同颜色，循环使用
                },
                label: {
                  show: true,
                  position: 'top',
                  formatter: '{c}', // 显示数据值
                },
              });
            }

            myChartSeason.setOption({
              tooltip: {
                trigger: 'axis',
                axisPointer: { type: 'shadow' },
              },
              xAxis: {
                type: 'category',
                data: months,
                axisLabel: {
                  interval: 0, // 设置为 0，表示所有标签都显示
                },
              },
              yAxis: { type: 'value' },
              series: series,
            });
          })
          .catch(error => {
            console.error(error.response.data);
          });

    };

    const seasonForm = () => {
      axios
          .post(`http://localhost:8998/api/export/view/extend/report/season?year=${input.value.yearSeason}&quarter=${input.value.quarter}`)
          .then(response => {
            const data = response.data; // 获取后端返回的数据

            // 提取officeName、totalReportCount和normalReportCount
            const officeNames = data.map(item => item.officeName);
            const totalReportCounts = data.map(item => item.totalReportCount);
            const normalReportCounts = data.map(item => item.normalReportCount);

            // 使用Echarts绘制面积图
            const chart = echarts.init(document.getElementById('extend-quarterly-chart'));

            const option = {
              tooltip: {
                trigger: 'axis'
              },
              legend: {
                data: ['应上报', '已上报']
              },
              xAxis: {
                type: 'category',
                data: officeNames
              },
              yAxis: {
                type: 'value'
              },
              series: [
                {
                  name: '应上报',
                  type: 'line',
                  areaStyle: {color: 'rgba(\t0 0 128)'},
                  data: totalReportCounts
                },
                {
                  name: '已上报',
                  type: 'line',
                  areaStyle: {},
                  data: normalReportCounts
                }
              ]
            };

            chart.setOption(option);
          });
    };

    const halfForm = () => {
      axios
          .post(`http://localhost:8998/api/export/view/extend/report/half-year?year=${input.value.yearHalf}&halfYear=${input.value.halfYear}`)
          .then(response => {
            // 处理返回的数据
            console.log(response.data);
            const data = response.data; // 获取后端返回的数据

            // 提取officeName、totalReportCount和normalReportCount
            const officeNames = data.map(item => item.officeName);
            const totalReportCounts = data.map(item => item.totalReportCount);
            const normalReportCounts = data.map(item => item.normalReportCount);

            // 使用Echarts绘制面积图
            const chart = echarts.init(document.getElementById('extend-half-year-chart'));

            const option = {
              tooltip: {
                trigger: 'axis'
              },
              legend: {
                data: ['应上报', '已上报']
              },
              xAxis: {
                type: 'category',
                data: officeNames
              },
              yAxis: {
                type: 'value'
              },
              series: [
                {
                  name: '应上报',
                  type: 'line',
                  areaStyle: {color: 'rgba(\t0 0 128)'},
                  data: totalReportCounts
                },
                {
                  name: '已上报',
                  type: 'line',
                  areaStyle: {},
                  data: normalReportCounts
                }
              ]
            };

            chart.setOption(option);
          });
    };

    const allForm = () => {
      axios
          .post(`http://localhost:8998/api/export/view/extend/report/year?year=${input.value.yearAll}`)
          .then(response => {
            // 处理返回的数据
            console.log(response.data);
            const data = response.data; // 获取后端返回的数据

            // 提取officeName、totalReportCount和normalReportCount
            const officeNames = data.map(item => item.officeName);
            const totalReportCounts = data.map(item => item.totalReportCount);
            const normalReportCounts = data.map(item => item.normalReportCount);

            // 使用Echarts绘制面积图
            const chart = echarts.init(document.getElementById('extend-year-all-chart'));

            const option = {
              tooltip: {
                trigger: 'axis'
              },
              legend: {
                data: ['应上报', '已上报']
              },
              xAxis: {
                type: 'category',
                data: officeNames
              },
              yAxis: {
                type: 'value'
              },
              series: [
                {
                  name: '应上报',
                  type: 'line',
                  areaStyle: {color: 'rgba(\t0 0 128)'},
                  data: totalReportCounts
                },
                {
                  name: '已上报',
                  type: 'line',
                  areaStyle: {},
                  data: normalReportCounts
                }
              ]
            };

            chart.setOption(option);
          });
    };


    return {
      input,
      extendDay,
      officeExtendDay,
      compareExtendDay,
      seasonForm,
      halfForm,
      allForm
    };
  },
};
</script>




<style scoped>
.box {
  border: 1px solid white;
  text-align: center;
  padding: 10px;
  width: 800px;
  height: 30px;
  font-weight: bold;
  font-size: 24px;
}
.color-block {
  display: inline-block;
  width: 20px;
  height: 20px;
  margin-right: 5px;
}
</style>