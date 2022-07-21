package transport;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

import java.util.UUID;

public class BUS extends Transport{

    public BUS(UUID licenseNum) {
        super(licenseNum);
        maxPassenger = 30;
        transport = "BUS";
        fee=1000;
        status = StatusEnum.운행중;
    }

    @Override
    public void boardPassenger(int passenger) {
        super.boardPassenger(passenger);
        if((this.nowPassenger+ passenger)<= this.maxPassenger) setEarn(passenger * fee);
    }
}
