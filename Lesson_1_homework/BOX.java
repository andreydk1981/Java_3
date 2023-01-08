package Lesson_1_homework;

import java.util.ArrayList;
import java.util.List;

public class BOX<T extends Fruit> {
    private static final double EPSILON = 0.0001;
    private List<T> fruits;

    public BOX() {
        this.fruits = new ArrayList<>();
    }

    public void putFruit(T fruit) {
        fruits.add(fruit);
    }

    public void emptyBox(){
        fruits.clear();
    }

    public double getWeight() {
        return fruits.stream().mapToDouble(Fruit::getWeight).sum();
    }


    public boolean compare(BOX <? extends Fruit> box){
        return Math.abs(this.getWeight() - box.getWeight()) < EPSILON;
    }

    public void transfer (BOX<T> box){
        fruits.forEach(box::putFruit);
        emptyBox();
    };

}
