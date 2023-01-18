package Lesson_2_class;

public class Bike {
    private final int id;
    private final String model;
    private final String serial_no;

    public Bike(int id, String model, String serial_no) {
        this.id = id;
        this.model = model;
        this.serial_no = serial_no;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", serial_no='" + serial_no + '\'' +
                '}';
    }
}
