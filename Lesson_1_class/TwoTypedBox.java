package Lesson_1_class;

public class TwoTypedBox<T, U> {
    private final T first;
    private final U second;

    public TwoTypedBox(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
    public void showTypes (){
        System.out.println("Types of T " + first.getClass().getName());
        System.out.println("Types of U " + second.getClass().getName());
    }
}
