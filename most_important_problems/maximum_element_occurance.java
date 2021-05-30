// This is the most important problem in dsa 
// we want to get answer in O(N) time and O(N) space complexity
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
public class maximum_element_occurance{
    public static void main(String [] args){
        int arr[] = {2 , 4, 12, 4, 23, 4, 5 , 4 , 2 , 4 , 23 , 22 , 4}; // using it for getting maximum occurance element in array
        System.out.println(find_maximum_element_occurance(arr));
    }
    public static int find_maximum_element_occurance(int arr[]){
        Map<Integer , Integer> map = new HashMap<Integer , Integer>();
        for(int i  =0; i < arr.length; i++){
            if(map.containsKey(arr[i])) {
            	int value = map.get(arr[i]);
            	value = value + 1;
            	map.replace(arr[i], value);
            }else {
            	map.put(arr[i],1);
            }
        }
        int max = 0;
        int helper = 0;
        for(Entry<Integer , Integer> entry : map.entrySet()) {
        	if(max < entry.getValue()) {
        		max = entry.getValue();
        		helper = entry.getKey();
        	}
        }
        return helper;
    }
    
}