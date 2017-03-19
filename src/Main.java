import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<CalP> calPList = Arrays.asList(
                new CalP(2019, 100000),
                new CalP(219, 100),
                new CalP(23319, 901));

        List<CalP> emptyList = new ArrayList<>();
        int array[] = calPList.stream().mapToInt(CalP::getYear).distinct().toArray();
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            int finalI = i;
            if (calPList.stream().
                    filter((calP) -> calP.getYear() == array[finalI]).
                    mapToInt(CalP::getCal).sum() > 1000)
                emptyList.addAll(calPList.stream().filter(calP -> calP.getYear() == array[finalI]).collect(Collectors.toList()));
        }

        for (CalP cc : emptyList)
            System.out.println(cc);


    }
}
