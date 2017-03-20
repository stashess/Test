import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<CalP> calPList = Arrays.asList(
                new CalP(2019, 100000),
                new CalP(219, 100),
                new CalP(219, 901),
                new CalP(2192, 1001),
                new CalP(2193, 9021));

        List<CalP> emptyList = new ArrayList<>();
        int array[] = calPList.stream().mapToInt(CalP::getYear).distinct().toArray();
        System.out.println(Arrays.toString(array));

        long time1 = System.nanoTime();
        Arrays.stream(array).forEach(value -> {
            if (calPList.stream().
                    filter((calP) -> calP.getYear() == value).
                    mapToInt(CalP::getCal).sum() > 1000)
                emptyList.addAll(calPList.stream().filter(calP -> calP.getYear() == value).collect(Collectors.toList()));
        });
        System.out.println(System.nanoTime() - time1);
        emptyList.clear();
        long time2 = System.nanoTime();
        //

        for (int i = 0; i < array.length; i++) {
            int finalI = i;
            if (calPList.stream().
                    filter((calP) -> calP.getYear() == array[finalI]).
                    mapToInt(CalP::getCal).sum() > 1000)
                emptyList.addAll(calPList.stream().filter(calP -> calP.getYear() == array[finalI]).collect(Collectors.toList()));
        }
        System.out.println(System.nanoTime() - time2);
//
        for (CalP cc : emptyList)
            System.out.println(cc);


    }
}
