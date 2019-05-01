package facade;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 * Kodeskelet til VOP eksamen F15, opgave 2.
 *
 * @author erso
 */
public class Facade {

    private int[] intArray;
    private final Random random;

    public Facade() {
        this.random = new Random();
    }

    public int[] getIntArray() {
        return intArray;
    }

    public int[] fillArray(int size, int max) {
        return intArray = Stream.generate(() -> random.nextInt(max + 1)).limit(size).mapToInt(i -> i).toArray();
    }

    public int sumOfDivisors(int divisor) {
        return Arrays.stream(intArray).filter(x -> x % divisor == 0).sum();
    }

    public int[] fillUniqueArray(int size, int max) {
        if (size >= max) {
            System.out.println("size er større end max!");
        }
        return intArray = size < max ? ThreadLocalRandom.current().ints(0, max + 1).distinct().limit(size).sorted().toArray() : null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Facade facade = new Facade();

        System.out.println("fillArray: " + Arrays.toString(facade.fillArray(20, 10)));
        int divisor = 3;
        System.out.println("Divisors of " + divisor + " has Sum: " + facade.sumOfDivisors(divisor));

        System.out.println("fillUnique: " + Arrays.toString(facade.fillUniqueArray(20, 30)));

        System.out.println("Error: " + Arrays.toString(facade.fillUniqueArray(20, 20)));
    }

}
