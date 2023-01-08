package Lesson_1_homework;

public class BoxApp {
    public static void main(String[] args) {
        Orange orange = new Orange(1.5);
        Apple apple = new Apple(1);
        BOX<Apple> appleBOX = new BOX<>();
        BOX<Apple> appleBOX2 = new BOX<>();
        BOX<Orange> orangeBOX = new BOX<>();

        appleBOX.putFruit(apple);
        appleBOX.putFruit(apple);
        appleBOX.putFruit(apple);
        appleBOX.putFruit(apple);

        appleBOX2.putFruit(apple);
        appleBOX2.putFruit(apple);

        orangeBOX.putFruit(orange);
        orangeBOX.putFruit(orange);
        orangeBOX.putFruit(orange);
        orangeBOX.putFruit(orange);

        System.out.println("appleBOX " + appleBOX.getWeight());
        System.out.println("appleBOX2 " + appleBOX2.getWeight());
        System.out.println("orangeBOX " + orangeBOX.getWeight());
        System.out.println(appleBOX.compare(orangeBOX));

        appleBOX.transfer(appleBOX2);
        System.out.println("appleBOX " + appleBOX.getWeight());
        System.out.println("appleBOX2 " + appleBOX2.getWeight());

        appleBOX2.transfer(appleBOX);
        System.out.println("appleBOX " + appleBOX.getWeight());
        System.out.println("appleBOX2 " + appleBOX2.getWeight());
    }
}
