package acgn.jessysnow.algorithm;

public class Base {
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

    /**
     * 利用二分搜索查找左边界的问题
     */
    public int binarySearchTillLeft(int[] array, int target) {
        int start = 0, end = array.length - 1, mid;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (array[mid] > target) {
                end = mid - 1;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else if (array[mid] == target) {
                end = mid - 1;
            }
        }

        return start;
    }

    public int binarySearchTillRight(int[] array, int target) {
        int start = 0, end = array.length - 1, mid;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (array[mid] > target) {
                end = mid - 1;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else if (array[mid] == target) {
                start = mid + 1;
            }
        }

        return end;
    }

    public static void main(String[] args) {
        int i = new Base().binarySearch(new int[]{1, 2, 3, 4, 4, 56}, 56);
        int j = new Base().binarySearchTillLeft(new int[]{1, 2, 3, 4, 4, 56}, 1);
        int k = new Base().binarySearchTillRight(new int[]{1, 2, 3, 4, 4, 56}, 1);
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }

}
