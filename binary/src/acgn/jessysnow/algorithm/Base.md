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


## 二分搜索左右边界模版
> 此类问题可以将数组抽象为一个 0, 1 数组，1 代表满足了某种条件，0 表示未满足某种条件




### 最大值最小化问题

