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

    // Encrypt the message
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

    // Encrypt the end character
    if (currentRow%2 == 0)
      indexToEncrypt = currentRow;
    else
      indexToEncrypt = width - currentRow;

    ch = '\\';
    encryptor = matrix[currentRow][indexToEncrypt].getBlue() + matrix[currentRow][indexToEncrypt].getGreen();
    encryptedNumber = Encryptor.encrypt(ch, encryptor);
    matrix[currentRow][indexToEncrypt].setRed(encryptedNumber);

    return matrix;
  } // encrypt

  public static String decryptMessage(Pixel[][] matrix, int height, int width)
  {
    // Some useful variables

    // String to be decrypted
    String message = "";
    char decryptedCh = 'a';
    int numberToDecrypt;
    // Number to encrypt against using the XOR cipher
    int encryptor;
    // The index of the pixel within the matrix from which the caracter will be
    // decrypted
    int indexToDecrypt;

    int row = 0;
    while (row < height)
    {
      if(row%2 == 0)
        indexToDecrypt = row;
      else
        indexToDecrypt = width - row;

      encryptor = matrix[row][indexToDecrypt].getBlue() + matrix[row][indexToDecrypt].getGreen();
      numberToDecrypt = matrix[row][indexToDecrypt].getRed();
      decryptedCh = Encryptor.decrypt(numberToDecrypt, encryptor);
      if(decryptedCh == '\\')
        break; // exit the loop
        
      message = message + decryptedCh;
      row++;
    } // for

    return message;
  } // decryptMessage
} // class EncryptMessage
