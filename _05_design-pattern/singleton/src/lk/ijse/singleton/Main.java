package lk.ijse.singleton;

public class Main {
    public static void main(String[] args) {
        /*WashingMachine wm1 = new WashingMachine();
        WashingMachine wm2 = new WashingMachine();
        WashingMachine wm3 = new WashingMachine();*/

        WashingMachine wm1 = WashingMachine.getInstance();
        WashingMachine wm2 = WashingMachine.getInstance();
        WashingMachine wm3 = WashingMachine.getInstance();

        System.out.println(wm1);
        System.out.println(wm2);
        System.out.println(wm3);
    }
}
