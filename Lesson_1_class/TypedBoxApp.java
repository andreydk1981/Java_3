package Lesson_1_class;

public class TypedBoxApp {
    public static void main(String[] args) {
        TypedBox <Integer> box1 = new TypedBox<>(42);
        TypedBox <Integer> box2 = new TypedBox<>(195);

        int sum = box1.getObject() + box2.getObject();
        System.out.println(sum);

        TypedBox<String> stringTypedBox = new TypedBox<>("195");
        box1.showType();
        stringTypedBox.showType();

        TwoTypedBox<Integer, String> twoTypedBox = new TwoTypedBox<>(10, "122");
        TwoTypedBox<Integer, Integer> twoTypedBox2 = new TwoTypedBox<>(10, 122);

        twoTypedBox.showTypes();
        twoTypedBox2.showTypes();
    }
}
