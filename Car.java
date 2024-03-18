/*
* <Makes car object and access the details>
* CSC 1351 Programming Project No <1>
* Section <2>
* @author <Nicholas Luke>
* @since <3/17/2024>
*/

public class Car implements Comparable<Car>{
		private String make;
		private int year;
		private int price; 
		/**
		* <Constructor to initialize variables >
		*
		* CSC 1351 Programming Project No <1>
		* Section <2>
		*
		* @author <Nicholas Luke>
		* @since <3/17/2024>
		*
		*/
		public Car(String Make, int Year, int Price) {
			make = Make;
			year = Year;
			price = Price;
		}
		/**
		* <Accessor class used to access the make of the car>
		*
		* CSC 1351 Programming Project No <1>
		* Section <2>
		*
		* @author <Nicholas Luke>
		* @since <3/17/2024>
		*
		*/
		public String getMake() {
			return make;
		}
		/**
		* <Accessor class used to access the year of the car>
		*
		* CSC 1351 Programming Project No <1>
		* Section <2>
		*
		* @author <Nicholas Luke>
		* @since <3/17/2024>
		*
		*/
		public int getYear() {
			return year;
		}
		/**
		* <Accessor class used to access the price of the car>
		*
		* CSC 1351 Programming Project No <1>
		* Section <2>
		*
		* @author <Nicholas Luke>
		* @since <3/17/2024>
		*
		*/
		public int getPrice() {
			return price;
		}
		/**
		* <Compare class used to sort the cars>
		*
		* CSC 1351 Programming Project No <1>
		* Section <2>
		*
		* @author <Nicholas Luke>
		* @since <3/17/2024>
		*
		*/
		public int compareTo(Car other) {
	        int makeComparison = this.make.compareTo(other.make); 
	        if (makeComparison != 0) { 
	            return makeComparison;
	        }
	        if (this.year != other.year) {
	            return this.year - other.year;
	        }
	        return 0;
	    }
		/**
		* <Prints out the information of the cars>
		*
		* CSC 1351 Programming Project No <1>
		* Section <2>
		*
		* @author <Nicholas Luke>
		* @since <3/17/2024>
		*
		*/
		public String toString() {
			return "Make: " + make + ", Year: " + year + ", Price: " + price + ";";
	    }
}  
