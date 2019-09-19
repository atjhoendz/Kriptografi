package cipher;

import java.lang.*;
import java.util.*;

public class Caesar{
    String text;
    int key;

    public void input(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan Text : ");
        this.text = scan.nextLine();
        System.out.print("Masukan Key : ");
        this.key = scan.nextInt();
    }

    public void encrypt(){
        System.out.println("Encrypted text : " + prosesEncrypt());
    }

    public void decrypt(){
        System.out.println("Decrypted text : " + prosesDecrypt());
    }

    public StringBuffer prosesEncrypt(){
        StringBuffer result = new StringBuffer();
        for (int i=0; i < this.text.length(); i++) {
            if(Character.isUpperCase(text.charAt(i))){
                char ch = (char)(((int) this.text.charAt(i) + this.key - 65) % 26 + 65);
                result.append(ch);
            }else{
                char ch = (char)(((int) this.text.charAt(i) + this.key - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    public StringBuffer prosesDecrypt(){
        StringBuffer result = new StringBuffer();
        for (int i=0; i < this.text.length(); i++) {
            if(Character.isUpperCase(text.charAt(i))){
                char ch = (char)(((int) this.text.charAt(i) - this.key) % 26 - 65);
                result.append(ch);
            }else{
                char ch = (char)(((int) this.text.charAt(i) - this.key) % 26 - 97);
                result.append(ch);
            }
        }
        return result;
    }
}
