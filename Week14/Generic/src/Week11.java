import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Week11 {
    /**
     * Sorting method in generic programming.
     * @param list the list to be sorted
     * @param <T> the type of each element in the list
     * @return the list that is sorted
     */
    public static <T extends Comparable<T>> List<T> sortGeneric(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(min).compareTo(list.get(j)) > 0) {
                    min = j;
                }
            }
            Collections.swap(list, min, i);
        }
        return list;
    }
}