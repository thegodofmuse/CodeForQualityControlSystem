//人事管理（hrp）-临床科室排序，不在数组中的科室不显示

export function officeSort(tableData) {
    const officeOrder = ["骨科", "神经外科", "肝胆胰外科", "胸外科", "泌尿外科", "普外儿外肛肠科", "烧伤整形美容皮肤外科",
        "乳腺甲状腺外科", "心血管内科", "呼吸与危重症医学科", "内分泌科", "消化内科", "神经内科", "肾病内科", "血液风湿免疫肿瘤科", "全科医学科",
        "老年医学科", "妇科","产一科","产二科", "儿科", "新生儿科", "重症医学科", "眼耳鼻喉科", "感染性疾病科","疼痛科"];

    // Filter the tableData array to only include elements that exist in officeOrder
    const filteredData = tableData.filter((item) => officeOrder.includes(item.officeName));

    // Sort the filteredData array based on the order in officeOrder
    const sortedData = filteredData.sort((a, b) => {
        const indexA = officeOrder.indexOf(a.officeName);
        const indexB = officeOrder.indexOf(b.officeName);
        return indexA - indexB;
    });

    return sortedData;
}
