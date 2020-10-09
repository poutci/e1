
public class CaesarCipherMain {
 public static void main(String[] args) {
	 CaesarCipher cipher = new CaesarCipher(3); //1
	 System.out.println("Encrpytion code = " + new String(cipher.encoder)); //2
	 System.out.println("Decryption code = " + new String(cipher.decoder)); //2
	 String message = "THIS IS a secrET MESsage"; //1
	 String coded = cipher.encrypt(message); // 1 + 1
	 System.out.println("Secret: "+coded); //1
	 String answer = cipher.decrypt(coded); // 1 + 1
	 System.out.println("Message: " + answer); //1
	 
 }// 12 operations or O(1)
  static class CaesarCipher{
	  //sets up the encoder and decoder arrays
	  private char[] encoder = new char[52]; //1
	  private char[] decoder = new char[52]; //1
	  
	  public CaesarCipher(int rotation) {
		  //for uppercase rotation
		  for (int k = 0; k < 26; k++) { //26
			  encoder[k] = (char)('A'+(k+rotation)%26); // 5
			  decoder [k] = (char)('A'+(k-rotation+26) %26); //6
		  } // 37
		  //for lower case rotation
		  for(int j = 26; j < 52; j++) { // 26
			  encoder[j] = (char)('a'+(j+rotation)%26); //5
			  decoder[j] = (char)('a'+(j-rotation+26)%26); //6
		  }//37
	  }// 74 operations or O(1)
	  //encrypts the string
	  public String encrypt(String m) {
		  return transform(m, encoder); //1 + O(n)
	  } // 5n + 2 operations or 6n + 2 operations or O(n)
	  //decrypts the string
	  public String decrypt(String m) {
		  return transform(m, decoder); // 1 + O(n)
	  }// 5n + 2 operations or 6n + 2 operations or O(n)
	  //used to either encrpty or decrypt with string with the given rotation
	  private String transform(String o, char[] code) {
		  char[] msg = o.toCharArray(); //1
		  for(int i=0; i<msg.length; i++) { //n 
			  // used for uppercase letters
			  if(Character.isUpperCase(msg[i])) { // 1
				  int j = msg[i] - 'A'; //2
				  msg[i] = code[j]; // 1
			  }
			  //used for lowercase letters
			  else if(Character.isLowerCase(msg[i])){ //1
				  int l = msg[i] - 'a'; //2
				  msg[i] = code[26+l]; //2
			  }
		  }
		  return new String(msg); //1
	  }//5n + 1 operations or 6n + 1 operations or O(n)
  }
}
