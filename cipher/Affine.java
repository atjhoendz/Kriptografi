package cipher;

import java.util.*;

public class Affine{

    String text,key;

    public void input(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan Text : ");
        this.text = scan.nextLine();
        System.out.print("Masukan Key : ");
        this.key = scan.nextLine();
    }

    public void encrypt(){
        System.out.println("Encrypted text : " + prosesEncrypt(this.text));
    }

    public void decrypt(){
        System.out.println("Decrypted text : " + prosesDecrypt(this.text    ));
    }

    public String prosesEncrypt(String Msg)
   {
       String CTxt = "";
       int a = 3;
       int b = 6;
       for (int i = 0; i < Msg.length(); i++)
       {
           CTxt = CTxt + (char) ((((a * Msg.charAt(i)) + b) % 26) + 65);
       }
       return CTxt;
   }

   public static String prosesDecrypt(String CTxt)
   {
       String Msg = "";
       int a = 3;
       int b = 6;
       int a_inv = 0;
       int flag = 0;
       for (int i = 0; i < 26; i++)
       {
           flag = (a * i) % 26;
           if (flag == 1)
           {
               a_inv = i;
               System.out.println(i);
           }
       }
       for (int i = 0; i < CTxt.length(); i++)
       {
           Msg = Msg + (char) (((a_inv * ((CTxt.charAt(i) - b)) % 26)) + 65);
       }
       return Msg;
   }
}
