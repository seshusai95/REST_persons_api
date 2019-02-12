package com.example.person.detailsAPI.serviceimpl;


import java.util.HashSet;
import java.util.Set;


public class Permutation {

	     Set<String> st1 = new HashSet<>();
	     Set<String> st2 = new HashSet<>();
	     public static void main(String []args){
	       
	        
	        String str = "CAT"; 
	        Permutation permutation = new Permutation(); 
	        permutation.subsequence(str);
	        for (String string : permutation.st1) {
	        	int n = string.length(); 
	        	permutation.permute(string, 0, n-1);
	        	break;
	        	//System.out.println(string);
			}
	        for (String string : permutation.st2) {
				System.out.println(string);
				}
	     }
	     
	     private void subsequence(String str) 
	    { 
	        // iterate over the entire string 
	        for (int i = 0; i < str.length(); i++) { 
	              
	            // iterate from the end of the string 
	            // to generate substrings 
	            for (int j = str.length(); j > i; j--) { 
	                String sub_str = str.substring(i, j); 
	              
	                if (!st1.contains(sub_str)) 
	                    st1.add(sub_str); 
	  
	                // drop kth character in the substring 
	                // and if its not in the set then recur 
	                for (int k = 1; k < sub_str.length() - 1; k++) { 
	                    StringBuffer sb = new StringBuffer(sub_str); 
	  
	                    // drop character from the string 
	                    sb.deleteCharAt(k); 
	                    if (!st1.contains(sb)) 
	                        ; 
	                    subsequence(sb.toString()); 
	                } 
	            } 
	        } 
	    } 
	     
	     private void permute(String str, int l, int r) 
	    { 
	        if (l == r) {
	        	// we can make an API call here.. like we can use Merriam WebStar or Google API and pass the word to them and if we get a response we can insert the word in the collection
	            st2.add(str);
	           // System.out.println("You are here"+str);
	        }
	        else
	        { 
	            for (int i = l; i <= r; i++) 
	            { 
	                str = swap(str,l,i); 
	                permute(str, l+1, r); 
	                str = swap(str,l,i); 
	            } 
	        } 
	    } 

	    
	    public String swap(String a, int i, int j) 
	    { 
	        char temp; 
	        char[] charArray = a.toCharArray(); 
	        temp = charArray[i] ; 
	        charArray[i] = charArray[j]; 
	        charArray[j] = temp; 
	        return String.valueOf(charArray); 
	    } 
	
	
	
}
