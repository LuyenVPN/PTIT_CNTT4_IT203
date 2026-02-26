package Session13;

import java.util.LinkedList;

class ERPatient {
    private String name;
    private boolean emergency;

    public ERPatient(String name, boolean emergency) {
        this.name = name;
        this.emergency = emergency;
    }

    public String getName() {
        return name;
    }

    public boolean isEmergency() {
        return emergency;
    }
}

class EmergencyRoom {

    private LinkedList<ERPatient> waitingList = new LinkedList<>();

    // Bệnh nhân thường
    public void patientCheckIn(String name) {
        ERPatient p = new ERPatient(name, false);
        waitingList.addLast(p);
        System.out.println("CheckIn thường: " + name);
    }

    // Bệnh nhân cấp cứu
    public void emergencyCheckIn(String name) {
        ERPatient p = new ERPatient(name, true);
        waitingList.addFirst(p);
        System.out.println("CheckIn cấp cứu: " + name);
    }

    // Gọi vào khám
    public void treatPatient() {
        if (waitingList.isEmpty()) {
            System.out.println("Không còn bệnh nhân.");
            return;
        }

        ERPatient p = waitingList.removeFirst();

        if (p.isEmergency()) {
            System.out.println("Đang cấp cứu: " + p.getName());
        } else {
            System.out.println("Đang khám: " + p.getName());
        }
    }
}

public class B4_s13 {
    public static void main(String[] args) {

        EmergencyRoom er = new EmergencyRoom();

        er.patientCheckIn("A");
        er.patientCheckIn("B");
        er.emergencyCheckIn("C");

        System.out.println();

        er.treatPatient();
        er.treatPatient();
        er.treatPatient();
    }
}