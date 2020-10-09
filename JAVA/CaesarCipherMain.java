
public class CaesarCipherMain {
 public static void main(String[] args) {
	 CaesarCipher cipher = new CaesarCipher(3);
	 System.out.println("Encrpytion code = " + new String(cipher.encoder));
	 System.out.println("Decryption code = " + new String(cipher.decoder));
	 String message = "THIS IS a secrET MESsage";
	 String coded = cipher.encrypt(message);
	 System.out.println("Secret: "+coded);
	 String answer = cipher.decrypt(coded);
	 System.out.println("Message: " + answer);
	 
 }
  static class CaesarCipher{
	  private char[] encoder = new char[52];
	  private char[] decoder = new char[52];
	  
	  public CaesarCipher(int rotation) {
		  for (int k = 0; k < 26; k++) {
			  encoder[k] = (char)('A'+(k+rotation)%26);
			  decoder [k] = (char)('A'+(k-rotation+26) %26);
		  }
		  for(int j = 26; j < 52; j++) {
			  encoder[j] = (char)('a'+(j+rotation)%26);
			  decoder[j] = (char)('a'+(j-rotation+26)%26);
		  }
	  }
	  public String encrypt(String m) {
		  return transform(m, encoder);
	  }
	  public String decrypt(String m) {
		  return transform(m, decoder);
	  }
	  private String transform(String o, char[] code) {
		  char[] msg = o.toCharArray();
		  for(int i=0; i<msg.length; i++) {
			  if(Character.isUpperCase(msg[i])) {
				  int j = msg[i] - 'A';
				  msg[i] = code[j];
			  }
			  else if(Character.isLowerCase(msg[i])){
				  int l = msg[i] - 'a';
				  msg[i] = code[26+l];
			  }
		  }
		  return new String(msg);
	  }
  }
}
