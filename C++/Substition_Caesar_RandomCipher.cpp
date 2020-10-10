#include <iostream>
using namespace std;

class SubstitutionCihper{
    public:
    char encoder[26];
    char decoder[26];
    string key;

    //creates the encoder and decoder
    SubstitutionCihper(string keyIn){
        key = keyIn; //1
    }//1 or O(1) in runtime
     //Theta(1)

    //encrypts the string
    string encrypt(string m){
        string encoder = m; //1
        for(int i =0; i<m.length(); i++){ //4n 
            encoder[i]=key.at(m.at(i)-'A'); //4
        }
        return encoder;//1
    }// 4n + 2 or O(n) in runtime
     //Theta(n)

    //Creates decryption key
    string decryptKey(){
        string decoder = key; //1
        for(int i =0; i <26; i++){ //26*4
            decoder[key[i]-'A']=(char)(i+'A');//4
        }
        return decoder; //1
    }//106 or O(1) in runtime
     //Theta(1)

    //decrypts the message
    string decrypt(string m){
        string decoded = m; //1
        for(int i = 0; i<m.length(); i++){ //n
            decoded[i] = key.find(m.at(i))+'A'; //4
        }
        return decoded; //1
    }// 4n + 2 or O(n) in runtime
     //Theta(n)
};

class CaesarCipher: public SubstitutionCihper{
    public:
    //creates caesarcipher as a child of substitutioncipher
    CaesarCipher(int rotation):SubstitutionCihper(""){
        string key = ""; //1
        for(int i = 0; i <26; i++){ //26*4
            key.push_back((char)('A'+(i+rotation)%26));//4
        }
        SubstitutionCihper::key = key;//1
    }//106 opreations or O(1) in runtime
     //Theta(1)

        //encrypts the string
        string encrypt(string m){
            return SubstitutionCihper::encrypt(m);
        }// 4n + 2 or O(n) in runtime
        //Theta(n)

        //creates decryption key
        string decryptKey(){
            return SubstitutionCihper::decryptKey();
        }//106 or O(1) in runtime
        //Theta(1)

        //decrypts the string
        string decrypt(string m){
            return SubstitutionCihper::decrypt(m);
        }// 4n + 2 or O(n) in runtime
         //Theta(n)
};
//creates random cipher
class RandomCipher: public SubstitutionCihper{
    public:
    RandomCipher():SubstitutionCihper(""){
        int random; //1
        string key = ""; //1
        //randomizes the key
        for(int i = 0; i <26; i++){ //26*4*3
            random = rand() %26; //3
            key.push_back((char)('A'+random)); //4
        }
        SubstitutionCihper::key = key; //1
    }//315 in runtime or O(1)
    // theta(1)

            //encrypts the string
        string encrypt(string m){
            return SubstitutionCihper::encrypt(m);
        }// 4n + 2 or O(n) in runtime
        //Theta(n)

        //creates decryption key
        string decryptKey(){
            return SubstitutionCihper::decryptKey();
        }//106 or O(1) in runtime
        //Theta(1)

        //decrypts the string
        string decrypt(string m){
            return SubstitutionCihper::decrypt(m);
        }// 4n + 2 or O(n) in runtime
         //Theta(n)
};
int main(){
    string key = "PTQGMKCRSVEXADZBJFOWYNIHLU"; //1
    string message = "PINEAPPLE"; //1
    SubstitutionCihper cipher(key); //1
    std::cout<< "Substitution Cipher: "; //1 
    std::cout<< "Encryption code = " << key << endl; //1
    std::cout<< "Decryption code = " << cipher.decryptKey()<< endl; //1 + 106
    std::cout<< "Secret: " << cipher.encrypt(message) << endl; // 1 +4n +2
    std::cout<< "Message: "<< cipher.decrypt(cipher.encrypt(message))<<endl; // 1+ 4n +2 + 4n +2

    CaesarCipher cipher2(3);
    std::cout<< "Caesar Cipher:" <<endl; //1 
    std::cout<< "Encryption code = " << cipher2.key << endl; //1
    std::cout<< "Decryption code = " << cipher2.decryptKey()<< endl;//1 + 106
    std::cout<< "Secret: " << cipher2.encrypt(message) << endl; // 1 +4n +2
    std::cout<< "Message: "<< cipher2.decrypt(cipher2.encrypt(message))<<endl; // 1+ 4n +2 + 4n +2

    RandomCipher cipher3;
    std::cout<< "Random Cipher:" <<endl;//1
    std::cout<< "Encryption code = " << cipher3.key << endl; // 1
    std::cout<< "Decryption code = " << cipher3.decryptKey()<< endl; //1 + 106
    std::cout<< "Secret: " << cipher3.encrypt(message) << endl; // 1 + 4n + 2
    std::cout<< "Message: "<< cipher3.decrypt(cipher3.encrypt(message));// 1+ 4n +2 + 4n +2
}//36n + 351 in runtime or O(n)
 //Theta(n)