package com.company;

import java.io.*;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;
public class RandomStr {
    public static File file;
    public static String filename;
    public static Scanner input;
    public static Random random;
    private static RandomStr randomStr;
    public BufferedWriter bufferedWriter;
    private RandomStr() {
        //--------------write the output into the create file--------------//
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Name Your File");
            filename = scan.nextLine();          //takes the file name
            String directory = System.getProperty("user.dir");
            String path;
            path = directory + File.separator + filename;
            System.out.println("Filepath is " + path);
            file = new File(path);
            boolean result;
            try {
                result = file.createNewFile();//*creates a new file....
                if (result)     //test if successfully created a new file and test the file is created
                {
                    System.out.println("file created" + file.getCanonicalPath());
                }
            } catch (IOException file_creation) {
                file_creation.printStackTrace();
            }
        }
    }

    //---------------follows singleton **Create a static method to getRandom number** And this method is used to return the object----------------//
    public static RandomStr getRandomStr() {
        if (randomStr == null) {
            randomStr = new RandomStr();
        }
        return randomStr;
    }

    public void UserMessage() {
        input = new Scanner(System.in);// takes input using scanner
        random = new Random();
        try {
            FileWriter myWriter = new FileWriter(filename);
            bufferedWriter = new BufferedWriter(myWriter);
            System.out.println("Enter the No.lines");
            int line = input.nextInt();
            System.out.println("Enter the length random String");
            int length = input.nextInt();
            for (int i = 0; i < line; i++) {
                String str1 = randomString(length);
                System.out.println(str1);
                bufferedWriter.write("\n" +str1);

            }
            bufferedWriter.write(("\nAbove output is "
                    + line + " line" +
                    " with Unique alphanumeric string with length of " + length));
            System.out.println("\nAbove output is "
                    + line + " line" +
                    " with Unique alphanumeric string with length of " + length);
            bufferedWriter.flush();
            bufferedWriter.close();
            System.out.println("Successfully wrote");
        } catch (IOException e) {
            System.out.println("File not Found ");
        }


        //=========================To explain the =================================================
//        System.out.println("\nSample of making random string");
//        for (int i = 0; i < 5; i++) { String beta = randomString(10);
//        System.out.println("\t" +beta); }
//        System.out.println("5 random alphanumeric string with length 10");
    }

        static SecureRandom secureRnd = new SecureRandom();
        static final String SOURCE = "0123456789"+"ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz";
        public  String randomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(SOURCE.charAt(secureRnd.nextInt(SOURCE.length())));
        return sb.toString();
        }

        public static void main(String[] args) {
        RandomStr randomStr1 = RandomStr.getRandomStr();
        randomStr1.UserMessage();
    }
}





