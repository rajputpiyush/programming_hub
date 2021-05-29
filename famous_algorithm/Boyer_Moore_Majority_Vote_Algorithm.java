// This is Boyer_Moore_Majority_Vote_Algorithm which is written by Robert S. Boyer and J Strother Moore in 1977

// Best Algorithm to find maximum elements occurs in array.

//  Condition is if the repeated element which occurs more in this array let '1' if taking below arr array as example
    //   so '1' occurs 5 times in array is greater than arr.length/2 (5 > arr.length /2) == (5>4). So it's return the element
    //  '1' else return no majority element found:
public class Boyer_Moore_Majority_Vote_Algorithm{
    public static void main(String [] args){
        int arr[] = {2, 1, 2, 2, 2, 1, 1 , 1,1};
        int answer = maximum_element_occur(arr);
        if(check_element(arr , answer)){
            System.out.println(answer);
        }else{
            System.out.println("No majority element found: ");
        }
    }
    public static int maximum_element_occur(int arr[]){
        int candidate = 0;
        int count = 0;
        for(int e : arr){
            if(count == 0) candidate = e;
            if(e == candidate) ++count;
            else --count;
        }
        return candidate;
    }
    public static boolean check_element(int arr[] , int answer){
        int count = 0;
        for(int element : arr){
            if(element == answer){
                count++;
            }
        }
        if(count > arr.length / 2){
            return true;
        }else{
            return false;
        }
    }
}