<template>
  <div>
    <div id="chart" style="width: 800px; height: 400px;"></div>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue';
import * as echarts from 'echarts';

export default {
  setup() {
    const chartOptions = ref({
      color: ['#003366', '#006699', '#4cabce', '#e5323e'],
      tooltip: {
        trigger: 'axis',
        axisPointer: {
          type: 'shadow'
        }
      },
      legend: {
        data: ['Forest', 'Steppe', 'Desert', 'Wetland']
      },
      toolbox: {
        show: true,
        orient: 'vertical',
        left: 'right',
        top: 'center',
        feature: {
          mark: { show: true },
          dataView: { show: true, readOnly: false },
          magicType: { show: true, type: ['line', 'bar', 'stack', 'tiled'] },
          restore: { show: true },
          saveAsImage: { show: true }
        }
      },
      calculable: true,
      xAxis: [
        {
          type: 'category',
          axisTick: { show: false },
          data: ['2012', '2013', '2014', '2015', '2016']
        }
      ],
      yAxis: [
        {
          type: 'value'
        }
      ],
      series: [
        {
          name: 'Forest',
          type: 'bar',
          barGap: 0,
          label: {
            show: true,
            position: 'inside'
          },
          data: [320, 332, 301, 334, 390]
        },
        {
          name: 'Steppe',
          type: 'bar',
          label: {
            show: true,
            position: 'inside'
          },
          data: [null, 182, 191, 234, 290]
        },
        {
          name: 'Desert',
          type: 'bar',
          label: {
            show: true,
            position: 'inside'
          },
          data: [150, 232, null, 154, 190]
        },
        {
          name: 'Wetland',
          type: 'bar',
          label: {
            show: true,
            position: 'inside'
          },
          data: [98, 77, 101, null, 40]
        }
      ]
    });

    onMounted(() => {
      const chartInstance = echarts.init(document.getElementById('chart'));
      chartInstance.setOption(chartOptions.value);
    });

    return {
      chartOptions
    };
  }
};
</script>

