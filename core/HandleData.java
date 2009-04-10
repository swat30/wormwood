/*
 * 
 */
package core;

public class HandleData {
	
	/**
	 * removeFirst:
	 * Removes the first element of the old array.
	 * @return new array with length = (old array length - 1)
	 */
	public static String[] removeFirst(String[] oldArr){
		String[] newArr = new String[oldArr.length - 1];
		
		try {
			for(int i = 1; i < oldArr.length; i++){
				newArr[i-1] = oldArr[i];
			}
		} catch (Exception e){} //Do nothing with exception. Just return blank array
		
		return newArr;
	}
	
	/**
	 * upperFirst:
	 * Converts the first letter of the string to an uppercase letter
	 * @return new string
	 */
	public static String upperFirst(String oldString){
		String newString = "";
		if(!oldString.equalsIgnoreCase("") && oldString != null){
			char[] temp = oldString.toCharArray();
			temp[0] = Character.toUpperCase(temp[0]);
			
			for(int i = 0; i < temp.length; i++){
				newString += temp[i];
			}
		}
		return newString;
	}
	
	/**
	 * arrToString
	 * Converts an array into a string in a list format
	 * @return array listed as string
	 */
	public static String arrToString(String[] s){
		String rtn = "";
		int last = getLastIndex(s);
		
		for(int i = 0; i <= last; i++){
			if(s[i] != null){
				//Inserts an and if it is the last element and there are other elements
				if(i == last && !rtn.equalsIgnoreCase(""))
					rtn += "and ";
				rtn += s[i];
				
				if(i != last)
					rtn += ", ";
			}
		}
		
		return rtn;
	}
	
	/**
	 * getLastIndex
	 * Gets the last none-null index of the array
	 * @retun last populated index. If the array is empty, -1 is returned
	 */
	public static int getLastIndex(Object[] arr){
		int last = -1;
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != null)
				last = i;
		}
		
		return last;
	}
}
