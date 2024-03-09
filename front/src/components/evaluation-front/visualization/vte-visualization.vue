<template>
  <div>
    <div class="box">各科室出血风险评估率（按月）</div>
    <input type="date" v-model="form.date" />
    <button @click="submitForm">查询</button>
    <div id="monthly-chart" style="width: 1200px;height:400px;"></div>

    <div class="box">各科室出血风险评估率（按季度）</div>
    <label for="yearInput">年份:</label>
    <input type="number" id="yearInput" v-model="input.year" min="1900" max="9999">
    <label for="quarterInput">季度:</label>
    <input type="number" id="quarterInput" v-model="input.quarter" min="1" max="4">
    <button @click="submitSeasonForm">查询</button>
    <div id="quarterly-chart" style="width: 1600px; height: 600px;"></div>

    <div class="box">各科室出血风险评估率趋势</div>
    <label for="officeInput">科室:</label>
    <input type="text" id="officeInput" v-model="input.officeName">
    <label for="trendYearInput">年份:</label>
    <input type="number" id="trendYearInput" v-model="input.trendYear" min="1900" max="9999">
    <button type="submit" @click="submitOfficeTrend">查询</button>
    <div id="office-trend-chart" style="width: 800px; height: 400px;"></div>

    <div class="box">全院出血风险评估率平均值趋势（按月）</div>
    <label for="avgTrendInput">年份:</label>
    <input type="number" id="avgTrendInput" v-model="input.avgTrend" min="1900" max="9999">
    <button type="submit" @click="submitAvgTrend">查询</button>
    <div id="hospital-trend-chart" style="width: 800px; height: 400px;"></div>

    <div class="box">全院出血风险评估率平均值趋势（按季度）</div>
    <label for="avgSeasonTrendInput">年份:</label>
    <input type="number" id="avgSeasonTrendInput" v-model="input.avgSeasonTrend" min="1900" max="9999">
    <button type="submit" @click="submitAvgSeasonTrend">查询</button>
    <div id="hospital-season-trend-chart" style="width: 800px; height: 400px;"></div>

    <div class="box">各科室vte预防率（按月）</div>
    <input type="date" v-model="form.date2" />
    <button @click="submitPreForm">查询</button>
    <div id="pre-monthly-chart" style="width: 1200px;height:400px;"></div>

    <div class="box">各科室vte预防率（按季度）</div>
    <label for="preYearInput">年份:</label>
    <input type="number" id="preYearInput" v-model="input.preYear" min="1900" max="9999">
    <label for="preQuarterInput">季度:</label>
    <input type="number" id="preQuarterInput" v-model="input.preQuarter" min="1" max="4">
    <button @click="submitPreSeasonForm">查询</button>
    <div id="pre-quarterly-chart" style="width: 1600px; height: 600px;"></div>

    <div class="box">各科室vte预防率趋势</div>
    <label for="preOfficeInput">科室:</label>
    <input type="text" id="preOfficeInput" v-model="input.preOfficeName">
    <label for="preTrendYearInput">年份:</label>
    <input type="number" id="preTrendYearInput" v-model="input.preTrendYear" min="1900" max="9999">
    <button type="submit" @click="submitPreOfficeTrend">查询</button>
    <div id="pre-office-trend-chart" style="width: 800px; height: 400px;"></div>

    <div class="box">全院vte预防率平均值趋势（按月）</div>
    <label for="preAvgTrendInput">年份:</label>
    <input type="number" id="preAvgTrendInput" v-model="input.preAvgTrend" min="1900" max="9999">
    <button type="submit" @click="submitPreAvgTrend">查询</button>
    <div id="pre-hospital-trend-chart" style="width: 800px; height: 400px;"></div>


    <div class="box">全院vte预防率平均值趋势（按季度）</div>
    <label for="preAvgSeasonTrendInput">年份:</label>
    <input type="number" id="preAvgSeasonTrendInput" v-model="input.preAvgSeasonTrend" min="1900" max="9999">
    <button type="submit" @click="submitPreAvgSeasonTrend">查询</button>
    <div id="pre-hospital-season-trend-chart" style="width: 800px; height: 400px;"></div>

  </div>



</template>

<script>
import { ref } from 'vue';
import axios from 'axios';
import * as echarts from 'echarts';

export default {
  setup() {
    const input = ref({
      year: null,
      quarter: null,
      trendYear:null,
      officeName:null,
      avgTrend:null,
      avgSeasonTrend:null,
      preYear: null,
      preQuarter: null,
      preOfficeName:null,
      preTrendYear:null,
      preAvgTrend:null,
      preAvgSeasonTrend:null

    });

    const form = ref({
      date: '',
      date2:''
    });

    const submitForm = () => {
      if (!form.value.date) {
        console.log("日期不能为空");
        return;
      }
      axios
          .post(`http://localhost:8998/api/export/view/vte/bleed/month?userTime=${form.value.date}`)
          .then(response => {
            if (!response.data) {
              console.log("未获取到数据");
              return;
            }
            const data = response.data;
            const officeNames = data.map(item => item.officeName);
            const vteRates = data.map(item => item.vteBleedingRiskAssessmentRate);


            const myChartMonthly = echarts.init(document.getElementById('monthly-chart'));
            myChartMonthly.setOption({
              tooltip: {},
              xAxis: {
                type: 'category',
                data: officeNames,
                axisLabel: {
                  interval: 0, // 设置为 0，表示所有标签都显示
                  rotate: -45, // 设置倾斜角度（逆时针方向）为 -45 度
                },
              },
              yAxis: {
                type: 'value',
              },
              series: [
                {
                  name: '出血风险评估率',
                  type: 'bar',
                  label: {
                    show: true,
                    position: 'top'
                  },
                  // barGap: '300', // 设置同一类目内柱形间距
                  // barCategoryGap: '100%', // 设置类目间柱形间距
                  data: vteRates,
                },
              ],
              grid: {
                left: '2%',
                right: '3%',
                bottom: '3%',
                containLabel: true
              },
            });
          })
          .catch(error => {
            console.error(error);
          });
    };

    const submitSeasonForm = () => {
      axios
          .post(`http://localhost:8998/api/export/view/vte/bleed/season?year=${input.value.year}&quarter=${input.value.quarter}`)
          .then(response => {
            const data = response.data;
            const officeNames = data.map(item => item.officeName);
            const vteRatesArray = data.map(item => item.vteBleedingRiskAssessmentRateArray);
            console.log(data);

            const myChartSeason = echarts.init(document.getElementById('quarterly-chart'));
            const colors = ['#003366', '#006699', '#4cabce'];
            const series = [];
            for (let i = 0; i < 3; i++) {
              series.push({
                name: `第 ${i + 1} 个月`,
                type: 'bar',
                data: vteRatesArray.map(rates => rates[i] || 0),
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
              legend: {
                data: series.map(item => item.name),
              },
              xAxis: {
                type: 'category',
                data: officeNames,
                axisLabel: {
                  interval: 0, // 设置为 0，表示所有标签都显示
                  rotate: -35, // 设置倾斜角度（逆时针方向）为 -45 度
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

    const submitOfficeTrend = () => {
      axios
          .post(`http://localhost:8998/api/export/view/vte/bleed/trend/office?year=${input.value.trendYear}&officeName=${input.value.officeName}`)
          .then(response => {
            if (!response.data) {
              console.log("未获取到数据");
              return;
            }
            const data = response.data;
            const month = data.map(item => item.month)
            const vteRates = data.map(item => item.vteBleedingRiskAssessmentRate);

            const myChartOffice = echarts.init(document.getElementById('office-trend-chart'));
            myChartOffice.setOption({
              xAxis: {
                type: 'category',
                data: month
              },
              yAxis: {
                type: 'value'
              },
              series: [{
                data: vteRates,
                type: 'line',
                label: {
                  show: true, // 显示数据标签
                  position: 'top', // 标签位置：折线上方
                  formatter: '{c}', // 标签格式化，可根据需要进行调整
                },
                lineStyle: {} // 其他样式配置
              }]
            });
          })
          .catch(error => {
            console.error(error);
          });
    };

    const submitAvgTrend = () => {
      axios
          .post(`http://localhost:8998/api/export/view/vte/bleed/trend/hospital/month?year=${input.value.avgTrend}`)
          .then(response => {
            if (!response.data) {
              console.log("未获取到数据");
              return;
            }
            const data = response.data;
            const month = data.map(item => item.month)
            const averageRate = data.map(item => item.averageRate);

            const myChartHospital = echarts.init(document.getElementById('hospital-trend-chart'));
            myChartHospital.setOption({
              xAxis: {
                type: 'category',
                data: month
              },
              yAxis: {
                type: 'value'
              },
              series: [{
                data: averageRate,
                type: 'line',
                label: {
                  show: true, // 显示数据标签
                  position: 'top', // 标签位置：折线上方
                  formatter: '{c}', // 标签格式化，可根据需要进行调整
                },
                lineStyle: {} // 其他样式配置
              }]
            });
          })
          .catch(error => {
            console.error(error);
          });
    };

    const submitAvgSeasonTrend = () => {
      axios
          .post(`http://localhost:8998/api/export/view/vte/bleed/trend/hospital/season?year=${input.value.avgSeasonTrend}`)
          .then(response => {
            if (!response.data) {
              console.log("未获取到数据");
              return;
            }
            const data = response.data;
            const quarter = data.map(item => item.quarter)
            const averageRate = data.map(item => item.averageRate);

            const myChartHospitalSeason = echarts.init(document.getElementById('hospital-season-trend-chart'));
            myChartHospitalSeason.setOption({
              xAxis: {
                type: 'category',
                data: quarter
              },
              yAxis: {
                type: 'value'
              },
              series: [{
                data: averageRate,
                type: 'line',
                label: {
                  show: true, // 显示数据标签
                  position: 'top', // 标签位置：折线上方
                  formatter: '{c}', // 标签格式化，可根据需要进行调整
                },
                lineStyle: {} // 其他样式配置
              }]
            });
          })
          .catch(error => {
            console.error(error);
          });
    };

    const submitPreForm = () => {
      if (!form.value.date2) {
        console.log("日期不能为空");
        return;
      }
      axios
          .post(`http://localhost:8998/api/export/view/vte/pre/month?userTime=${form.value.date2}`)
          .then(response => {
            if (!response.data) {
              console.log("未获取到数据");
              return;
            }
            const data = response.data;
            const officeNames = data.map(item => item.officeName);
            const vteRates = data.map(item => item.vtePreventionRate);


            const preMonthly = echarts.init(document.getElementById('pre-monthly-chart'));
            preMonthly.setOption({
              tooltip: {},
              xAxis: {
                type: 'category',
                data: officeNames,
                axisLabel: {
                  interval: 0, // 设置为 0，表示所有标签都显示
                  rotate: -45, // 设置倾斜角度（逆时针方向）为 -45 度
                },
              },
              yAxis: {
                type: 'value',
              },
              series: [
                {
                  name: 'VTE中高危风险患者预防率',
                  type: 'bar',
                  label: {
                    show: true,
                    position: 'top'
                  },
                  // barGap: '300', // 设置同一类目内柱形间距
                  // barCategoryGap: '100%', // 设置类目间柱形间距
                  data: vteRates,
                },
              ],
              grid: {
                left: '2%',
                right: '3%',
                bottom: '3%',
                containLabel: true
              },
            });
          })
          .catch(error => {
            console.error(error);
          });
    };

    const submitPreSeasonForm = () => {
      axios
          .post(`http://localhost:8998/api/export/view/vte/pre/season?year=${input.value.preYear}&quarter=${input.value.preQuarter}`)
          .then(response => {
            const data = response.data;
            const officeNames = data.map(item => item.officeName);
            const vteRatesArray = data.map(item => item.vtePreventionRateArray);
            console.log(data);

            const preSeason = echarts.init(document.getElementById('pre-quarterly-chart'));
            const colors = ['#003366', '#006699', '#4cabce'];
            const series = [];
            for (let i = 0; i < 3; i++) {
              series.push({
                name: `第 ${i + 1} 个月`,
                type: 'bar',
                data: vteRatesArray.map(rates => rates[i] || 0),
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

            preSeason.setOption({
              tooltip: {
                trigger: 'axis',
                axisPointer: { type: 'shadow' },
              },
              legend: {
                data: series.map(item => item.name),
              },
              xAxis: {
                type: 'category',
                data: officeNames,
                axisLabel: {
                  interval: 0, // 设置为 0，表示所有标签都显示
                  rotate: -35, // 设置倾斜角度（逆时针方向）为 -45 度
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

    const submitPreOfficeTrend = () => {
      axios
          .post(`http://localhost:8998/api/export/view/vte/pre/trend/office?year=${input.value.preTrendYear}&officeName=${input.value.preOfficeName}`)
          .then(response => {
            if (!response.data) {
              console.log("未获取到数据");
              return;
            }
            const data = response.data;
            const month = data.map(item => item.month)
            const vteRates = data.map(item => item.vtePreventionRate);

            const preOffice = echarts.init(document.getElementById('pre-office-trend-chart'));
            preOffice.setOption({
              xAxis: {
                type: 'category',
                data: month
              },
              yAxis: {
                type: 'value'
              },
              series: [{
                data: vteRates,
                type: 'line',
                label: {
                  show: true, // 显示数据标签
                  position: 'top', // 标签位置：折线上方
                  formatter: '{c}', // 标签格式化，可根据需要进行调整
                },
                lineStyle: {} // 其他样式配置
              }]
            });
          })
          .catch(error => {
            console.error(error);
          });
    };

    const submitPreAvgTrend = () => {
      axios
          .post(`http://localhost:8998/api/export/view/vte/bleed/trend/hospital/month?year=${input.value.preAvgTrend}`)
          .then(response => {
            if (!response.data) {
              console.log("未获取到数据");
              return;
            }
            const data = response.data;
            const month = data.map(item => item.month)
            const averageRate = data.map(item => item.averageRate);

            const myChartHospital = echarts.init(document.getElementById('pre-hospital-trend-chart'));
            myChartHospital.setOption({
              xAxis: {
                type: 'category',
                data: month
              },
              yAxis: {
                type: 'value'
              },
              series: [{
                data: averageRate,
                type: 'line',
                label: {
                  show: true, // 显示数据标签
                  position: 'top', // 标签位置：折线上方
                  formatter: '{c}', // 标签格式化，可根据需要进行调整
                },
                lineStyle: {} // 其他样式配置
              }]
            });
          })
          .catch(error => {
            console.error(error);
          });
    };

    const submitPreAvgSeasonTrend = () => {
      axios
          .post(`http://localhost:8998/api/export/view/vte/pre/trend/hospital/season?year=${input.value.preAvgSeasonTrend}`)
          .then(response => {
            if (!response.data) {
              console.log("未获取到数据");
              return;
            }
            const data = response.data;
            const quarter = data.map(item => item.quarter)
            const averageRate = data.map(item => item.averageRate);

            const myChartHospitalSeason = echarts.init(document.getElementById('pre-hospital-season-trend-chart'));
            myChartHospitalSeason.setOption({
              xAxis: {
                type: 'category',
                data: quarter
              },
              yAxis: {
                type: 'value'
              },
              series: [{
                data: averageRate,
                type: 'line',
                label: {
                  show: true, // 显示数据标签
                  position: 'top', // 标签位置：折线上方
                  formatter: '{c}', // 标签格式化，可根据需要进行调整
                },
                lineStyle: {} // 其他样式配置
              }]
            });
          })
          .catch(error => {
            console.error(error);
          });
    };






    return {
      form,
      input, // 这里需要返回 input 使其能在模板中使用
      submitForm,
      submitSeasonForm,
      submitOfficeTrend,
      submitAvgTrend,
      submitAvgSeasonTrend,
      submitPreForm,
      submitPreSeasonForm,
      submitPreOfficeTrend,
      submitPreAvgTrend,
      submitPreAvgSeasonTrend
    };
  },
};
</script>



<style scoped>
/* 可选：VTE 页面的样式 */
.box {
  border: 1px solid white;
  text-align: center;
  padding: 10px;
  width: 800px;
  height: 30px;
  font-weight: bold;
  font-size: 24px;
}

</style>
