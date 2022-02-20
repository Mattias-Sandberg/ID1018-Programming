// OU4

import  java.util .*;     //  Scanner
import  static  java.lang.System.out;

class  OperationerMedNaturligaHeltalGivnaSomTeckenstrangar
{
	public  static  void  main (String [] args)
	{
		out.println ("Operationer med två naturliga tal representerade som stringar");

		//  mata in två naturliga heltal
		Scanner     in = new  Scanner (System.in);
		out.println ("Två naturliga tal:");
		String     tal1 = in.next  ();
		String     tal2 = in.next  ();
		out.println  ();

		// addera heltalen och visa resultatet
		String     sum = addition (tal1 , tal2);
		showResult (tal1 , tal2 , sum , '+');

		// subtrahera heltalen och visa resultatet
		String 	   differens = subtraction(tal1, tal2);
		showResult (tal1, tal2, differens, '-');
	}

	// Addera tar emot två naturliga heltal givna som teckensträngar,
	// och returnerar deras summa som en teckensträng.
	public  static  String  addition (String  num1 , String  num2)
	{
		String result = "";
		StringBuilder sb = new StringBuilder(result);

		int length1 = num1.length();
		int length2= num2.length();

		// Ser till att strängarna är av samma längd
		if(length1 > length2)
		{
			num2 = setLength(num2, length1-length2);
		}
		else if(length2 > length1)
		{
			num1 = setLength(num1, length2-length1);
		}

		// Används för iteration
		int maxLength = Math.max(length1, length2);

		// Temporära variabler använda i loopen för aritmetiken
		char c;
		int n, m, sum, carry = 0;
		int sumLastN;
		String sumStr = "";

		for (int i = maxLength-1; i >= 0; i--)
		{
			// återställer alla temporära variabler
			sumStr = "";
			n = 0;
			m = 0;
			sum = 0;

			// byter ut tomma rum med 0 för num1
			if(num1.charAt(i) == ' ')
			{
				n = 0;

			}
			// returnerar talet vid index i - num1
			else
			{
				c = num1.charAt(i);
				n = Integer.parseInt(""+c);
			}

			// byter ut tomma rum med 0 för num2
			if(num2.charAt(i) == ' ')
			{
				m = 0;
			}
			// returnerar talet vid index i - num2
			else
			{
				c = num2.charAt(i);
				m = Integer.parseInt(""+c);
			}

			sum = n+m+carry;
			sumStr = ""+sum;

			// sätter carry till 1 om summans längd är mer än 1
			if(sum >= 10)
				carry = 1;
			else carry = 0;

			// lägger siffran till resultatet
			sumLastN = sumStr.length()-1;
			sb.append(sumStr.substring(sumLastN));


		}
		// lägger till carry till den största platsen, om det är = 1
		if(carry==1)
			sb.append( (carry+"").charAt(0));

		// vänder om resultatets stränger eftersom dens siffror har blivit appended
		sb.reverse();

		// returnerar resultatet
		return sb.toString();
	}

	// 	subtrahera tar emot två naturliga heltal givna som teckensträngar
	//  och returnerar deras differens som en teckensträng.
	//  Det första heltalet är inte mindre än det andra heltalet.
	public  static  String  subtraction (String  num1 , String  num2)
	{
		String result = "";
		StringBuilder sb = new StringBuilder(result);

		int length1 = num1.length();
		int length2= num2.length();

		// ser till att strängarna är lika långa
		if(length1 > length2)
			num2 = setLength(num2, length1-length2);

		// temporära variabler använda i loopen för aritmetiken
		char c;
		int n, m, differens, carry = 0;
		int diffLastN;
		String diffStr = "";

		for (int i = length1-1; i >= 0; i--)
		{
			// återställer alla temporära variabler
			diffStr = "";
			n = 0;
			m = 0;
			differens = 0;

			// återställer replaces empty spaces with 0's - num1
			if(num1.charAt(i) == ' ')
			{
				n = 0;

			}else{ //parses the integer at index i - num1
				c = num1.charAt(i);
				n = Integer.parseInt(""+c);
			}

			//replaces empty spaces with 0's - num2
			if(num2.charAt(i) == ' ')
			{
				m = 0;
			}else{ //parses the integer at index i - num2
				c = num2.charAt(i);
				m = Integer.parseInt(""+c);
			}
			differens = n-m+carry;

			//sets the carry to 1 if the sum's length is more than 1
			if(differens < 0)
			{
				carry = -1;
				differens += 10;
			}
			else carry = 0;

			//parses int to string after operations
			//if-statement makes sure no extraneous 0's are added
			diffStr = ""+differens;

			//helps parse the last number of the sum
			diffLastN = diffStr.length()-1;

			//adds the digit to the result
			sb.append(diffStr.substring(diffLastN));

		}
		//adds the carry to the most significant place, if it's = 1
		if(carry==1)
			sb.append( (carry+"").charAt(0));

		//reverse the result strings since it's had the digits appended
		sb.reverse();

		//returns result
		return sb.toString();
	}
	// The  showResult  method  presents  two  natural  numbers , an
	//  operator  and  the  result  string.
	public  static  void  showResult (String  num1 , String  num2 ,
			String  result , char  operator)
	{
		// set an  appropriate  length  on  numbers  and  result
		int     len1 = num1.length  ();
		int     len2 = num2.length  ();
		int     len   = result.length  ();
		int     maxLen = Math.max (Math.max (len1 , len2), len);
		num1 = setLength (num1 , maxLen  - len1);
		num2 = setLength (num2 , maxLen  - len2);
		result = setLength (result , maxLen  - len);
		// show  the  expression
		out.println ("  " + num1);
		out.println ("" + operator + " " + num2);
		for (int i = 0; i < maxLen + 2; i++)
			out.print ("-");
                out.println();
		out.println ("  " + result + "\n");
	}
	// The  setLength  method  prepends  the  supplied  number  of
	//  spaces  to  the  beginning  of a string
	public  static  String  setLength (String s, int  noSpaces)
	{
		StringBuilder     sb = new  StringBuilder (s);
		for (int i = 0; i < noSpaces; i++)
			sb.insert (0, " ");

		return  sb.toString  ();
	}
}
