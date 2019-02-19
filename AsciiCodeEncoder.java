import java.util.Scanner;
import java.util.*;
public class AsciiCodeEncoder{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String sent = sc.nextLine();
		int len=sent.length();
		int ar[]=new int[len];
    int binary[] = new int[len];
		ar=changeAsc(sent,len);
		NoOfOccurenceOfCharacters checkNum = new NoOfOccurenceOfCharacters();
		checkNum.getOccuringChar(sent);
		for(int i =0;i<len;i++)
		{
			System.out.print(ar[i]+" ");
		}
    System.out.println("");
    for(int r=0;r<len;r++)
    {
      convertBinary(ar[r]);
    }	
	}
	public static int[] changeAsc(String sent,int len)
	{
		int asc[]=new int[len];
    		for(int i = 0; i < len ; i++)
    	{   // while counting characters if less than the length add one        
        	char character = sent.charAt(i); // start on the first character
        	int ascii = (int) character; //convert the first character
			asc[i]=ascii;
		}
		
		return asc;
	}
    public static void convertBinary(int decimal) {
    String binary="";

    if(decimal<=0)
    {
        System.out.println("Please Enter more than 0");

    }
    else
    {
        while(decimal>0)
        {

            binary=(decimal%2)+binary;
            decimal=decimal/2;

        }
        System.out.print(binary+" ");

    }
}
}
class NoOfOccurenceOfCharacters { 
    static final int MAX_CHAR = 256; 
  
    static void getOccuringChar(String str) 
    { 
        // Create an array of size 256 i.e. ASCII_SIZE 
        int count[] = new int[MAX_CHAR]; 
  
        int len = str.length(); 
  
        // Initialize count array index 
        for (int i = 0; i < len; i++) 
            count[str.charAt(i)]++; 
  
        // Create an array of given String size 
        char ch[] = new char[str.length()]; 
        for (int i = 0; i < len; i++) { 
            ch[i] = str.charAt(i); 
            int find = 0; 
            for (int j = 0; j <= i; j++) { 
  
                // If any matches found 
                if (str.charAt(i) == ch[j])  
                    find++;                 
            } 
  
            if (find == 1)  
                System.out.println("Number of Occurrence of " + 
                 str.charAt(i) + " is:" + count[str.charAt(i)]);             
        } 
    } 
} 