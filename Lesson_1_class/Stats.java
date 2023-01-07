package Lesson_1_class;

import java.util.Arrays;
import java.util.List;

public class Stats<T extends Number> {
    private static final double EPSILON  = 0.00001;
    private final T[] numbers;

    @SafeVarargs
    public Stats(T... numbers) {
        this.numbers = numbers;
    }

    double avg() {
        double sum = 0;
        for (T number : numbers) {
            sum += number.doubleValue();
        }
        return sum / numbers.length;
    }

    public boolean sameAvg (Stats<? extends Number> another){
        return Math.abs(this.avg() - another.avg()) < EPSILON;
    }

    public List<? extends Number> getElements(){
        return Arrays.asList(numbers);
    }
}
