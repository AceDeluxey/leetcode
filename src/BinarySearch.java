

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,12,18,22,29,38,49,52,85,92};
        int i = search(arr, 88, 0, arr.length - 1);//(0 , 4)
//        System.out.print(i);
        for(i=0;i<arr.length;i++){
            search(arr, arr[i], 0, arr.length - 1);
        }
    }
    public static int search(int[] arr, int target, int min, int max) {
        int cnt=0;
        if(min > max || max < min) {
            return -1;
        }
        while(min <= max) {
            int mid = (min + max) / 2;
            cnt++;
//            System.out.println(arr[mid] );
            if(arr[mid] == target) {
                System.out.println(cnt);
                return mid;
            }
            if(arr[mid] < target) {
                min = mid + 1;
            }else if(arr[mid] > target) {
                max = mid - 1;
            }else {
                return -1;
            }
        }

        return -1;
    }
}