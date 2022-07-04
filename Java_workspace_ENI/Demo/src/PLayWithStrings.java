import java.util.Arrays;

class PLayWithStrings {

	static String strUn = "Une phrase au hasard";
	static char[] charArrayUn;
	
	public static void main(String[] args) {
		
		
		charArrayUn = strToCharArray(strUn);	
		System.out.println(Arrays.toString(charArrayUn));
		
		for(char i : charArrayUn) {
			System.out.print(i + "");
		}
	}
	
	//--METHODS
	//comment to test git
	//String ti char array
	public static char[]strToCharArray(String str){
		return str.toCharArray();
	}
	
	// un commentaire en plus pour github
	//sldkjsdgf
}
