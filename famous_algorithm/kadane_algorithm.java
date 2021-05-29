// It is a famous kadane's algorithm which is written by Ulf Grenander in 1977. 
// Time complexity of this algorithm is O(N) which makes it very fast.
// Space complexity of this algorithm is also O(N).
// Most Important algorithm asked by many MNC companies.
class kadane_algorithm{
    public static void main(String args[]){
        int arr[] = {-2, 3, 4, -1, 0, -3, 2};
        int answer = max_sum_subarray(arr);
        System.out.println(answer);
    }

    public static int max_sum_subarray(int arr[]){
        int max = arr[0]; // It is used to store max sum subarray element 
        for(int i = 1; i < arr.length; i++){
            int value = Math.max(arr[i], arr[i] + arr[i-1]);
            max = Math.max(value , max);
        }
        return max;
    }
}