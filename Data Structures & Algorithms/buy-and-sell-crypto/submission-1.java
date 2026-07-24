class Solution {
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int pist = 0;
        int op = 0;

        for(int price : prices){
            if(price < lsf){
                lsf = price;
            }

            pist = price - lsf;
            if(op < pist){
                op = pist;
            }
        }
        return op;
    }
}
