package algo.string;

public class CaesarCypherEncryptor {


    public static String caesarCypherEncryptorMySol(String str, int key) {

        StringBuilder sb = new StringBuilder();
        key = key % 26;
        for (char c: str.toCharArray()) {
            int newChar = c + key;
            if (newChar > 122) {
                int excess = newChar - 122;
                newChar = 96 + excess;
            }

            sb.append((char)newChar);
        }

        return sb.toString();
    }


    // other way is to have a alphabet = "abcedefghijklmnopqrstuvwxyz"
    //then for our char find the new char by adding key to char index
    // eg for key =2 and letter a, index of a= 0 then 0 + key = 2 so c is new char


}
