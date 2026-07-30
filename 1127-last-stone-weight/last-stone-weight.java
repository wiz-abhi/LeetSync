class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int s : stones) pq.offer(s);

        

        while(!pq.isEmpty()){
            if(pq.size() == 1) return pq.peek();
            int y = pq.poll();
            int x = pq.poll();

            if(x != y) pq.offer(y-x);  
        }

        if(pq.size()==0) return 0;
        else
        return pq.peek();

    }
}