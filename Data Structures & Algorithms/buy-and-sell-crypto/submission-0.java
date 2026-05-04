class Solution {
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE, op = 0, pist = 0;
        for(int price : prices){
            if(price < lsf){
                lsf = price;
            }

            pist = price - lsf;
            if(pist > op){
                op = pist;
            }
        }
        return op;
    }
}
