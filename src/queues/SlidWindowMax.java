package queues;
import java.util.Deque;


public class SlidWindowMax{
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new java.util.LinkedList<>();
        for(int i = 0; i < n; i++){
            if(!deque.isEmpty() && deque.peekFirst() <= i-k){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i>=k-1){
                result[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] arr = {6,4,2,7,4,2};
        int window = 3;
        int[] res = maxSlidingWindow(arr, window);
        System.out.println(java.util.Arrays.toString(res));
    }
}