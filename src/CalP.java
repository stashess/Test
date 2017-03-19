/**
 * Created by Admin on 19.03.2017.
 */
public class CalP {
    int year;
    int cal;

    public CalP(int year, int cal) {
        this.year = year;
        this.cal = cal;
    }

    public int getYear() {
        return year;

    }

    public int getCal() {
        return cal;
    }

    @Override
    public String toString() {
        return "CalP{" +
                "year=" + year +
                ", cal=" + cal +
                '}';
    }
}
