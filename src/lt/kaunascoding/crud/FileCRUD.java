package lt.kaunascoding.crud;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCRUD {
    public void creatFile() {
        System.out.println("Įveskite failo pavadinimą \u263A");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        System.out.println("Įvestas failo pavadimas: " + fileName + " \u263B");

        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("toks failas egzizuoja |u263A");
        } else {
            System.out.println("Toks failas neegziztuoja \uD83D\uDE22");
            System.out.println("ar norite tokį failą sukurtume?");
            System.out.println("y/n");
            String arSukurti = sc.nextLine();
            if (arSukurti.toLowerCase().equals("y")) {
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

    public void updateFile() {
        System.out.println("Įveskite failo pavadinimą");
        Scanner sc = new Scanner(System.in);
        String failoVardas = sc.nextLine();
        File file = new File(failoVardas);

        if (file.exists()){
            System.out.println("Toks failas egzistuoja");
            System.out.println("Iveskite teksta ir spausdinkite enter");
            System.out.println("ivedus zodi pabaiga, saugojimas bus baigtas");
            try {
                FileWriter writer = new FileWriter(file,true);
                String eilute;
                do{

                    eilute = sc.nextLine();
                    if(!eilute.toLowerCase().equals("pabaiga")){
                        writer.write(eilute + "\n");
                    }

                }while (!eilute.toLowerCase().equals("pabaiga"));
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readFile (){
        System.out.println("Įveskite failo pavadimą");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        File file = new File(fileName);

        if (file.exists()){
            try {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNext()){
                    System.out.println(fileScanner.nextLine());
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
