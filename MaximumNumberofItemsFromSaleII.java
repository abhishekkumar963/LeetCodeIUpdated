// 3947. Maximum Number of Items From Sale II

import java.util.*;

class Solution {
    public long maximumSaleItems(int[][] items, long budget) {
        int n = items.length;
        long minPrice = Long.MAX_VALUE;
        
        int[] freq = new int[n + 1];
        for (int[] item : items) {
            int factor = item[0];
            long price = item[1];
            minPrice = Math.min(minPrice, price);
            freq[factor]++;
        }
        int[] multiples = new int[n + 1];
        for (int f = 1; f <= n; f++) {
            if (freq[f] > 0) {
                for (int mult = f; mult <= n; mult += f) {
                    multiples[f] += freq[mult];
                }
            }
        }
        
        List<long[]> deals = new ArrayList<>();
        for (int[] item : items) {
            int factor = item[0];
            long price = item[1];
            long gain = multiples[factor] - 1; // Exclude self
            
            if (gain > 0 && price < 2 * minPrice) {
                deals.add(new long[]{price, gain});
            }
        }
        
        // Sort deals by cheapest price first
        deals.sort(Comparator.comparingLong(a -> a[0]));
        
        long totalItems = 0;
        
        for (long[] deal : deals) {
            long price = deal[0];
            long gain = deal[1];
            
            if (budget < price) {
                break;
            }
            
            long canBuy = Math.min(gain, budget / price);
            totalItems += canBuy * 2;
            budget -= canBuy * price;
        }
        
        totalItems += budget / minPrice;
        
        return totalItems;
    }
}
