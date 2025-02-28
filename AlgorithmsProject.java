
/**
 * This class is a submission to the Algorithms Project.
 * MILCS
 * @author Daniel B)
 */
public class AlgorithmsProject
{

	public static int[] array = {3, 14, 159, 2, 65, 358, 9, 79, 323, 8, 46, 264, 3, 38, 327};
	
	/**
	 * The main method. Runs all the methods so you can check if they're working properly through the console.
	 * @param args
	 */
	public static void main(String args[])
	{
		
		int[] copyArray = copyArray(array);
		
		//1. Return the smallest number in the array.
		System.out.println("1.");
		
		System.out.println(smallest(array));
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		//2. Return the index of the smallest number in the array.
		System.out.println("2.");
		
		System.out.println(indexOfSmallest(array));
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		//3. Return the average of all numbers in the array.
		System.out.println("3.");
		
		System.out.println(average(array));
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		//4. Return true if all numbers in the array are even, and return false otherwise.
		System.out.println("4.");
		
		System.out.println(allEven(array));
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		//5. If the array ever has two consecutive 5's, change them to 0's. 
		System.out.println("5.");
		
		copyArray = copyArray(array);
		neighbor5to0(copyArray);
		printArray(copyArray);
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		//6. Return true if any number shows up three times in a row, and return false otherwise. 
		System.out.println("6.");
		
		copyArray = new int[] {5, 3, 3, 3, 5};
		System.out.println(threeInARow(copyArray));
		
		copyArray = new int[] {3, 3, 3, 5};
		System.out.println(threeInARow(copyArray));
		
		copyArray = new int[] {5, 3, 3, 3};
		System.out.println(threeInARow(copyArray));
		
		System.out.println(threeInARow(array));
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		//7. Pass an array of ints and an int to be searched for. Return how many times that int shows up in the array.
		System.out.println("7.");
		
		System.out.println(countOf(3, array));
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		//8. Alter an array so that is the backwards version of the array initially passed. 
		System.out.println("8.");
		
		copyArray = copyArray(array);
		reverse(copyArray);
		printArray(copyArray);
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		//9. Shift all elements in an array to the right.
		System.out.println("9.");
		
		copyArray = copyArray(array);
		shift(copyArray);
		printArray(copyArray);
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		//10. Use either selection sort or insertion sort to sort an array. 
		System.out.println("10.");
		int[] stats;
		
		System.out.print("Selection Sort: ");
		copyArray = copyArray(array);
		stats = selectionSort(copyArray);
		printArray(copyArray);
		System.out.println("Checks: " + stats[0]);
		System.out.println("Switches: " + stats[1]);
		
		System.out.print("Insertion Sort: ");
		copyArray = copyArray(array);
		stats = insertionSort(copyArray);
		printArray(copyArray);
		System.out.println("Checks: " + stats[0]);
		System.out.println("Switches: " + stats[1]);
		
		System.out.print("Bubble Sort: ");
		copyArray = copyArray(array);
		stats = bubbleSort(copyArray);
		printArray(copyArray);
		System.out.println("Checks: " + stats[0]);
		System.out.println("Switches: " + stats[1]);
		
		System.out.print("Merge Sort: ");
		copyArray = copyArray(array);
		stats = mergeSort(copyArray);
		printArray(copyArray);
		System.out.println("Checks: " + stats[0]);
		System.out.println("Switches: " + stats[1]);
		
		System.out.print("Quick Sort: ");
		copyArray = copyArray(array);
		stats = quickSort(copyArray);
		printArray(copyArray);
		System.out.println("Checks: " + stats[0]);
		System.out.println("Switches: " + stats[1]);
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------\n");
		
		
		
		
	}

	/**
	 * 1. Return the smallest number in the array. 
	 */
	public static int smallest(int[] array)
	{
		
		//Length check.
		if (array.length > 0)
		{
			
			//Initializes smallest as the first element in the array.
			int smallest = array[0];
			
			//Iterates through each number in the array.
			for (int number : array)
			{
				
				//Changes smallest to the current number if smallest is actually bigger.
				if (number < smallest)
					smallest = number;
				
			}
			
			//Returns the smallest element of the array.
			return smallest;
			
		}

		//Returns 0 if there are no elements in the array.
		return 0;
		
	}

	/**
	 * 2. Return the index of the smallest number in the array. 
	 */
	public static int indexOfSmallest(int[] array)
	{
		
		//Length check.
		if (array.length > 0)
		{	
			
			//Initializes smallest as the first element in the array.
			int smallest = array[0];
			//Initializes the index of the smallest element to the first index of the array.
			int index = 0;
			
			//Iterates through the array.
			for (int i = 1; i < array.length; i++)
			{
				
				//Changes smallest and index to the current number and its index respectively if the current number is smaller.
				if (array[i] < smallest)
				{
					
					smallest = array[i];
					index = i;
					
				}
				
			}
			
			//Returns the smallest number's index.
			return index;
			
		}
		
		//Returns -1 if there are no elements in the array.
		return -1;
		
	}
		
	/**
	 * 3. Return the average of all numbers in the array. 
	 */
	public static int average(int[] array)
	{
		
		//Length check.
		if (array.length > 0)
		{
			
			
			//Initializes sum as zero.
			int sum = 0;
			
			//Iterates through each number in the array.
			for (int number : array)
			{
				
				//Adds the current number to sum.
				sum += number;
				
			}
			
			//Returns the sum of all the numbers in the array divided by the number of elements in the array.
			return sum / array.length;
			
		}
		
		//Returns 0 if there are no elements in the array.
		return 0;
			
		
	}
	
	/**
	 * 4. Return true if all numbers in the array are even, and return false otherwise.
	 */
	public static boolean allEven(int[] array)
	{
		
		//Iterates through each number in the array.
		for (int number : array)
		{
			
			//Determines if the number is even by checking if it can be divided by 2 without a reminder. Returns false if the number is not even.
			if (number % 2 > 0)
				return false;
			
		}
		
		
		//This part is reached only if all the numbers if have been determined to be true. Returns true, meaning all the numbers in the array are even.
		return true;
		
	}
	
	/**
	 * 5. If the array ever has two consecutive 5's, change them to 0's. 
	 * (For example, passing {4, 5, 5, 2, 1} changes the array to {4, 0, 0, 2, 1} ).
	 */
	public static void neighbor5to0(int[] array)
	{
		
		//Iterates through the array, except for the last element.
		for (int i = 0; i < array.length - 1; i++)
		{
			
			//Checks if the current element and the element after it are both 5.
			if (array[i] == 5 && array[i + 1] == 5)
			{
				
				//Turns both the current element and the element after it to 0 if they were both 5 beforehand.
				array[i] = 0;
				array[i + 1] = 0;
				
			}
			
		}
		
		
	}
	
	/**
	 * 6. Return true if any number shows up three times in a row, and return false otherwise. 
	 * Maybe not the best way to do this method but it's kinda funny with a for each.
	 */
	public static boolean threeInARow(int[] array)
	{
		
		//Length check.
		if (array.length > 2)
		{
			
			//Keeps track of how many of the same number occured in a row.
			int count = 1;
			
			//Initializes the previous number as a number that is not the first element in the array.
			int previous = array[0] + 1;
			for (int number : array)
			{
						
				//Increments the count if the previous number is the same as the current number.
				if (previous == number)
					count++;
				//Otherwise resets the count back to 1.
				else
					count = 1;
				
				
				//Returns true if three of the same number ever occurs.
				if (count == 3)
					return true;
				
				//Sets the previous number to the current number.
				previous = number;
				
			}
			
		}
		
		//If no three-in=a-rows pop up, then this will return false.
		return false;
		
	}
		
	/**
	 * 7. Pass an array of ints and an int to be searched for. Return how many times that int shows up in the array. 
	 * (For example, passing ( {4, 5, 5, 2, 1} , 5) returns 2 because 5 shows up twice)
	 */
	public static int countOf(int searched, int[] array)
	{
		
		//Keeps track of the number of times searched appears in the array.
		int count = 0;
		
		//Iterates through each number in the array.
		for (int number : array)
		{
			
			//If the current number is the searched number, count is incremented.
			if (number == searched)
				count++;
			
		}
		
		//Returns how many times the number searched for appeared in the array.
		return count;
		
	}
	
	/**
	 * 8. Alter an array so that is the backwards version of the array initially passed. 
	 * (For example, passing {4, 5, 5, 2, 1} changes the array to {1, 2, 5, 5, 4})
	 */
	public static void reverse(int[] array)
	{
		
		//Initializes an array called reversed with the same amount of elements as the original array.
		int[] reversed = new int[array.length];
		
		//Keeps track of how many times the for each loop has iterated.
		int count = 1;
		
		//Iterates through each number in the array.
		for (int number : array)
		{
			
			//Sets the last number of reversed to the first number of the original, etc.
			reversed[reversed.length - count] = number;
			//Increments count.
			count++;
			
		}
		
		//Sets the original array to the reversed array.
		for (int i = 0; i < reversed.length; i++)
			array[i] = reversed[i];
		
	}
	
	/**
	 * 9. Shift all elements in an array to the right. 
	 * (For example, passing {4, 5, 5, 2, 1} changes the array to {1, 4, 5, 5, 2})
	 */
	public static void shift(int[] array)
	{
		
		//Initializes an array called shifted with the same amount of elements as the original array.
		int[] shifted = new int[array.length];
		
		//Keeps track of how many times the for each loop has iterated.
		int count = 1;
		
		//Iterates through each number in the array.
		for (int number : array)
		{
			
			//Moves each number of the original array to the index after it in the shifted array.
			if (count == shifted.length)
				shifted[0] = number;
			//Moves the last number in the original to first number in the shifted array.
			else
				shifted[count] = number;
				count++;
			
		}
		
		//Sets the original array to the shifted array.
		for (int i = 0; i < shifted.length; i++)
			array[i] = shifted[i];
		
	}
	
	/*
	 * 10. Use either selection sort or insertion sort to sort an array. 
	 * (For example, passing {4, 5, 5, 2, 1} changes the array to {1, 2, 4, 5, 5})
	 * Imma do both cause why not.
	 * I'll also do bubble, quick, and merge, cause why not.
	 * I'll also keep track of the iterations, cause I'm curious.
	 */
	
	/**
	 * Selection Sort. Starts at the first number, switches it with the minimum if it is not the minimum already, then moves on to the next and repeats.
	 * @param array - The array to be sorted.
	 * @return The number of checks and switches that occurred.
	 */
	public static int[] selectionSort(int[] array)
	{
		
		//Keeps track of how many comparisons and switches the algorithm made.
		int checks = 0;
		int switches = 0;
		
		//Iterates through each number except for the last one.
		for (int i = 0; i < array.length - 1; i++)
		{
				
			//Sets the default minimum and its index as the current iteration.
			int min = array[i];
			int indexOfMin = i;
			
			//Increments checks.
			checks++;
			//Iterates through the rest of the numbers to find the true minimum. Increments checks after each iteration.
			for (int j = i + 1; j < array.length; j++, checks++)
			{
				
				//Sets min and indexOfMin to the current number and its index respectively if the current number is smaller than min.
				if (array[j] < min)
				{
					
					min = array[j];
					indexOfMin = j;
					
				}
				
			}
			
			//Checks if the min was not the original that was set.
			if (min != array[i])
			{
				
				//Switches the current number with the minimum.
				int temp = array[i];
				array[i] = min;
				array[indexOfMin] = temp;
				
				//Increments switches.
				switches++;
				
			}
			
    }
		
		//Returns the number of checks and switches that occurred.
		return new int[] {checks, switches};
		
	}

	/**
	 * Insertion Sort. Goes to the first element out of place, and inserts it to the left where it is supposed to be.
	 * I thought this would be harder to implement than selection, but it was surprisingly simple. Just wish I could make it more efficient.
	 * @param array - The array to be sorted.
	 * @return Number of checks and switches that occurred. 
	 */
	public static int[] insertionSort(int[] array)
	{
		
		//Keeps track of how many comparisons and switches the algorithm made.
		int checks = 0;
		int switches = 0;
		
		//Iterates through each number except for the first one.
		for (int i = 1; i < array.length; i++)
		{
			
			//Increments checks.
			checks++;
			//Iterates backwards from index i until the current number no longer has to be moved backwards or the it reaches the beginning.
			for (int j = i; j > 0 && array[j] < array[j - 1]; j--)
			{
				
				//Switches the element with the one before it.
				int temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
				
				//Increments checks and switches.
				checks++;
				switches++;
				
				
			}
			
		}
		
		//Returns the number of checks and switches that occurred.
		return new int[] {checks, switches};
		
	}
	
	/**
	 * Bubble Sort. Goes through the whole array, switching numbers that are next to each other, until the highest numbers "bubble" to the top.
	 * @param array - The array to be sorted.
	 * @return The number of checks and switches that occurred.
	 */
	public static int[] bubbleSort(int[] array)
	{
		
		//Keeps track of how many comparisons and switches the algorithm made.
		int checks = 0;
		int switches = 0;
		
		//Sets the sorted boolean to false to makes sure that the while loop iterates at least once.
		boolean sorted = false;
		//Iterates until the array is sorted. (No switches occur through a whole iteration.
		while (!sorted)
		{
			 
			//Sets sorted to true until a switch occurs.
			sorted = true;
			
			//Increments checks.
			checks++;
			//Iterates through each number of the array except the first one.
			for(int i = 1; i < array.length; i++, checks++)
			{
				 
				//Checks if the current number is less than the number before it.
				if (array[i] < array[i - 1])
				{
					
					//Swaps the current number and the one before it.
					int temp = array[i];
					array[i] = array[i - 1];
					array[i - 1] = temp;
					
					//Increments switches.
					switches++;
					
					//Sets sorted to false so the while loop iterates again.
					sorted = false;
					 
				}
				 
			}
			 
		}
		
		//Returns the number of checks and switches that occurred.
		return new int[] {checks, switches};
		
	}
	
	/**
	 * Merge Sort. Splits up an array into groups of two, then merges those groups of two with each other, then those groups with each other, etc.
	 * Based on what I've heard from Keola and you, I should be doing quick sort first as it's easier, but I guess I just hate myself.
	 * Ok I almost got it like 3rd try after some bug fixing but why are there two 327's now and one less 3? You know what I'mma work with a shorter array first.
	 * Nevermind I just forgot to increment.
	 * Ok apparently you can't just implement insertion sort inside merge sort and expect it to be efficient so I looked up how merging works and now know to just compare the two arrays' first values.
	 * How do I even define a switch in this algorithm?
	 * @param array - The array to be sorted.
	 * @return The amount of checks and switches that occurred..
	 */
	public static int[] mergeSort(int[] array)
	{
		
		//Keeps track of how many comparisons and switches the algorithm made.
		int checks = 0;
		int switches = 0;
		
		//Sets array1 to the left half of the original array.
		int[] array1 = new int[array.length / 2];
		//Declaring i outside the for loop keeps track of what index of the array that we are on for array2.
		int i;
		for (i = 0; i < array.length / 2; i++)
		{
			
			array1[i] = array[i];
			
		}
		
		//Sets array2 to the right half of the original array. (Modulo is there so that the length is right even if the original array length is odd)
		int[] array2 = new int[array.length / 2 + array.length % 2];
		for (int j = 0; i < array.length; j++)
		{
			
			array2[j] = array[i++];
			
		}
		
		//Recursively mergeSorts until each subarray only holds at most 1 element.
		if (array1.length > 1)
		{
			
			int[] stats = mergeSort(array1);
			
			//Adds the checks and switches of the recursive merge sorts to the main merge sort stats.
			checks += stats[0];
			switches += stats[1];
			
		}
		//Recursively mergeSorts until each subarray only holds at most 1 element.
		if (array2.length > 1)
		{
			
			int[] stats = mergeSort(array2);
			
			//Adds the checks and switches of the recursive merge sorts to the main merge sort stats.
			checks += stats[0];
			switches += stats[1];
			
		}
		
		//Sets i to zero so we can merge the arrays while changing the original.
		i = 0;
		//Keeps track of what index of array1 we are looking at, starting with the first.
		int array1Counter = 0;
		//Keeps track of what index of array2 we are looking at, starting with the first.
		int array2Counter = 0;
		
		//I think I blacked out while writing this merge section ngl. I'm was surprised when it actually worked.
		//I didn't really know how to define a switch, so I just incremented switches every time array2 was bigger than array1. 
		
		//Iterates until array1 and array2 have both been merged together.
		while (array1Counter < array1.length || array2Counter < array2.length)
		{
		
			//Appends the rest of array2 if array1 has been merged completely.
			while (array1Counter == array1.length && array2Counter < array2.length)
				array[i++] = array2[array2Counter++];
			
			//Appends the rest of array1 if array2 has been merged completely.
			while (array2Counter == array2.length && array1Counter < array1.length)
			{
				array[i++] = array1[array1Counter++];
				switches++;
			}
			
			//Compares the two values of array1 and array2 we are looking at and merges the one that is smaller. Then we change the element to compare at to the one after.
			if (array1Counter < array1.length && array2Counter < array2.length)
			{
				
				//Increments checks.
				checks++;
				
				//Merges the array1 element if it is less than or equal to the array2 element.
				if (array1[array1Counter] <= array2[array2Counter])
					array[i++] = array1[array1Counter++];
				//Otherwise merges the array2 element and increments switches.
				else
				{
					
					array[i++] = array2[array2Counter++];
					switches++;
					
				}
			}
				
			
		}
		
		//Returns the number of checks and switches that occurred.
		return new int[] {checks, switches};
		
	}

	/**
	 * Quick Sort. Picks a number (the pivot), sorts the rest into two sides that are less than or greater than that number, then recursively does that to the two sides.
	 * Wait why is this so much harder than merge sort.
	 * Nevermind it's just cause I counted the pivot when setting lesser and greater count instead of excluding it God that wasted so much time.
	 * @param array - The array to be sorted.
	 * @return The amount of checks and switches that occurred.
	 */
	public static int[] quickSort(int[] array)
	{
		
		//Keeps track of how many comparisons and switches the algorithm made.
		int checks = 0;
		int switches = 0;
		
		//Keeps track of how many numbers are lesser than (exclusive) or greater than (inclusive) the first number in the array.
		int lesserCount = 0;
		int greaterCount = 0;
		
		//I accidentally originally counted the pivot in this for loop, and spent 30 minutes trying to look for the bug in all the code below it.
		for (int i = 1; i < array.length; i++)
		{
			
			//I would have made the pivot number random, but I like the consistency of having it be the same every time, so I just made it the first number.
			if (array[i] < array[0])
				lesserCount++;
			else
				greaterCount++;
			
		}
		
		//Initializes arrays for the numbers less than (exclusive) and greater than (inclusive) the pivot with their respective counts.
		int[] lesserArray = new int[lesserCount];
		int[] greaterArray = new int[greaterCount];
		
		//Sets the counts back to zero so we can iterate over them in the upcoming for loop.
		lesserCount = 0;
		greaterCount = 0;
		
		//Iterates through each element in the array except for the first one.
		for (int i = 1; i < array.length; i++)
		{
			
			//Increments checks and switches and adds the current number to lesserArray if the number is less than the pivot.
			if (array[i] < array[0])
			{
				
				checks++;
				lesserArray[lesserCount++] = array[i];
				switches++;
			
			}
			//Otherwise just increments checks and adds the current number to greaterArray.
			else
			{
				
				checks++;
				greaterArray[greaterCount++] = array[i];
				
			}
			
		}
		
		//Recursively quickSorts until each subarray only holds at most 1 element.
		if (lesserArray.length > 1)
		{
			
			int[] stats = quickSort(lesserArray);
			
			//Adds the checks and switches of the recursive quick sorts to the main quick sort stats.
			checks += stats[0];
			switches += stats[1];
			
		}
		//Recursively quickSorts until each subarray only holds at most 1 element.
		if (greaterArray.length > 1)
		{
			
			int[] stats = quickSort(greaterArray);
			
			//Adds the checks and switches of the recursive quick sorts to the main quick sort stats.
			checks += stats[0];
			switches += stats[1];
			
		}
		
		//Declares the pivot formally as the initial element in the array.
		int pivot = array[0];
		//Declares i to keep track of which index we are changing in the original.
		int i = 0;
		
		//Iterates through each number in lesserArray, setting array at index i to the number and incrementing i.
		for (int number : lesserArray)
			array[i++] = number;
		
		//Fills in the missing pivot value.
		array[i++] = pivot;
		
		//Iterates through each number in greaterArray, setting array at index i to the number and incrementing i.
		for (int number : greaterArray)
		{
			
			array[i++] = number;
			
		}
		
		//Returns the number of checks and switches that occurred.
		return new int[] {checks, switches};
				
	}
	
	/**
	 * Method to make a copy of an int array easily.
	 * @param array - The array to be copied.
	 * @return A copy of the passed array.
	 */
	public static int[] copyArray(int[] array)
	{
		
		//Makes a copy array with the same amount of elements as the original.
		int[] copyArray = new int[array.length];
		
		//Copies elements one by one from the original to the copy.
		for (int i = 0; i < array.length; i++)
		{
			
			copyArray[i] = array[i];
			
		}
		
		//Returns the copy.
		return copyArray;
		
	}
	
	/**
	 * Method for easy printing of int arrays.
	 * @param array = The array to be printed.
	 */
	public static void printArray(int[] array)
	{
		
		//Iterates through each number in the array.
		for (int i = 0; i < array.length; i++)
		{
			
			//Adds a comma after the number, unless it is the last number.
			if (i == array.length - 1)
				System.out.print(array[i]);
			else
				System.out.print(array[i] + ", ");
			
		}
		
		//Goes to the next line.
		System.out.println();
		
	}
	
}
