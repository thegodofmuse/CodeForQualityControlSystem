// tableToExcel.js
import * as XLSX from 'xlsx';


export function tableToExcel(tableId, filename) {
    const table = document.getElementById(tableId);
    const wb = XLSX.utils.table_to_book(table);
    XLSX.writeFile(wb, filename);
}

