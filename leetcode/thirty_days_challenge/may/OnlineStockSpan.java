package leetcode.thirty_days_challenge.may;

public class OnlineStockSpan {

	int[] arr = new int[10000];
    int[] counter = new int[10000];
    int index = 0;
    
    public int next(int price) {
        this.arr[index++] = price;
        return getSpan(index-1);
    }
    
    private int getSpan(int index) {
        int span = 1, i = index-1;
        while(i >= 0) {
            if(arr[i] <= arr[index])
                span += counter[i];
            else
                break;
            i = i-counter[i];
        }
        counter[index]=span;
        return span;
    }
    
}