package cipher;

import java.util.*;

public class Vigenere{
    String text,key;

    public void input(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan Text : ");
        this.text = scan.nextLine();
        System.out.print("Masukan Key : ");
        this.key = scan.nextLine();
    }

    public void encrypt(){
        System.out.println("Encrypted text : " + prosesEncrypt(this.text, this.key));
    }

    public void decrypt(){
        System.out.println("Decrypted text : " + prosesDecrypt(this.text, this.key));
    }

    public String prosesEncrypt(String text, String key){
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

    public String prosesDecrypt(String text, String key){
        String res = "";
       text = text.toUpperCase();
       for (int i = 0, j = 0; i < text.length(); i++) {
           char c = text.charAt(i);
           if (c < 'A' || c > 'Z') continue;
           res += (char)((c - key.charAt(j) + 26) % 26 + 'A');
           j = ++j % key.length();
       }
       return res;
    }
}
