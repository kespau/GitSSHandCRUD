package lt.kaunascoding.crud;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileCRUD {
    public void creatFile() {
        System.out.println("Įveskite failo pavadinimą \u263A");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        System.out.println("Įvestas failo pavadimas: " + fileName + " \u263B");

        File file = new File(fileName);
        if (file.exists()){
            System.out.println("toks failas egzizuoja |u263A");
        }else {
            System.out.println("Toks failas neegziztuoja \uD83D\uDE22");
            System.out.println("ar norite tokį failą sukurtume?");
            System.out.println("y/n");
            String arSukurti = sc.nextLine();
            if (arSukurti.toLowerCase().equals("y")){
                try {
                    file.createNewFile();
                    System.out.println("Failas sukurtas sėkmingai");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Sum ting wong");
                }
            }
        }
    }
}
