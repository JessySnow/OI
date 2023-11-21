# 二分搜索
> 二分查找（英语：binary search），也称折半搜索（英语：half-interval search）、对数搜索（英语：logarithmic search），是用来在一个有序数组中查找某一元素的算法。

## 二分搜索基础模版

```
/**
 * 搜索到 target 返回下标，未搜索到返回 -1
 */
public int binarySearch(int[] array, int target) {
    int start = 0, end = array.length - 1;
    int index = -1;
    int mid;
    while (start <= end) {
        mid = start + ((end - start) >> 1);
        if (array[mid] > target) {
            end = mid - 1;
        } else if (array[mid] < target) {
            start = mid + 1;
        } else {
            index = mid;
            break;
        }
    }
    return index;
}
```

### 基础模版的中二分搜索边界

二分搜索的边界和搜索区间有关

基础模版中的搜索区间：[start, end]，属于是左闭右闭的区间范围，所以搜索结束时区间范围不合法的条件应该是 start > end（当 start = end 时依然合法)，当 mid 索引所指向的元素不是目标元素时可以直接跳过该索引（已经搜索过），所以区间范围中的 start 或者 end 更新为 mid + 1 或者 mid - 1

## 二分搜索左右边界模版

[Fuck algorithm 模版](https://github.com/labuladong/fucking-algorithm/blob/master/算法思维系列/二分查找详解.md)

### 最大值最小化问题

