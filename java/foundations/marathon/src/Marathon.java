// Marathon rankings. See README.md for usage.
public class Marathon {
    public static void main(String[] args) {
        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
            "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        int[] times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
        int fastest = getFastestIndex(times);
        int second = getSecondFastestIndex(times);
        System.out.println("Fastest runner: " + names[fastest] + " (" + times[fastest] + " minutes)");
        System.out.println("Second fastest: " + names[second] + " (" + times[second] + " minutes)");
    }
    public static int getFastestIndex(int[] times) {
        validate(times, 1);
        int fastest = 0;
        for (int i = 1; i < times.length; i++) if (times[i] < times[fastest]) fastest = i;
        return fastest;
    }
    public static int getSecondFastestIndex(int[] times) {
        validate(times, 2);
        int fastest = getFastestIndex(times);
        int second = -1;
        for (int i = 0; i < times.length; i++) {
            if (i != fastest && (second == -1 || times[i] < times[second])) second = i;
        }
        return second;
    }
    private static void validate(int[] times, int minimumSize) {
        if (times == null || times.length < minimumSize)
            throw new IllegalArgumentException("At least " + minimumSize + " time(s) are required.");
        for (int time : times) if (time < 0) throw new IllegalArgumentException("Times must be non-negative.");
    }
}
