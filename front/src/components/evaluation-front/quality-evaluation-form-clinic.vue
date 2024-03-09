<template>
  <div class="container">
    <div class="left">
      <form @submit.prevent="submitForm">
        <div class="form-group">
          <label for="selectInput">科室:</label>
          <select id="selectInput" v-model="form.select">
            <option disabled value="">请选择</option>
            <option value="心血管内科">心血管内科</option>
            <option value="消化内科">消化内科</option>
            <option value="呼吸与危重症医学科">呼吸与危重症医学科</option>
            <option value="肾病内科">肾病内科</option>
            <option value="神经内科">神经内科</option>
            <option value="内分泌科">内分泌科</option>
            <option value="全科医学科">全科医学科</option>
            <option value="重症医学科">重症医学科</option>
            <option value="老年医学科">老年医学科</option>
            <option value="血液风湿免疫肿瘤科">血液风湿免疫肿瘤科</option>
            <option value="感染性疾病科">感染性疾病科</option>
            <option value="中医科">中医科</option>
            <option value="中医康复科">中医康复科</option>
            <option value="康复科">康复科</option>
            <option value="普外儿外肛肠科">普外儿外肛肠科</option>
            <option value="胸外科">胸外科</option>
            <option value="肝胆胰外科">肝胆胰外科</option>
            <option value="神经外科">神经外科</option>
            <option value="泌尿外科">泌尿外科</option>
            <option value="骨科">骨科</option>
            <option value="乳腺甲状腺外科">乳腺甲状腺外科</option>
            <option value="烧伤整形美容皮肤外科">烧伤整形美容皮肤外科</option>
            <option value="眼耳鼻喉科">眼耳鼻喉科</option>
            <option value="疼痛科">疼痛科</option>
            <option value="麻醉科">麻醉科</option>
            <option value="妇科">妇科</option>
            <option value="产科">产科</option>
            <option value="产一科">产一科</option>
            <option value="产二科">产二科</option>
            <option value="儿科">儿科</option>
            <option value="新生儿科">新生儿科</option>

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
        <button @click="copyTable">一键复制表格</button>
      </div>

      <div class="form-group">
        <button @click="exportTable">导出到Excel</button>
      </div>
      <div class="form-group">
        <button @click="saveFinalScore">保存最终得分</button>
      </div>
      <div class="form-group">
        <button @click="saveFinalAppeal">保存最终申诉</button>
      </div>

      <div class="form-group">
        通过搜索框查询科室不能保存最<br>终扣分和最终申诉<br>
        <input type="text" v-model="form.searchInput" placeholder="请输入查询科室名" class="search-input" />
      </div>
      <div class="form-group">
      <button @click="submitInput">文本查询</button>
      </div>

    </div>

    <!-- 表格 -->
    <div class="right">
      <div id="tables">
      <table id="table-title">
        <tr>
          <td>{{ formattedDate }}</td>
          <td class="center">人民医院{{ form.select }}质控反馈单</td>
          <td></td>
        </tr>
      </table>
    <table id="table">
      <tr>
        <td>申诉后最终得分</td>
        <td><input type="number" v-model="fscore.value"></td>
        <td></td>
      </tr>
      <tr>
        <td>评估扣分</td>
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
        <td colspan="3">核心制度落实情况</td>
      </tr>
      <tr>
        <td>交接班制度</td>
        <td>
          <span v-if="!clinicData || !clinicData.shiftHandoverData || clinicData.shiftHandoverData.length === 0 ||
            (clinicData.shiftHandoverData[0].eyebrowColumn == null &&
            clinicData.shiftHandoverData[0].shiftContent == null &&
            clinicData.shiftHandoverData[0].successionContent == null &&
            clinicData.shiftHandoverData[0].bedsideHandover == null &&
            clinicData.shiftHandoverData[0].shiftDoctorSign == null &&
            clinicData.shiftHandoverData[0].successDoctorSign == null)">
            本月无质控缺陷
          </span>
          <span v-else>
            交接班眉栏未填 : {{ clinicData && clinicData.shiftHandoverData[0] && clinicData.shiftHandoverData[0].eyebrowColumn }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;交班内容不全 : {{ clinicData && clinicData.shiftHandoverData[0] && clinicData.shiftHandoverData[0].shiftContent }}<br>
            接班内容不全  : {{ clinicData && clinicData.shiftHandoverData[0] && clinicData.shiftHandoverData[0].successionContent }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;未体现床旁交接班 : {{ clinicData && clinicData.shiftHandoverData[0] && clinicData.shiftHandoverData[0].bedsideHandover }}<br>
            交班医生没签名 : {{ clinicData && clinicData.shiftHandoverData[0] && clinicData.shiftHandoverData[0].shiftDoctorSign}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;接班医生没签名 : {{ clinicData && clinicData.shiftHandoverData[0] && clinicData.shiftHandoverData[0].successDoctorSign}}<br>
          </span>

        </td>
        <td>{{ clinicData && clinicData.shiftHandoverData[0] && clinicData.shiftHandoverData[0].pointsDeducted }}</td>
      </tr>
      <tr>
        <td>疑难病例讨论制度</td>
        <td>
          <span v-if="!clinicData || !clinicData.difficultCaseData || clinicData.difficultCaseData.length === 0 ||
          (clinicData.difficultCaseData[0] &&
           clinicData.difficultCaseData[0].difficultDiscussion === null &&
           clinicData.difficultCaseData[0].participation == null &&
            clinicData.difficultCaseData[0].signedTitle == null &&
            clinicData.difficultCaseData[0].participationSigned == null &&
            clinicData.difficultCaseData[0].speechOrder == null &&
            clinicData.difficultCaseData[0].paste == null &&
            clinicData.difficultCaseData[0].discussionOpinions == null &&
            clinicData.difficultCaseData[0].hostSigned == null &&
            clinicData.difficultCaseData[0].recorderSigned == null &&
            clinicData.difficultCaseData[0].deathDiagnosis == null &&
            clinicData.difficultCaseData[0].solution == null &&
            clinicData.difficultCaseData[0].scrawledSignature == null)">
            本月无质控缺陷
          </span>
          <span v-else>
            是否进行疑难讨论: {{ clinicData && clinicData.difficultCaseData[0] && clinicData.difficultCaseData[0].difficultDiscussion}}<br>
            讨论病历类型: {{ clinicData && clinicData.difficultCaseData[0] && clinicData.difficultCaseData[0].medicalRecordType}}<br>
            参加人员是否欠缺: {{ clinicData && clinicData.difficultCaseData[0] && clinicData.difficultCaseData[0].participation}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;参与者是否签署职称: {{ clinicData && clinicData.difficultCaseData[0] && clinicData.difficultCaseData[0].signedTitle}}<br>
            参与者是否签字: {{ clinicData && clinicData.difficultCaseData[0] && clinicData.difficultCaseData[0].participationSigned}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发言顺序是否规范: {{ clinicData && clinicData.difficultCaseData[0] && clinicData.difficultCaseData[0].speechOrder}}<br>
            是否粘贴规范: {{ clinicData && clinicData.difficultCaseData[0] && clinicData.difficultCaseData[0].paste}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;是否手写具体讨论意见: {{ clinicData && clinicData.difficultCaseData[0] && clinicData.difficultCaseData[0].discussionOpinions}}<br>
            主持人是否签字: {{ clinicData && clinicData.difficultCaseData[0] && clinicData.difficultCaseData[0].hostSigned}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;是否签字潦草: {{ clinicData && clinicData.difficultCaseData[0] && clinicData.difficultCaseData[0].scrawledSignature}}<br>
            记录人是否签字:{{ clinicData && clinicData.difficultCaseData[0] && clinicData.difficultCaseData[0].recorderSigned}}
          </span>

        </td>
        <td>{{ clinicData && clinicData.difficultCaseData[0] && clinicData.difficultCaseData[0].pointsDeducted }}</td>

      </tr>
      <tr>
        <td>死亡病例讨论制度</td>
        <td>
          <span v-if="clinicData && clinicData.deathCaseData && (clinicData.deathCaseData.length === 0 || (clinicData.deathCaseData[0] && clinicData.deathCaseData[0].hasCaseDeath === '否'))">
          无死亡病人
          </span>
          <span v-else>
          是否有死亡病人: {{ clinicData && clinicData.deathCaseData[0] && clinicData.deathCaseData[0].hasCaseDeath}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;是否一周内完成死亡病例讨论:{{ clinicData && clinicData.deathCaseData[0] && clinicData.deathCaseData[0].hasRecord}}<br>
          参与人员是否欠缺:{{ clinicData && clinicData.deathCaseData[0] && clinicData.deathCaseData[0].participation}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;参与者是否签署职称:{{ clinicData && clinicData.deathCaseData[0] && clinicData.deathCaseData[0].signedTitle}}<br>
          参与者是否签字:{{ clinicData && clinicData.deathCaseData[0] && clinicData.deathCaseData[0].participationSigned}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发言顺序是否规范:{{ clinicData && clinicData.deathCaseData[0] && clinicData.deathCaseData[0].speechOrder}}<br>
          粘贴是否规范:{{ clinicData && clinicData.deathCaseData[0] && clinicData.deathCaseData[0].paste}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;是否手写具体讨论意见:{{ clinicData && clinicData.deathCaseData[0] && clinicData.deathCaseData[0].discussionOpinions}}<br>
          主持人是否签字:{{ clinicData && clinicData.deathCaseData[0] && clinicData.deathCaseData[0].hostSigned}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;记录人是否签字:{{ clinicData && clinicData.deathCaseData[0] && clinicData.deathCaseData[0].recorderSigned}}<br>
          是否明确死亡诊断:{{ clinicData && clinicData.deathCaseData[0] && clinicData.deathCaseData[0].deathDiagnosis}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;是否总结经验教训:{{ clinicData && clinicData.deathCaseData[0] && clinicData.deathCaseData[0].sumExperience}}<br>
          是否签字潦草:{{ clinicData && clinicData.deathCaseData[0] && clinicData.deathCaseData[0].scrawledSignature}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          </span>
        </td>
        <td>{{ clinicData && clinicData.deathCaseData[0] && clinicData.deathCaseData[0].pointsDeducted }}</td>
      </tr>
      <tr>
        <td>其他医疗管理制度</td>
        <td>无</td>
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
          {{ clinicData && clinicData.outPatientEmergencyAssessmentMessage }}
        </td>
        <td></td>
      </tr>

      <tr>
        <td>门诊病历书写</td>
        <td>
          <template v-if="clinicData && clinicData.outpatientMedicalRecordsData1">
            <div v-for="(item, index) in clinicData.outpatientMedicalRecordsData1" :key="index">
            {{ item.doctorName }}，{{ item.outpatientNumber }}，{{ item.summary }}，{{ item.totalDeductionPoints }}
            </div>
          </template>
          {{ clinicData && clinicData.outPatientMedicalRecordsMessage }}
        </td>
        <td>{{ clinicData && clinicData.outpatientMedicalRecordsData2[0] && clinicData.outpatientMedicalRecordsData2[0].totalPointsDeducted }}</td>
      </tr>
      <tr>
        <td>书写及时性（运行病历）</td>
        <td>
          {{ clinicData && clinicData.timelinessOfWritingMessage }}
          <template v-if="clinicData && clinicData.timelinessOfWritingData1">
            <div v-for="(item, index) in clinicData.timelinessOfWritingData1" :key="index">
              {{ item.admissionNumber }}，{{ item.doctorName }}，{{ item.qcResult }}
            </div>
          </template>
        </td>
        <td></td>
      </tr>

      <tr>
        <td>专项督查项目</td>
        <td>
          <template v-if="clinicData && clinicData.specialInspectionProjectData && clinicData.specialInspectionProjectData.length > 0">
            <div v-for="(item, index) in clinicData.specialInspectionProjectData" :key="index">
              {{ item.doctorName }}，{{ item.admissionNumber }}，{{ item.keyInspectionsThisMonth }}，{{ item.rectificationStatusIssuesLastMonth }}
            </div>
          </template>
          <template v-else>
            无明显质控缺陷
          </template>
        </td>
        <td></td>
      </tr>

      <tr>
        <td>终末病历</td>
        <td>
          {{ clinicData && clinicData.finalMedicalRecordDataMessage }}
          <template v-if="clinicData && clinicData.finalMedicalRecordData">
            <div v-for="(item, index) in clinicData.finalMedicalRecordData" :key="index">
              乙级病历：{{ item.patientId }}，缺陷：{{ item.fineReason }}， 医生：{{ item.doctorName }}和科室主任：{{ item.directorName }}，各扣{{ item.gradeBMedicalRecordDoctorFine }}元 {{ item.gradeCMedicalRecordDoctorFine }} {{ item.gradeCMedicalRecordDirectorFine }}
            </div>
          </template>
        </td>
        <td></td>
      </tr>
      <tr>
        <td colspan="3">住院日超30天</td>
<!--        <td></td>-->
<!--        <td></td>-->
      </tr>
      <tr>
        <td>病历书写</td>
        <td>
          {{ clinicData && clinicData.extendedHospitalStayManagementDataMessage1 }}
          {{ clinicData && clinicData.extendedHospitalStayManagementDataMessage11 }}
          <template v-if="clinicData && clinicData.extendedHospitalStayManagementData1">
            <div v-for="(item, index) in clinicData.extendedHospitalStayManagementData1" :key="index">
              {{ item.admissionNumber }}，有无阶段小结：{{ item.stageSummary }}，科主任是否查房：{{ item.directorRounds }}，是否科室讨论：{{item.officeDiscuss}}，是否进行沟通：{{ item.discuss }}
            </div>
          </template>
        </td>
        <td></td>
      </tr>
      <tr>
        <td>上报及时性</td>
        <td>
          <template v-if="clinicData && clinicData.extendedHospitalStayManagementDataMessage1 !== clinicData.extendedHospitalStayManagementDataMessage2">
            {{ clinicData.extendedHospitalStayManagementDataMessage1 }}
            {{ clinicData.extendedHospitalStayManagementDataMessage2 }}
          </template>
          <template v-else>
            {{ clinicData && clinicData.extendedHospitalStayManagementDataMessage1 }}
          </template>
          <template v-if="clinicData && clinicData.extendedHospitalStayManagementData2">
            <div v-for="(item, index) in clinicData.extendedHospitalStayManagementData2" :key="index">
              {{ item.doctorName }}，{{ item.admissionNumber }}，{{ item.reportType}}，{{ item.pointsDeducted }}
            </div>
          </template>
        </td>
        <td>{{ clinicData && clinicData.extendedHospitalStayManagementData3[0] && clinicData.extendedHospitalStayManagementData3[0].totalPointsDeducted }}</td>
      </tr>
      <tr>
        <td>VTE防控指标</td>
        <td>
          VTE评估中、高风险患者出血风险评估率{{ clinicData && clinicData.vtePreventionControlIndicatorsData[0] && clinicData.vtePreventionControlIndicatorsData[0].vteBleedingRiskAssessmentRate }}%<br>
          VTE评估中、高风险患者预防率{{ clinicData && clinicData.vtePreventionControlIndicatorsData[0] && clinicData.vtePreventionControlIndicatorsData[0].vtePreventionRate }}%
        </td>
        <td>{{ clinicData && clinicData.vtePreventionControlIndicatorsData[0] && clinicData.vtePreventionControlIndicatorsData[0].pointsDeducted }}</td>
      </tr>
      <tr>
        <td colspan="3">围手术期质量管理</td>
<!--        <td></td>-->
<!--        <td></td>-->
      </tr>

<!--      <tr>-->
<!--        <td>重大特殊手术审批</td>-->
<!--        <td></td>-->
<!--        <td></td>-->
<!--      </tr>-->

      <tr>
        <td>非计划再手术</td>
        <td>
          上月非计划再手术共{{ clinicData && clinicData.unplannedReoperationData1 && clinicData.unplannedReoperationData1.totalCount }}例<br>
          {{ clinicData && clinicData.unplannedReoperationDataMessage1 }}
          <template v-if="clinicData && clinicData.unplannedReoperationData2">
            <div v-for="(item, index) in clinicData.unplannedReoperationData2" :key="index">
              {{ item.admissionNumber }},上报类型：{{item.reportType}},科主任是否查房：{{item.directorRounds}},有无讨论：{{item.discuss}}
            </div>
          </template>
        </td>
        <td>{{ clinicData && clinicData.unplannedReoperationData1 && clinicData.unplannedReoperationData1.deductedTotal }}</td>
      </tr>
      <tr>
        <td>术后并发症</td>
        <td>
          {{ clinicData && clinicData.postoperativeComplicationsDataMessage }}
<!--          空值则不显示-->
          <template v-if="clinicData && clinicData.postoperativeComplicationsData && clinicData.postoperativeComplicationsData[0]">
            {{ clinicData.postoperativeComplicationsData[0].admissionNumber !== null ? clinicData.postoperativeComplicationsData[0].admissionNumber : '' }}
          </template>
        </td>
        <td></td>
      </tr>
<!--      <tr>-->
<!--        <td colspan="2">辅查申请单规范/病检申请单</td>-->
<!--&lt;!&ndash;        <td></td>&ndash;&gt;-->
<!--        <td></td>-->
<!--      </tr>-->
      <tr>
        <td>辅查申请单规范</td>
        <td>
          {{ clinicData && clinicData.medicalExamApplicationFormFailDataMessage }}
          <span v-if="clinicData && clinicData.medicalExamApplicationFormData && clinicData.medicalExamApplicationFormData.length > 0 && clinicData.medicalExamApplicationFormData[0].failureRate">
            缺陷率{{ toPercentage(clinicData.medicalExamApplicationFormData[0].failureRate) }}
          </span>
          <template v-if="clinicData && clinicData.medicalExamApplicationFormData && clinicData.medicalExamApplicationFormData[0]">
            缺陷例数{{ clinicData && clinicData.medicalExamApplicationFormData && clinicData.medicalExamApplicationFormData[0].unqualifiedCasesNumber }}<br>
          </template>
          <template v-if="clinicData && clinicData.medicalExamApplicationFormFailData">
            <div v-for="(item, index) in clinicData.medicalExamApplicationFormFailData" :key="index">
              {{ item.patientName }}，{{ item.doctorName }}，{{ item.receptionTime }}，申请单填写是否规范？{{ item.applicationFormSpecification }}，{{ item.doctorAdvice }}医嘱，是否填写标本固定时间？{{ item.specimenFixationTime }}，标本是否添加固定液？{{ item.addSampleFixationSolution }}
            </div>
          </template>
        </td>
        <td></td>
      </tr>
      <tr>
        <td colspan="3">合理诊疗</td>
<!--        <td></td>-->
<!--        <td></td>-->
      </tr>
      <tr>
        <td>临床路径</td>
        <td>
          <span v-if="clinicData && clinicData.diameterCalculationData && clinicData.diameterCalculationData[0] && typeof clinicData.diameterCalculationData[0].enrollmentRate !== 'undefined'">
            上月临床路径入组率{{ toPercentage(clinicData.diameterCalculationData[0].enrollmentRate) }}
          </span>
          <span v-else>
            本月临床路径无质控缺陷
          </span><br>
          <span v-if="clinicData && clinicData.diameterCalculationData && clinicData.diameterCalculationData[0] && typeof clinicData.diameterCalculationData[0].entryRate !== 'undefined'">
            上月临床路径入径率{{ toPercentage(clinicData.diameterCalculationData[0].entryRate) }}
          </span><br>
          <span v-if="clinicData && clinicData.diameterCalculationData && clinicData.diameterCalculationData[0] && typeof clinicData.diameterCalculationData[0].completionRate !== 'undefined'">
            上月临床路径完成率{{ toPercentage(clinicData.diameterCalculationData[0].completionRate) }}
          </span>
        </td>
        <td>
          {{ clinicData && clinicData.diameterCalculationData[0] && clinicData.diameterCalculationData[0].pointsDeducted }}
        </td>
      </tr>
      <tr>
        <td>单病种</td>
        <td>
<!--          <span v-if="clinicData && clinicData.singleDiseaseData1 && clinicData.singleDiseaseData1.length > 0 && clinicData.singleDiseaseData1[0] && clinicData.singleDiseaseData1[0].averageFillingRate">-->
<!--            年度平均上报率{{ clinicData.singleDiseaseData1[0].averageFillingRate }}%-->
<!--          </span>-->
          <span v-if="clinicData && clinicData.singleDiseaseData2 && clinicData.singleDiseaseData2.length > 0 && clinicData.singleDiseaseData2[0].reportingRate">
            年度上报率{{ clinicData.singleDiseaseData2[0].reportingRate }}%
          </span>
          <span v-else>
            本月单病种无质控缺陷
          </span>
        </td>
        <td>
          {{ clinicData && clinicData.singleDiseaseData2[0] && clinicData.singleDiseaseData2[0].pointsDeducted}}
        </td>
      </tr>
      <tr>
        <td colspan="3">合理用血(如为空白，则说明本月无用血)</td>
<!--        <td></td>-->
<!--        <td></td>-->
      </tr>
      <tr>
        <td>输血比例</td>
        <td>
          <span v-if="clinicData && clinicData.bloodTransfusionRatioData1 && clinicData.bloodTransfusionRatioData1.length > 0 && clinicData.bloodTransfusionRatioData1[0].componentBloodRatio">
            成分输血{{ clinicData.bloodTransfusionRatioData1[0].componentBloodRatio }}%
          </span>
        </td>
        <td></td>
      </tr>
      <tr>
        <td>用血情况</td>
        <td>
          <template v-if="clinicData && clinicData.bloodTransfusionRatioData2">
            <div v-for="(item, index) in clinicData.bloodTransfusionRatioData2" :key="index">
              <template v-if="Object.keys(item.data).length > 0">
                A型悬红:{{ item.data.atypeSuspensionRed }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A型血浆:{{ item.data.atypePlasma }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; B型悬红:{{ item.data.btypeSuspensionRed }}<br>
                B型血浆:{{ item.data.btypePlasma }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O型悬红:{{ item.data.otypeSuspensionRed }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O型血浆:{{ item.data.otypePlasma }}<br>
                AB型悬红:{{ item.data.abTypeSuspensionRed }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AB型血浆:{{ item.data.abTypePlasma }} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;洗涤RBC:{{ item.data.washRbc }}<br>
                解冻RBC:{{ item.data.thawRbc }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;全血:{{ item.data.fullBlood }}<br>
                单采血小板:{{ item.data.apheresisPlatelets}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 冷沉淀:{{ item.data.cryoprecipitate }}
              </template>
            </div>
          </template>
        </td>
        <td></td>
      </tr>
      <tr>
        <td>输血相关记录</td>
        <td>
          {{ clinicData && clinicData.bloodTransRecordMessage }}
            <template v-if="clinicData && clinicData.bloodTransfusionRelatedRecordsData">
              <div v-for="(item, index) in clinicData.bloodTransfusionRelatedRecordsData" :key="index">
                {{ item.zhuguanDoctorName}}，{{ item.admissionNumber }}，{{ item.majorDefect}}
              </div>
            </template>
        </td>
        <td>{{ clinicData && clinicData.bloodTransfusionRelatedRecordsData2[0] && clinicData.bloodTransfusionRelatedRecordsData2[0].totalPointsDeducted }}</td>
      </tr>
<!--      <tr>-->
<!--        <td colspan="2">合理用药</td>-->
<!--        &lt;!&ndash;        <td></td>&ndash;&gt;-->
<!--        <td></td>-->
<!--      </tr>-->
      <tr>
        <td>合理用药</td>
        <td>
<!--          <template v-if="clinicData && clinicData.rationalAdministrationDrugData">-->
<!--            <div v-for="(item, index) in clinicData.rationalAdministrationDrugData" :key="index">-->
<!--              {{ item.personResponsible}}&nbsp;{{ item.admissionOutpatientNum }}&nbsp;{{ item.qualityControlDetails}}&nbsp;{{ item.assessmentResults}}&nbsp;申诉：{{ item.appeal}}-->
<!--            </div>-->
<!--          </template>-->
<!--          {{ clinicData && clinicData.rationalAdministrationDrugMessage }}-->
          详见临床药学室OA传阅考核反馈
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
          {{ clinicData && clinicData.doctorPatientRelationshipMessage3 }}<br>
        </td>
        <td>{{ clinicData && clinicData.doctorPatientRelationshipData4[0] && clinicData.doctorPatientRelationshipData4[0].totalPointsDeducted }}</td>
      </tr>


<!--      <tr>-->
<!--        <td>公卫、预防保健、传染病</td>-->
<!--        <td>-->
<!--          病区健康教育问题反馈：{{ clinicData && clinicData.phPhIdData[0] && clinicData.phPhIdData[0].wardHealthEducation }}<br>-->
<!--          死因监测工作中问题反馈：{{ clinicData && clinicData.phPhIdData[0] && clinicData.phPhIdData[0].deathMonitoringWork}}<br>-->
<!--          疫苗及冷链相关工作中问题反馈：{{ clinicData && clinicData.phPhIdData[0] && clinicData.phPhIdData[0].vaccinesAndColdChain }}<br>-->
<!--          食源性疾病监测工作问题反馈：{{ clinicData && clinicData.phPhIdData[0] && clinicData.phPhIdData[0].foodborneDiseaseMonitoring }}<br>-->
<!--          传染病上报管理工作中问题反馈：{{ clinicData && clinicData.phPhIdData[0] && clinicData.phPhIdData[0].winfectiousDiseaseReporting }}<br>-->
<!--          妇幼工作中问题反馈：{{ clinicData && clinicData.phPhIdData[0] && clinicData.phPhIdData[0].maternalChildWork }}<br>-->
<!--          公共卫生科建卷专项检查：{{ clinicData && clinicData.phPhIdData[0] && clinicData.phPhIdData[0].publicHealthCheck }}<br>-->
<!--        </td>-->
<!--        <td></td>-->
<!--      </tr>-->
      <tr>
        <td>病案科质控</td>
        <td>详见OA传阅病案科质控反馈</td>
        <td></td>
      </tr>
      <tr>
        <td>其他质控项目</td>
        <td>无</td>
        <td></td>
      </tr>
<!--      <tr>-->
<!--        <td>质控科追踪上月整改情况</td>-->
<!--        <td>{{ clinicData && clinicData.qcRectificationSituationData[0] && clinicData.qcRectificationSituationData[0].rectificationSituation }}</td>-->
<!--        <td></td>-->
<!--      </tr>-->
      <tr>
        <td>科室整改措施</td>
        <td>{{ clinicData && clinicData.rectificationMeasuresData[0] && clinicData.rectificationMeasuresData[0].measure }}<br><br></td>
        <td></td>
      </tr>
      <tr>
        <td>最终申诉</td>
        <td></td>
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
          1、以上考核中各项目解释权分别为:门诊出勤考核归门诊部，病案科质控归病案科，合理用药考核归临床药学室，合理用血考核归输血科，不良事件上报及患者权益归医患关系办，其余项目归质控科。<br>
          2、部分考核结果已提前公示通知各科负责人并告知最后申诉时间，过期不再接受申诉。<br>
          3、未提前公示的内容在本质控单发放后下一个工作日下午17:00结束申诉。<br>
        </td>
        <td></td>
      </tr>


      <!-- 其他行... -->
    </table>
    </div><br>
      最终申诉请填到这里来：
      <textarea v-model="finalAppeal" class="final-appeal-input"></textarea>
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




.container {
  display: flex;
}

.left {
  flex-basis: 30%; /* 左边占据30%的宽度 */
  padding-right: 20px; /* 左边与右边的间距，根据需要进行调整 */
}

.right {
  flex-basis: 45%; /* 右边占据70%的宽度 */
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








