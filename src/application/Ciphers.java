//Author: Brian Harms

package application;

import static java.lang.Math.*;
import java.lang.StringBuilder.*;

public class Ciphers {
	public Conversions conversions = new Conversions();
	// y = (x + shift)(mod26) Encryption
	// y = (x - shift)(mod26) Decryption
	
	//Method for Caesar cipher encrypting/decrypting.
    public char CaesarCipher(char value, int key, boolean encode) {
    	int position = 0;
    	int val = 0;
    	switch(value) {
    	case 'A':
    	case 'a':
    		position = 0;
    		break;

    	case 'B':
    	case 'b':
    		position = 1;
    		break;
    		
    	case 'C':
    	case 'c':
    		position = 2;
    		break;
    		
    	case 'D':
    	case 'd':
    		position = 3;
    		break;
    		
    	case 'E':
    	case 'e':
    		position = 4;
    		break;

    	case 'F':
    	case 'f':
    		position = 5;
    		break;
    			
    	case 'G':
    	case 'g':
    		position = 6;
    		break;
    		
    	case 'H':
    	case 'h':
    		position = 7;
    		break;
    	
    	case 'I':
    	case 'i':
    		position = 8;
    		break;
    		
    	case 'J':
    	case 'j':
    		position = 9;
    		break;
    		
    	case 'K':
    	case 'k':
    		position = 10;
    		break;
    		
    	case 'L':
    	case 'l':
    		position = 11;
    		break;
    	
    	case 'M':
    	case 'm':
    		position = 12;
    		break;
    		
    	case 'N':
    	case 'n':
    		position = 13;
    		break;
    		
    	case 'O':
    	case 'o':
    		position = 14;
    		break;
    		
    	case 'P':
    	case 'p':
    		position = 15;
    		break;

    	case 'Q':
    	case 'q':
    		position = 16;
    		break;
    		
    	case 'R':
    	case 'r':
    		position = 17;
    		break;
    		
    	case 'S':
    	case 's':
    		position = 18;
    		break;
    		
    	case 'T':
    	case 't':
    		position = 19;
    		break;

    	case 'U':
    	case 'u':
    		position = 20;
    		break;
    			
    	case 'V':
    	case 'v':
    		position = 21;
    		break;
    		
    	case 'W':
    	case 'w':
    		position = 22;
    		break;
    	
    	case 'X':
    	case 'x':
    		position = 23;
    		break;
    		
    	case 'Y':
    	case 'y':
    		position = 24;
    		break;
    		
    	case 'Z':
    	case 'z':
    		position = 25;
    		break;
    	
    	case ' ':
    		return ' ';
    		
    	case '.':
    		return '.';
    	
    	case ',':
    		return ',';
    		
       	case '?':
    		return '?';
    		
       	case '!':
    		return '!';
    	
       	case '/':
    		return '/';
    		
       	case ':':
    		return ':';
    		
       	case ';':
    		return ';';
       	case '-':
    		return '-';
       	case '=':
    		return '=';
    	default:
    		position = 0;
    		break;
    		
    	}
    	
    	//Encryption
    	if (encode) {
    		val =  ((position + key) % 26);
    	} //Decryption
    	else {
    		val = (((position - key) % 26) + 26) % 26;
    	}
    	
    	
        return conversions.NumberToLetter(val);
    }
    
    //Converts binary to text
    public String BinaryToText(String value) {
    	int sum = 0;
    	int powIndex = 0;
    	int currentVal;
    	String result = "";
    	for (int i = value.length()-1; i >= 3; i--) {
    		String temp = value.charAt(i) + "";
    		currentVal = Integer.parseInt(temp); //either 1 or 0
    		sum += currentVal * pow(2, powIndex); // currentVal * 2^position
    		powIndex++;
    		if (powIndex == 5 || i == 0) {
    			String resultChar = conversions.NumberToLetter(sum-1) + "";
    			//1 = lower case
    			//0 = upper case
    			if (value.charAt((i-1)) == '1') {
    				resultChar = resultChar.toLowerCase();
    			}
    			else if (value.charAt((i-1)) == '0')
    				resultChar = resultChar.toUpperCase();
    			
    			i -= 3; // i.e if i = 11, 11 - 3 = 8, 8 - 1 = 7. i = 7
    			result += resultChar;
    			powIndex = 0;
    			sum = 0;
    		}
    	}
		StringBuilder str = new StringBuilder(result);
		result = str.reverse().toString();
    	return result;
    			
    }
    
    //Converts text to binary
    public String TextToBinary(String text) {
    	//Consider one letter has 8 binary digits. i starts at 7.
    	//First character of text sequence is converted to a number.
    	//Convert that number to binary.
    	//(n / 2), (n % 2)
    	//Add the binary to new String sequence;
    	String result = "";
    	for (int i = 0; i < text.length(); i++) {
    		if (text.charAt(i) == ' ' || text.charAt(i) == '.'  || text.charAt(i) == ',' 
    		    || text.charAt(i) == ';')
    			i++;
    		
    		int num = conversions.LetterToNumber(text.charAt(i));
    		System.out.println("LetterToNumber: " + (num+1));
    		String binary = conversions.DecimalToBinary(num+1);
    		System.out.println("Number to binary: " + binary);
    		
    		//Determine whether letter is upper case/lower case.
    		char [] binaryArray = binary.toCharArray();
    		binaryArray[1] = '1';
    		if (Character.isUpperCase(text.charAt(i)))
    			binaryArray[2] = '0';
    		else
    			binaryArray[2] = '1';
    		
    		//End result
    		for (int j = 0; j < binaryArray.length; j++)
    			result += binaryArray[j];
    	}
    	return result;
    }
    
}
