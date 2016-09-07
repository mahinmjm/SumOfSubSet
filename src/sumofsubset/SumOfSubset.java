/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumofsubset;

import java.util.*;

/**
 *
 * @author mahinjm
 */
public class SumOfSubset {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        int arr2[] = {15, 22, 14, 26, 32, 9, 16, 8};
        int len = arr2.length;
        //System.out.println(sumOSubset(arr2,30));
        
        System.out.println(sumOSubsetDP(arr2, len, 53));
    }
    
    //SumOfSubset in Recursion
    public static boolean sumOSubset(int arr[], int len, int sum){
        
        if(sum==0){
            return true;
        }
        
        if(len==0 && sum !=0){
            return false;
        }
        
        if(arr[len-1]>sum){
            return sumOSubset(arr, len-1, sum);
        }
        
        return sumOSubset(arr, len-1, sum) || sumOSubset(arr, len-1, sum-arr[len-1]);
        
    }
    
    
    //SumOfSubset in Dynamic Programming
    public static boolean sumOSubsetDP(int arr[], int len, int sum){
        
        boolean result[][] = new boolean[sum+1][len+1];
        

        //initializing true for second row of result array
        for(int i=0; i<=len;i++){
            result[0][i]=true;
        }
        //initializing false for first row of result array
        for(int i=0; i<=sum;i++){
            result[i][0]=false;
        }

        for(int i=1; i<=sum; i++){
            for(int j=1; j<=len; j++){
                if(sum==0){
                   return true;
                }
                if(len==0 && sum !=0){
                    return false;
                }
                result[i][j]=result[i][j-1];
                if(i>=arr[j-1]){
                    result[i][j] = result[i][j] || result[i-arr[j-1]][j-1];
                }
            }
        }
        
        return result[sum][len];
        
    }
    
}
