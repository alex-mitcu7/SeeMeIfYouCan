import java.lang.*;

// Encrypt a character with an XOR cipher against a given number
// Decrypt a character out of a number with an XOR cipher against a given number
// Author: Maria Musat

public class Encryptor
{
	public static int encrypt(char ch, int encryptor)
	{
		String binaryArray = new String();
		String binaryArrayCrypted = new String();
    	String encryptorStr = Integer.toBinaryString(encryptor);
    	encryptor = Integer.parseInt(encryptorStr);
		String numberEncryption = String.format("%08d", encryptor);

		//Convert the character into an 8 bites string
		int number = (int)ch;
		String binaryStr = Integer.toBinaryString(number);
		int binaryInt = Integer.parseInt(binaryStr);
		String fixedNumber = String.format("%08d", binaryInt);

		// Compute the xor of the character with number encryption
		StringBuilder xor = new StringBuilder();
		xor.append("");
		for(int i = 0; i<8; i++)
		{
			int dig1 = (int)fixedNumber.charAt(i);
			int dig2 = (int)numberEncryption.charAt(i);
			xor.append((dig1 + dig2)%2);
		} //for i

		String xorString = xor.toString();
    int toBeReturned = Integer.parseInt(xorString, 2);
    return toBeReturned;
	} // encrypt


	public static char decrypt(int chValue, int numberEncryption)
	{
		String chBinaryStr = Integer.toBinaryString(chValue);
		int value = Integer.parseInt(chBinaryStr);
		String chBinaryStr8 = String.format("%08d", value);

		String encBinaryStr = Integer.toBinaryString(numberEncryption);
		int numberEncryptionB = Integer.parseInt(encBinaryStr);
		String encBinaryStr8 = String.format("%08d", numberEncryptionB);


		StringBuilder xor = new StringBuilder();
		xor.append("");

		for(int i = 0; i<8; i++)
		{
			int dig1 = (int)chBinaryStr8.charAt(i);
			int dig2 = (int)encBinaryStr8.charAt(i);
			xor.append((dig1 + dig2)%2);
		} //for i


		String xorString = xor.toString();
		int xorDecimal = Integer.parseInt(xorString, 2);
		char returnChar = (char) xorDecimal;
		return returnChar;
	}
} // class Encryptor
