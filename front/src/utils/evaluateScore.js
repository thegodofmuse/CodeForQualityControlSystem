export default function evaluateScore(clinicData) {
    let escore = 0;

    if (clinicData && clinicData.mqData[0] && clinicData.mqData[0].pointsDeducted !== null) {
        escore += parseFloat(clinicData.mqData[0].pointsDeducted);
    }

    if (clinicData && clinicData.shiftHandoverData[0] && clinicData.shiftHandoverData[0].pointsDeducted !== null) {
        escore += parseFloat(clinicData.shiftHandoverData[0].pointsDeducted);
    }

    if (clinicData && clinicData.difficultCaseData[0] && clinicData.difficultCaseData[0].pointsDeducted !== null) {
        escore += parseFloat(clinicData.difficultCaseData[0].pointsDeducted);
    }

    if (clinicData && clinicData.deathCaseData[0] && clinicData.deathCaseData[0].pointsDeducted !== null) {
        escore += parseFloat(clinicData.deathCaseData[0].pointsDeducted);
    }

    if (clinicData && clinicData.outpatientMedicalRecordsData2[0] && clinicData.outpatientMedicalRecordsData2[0].totalPointsDeducted !== null) {
        escore += parseFloat(clinicData.outpatientMedicalRecordsData2[0].totalPointsDeducted);
    }

    // if (clinicData && clinicData.timelinessOfWritingData2[0] && clinicData.timelinessOfWritingData2[0].totalPointsDeducted !== null) {
    //     escore += parseFloat(clinicData.timelinessOfWritingData2[0].totalPointsDeducted);
    // }

    if (clinicData && clinicData.extendedHospitalStayManagementData3[0] && clinicData.extendedHospitalStayManagementData3[0].totalPointsDeducted !== null) {
        escore += parseFloat(clinicData.extendedHospitalStayManagementData3[0].totalPointsDeducted);
    }

    if (clinicData && clinicData.vtePreventionControlIndicatorsData[0] && clinicData.vtePreventionControlIndicatorsData[0].pointsDeducted !== null) {
        escore += parseFloat(clinicData.vtePreventionControlIndicatorsData[0].pointsDeducted);
    }

    if (clinicData && clinicData.unplannedReoperationData1 && clinicData.unplannedReoperationData1.deductedTotal !== null) {
        escore += parseFloat(clinicData.unplannedReoperationData1.deductedTotal);
    }

    if (clinicData && clinicData.singleDiseaseData2[0] && clinicData.singleDiseaseData2[0].pointsDeducted !== null) {
        escore += parseFloat(clinicData.singleDiseaseData2[0].pointsDeducted);
    }

    if (clinicData && clinicData.diameterCalculationData[0] && clinicData.diameterCalculationData[0].pointsDeducted !== null) {
        escore += parseFloat(clinicData.diameterCalculationData[0].pointsDeducted);
    }

    if (clinicData && clinicData.bloodTransfusionRelatedRecordsData2[0] && clinicData.bloodTransfusionRelatedRecordsData2[0].totalPointsDeducted !== null) {
        escore += parseFloat(clinicData.bloodTransfusionRelatedRecordsData2[0].totalPointsDeducted);
    }

    if (clinicData && clinicData.doctorPatientRelationshipData4[0] && clinicData.doctorPatientRelationshipData4[0].totalPointsDeducted !== null) {
        escore += parseFloat(clinicData.doctorPatientRelationshipData4[0].totalPointsDeducted);
    }

    escore = parseFloat(escore.toFixed(2));

    // 其他计算...

    return escore;
}
