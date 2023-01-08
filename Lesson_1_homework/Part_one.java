package Lesson_1_homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part_one<V> {
    private final V[] values;
    private int first;
    private int second;

    @SafeVarargs
    public Part_one(V... values) {
        this.values = values;
    }

    public V[] getValues() {
        return values;
    }

    public List<V> toArrayList(){
        return new ArrayList<>(Arrays.asList(values));
    }

    public void swapElements(int first, int second){
        try {
            V temp = values[first];
            values[first] = values[second];
            values[second] = temp;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Wrong index");
        }
    }
}
