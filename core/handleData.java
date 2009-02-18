package core;

public class handleData {
	
	/**
	 * removeFirst:
	 * Removes the first element of the old array.
	 * Returns: new array with length = (old array length - 1)
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
	 * Returns: new string
	 */
	public static String upperFirst(String oldString){
		String newString = "";
		char[] temp = oldString.toCharArray();
		temp[0] = Character.toUpperCase(temp[0]);
		
		for(int i = 0; i < temp.length; i++){
			newString += temp[i];
		}
		
		return newString;
	}
}
