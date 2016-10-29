public class EncryptMessage
{
  // Loop through the message to encrypt it into the image represented by the
  // matrix
  public static Pixel[][] encryptMessage(String message, Pixel[][] matrix, int height, int width)
  {
    // Keeps track of the row on which the pixel will be encrypted
    int currentRow = 0;
    // Some useful variables
    // Character to be encrypted
    char ch;
    // Number to encrypt against using the XOR cipher
    int encryptor;
    // The 8bit binary number saved a string
    int encryptedNumber;
    // The index of the pixel within the matrix in which the caracter will be
    // encrypted
    int indexToEncrypt;

    for (int index = 0; index < message.length(); index++)
    {
      if(currentRow%2 == 0)
        indexToEncrypt = index;
      else
        indexToEncrypt = width - index;
      ch = message.charAt(index);
      encryptor = matrix[currentRow][indexToEncrypt].getBlue() + matrix[currentRow][indexToEncrypt].getGreen();
      encryptedNumber = Encryptor.encrypt(ch, encryptor);
      matrix[currentRow][indexToEncrypt].setRed(encryptedNumber);
      currentRow++;
    } // for

    return matrix;
  } // encrypt
} // class EncryptMessage
