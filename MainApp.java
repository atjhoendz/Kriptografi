import java.io.*;
import java.lang.*;
import cipher.*;

public class MainApp{
    public static void main(String[] args) throws IOException{
        System.out.println("Kripto Apps");
        System.out.println("1. Caesar Cipher");
        System.out.println("2. Vigenere Cipher");
        System.out.println("3. Hill Cipher");
        System.out.println("4. Affine Cipher\n");
        System.out.println("0. Exit");

        MainApp.Apps app = new MainApp().new Apps();
        int pilihan = app.inputInt("Masukan Pilihan :");

        switch (pilihan) {
            case 1:
                System.out.println("Caesar Cipher");
                System.out.println("1. Encrypt");
                System.out.println("2. Decrypt\n");

                pilihan = app.inputInt("Pilih :");
                Caesar caesar = new Caesar();
                switch(pilihan){
                    case 1:
                        caesar.input();
                        caesar.encrypt();
                        break;
                    case 2:
                        caesar.input();
                        caesar.decrypt();
                        break;
                    default:
                        System.out.println("Input yang anda masukan tidak ada dimenu!");
                        break;
                }
                break;
            case 2:
                System.out.println("Vigenere Cipher");
                System.out.println("1. Encrypt");
                System.out.println("2. Decrypt\n");

                pilihan = app.inputInt("Pilih :");
                Vigenere vigenere = new Vigenere();
                switch(pilihan){
                    case 1:
                        vigenere.input();
                        vigenere.encrypt();
                        break;
                    case 2:
                        vigenere.input();
                        vigenere.decrypt();
                        break;
                    default:
                        System.out.println("Input yang anda masukan tidak ada dimenu!");
                        break;
                }
                break;
            case 3:
                System.out.println("Hill Cipher");
                Hill hill = new Hill();
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Menu:\n1: Encryption\n2: Decryption");
                System.out.print("\nPilih : ");
                hill.choice = Integer.parseInt(in.readLine());
                System.out.print("Enter the line: ");
                String line = in.readLine();
                System.out.print("Enter the key: ");
                String key = in.readLine();
                double sq = Math.sqrt(key.length());
                if (sq != (long) sq)
                    System.out.println("Cannot Form a square matrix");
                else
                {
                    int size = (int) sq;
                    if (hill.check(key, size))
                    {
                        System.out.println("Result:");
                        hill.cofact(hill.km, size);
                        hill.performDivision(line, size);
                    }
                }
                break;
            case 4:
                System.out.println("Affine Cipher");
                System.out.println("1. Encrypt");
                System.out.println("2. Decrypt\n");

                pilihan = app.inputInt("Pilih :");
                Affine affine  = new Affine();
                switch(pilihan){
                    case 1:
                        affine.input();
                        affine.encrypt();
                        break;
                    case 2:
                        affine.input();
                        affine.decrypt();
                        break;
                    default:
                        System.out.println("Input yang anda masukan tidak ada dimenu!");
                        break;
                }
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Input yang anda masukan tidak ada dimenu!");
                break;
        }
    }

    class Apps{
        public void printPrompt(String prompt){
            System.out.print(prompt + " ");
            System.out.flush();
        }

        public void inputFlush(){
            int temp;

            try{
                while((System.in.available()) != 0){
                    temp = System.in.read();
                }
            }catch (IOException e) {
                System.out.println("Input Error");
            }
        }

        public String cekInputString(){
            int aChar;
            String s = "";
            boolean finished = false;

            while(!finished){
                try {
                    aChar = System.in.read();
                    if(aChar < 0 || (char) aChar == '\n'){
                        finished = true;
                    }else if((char) aChar != '\r'){
                        s = s + (char) aChar;
                    }
                }catch (IOException e) {
                    System.out.println("Input error");
                    finished = true;
                }
            }

            return s;
        }

        public int inputInt(String prompt){
            while(true){
                inputFlush();
                printPrompt(prompt);

                try {
                    return Integer.valueOf(cekInputString().trim()).intValue();
                }catch (NumberFormatException e) {
                    System.out.println("Input yang dimasukan harus angka!");
                }
            }
        }
    }
}
