package Lesson_3_class;

import java.io.*;

public class StreamApp {
    public static void main(String[] args) {
        String str = "My string";
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File("demo.txt"))){
            fileOutputStream.write(str.getBytes());
        } catch (IOException e){
            e.printStackTrace();
        }

        try(FileInputStream fileInputStream = new FileInputStream("demo.txt")){
            byte[] bytes = new byte[10];
            fileInputStream.read(bytes);
            System.out.println(new String(bytes));
        } catch (IOException e){
            e.printStackTrace();
        }

        byte[] bytes = {65, 66, 67};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int x;
        while ((x = byteArrayInputStream.read()) != -1) {
            System.out.println(x);
        }
    }


}


