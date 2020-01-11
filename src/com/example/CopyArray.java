package com.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyArray {
	  public static void main(String[] args) {
		  CopyArray copyArray=new CopyArray();
		  copyArray.copy1();
		  copyArray.copy1Array2D();
		  copyArray.copy2();
		  copyArray.copy3Array2D();
		  copyArray.copy4Array2D();
	    }
	  
	  
	  public void copy1() { //fail
          System.out.println("copy1:" );
	        int[] scores1 = {88, 81, 74, 68, 78, 76, 77, 85, 95, 93};
	        int[] scores2 = Arrays.copyOf(scores1, scores1.length);
            System.out.println("score2:" );
	        for(int score : scores2) {
	            System.out.printf("%3d", score);
	        }
	        System.out.println();
	        scores1[0] = 99;
	        // ぃ紇臫score1把σ皚ン
            System.out.println("new score1:" );
	        for(int score : scores1) {
	            System.out.printf("%3d", score);
	        }
            System.out.println("\n new score2:" );
	        for(int score : scores2) {
	            System.out.printf("%3d", score);
	        }
	                
	  }
	  
	  public void copy1Array2D() { //good
          System.out.println("\ncopy1Array2D:" );
	        int[][] scores1 = {{88, 81, 74, 68, 78, 76, 77, 85, 95, 93},{88, 81, 74, 68, 78, 76, 77, 85, 95, 93}};
	        int[][] scores2 = Arrays.copyOf(scores1, scores1.length);
            System.out.println("score2:" );
	        for(int[] score : scores2) {
	        	for(int scoreint : score)
	            System.out.printf("%3d", scoreint);
	        }
	        System.out.println();
	        scores2[0][0] = 99;
	        // ぃ紇臫score1把σ皚ン
            System.out.println("score1:" );
	        for(int[] score : scores1) {
	        	for(int scoreint : score)
		            System.out.printf("%3d", scoreint);
	        }
            System.out.println("\nscore2:" );
	        for(int[] score : scores2) {
	        	for(int scoreint : score)
		            System.out.printf("%3d", scoreint);
	        }
	                
	  }
	  public void copy2() { //fail
          System.out.println("\ncopy2:" );
	        int[] scores1 = {88, 81, 74, 68, 78, 76, 77, 85, 95, 93};
	        int[] scores2 = scores1;
          System.out.println("score2:" );
	        for(int score : scores2) {
	            System.out.printf("%3d", score);
	        }
	        System.out.println();
	        scores2[0] = 99;
	        // 
          System.out.println("score1:" );
	        for(int score : scores1) {
	            System.out.printf("%3d", score);
	        }
          System.out.println("\nscore2:" );
	        for(int score : scores2) {
	            System.out.printf("%3d", score);
	        }
	                
	  }
	  
	  
	  public void copy3Array2D() { //good
          System.out.println("\ncopy3Array2D:" );
	        int[][] scores1 = {{88, 81, 74, 68, 78, 76, 77, 85, 95, 93},{88, 81, 74, 68, 78, 76, 77, 85, 95, 93}};
	        int[][] scores2 = scores1.clone() ;//= Arrays.copyOf(scores1, scores1.length);
	       //Arrays.stream(scores1).map(el -> el.clone()).toArray($ -> scores2.clone());
	  
	        		//deepCopy( scores1);
            System.out.println("score2:" );
	        for(int[] score : scores2) {
	        	for(int scoreint : score)
	            System.out.printf("%3d", scoreint);
	        }
	        System.out.println();
	        scores2[0][0] = 99;
	        // ぃ紇臫score1把σ皚ン
            System.out.println("score1:" );
	        for(int[] score : scores1) {
	        	for(int scoreint : score)
		            System.out.printf("%3d", scoreint);
	        }
            System.out.println("\nscore2:" );
	        for(int[] score : scores2) {
	        	for(int scoreint : score)
		            System.out.printf("%3d", scoreint);
	        }
	                
	  }
	  public void copy4Array2D() { //good
          System.out.println("\ncopy4Array2D:" );
	        int[][] scores1 = {{88, 81, 74, 68, 78, 76, 77, 85, 95, 93},{88, 81, 74, 68, 78, 76, 77, 85, 95, 93}};
	        int[][] scores2 = (int[][]) deepCopy(scores1);//= Arrays.copyOf(scores1, scores1.length);
	       //Arrays.stream(scores1).map(el -> el.clone()).toArray($ -> scores2.clone());
	  
	        		//deepCopy( scores1);
            System.out.println("score2:" );
	        for(int[] score : scores2) {
	        	for(int scoreint : score)
	            System.out.printf("%3d", scoreint);
	        }
	        System.out.println();
	        scores2[0][0] = 99;
	        // ぃ紇臫score1把σ皚ン
            System.out.println("score1:" );
	        for(int[] score : scores1) {
	        	for(int scoreint : score)
		            System.out.printf("%3d", scoreint);
	        }
            System.out.println("\nscore2:" );
	        for(int[] score : scores2) {
	        	for(int scoreint : score)
		            System.out.printf("%3d", scoreint);
	        }
	                
	  }
	  
	  public static Object deepCopy(Object src) 
	  { 
	      int srcLength = Array.getLength(src); 
	      Class srcComponentType = src.getClass().getComponentType(); 

	      Object dest = Array.newInstance(srcComponentType, srcLength); 

	      if (srcComponentType.isArray()) 
	      { 
	       for (int i = 0; i < Array.getLength(src); i++) 
	        Array.set(dest, i, deepCopy(Array.get(src, i))); 
	      } 
	      else 
	      { 
	       System.arraycopy(src, 0, dest, 0, srcLength); 
	      } 

	      return dest; 
	  } 
}
