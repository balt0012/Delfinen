import java.util.Comparator;

public class SwimmerComparator implements Comparator<Training> {

    @Override
    public int compare(Training o1, Training o2) {
        // returns 0 if o1 is equal to o2. 1 if o1 is higher than o2. -1 if
        if (o1.getTime() == o2.getTime()) {
            return 0;
        } else if (o1.getTime() > o2.getTime()) {
            return 1;
        } else {
            return -1;
        }
    }
}
