package laundry_facade;

/**
 * VOP Eksamen F15 Interface til opg 3.
 *
 * @author erso
 */
public interface LaundryMachine {

    String getModel();

    double getPrice(int prog);

    String getProgName(int prog);
}
