package laundry_facade;

/**
 * VOP eksamen F15 Færdig kode Klasse som repræsenterer et enkelt vaskeprogram
 *
 * @author erso
 */
public class WashProgram {

    private final String name;
    private final double price;

    public WashProgram(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": " + price + "\n";
    }
}
