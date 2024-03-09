<template>
  <div>
    <el-button type="primary" @click="exportToExcel">导出为Excel</el-button>
    <el-table :data="tableData">
      <el-table-column prop="hospitalNumber" label="住院号"></el-table-column>
      <el-table-column prop="medicalRecordNumber" label="病案号"></el-table-column>
      <el-table-column prop="patientName" label="病人姓名"></el-table-column>
      <el-table-column prop="assessmentItem" label="考核项目"></el-table-column>
      <el-table-column prop="assessmentResult" label="考核结果"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import * as XLSX from 'xlsx';

export default {
  data() {
    return {
      tableData: [
        // 示例数据，实际根据需求自行填充
        { hospitalNumber: '12345', medicalRecordNumber: 'M1234', patientName: '张三', assessmentItem: '项目1', assessmentResult: '合格' },
        { hospitalNumber: '56789', medicalRecordNumber: 'M5678', patientName: '李四', assessmentItem: '项目2', assessmentResult: '不合格' },
      ],
    };
  },
  methods: {
    exportToExcel() {
      const worksheet = XLSX.utils.json_to_sheet(this.tableData);
      const workbook = XLSX.utils.book_new();
      XLSX.utils.book_append_sheet(workbook, worksheet, 'Sheet1');
      XLSX.writeFile(workbook, '表格数据.xlsx'); // 导出为名为 "表格数据.xlsx" 的 Excel 文件
    },
  },
};
</script>

