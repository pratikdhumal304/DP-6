// Time Complexity : O(n2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : nopes

/*class SolutionTwo
{
    public String longestPalindrome(String s)
    {

        if(s.length()<2)
            return s;

        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        int max = 1;

        int start = 0;
        int end = 0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                //charcters are equal and less than 2 or charcters are equal and i-1 j+1 are true then value is true
                if( s.charAt(i) == s.charAt(j) && (i-j < 2 || dp[i-1][j+1]) )
                {
                    dp[i][j] = true;
                    if(max< i - j + 1 )
                    {
                        max = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}*/

class SolutionTwo
{
    int start, max;
    public String longestPalindrome(String s)
    {

        if(s.length()<2)
            return s;

        int n = s.length();

        for(int i=0;i<n;i++)
        {
            extendAroundIndex(s,i,i);

            if( i<n-1 && s.charAt(i) == s.charAt(i+1))
            {
                extendAroundIndex(s,i,i+1);
            }

        }

        return s.substring(start,start+max);
    }

    private void extendAroundIndex(String s,int left, int right)
    {
        while( left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }

        if(right - left - 1 > max)
        {
            max = right - left - 1;
            start = left +1;
        }

    }
}





