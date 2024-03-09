<template>
  数据库中的数据是上一个月的数据<br>
  <div class="box">年度科室非计划再手术数量</div>
  <label for="officeYearInput">年份:</label>
  <input type="number" id="officeYearInput" v-model="input.officeYear" min="1900" max="9999">
  <button type="submit" @click="submitOfficeYear">查询</button>
  <div id="office-year-chart" style="width: 800px; height: 400px;"></div>

  <div class="box">同期比较年度科室非计划再手术数量</div>
  <label for="officeYearCompareInput">年份:</label>
  <input type="number" id="officeYearCompareInput" v-model="input.officeYearCompare" min="1900" max="9999">
  <button type="submit" @click="submitOfficeYearCompare">查询</button><br><br>
  <span class="color-block" style="background-color: #003366;"></span>头一年
  <span class="color-block" style="background-color: #4cabce;"></span>今年
  <div id="office-year-compare-chart" style="width: 800px; height: 400px;"></div>

  <div class="box">非计划再手术比例</div>


</template>

<script>
import axios from "axios";
import * as echarts from "echarts";
import {ref} from "vue";

export default {
  setup() {
    const input = ref({
      officeYear: null,
      officeYearCompare: null
    });
  const submitOfficeYear = () => {
    axios
        .post(`http://localhost:8998/api/export/view/unplanned/year/office?year=${input.value.officeYear}`)
        .then(response => {
          if (!response.data) {
            console.log("未获取到数据");
            return;
          }
          const data = response.data;
          const officeNames = data.map(item => item.officeName)
          const counts = data.map(item => item.count);

          const myChartOffice = echarts.init(document.getElementById('office-year-chart'));
          myChartOffice.setOption({
            xAxis: {
              type: 'category',
              data: officeNames
            },
            yAxis: {
              type: 'value'
            },
            series: [{
              data: counts,
              type: 'bar',
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

    const submitOfficeYearCompare = () => {
      axios
          .post(`http://localhost:8998/api/export/view/unplanned/year/compare?year=${input.value.officeYearCompare}`)
          .then(response => {
              const data = response.data;
              const officeNames = data.map(item => item.officeName);
              const countArray = data.map(item => item.countArray);
              console.log(data);

            const myChartYear = echarts.init(document.getElementById('office-year-compare-chart'));
            const colors = ['#003366', '#4cabce'];
            const series = [];
            for (let i = 0; i < 2; i++) {
              series.push({
                type: 'bar',
                data: countArray.map(rates => rates[i] || 0),
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

            myChartYear.setOption({
              tooltip: {
                trigger: 'axis',
                axisPointer: { type: 'shadow' },
              },
              // legend: {
              //   data: series.map(item => item.name),
              // },
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




    return {
      input, // 这里需要返回 input 使其能在模板中使用
      submitOfficeYear,
      submitOfficeYearCompare
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