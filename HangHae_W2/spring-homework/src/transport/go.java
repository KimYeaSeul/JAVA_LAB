package transport;

import java.util.UUID;

public class go {
    public static void main(String[] args) {
        BUS bus1 = new BUS(UUID.randomUUID());
        BUS bus2 = new BUS(UUID.randomUUID());


        bus1.boardPassenger(2);
        System.out.println("==== BUS ====");

        System.out.println("bus1 번호 = " +bus1.licenseNum);
        System.out.println("bus2 번호 = " +bus2.licenseNum);

        System.out.println("==== BUS1 ====");
        System.out.println("탑승 승객 수 = " +bus1.nowPassenger);
        System.out.println("잔여 승객 수 = " +bus1.remainPassenger());
        System.out.println("요금 확인 = " +bus1.getEarn());
        bus1.changeOil(-50);
        System.out.println("주유량 = " +bus1.getOil());
        bus1.changeStatus();
        bus1.changeOil(10);
        System.out.println("상태 = " +bus1.getStatus());
        System.out.println("주유량 = " +bus1.getOil());
        bus1.changeStatus();
        bus1.boardPassenger(45);
        bus1.boardPassenger(5);
        System.out.println("탑승 승객 수 = " +bus1.nowPassenger);
        System.out.println("잔여 승객 수 = " +bus1.remainPassenger());
        System.out.println("요금 = " +bus1.getEarn());
        bus1.changeOil(-55);
        System.out.println("주유량 = " +bus1.getOil());
        System.out.println("상태 = " +bus1.getStatus());

        TAXI taxi1 = new TAXI(UUID.randomUUID());
        TAXI taxi2 = new TAXI(UUID.randomUUID());

        System.out.println("==== TAXI ====");

        System.out.println("taxi1 번호 = " +taxi1.licenseNum);
        System.out.println("taxi1 주유량 = " +taxi1.getOil());
        System.out.println("taxi1 상태 = " +taxi1.getStatus());
        System.out.println("taxi2 번호 = " +taxi2.licenseNum);
        System.out.println("taxi2 주유량 = " +taxi2.getOil());
        System.out.println("taxi2 상태 = " +taxi2.getStatus());

        System.out.println("==== TAXI1 ====");
        taxi1.setDrive(2, "서울역", 2);
        System.out.println("탑승 승객 수 = " +taxi1.nowPassenger);
        System.out.println("잔여 승객 수 = " +taxi1.remainPassenger());
        System.out.println("기본 요금 확인 = " +taxi1.getBasicFee());
        System.out.println("목적지 = " +taxi1.getDestination());
        System.out.println("목적까지 거리 = " +taxi1.getDestinationDistance()+"km");
        System.out.println("지불할 요금 = " +taxi1.getPayment());
        System.out.println("상태 = " +taxi1.getStatus());
        taxi1.changeOil(-80);
        taxi1.payment();
        System.out.println("주유량 = " +taxi1.getOil());
        System.out.println("누적 요금 = " +taxi1.getEarn());
        taxi1.boardPassenger(5);
        taxi1.setDrive(3, "구로디지털단지역", 12);

        System.out.println("탑승 승객 수 = " +taxi1.nowPassenger);
        System.out.println("잔여 승객 수 = " +taxi1.remainPassenger());
        System.out.println("기본 요금 확인 = " +taxi1.getBasicFee());
        System.out.println("목적지 = " +taxi1.getDestination());
        System.out.println("목적까지 거리 = " +taxi1.getDestinationDistance()+"km");
        System.out.println("지불할 요금 = " +taxi1.getPayment());
        taxi1.changeOil(-20);
        taxi1.payment();
        System.out.println("주유량 = " +taxi1.getOil());
        System.out.println("상태 = " +taxi1.getStatus());
        System.out.println("누적 요금 = " +taxi1.getEarn());
    }
}
