/*
* <Makes an array of the cars and modifies it>
* CSC 1351 Programming Project No <1>
* Section <2>
* @author <Nicholas Luke>
* @since <3/17/2024>
*/
import java.util.Arrays;
import java.util.Iterator;

public class aOrderedList {
	private final int SIZEINCREMENTS = 20; //size of increments for increasing ordered list
	private Comparable[] oList; //the ordered list
	private int listSize; //the size of the ordered list
	private int numObjects; //the number of objects in the ordered list
	/**
	* <Constructor that sets the number of objects, gives the list size a size, and instantiates our array>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Nicholas Luke>
	* @since <3/17/2024>
	*
	*/
	public aOrderedList() {
		numObjects = 0;
		listSize = SIZEINCREMENTS;
		oList = new Comparable[listSize];
	}
	/**
	* <Adds new objects to array and maintains sorted order>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Nicholas Luke>
	* @since <3/17/2024>
	*
	*/
	public void add(Comparable newObject) {
        // Ensure capacity
        if (numObjects == listSize) {
           increaseArray();
        }

        // Find the correct position to maintain sorted order
        int index = 0;
        while (index < numObjects && oList[index].compareTo(newObject) < 0) {
            index++;
        }
        // Shift elements to make space for the new Comparable
        for (int i = numObjects; i > index; i--) {
            oList[i] = oList[i - 1];
        }
        // Insert the new Comparable
        oList[index] = newObject;
        numObjects++;
	}
	/**
	* <Increases the size of the array>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Nicholas Luke>
	* @since <3/17/2024>
	*
	*/
    public void increaseArray() {
    	listSize += SIZEINCREMENTS;
    	oList = Arrays.copyOf(oList, listSize);
    }
	/**
	* <Formats the information and prints it out>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Nicholas Luke>
	* @since <3/17/2024>
	*
	*/
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < numObjects; i++) {
            result.append(oList[i].toString());
            if (i < numObjects - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    	}
    
	/**
	* <Used to return the number of elements in list>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Nicholas Luke>
	* @since <3/17/2024>
	*
	*/
    public int size() {
    	return numObjects;
    }
    
	/**
	* <Returns the element at the specified position in list>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Nicholas Luke>
	* @since <3/17/2024>
	*
	*/
    public Comparable get(int index) {
    	return oList[index];
    }
    
	/**
	* <Tells us if the array is empty and returns true if it is, false otherwise>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Nicholas Luke>
	* @since <3/17/2024>
	*
	*/
    public boolean isEmpty() {
    	if (numObjects == 0) {
    		return true;
    	}
    	return false;
    }
    
	/**
	* <Removes element at specified position on array>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Nicholas Luke>
	* @since <3/17/2024>
	*
	*/
    public void remove(String make, int year){   
    	Comparable[] newArray = new Comparable[oList.length - 1];
    	Car tempCar = new Car (make, year, 0);
    	
    	boolean inList = false;
    	
    	for (int i = 0, k = 0; i < numObjects; i++) { 
    		 if (oList[i].compareTo(tempCar) == 0) {
    			 inList = true;
    			 continue;		// if the 2 cars are the same then loop is repeated 
    		 }
    		 newArray[k++] = oList[i]; //if it doesn't meet requirements, added to array
    	 }
    	
    	if (inList)
    	{
    		oList = newArray;
    		listSize--;
        	numObjects--;
    	}
    }
	/**
	* <Initializes iterator method>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Nicholas Luke>
	* @since <3/17/2024>
	*
	*/
    private int curr;{
    }
    /**
	* <Resets the iterator parameters>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Nicholas Luke>
	* @since <3/17/2024>
	*
	*/
    public void reset() {
        curr = 0;
    }
    /**
	* <Returns next element in iteration and increments the paramaters>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Nicholas Luke>
	* @since <3/17/2024>
	*
	*/
    public Comparable next() {
        return oList[curr++];
    }
    /**
	* <Returns true if iteration has more elements to iterate through>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Nicholas Luke>
	* @since <3/17/2024>
	*
	*/
    public boolean hasNext() {
        return curr < numObjects;
    }
    /**
	* <Removes last element returned by the next() method>
	*
	* CSC 1351 Programming Project No <1>
	* Section <2>
	*
	* @author <Nicholas Luke>
     * @param k 
     * @param j 
	* @since <3/17/2024>
	*
	*/
    public void remove(int j, int k) {
        if (curr == 0)
            throw new IllegalStateException();
        for (int i = curr - 1; i < numObjects - 1; i++) {
            oList[i] = oList[i + 1];
        }
        numObjects--;
        curr--;
    }
}
