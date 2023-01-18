package Lesson_3_class;

import java.io.*;
import java.util.Arrays;

public class SerialiseApp {
    public static void main(String[] args) {
        File file = new File("demo.txt");
        Bike bike = new Bike("Canyon");
        bike.setSerialNo("111111");

        System.out.println("наш велосипед " + bike);
        byte[] bytes = new byte[0];
        try (
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream)
        ) {
            outputStream.writeObject(bike);
            bytes = byteArrayOutputStream.toByteArray();
            System.out.println("serial bike: " + Arrays.toString(bytes));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try (
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)
        ) {
            Bike deserBile = (Bike) objectInputStream.readObject();
            System.out.println("bike from file " + deserBile);

        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
