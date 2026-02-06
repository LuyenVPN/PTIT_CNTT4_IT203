package Session10.B4;

public class Main {
    public static void main(String[] args) {

        RemoteControl smartLight = new RemoteControl() {
            @Override
            public void powerOn() {
                System.out.println("Đèn đã bật");
            }
        };

        smartLight.powerOn();
        smartLight.checkBattery();
    }
}
