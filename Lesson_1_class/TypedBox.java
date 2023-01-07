package Lesson_1_class;

public class TypedBox <T> {
    private final T object;

    public TypedBox(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void showType(){
        System.out.println("box type is: " + object.getClass().getName());
    }
}
