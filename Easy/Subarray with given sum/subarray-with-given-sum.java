//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends



class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        ArrayList<Integer> list =  new ArrayList<>();
        if(s==0){
            list.add(-1);
            return list;
        }
        int i=0;
        int j=0;
        boolean isFound = false;
        int sum = arr[0];
        while(j<n){
            if(sum == s){
                isFound = true;
                break;
            }
            else if(sum>s){
                sum -= arr[i];
                i++;
            }
            else {
                j++;
                if(j<n)
                sum+=arr[j];
            }

        }
        if(!isFound){
            list.add(-1);
            return list;
        }
        list.add(i+1);
        list.add(j+1);
        return list;
    }
}