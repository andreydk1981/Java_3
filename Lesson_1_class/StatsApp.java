package Lesson_1_class;

public class StatsApp {
    public static void main(String[] args) {
        Stats<Integer> integerStats = new Stats<>(1,2,3,4);
        Stats<Integer> integerStats2 = new Stats<>(1,2,3,4);
        Stats<Integer> integerStats3 = new Stats<>(1,2,3,4,7,8);

        System.out.println(integerStats.avg());

        Stats<Double> doubleStats = new Stats<>(1.0,2.0,3.0,4.0);

        System.out.println(doubleStats.avg());

        System.out.println(integerStats.sameAvg(integerStats2));
        System.out.println(integerStats.sameAvg(integerStats3));
        System.out.println(integerStats.sameAvg(doubleStats));
    }
}
