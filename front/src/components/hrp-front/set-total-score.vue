<template>
  <div class="center-text">
    设置质控单总分
  </div>
  <div>

    <el-table :data="tableData" border>
      <el-table-column label="科室">
        <template #default="scope">
          <!-- 使用普通的文本标签显示文本内容 -->
          <span>{{ scope.row.officeName }}</span>
        </template>
      </el-table-column>


      <el-table-column label="总分">
        <template #default="scope">
          <el-input v-model="scope.row.officeScore" @change="handleDataChange(scope.row)"></el-input>
          <el-button type="text" size="mini" @click="submitRowData(scope.row)">提交</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { reactive } from 'vue';
import axios from 'axios';

export default {
  data() {
    return {
      tableData: [] // 表格数据
    };
  },
  created() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      const url = 'http://localhost:8998/api/hrp/qcFormScore'; // 接口地址
      axios.get(url)
          .then(response => {
            // 处理成功响应
            const data = response.data;
            this.tableData = data.map(item => ({
              officeName: item.officeName,
              officeScore: item.officeScore
            }));
          })
          .catch(error => {
            // 处理错误
            console.error(error);
          });
    },
    handleDataChange(row) {
      // 处理数据修改
      row.modified = true; // 标记该行数据已被修改
    },
    submitRowData(row) {
      // 提交单行修改后的数据
      const url = 'http://localhost:8998/api/hrp/updateQcFormScore'; // 接口地址
      axios.put(url, [row])
          .then(response => {
            // 处理成功响应
            console.log('数据保存成功');
            this.$message.success('保存成功'); // 使用Element UI的Message组件显示保存成功的提示
            // 重新获取数据，更新表格
            this.fetchData();
          })
          .catch(error => {
            // 处理错误
            console.error(error);
            this.$message.error('保存失败'); // 使用Element UI的Message组件显示保存失败的提示
          });
    }

  }
};
</script>




<style scoped>
.center-text {
  text-align: center;
  font-size: 30px;
  font-weight: bold;
  color: green;
}

</style>