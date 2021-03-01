//Author: Brian Harms


package application;
import static java.lang.Math.*;
import java.lang.StringBuilder;

public class Conversions {
    public char NumberToLetter(int num) {
    	switch(num) {
       	case 0:
    		return 'a';

       	case 1:
    		return 'b';
    		
       	case 2:
    		return 'c';
    		
       	case 3:
    		return 'd';
    		
       	case 4:
    		return 'e';

       	case 5:
    		return 'f';
    			
       	case 6:
    		return 'g';
    		
       	case 7:
    		return 'h';
    	
       	case 8:
    		return 'i';
    		
    	case 9:
    		return 'j';
    		
    	case 10:
    		return 'k';
    		
    	case 11:
    		return 'l';
    	
    	case 12:
    		return 'm';
    		
    	case 13:
    		return 'n';
    		
    	case 14:
    		return 'o';
    		
    	case 15:
    		return 'p';
    		
    	case 16:
    		return 'q';
    		
    	case 17:
    		return 'r';
    		
    	case 18:
    		return 's';
    		
    	case 19:
    		return 't';

    	case 20:
    		return 'u';
    			
    	case 21:
    		return 'v';
    		
    	case 22:
    		return 'w';
    	
    	case 23:
    		return 'x';
    		
    	case 24:
    		return 'y';
    		
    	case 25:
    		return 'z';
    		
    	default:
    		return ' ';
    	}
    }
    
    public int LetterToNumber(char letter) {
    	switch(letter) {
    	case 'A':
    	case 'a':
    		return 0;

    	case 'B':
    	case 'b':
    		return 1;
    		//break;
    		
    	case 'C':
    	case 'c':
    		return 2;
    		//break;
    		
    	case 'D':
    	case 'd':
    		return 3;
    		//break;
    		
    	case 'E':
    	case 'e':
    		return 4;
    		//break;

    	case 'F':
    	case 'f':
    		return 5;
    		//break;
    			
    	case 'G':
    	case 'g':
    		return 6;
    		//break;
    		
    	case 'H':
    	case 'h':
    		return 7;
    		//break;
    	
    	case 'I':
    	case 'i':
    		return 8;
    		//break;
    		
    	case 'J':
    	case 'j':
    		return  9;
    		//break;
    		
    	case 'K':
    	case 'k':
    		return 10;
    		//break;
    		
    	case 'L':
    	case 'l':
    		return 11;
    		//break;
    	
    	case 'M':
    	case 'm':
    		return  12;
    		//break;
    		
    	case 'N':
    	case 'n':
    		return 13;
    		//break;
    		
    	case 'O':
    	case 'o':
    		return  14;
    		//break;
    		
    	case 'P':
    	case 'p':
    		return 15;
    		//break;

    	case 'Q':
    	case 'q':
    		return 16;
    		//break;
    		
    	case 'R':
    	case 'r':
    		return 17;
    		//break;
    		
    	case 'S':
    	case 's':
    		return 18;
    		//break;
    		
    	case 'T':
    	case 't':
    		return 19;
    		//break;

    	case 'U':
    	case 'u':
    		return 20;
    		//break;
    			
    	case 'V':
    	case 'v':
    		return 21;
    		//break;
    		
    	case 'W':
    	case 'w':
    		return 22;
    		//break;
    	
    	case 'X':
    	case 'x':
    		return 23;
    		//break;
    		
    	case 'Y':
    	case 'y':
    		return 24;
    		//break;
    		
    	case 'Z':
    	case 'z':
    		return 25;
    		//break;
    	
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
    		return -1;
    	}
    }
    
    public String DecimalToBinary(int num) {
    	StringBuilder str = new StringBuilder("");
    	while (num > 0) {
    		str.append(num % 2);
    		num /= 2;
    	}
    	while (str.length() % 8 != 0) {
    		str.append('0');
    	}
    	str = str.reverse();
    	System.out.println(str.length());
    	return str.toString();
    }
    
    public int BinaryToDecimal(int num) {
    	String s = num + "";
    	int result = 0;
    	int powIndex = 0;
    	for (int i = s.length()-1; i >= 0; i--) {
    		int digit = Integer.parseInt(s.charAt(i) + "");
    		result += (digit * pow(2, powIndex));
    		powIndex++;
    	}
    	return result;
    }
}
