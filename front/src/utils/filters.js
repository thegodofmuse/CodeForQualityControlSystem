//转换百分数
export function toPercentage(value) {
    if (!value) return
    return (value * 100).toFixed(2) + '%';
}
