package Lesson_1_homework;

import java.util.Arrays;

public class Part_oneApp {
    public static void main(String[] args) {
        Integer[] intArr = {1,2,3,4,5};
        Part_one<Integer> integerPartOne= new Part_one<>(intArr);
        integerPartOne.swapElements(0, 2);
        System.out.println(Arrays.toString(integerPartOne.getValues()));

        Part_one<String> stringPartOne = new Part_one<>("a","ddd","ttt","123", "asdfg");
        stringPartOne.swapElements(2,4);
        System.out.println(Arrays.toString(stringPartOne.getValues()));


        System.out.println(stringPartOne.toArrayList().toString());

    }

    public static <V> void swapArr(V[] elements, int first, int second){
        V temp = elements[first];
        elements[first] = elements[second];
        elements[second] = temp;
    }
}


