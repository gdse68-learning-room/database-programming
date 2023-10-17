package lk.ijse.singleton;

public class WashingMachine {
    private static WashingMachine washingMachine;
    private WashingMachine() {

    }

    public static WashingMachine getInstance() {
        if(washingMachine == null) {
            washingMachine = new WashingMachine();
            return washingMachine;
        } else {
            return washingMachine;
        }
    }
}
