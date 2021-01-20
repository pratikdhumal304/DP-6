
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : nopes

/*class Solution {
    public int nthUglyNumber(int n) {

        if(n==1)
            return 1;

        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        long ugly = 1;

        pq.add(ugly);
        set.add(ugly);

        int[] primes = {2,3,5};

        for(int i=1;i<=n;i++)
        {
            ugly = pq.poll();

            for(int prime:primes)
            {
                long newUglyNo = prime * ugly;
                if(!set.contains(newUglyNo))
                {
                    set.add(newUglyNo);
                    pq.add(newUglyNo);

                }
            }
        }

        return Math.toIntExact(ugly);
    }
}*/

class SolutionOne {
    public int nthUglyNumber(int n)
    {

        if(n==1)
            return 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        int n2 = 2;
        int n3 = 3;
        int n5 = 5;

        int[] array = new int[n+1];

        array[0] = 1;

        for(int i=1;i<=n;i++)
        {
            int min = Math.min(n2,Math.min(n3,n5));
            array[i] = min;

            if(min == n2)
            {
                p2++;

                n2 = array[p2]*2;
            }
            if(min == n3)
            {
                p3++;

                n3 = array[p3]*3;
            }
            if(min == n5)
            {
                p5++;

                n5 = array[p5]*5;
            }

        }

        return array[n-1];
    }
}