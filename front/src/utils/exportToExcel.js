import * as XLSX from 'xlsx';
import { saveAs } from 'file-saver';
export function exportToExcel(fscoreValue, finalAppealValue,table, fileName = '质控反馈单.xlsx') {
    const workbook = XLSX.utils.book_new();
    const worksheet = XLSX.utils.table_to_sheet(table, { cellStyles: true });

    // 设置列宽度
    worksheet['!cols'] = [
        { wch: 13.2 }, // 第一列宽度为 13.2
        { wch: 53.5 }, // 第二列宽度为 53.5
        { wch: 9.7 }   // 第三列宽度为 9.7
    ];

    // 设置默认样式
    const defaultStyle = {
        wrapText: true,
        alignment: { wrapText: true }
    };
    const defaultCellStyle = XLSX.utils.json_to_sheet([{ s: defaultStyle }]);
    worksheet['!rows'] = defaultCellStyle['!rows'];

    // 添加 fscore 值到表格中
    const fscoreCell = { r: 1, c: 1, v: fscoreValue };
    XLSX.utils.sheet_add_aoa(worksheet, [[fscoreCell.v]], { origin: fscoreCell });
    //添加finalAppealValue值到表中
    const finalAppealCell ={r:39, c:1, v:finalAppealValue};
    XLSX.utils.sheet_add_aoa(worksheet, [[finalAppealCell.v]], { origin: finalAppealCell });

    // 设置单元格样式
    const cellAddress = XLSX.utils.encode_cell(fscoreCell);
    worksheet[cellAddress].s = defaultStyle;

    const border = {
        top: { style: 'medium', color: { rgb: 'FF000000' } },
        bottom: { style: 'medium', color: { rgb: 'FF000000' } },
        left: { style: 'medium', color: { rgb: 'FF000000' } },
        right: { style: 'medium', color: { rgb: 'FF000000' } },
    };

    // 获取工作表的范围
    const range = XLSX.utils.decode_range(worksheet['!ref']);

    // 遍历工作表的每个单元格并设置边框
    for(let R = range.s.r; R <= range.e.r; ++R) {
        for(let C = range.s.c; C <= range.e.c; ++C) {
            let cell_address = {c:C, r:R};
            let cell_ref = XLSX.utils.encode_cell(cell_address);

            if(!worksheet[cell_ref]) worksheet[cell_ref] = {t:'n', v:undefined};
            worksheet[cell_ref].s = { border };
        }
    }

    XLSX.utils.book_append_sheet(workbook, worksheet, 'Sheet1');
    const excelBuffer = XLSX.write(workbook, { bookType: 'xlsx', type: 'array' });
    const data = new Blob([excelBuffer], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
    saveAs(data, fileName);
}




