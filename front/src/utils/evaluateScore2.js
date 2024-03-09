//急诊科分数
export default function evaluateScore2(clinicData, medicalData) {
    let escore2 = 0;

    if (clinicData && clinicData.mqData[0] && clinicData.mqData[0].pointsDeducted !== null) {
        escore2 += parseFloat(clinicData.mqData[0].pointsDeducted);
    }

    if (clinicData && clinicData.shiftHandoverData[0] && clinicData.shiftHandoverData[0].pointsDeducted !== null) {
        escore2 += parseFloat(clinicData.shiftHandoverData[0].pointsDeducted);
    }

    if (clinicData && clinicData.difficultCaseData[0] && clinicData.difficultCaseData[0].pointsDeducted !== null) {
        escore2 += parseFloat(clinicData.difficultCaseData[0].pointsDeducted);
    }

    if (clinicData && clinicData.deathCaseData[0] && clinicData.deathCaseData[0].pointsDeducted !== null) {
        escore2 += parseFloat(clinicData.deathCaseData[0].pointsDeducted);
    }



    if (medicalData && medicalData.emergencyMedicalRecordsData2[0] && medicalData.emergencyMedicalRecordsData2[0].totalPointsDeducted !== null) {
        escore2 += parseFloat(medicalData.emergencyMedicalRecordsData2[0].totalPointsDeducted);
    }
    if (medicalData && medicalData.emergencyMedicalRecordsData4[0] && medicalData.emergencyMedicalRecordsData4[0].totalPointsDeducted !== null) {
        escore2 += parseFloat(medicalData.emergencyMedicalRecordsData4[0].totalPointsDeducted);
    }
    if (medicalData && medicalData.emergencyMedicalRecordsData6[0] && medicalData.emergencyMedicalRecordsData6[0].totalPointsDeducted !== null) {
        escore2 += parseFloat(medicalData.emergencyMedicalRecordsData6[0].totalPointsDeducted);
    }




    if (clinicData && clinicData.extendedHospitalStayManagementData3[0] && clinicData.extendedHospitalStayManagementData3[0].totalPointsDeducted !== null) {
        escore2 += parseFloat(clinicData.extendedHospitalStayManagementData3[0].totalPointsDeducted);
    }

    if (clinicData && clinicData.vtePreventionControlIndicatorsData[0] && clinicData.vtePreventionControlIndicatorsData[0].pointsDeducted !== null) {
        escore2 += parseFloat(clinicData.vtePreventionControlIndicatorsData[0].pointsDeducted);
    }

    if (clinicData && clinicData.unplannedReoperationData1 && clinicData.unplannedReoperationData1.deductedTotal !== null) {
        escore2 += parseFloat(clinicData.unplannedReoperationData1.deductedTotal);
    }

    if (clinicData && clinicData.singleDiseaseData2[0] && clinicData.singleDiseaseData2[0].pointsDeducted !== null) {
        escore2 += parseFloat(clinicData.singleDiseaseData2[0].pointsDeducted);
    }

    if (clinicData && clinicData.diameterCalculationData[0] && clinicData.diameterCalculationData[0].pointsDeducted !== null) {
        escore2 += parseFloat(clinicData.diameterCalculationData[0].pointsDeducted);
    }

    if (clinicData && clinicData.bloodTransfusionRelatedRecordsData2[0] && clinicData.bloodTransfusionRelatedRecordsData2[0].totalPointsDeducted !== null) {
        escore2 += parseFloat(clinicData.bloodTransfusionRelatedRecordsData2[0].totalPointsDeducted);
    }

    if (clinicData && clinicData.doctorPatientRelationshipData4[0] && clinicData.doctorPatientRelationshipData4[0].totalPointsDeducted !== null) {
        escore2 += parseFloat(clinicData.doctorPatientRelationshipData4[0].totalPointsDeducted);
    }

    escore2 = parseFloat(escore2.toFixed(2));

    // 其他计算...

    return escore2;
}
