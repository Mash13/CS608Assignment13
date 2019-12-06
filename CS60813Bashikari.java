import java.util.*;
import java.io.*;

public class CS60813Bashikari {
	
	static int[] LUP(String[] array, int lineNum) {
		
		int line = lineNum + 1;
		int maxLength = 0;
		int largestHeadLocation = 0;
		
		int[] longest = new int[separateIntLength(array, lineNum)];//original array
		longest = separateInt(array, lineNum);
		
		int[] longestSL = new int[separateIntLength(array, lineNum)];//length of each element
		int[] prevHead = new int[separateIntLength(array, lineNum)];//element's previous head
		
		System.out.println("Line # " + line);
		//System.out.println("3xn array for line # " + line);
		System.out.print("Ar: ");
		System.out.print(longest[0] + " ");
		longestSL[0] = 1;
		prevHead[0] = 0;
		for (int i = 1; i < longest.length; i++) 
		{
			int j = 0;
			System.out.print(longest[i] + " ");
			
			//System.out.println("Test: current value of longest[i] = " + longest[i]);
			//for (int j = 0; j < longest.length; j++)
			while (j < i) {//iterate through all previous elements
				//System.out.println("\nTest: current value of longest[i] = " + longest[i]);
				//System.out.println("Test: current value of longest[j] = " + longest[j]);
				if (longest[i] > longest[j]) { //if current elements is larger than current iteration
					
					//System.out.println("Test: current value of longest[j] = " + longest[j]);
					//System.out.println("\nTest: current value of j = " + j);
					//System.out.println("Test: current value of longestSL[i] = " + longestSL[i]);
					//System.out.println("Test: current value of longestSL[j] = " + longestSL[j]);
					if (longestSL[i] <= longestSL[j]) { //if current element's length is smaller than current iteration's length
						longestSL[i] = longestSL[j] + 1; //make current element's length one more than current iteration's length
						prevHead[i] = longest[j];
					}									 
				}
				
				j++;
			}
			
			
		}
		System.out.println("");
		
		//System.out.print("SL: ");
		for (int i = 0; i < longestSL.length; i++) 
		{
			
			//System.out.print(longestSL[i] + " ");
			
		}
		System.out.println("");
		
		//System.out.print("PH: - ");
		for (int i = 1; i < prevHead.length; i++) 
		{
			
			//System.out.print(prevHead[i] + " ");
			
		}
		//System.out.println("");
		
		for (int i = 0; i < longestSL.length; i++) {
			
			if (longestSL[i] > maxLength) {
				maxLength = longestSL[i];
				largestHeadLocation = i;
			}
			
		}
		
		int[] longestSequence = new int[maxLength];
		maxLength = maxLength - 1;
		
		longestSequence[maxLength] = longest[largestHeadLocation]; //last element in longestSequence is equal to the element with max length
		
		for (int j = longestSequence.length - 1; j >= 0; j--) {
			
			if (longestSequence[j] != longest[largestHeadLocation]) {// if last element in longestSequence does not equal the largest head... basically testing to see if longestSequence[j] is filled with an element already.
					
				longestSequence[j] = prevHead[largestHeadLocation];//fill longestSequence[j] with the previous head
					
				int k = 0;
				while (longestSequence[j] != longest[k]) { //find the next previous head by searching through 'longest[]' array	
					k++;
				}
					
				if (longestSequence[j] == longest[k]) {//test
						
					largestHeadLocation = k;
						
				}
			}
		}
		
		//for(int i = 0; i < prevHead.length; i++)
		//	System.out.println("prevHead[" + i + "] = " + prevHead[i]);
		
		System.out.println("Hanger for line " + line + ": ");
		hangers(longest, longestSL, maxLength);
		System.out.println("");
		
		System.out.println("The LUP for line " + line + " is: ");
		for (int i = 0; i <= maxLength; i++) {
			
			System.out.print(longestSequence[i] + " ");
			
		}
		System.out.println("");
		System.out.println("");
		
		return longestSequence;
	}
	
	static int[] separateInt(String[] array, int lineNum) {
		
		String[] stringArray = array[lineNum].split(" ");
	      int[] intArray = new int[stringArray.length];
	      for (int i = 0; i < stringArray.length; i++) {
	         String numberAsString = stringArray[i];
	         intArray[i] = Integer.parseInt(numberAsString);
	      }
	      //System.out.println("Number of integers for line " + lineNum + ": " + intArray.length);
	      //System.out.println("The integers are:");
	      //for (int number : intArray) {
	      //   System.out.println(number);
	      //}
	      
	      return intArray;
	}
	
	static int separateIntLength(String[] array, int lineNum) {
		
		String[] stringArray = array[lineNum].split(" ");
	      int[] intArray = new int[stringArray.length];
	      for (int i = 0; i < stringArray.length; i++) {
	         String numberAsString = stringArray[i];
	         intArray[i] = Integer.parseInt(numberAsString);
	      }
	      //System.out.println("Number of integers: " + intArray.length);
	      //System.out.println("The integers are:");
	      //for (int number : intArray) {
	      //   System.out.println(number);
	      //}
	      
	      return intArray.length;
	}
	
	static void hangers(int[] longest, int[] longestSL, int maxLength) {
		
		
		
		for (int i = 0; i <= maxLength + 1; i++) {
			
			int tempLength = 0;
			
			for (int k = 0; k < longestSL.length; k++) {
				
				if (longestSL[k] == i) {
					tempLength++;
				}
				
			}
			int[] temp = new int[tempLength];
			int tempIterate = 0;
			
			for (int j = 0; j < longest.length; j++) {
				if (longestSL[j] == i) {//checks to see if the elements length is equal to the current length
					//System.out.print(longest[j] + " ");
					temp[tempIterate] = longest[j];
					tempIterate++;
				}
			}
			
			for (int l = 0; l < temp.length; l++) {
				
				System.out.print(temp[l] + " ");
				
			}
			
			System.out.println("");
		}	
	}
	
	public static void main(String[] args) throws Exception {
		
		String[] dataLength = new String[100];
		int lengthCount = 0;
		int j = 0;
		
		//scan data file to in
		Scanner in = new Scanner(new File("LUPData.txt"));
		
		//place data within int array dataLength 
		//to later find the exact amount of numbers to be added to the tree
		while (in.hasNextLine())
	    {
	        dataLength[j] = in.nextLine();
	        j++;
	    }
		j = 0;
		
		//if an arrayOutOfBounds error is given, dataLength may need to be filled with nulls.
		//makes lengthCount equal to the correct number of elements to be inserted
		while (dataLength[j] != null)
		{
			lengthCount++;
			j++;
		}
		
		//System.out.println("Amount of lines in file: " + lengthCount);
		
		String[] data = new String[lengthCount];
		
		//transfers elements scanned into dataLength to data
		for(int i = 0; i < data.length; i++)
		{
			data[i] = dataLength[i];
		}
		
		//separateInt(data, 0);
		
		//Print the LUP for each line
		for (int i = 0; i < data.length; i++)
		{
		LUP(data, i);
		}
		
		//Print the 3xn array for each line
		
		
		
	}

}
