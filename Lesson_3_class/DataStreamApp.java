package Lesson_3_class;

import java.io.*;
import java.util.Scanner;

public class DataStreamApp {
    public static void main(String[] args) {
        File file = new File("demo.txt");

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            dataOutputStream.writeUTF("writeUTF");
            dataOutputStream.writeInt(43);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
