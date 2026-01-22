package stacks;
import java.util.Stack;

public class StockSpan {
    static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> s = new Stack<>();
        
        span[0] = 1;
        s.push(0);
        for(int i=1; i<n; i++){
            while(!s.empty() && prices[s.peek()]<=prices[i]){
                s.pop();
            }
            if(s.empty()){
                span[i] = i+1;
            }
            else{
                span[i] = i - s.peek();
            }
            s.push(i);
        }
        return span;
    }
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);
        for(int s : span){
            System.out.print(s + " ");
        }
    }
}
