import java.util.Comparator;

public class SwimmerComparator implements Comparator<TrainingResult> {
    // Lavet af Carl

    @Override
    public int compare(TrainingResult o1, TrainingResult o2) {
        // returns 0 if o1 is equal to o2. 1 if o1 is higher than o2. -1 if o1 is lower than o2.
        if (o1.getTime() == o2.getTime()) {
            return 0;
        } else if (o1.getTime() > o2.getTime()) {
            return 1;
        } else {
            return -1;
        }
    }
}
