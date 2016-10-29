import java.lang.*;

public class Encrypt
{
	public static void main(String args[])
	{
		String str = "ab";
		String[] binaryArray = new String[str.length()];
		String[] binaryArrayCrypted = new String[str.length()];
		String numberEncryption = "10101010"; 

		//Convert each character into a 8 bites string
		for (int i = 0; i <str.length(); i++)
		{
			int number = (int)str.charAt(i);
			String binaryStr = Integer.toBinaryString(number);
			int binaryInt = Integer.parseInt(binaryStr);
			String fixedNumber = String.format("%08d", binaryInt);
			System.out.println(str.charAt(i) + " converted in binary is " + fixedNumber);
			binaryArray[i] = fixedNumber;
		} 

		// Compute the xor of each caharter with number encryption
		for(int j = 0; j<str.length(); j++)
		{
			StringBuilder xor = new StringBuilder();
			xor.append("");
			for(int i = 0; i<8; i++)
			{
				int dig1 = (int)binaryArray[j].charAt(i);
				int dig2 = (int)numberEncryption.charAt(i);
				xor.append((dig1 + dig2)%2);
			} //for i

			String xorString = xor.toString();
			System.out.println("After xor " + str.charAt(j) + " will be " + xorString);
			binaryArrayCrypted[j] = xorString;
		} 
	}
}