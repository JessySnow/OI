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

    public static void main(String[] args) {
        int i = new Base().binarySearch(new int[]{1, 2, 3, 4, 4, 56}, 56);
        System.out.println(i);
    }

}
