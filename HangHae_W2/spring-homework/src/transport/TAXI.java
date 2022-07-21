package transport;

import java.util.UUID;

public class TAXI extends Transport{

    int destinationDistance = 0;
    String destination = "";
    int basicFee = 3000;
    int basicDistance = 1;
    int feePerDistance = 1000;
    int addFee = 0;
    public TAXI(UUID licenseNum) {
        super(licenseNum);
        maxPassenger = 4;
        transport = "TAXI";
        status = StatusEnum.일반;
    }

    public void setDrive(int p, String s, int d){
        this.boardPassenger(p);
        this.destination=s;
        this.destinationDistance=d;
    }

    public int getBasicFee(){
        return this.basicFee;
    }
    public String getDestination(){
        return this.destination;
    }
    public int getDestinationDistance(){
        return this.destinationDistance;
    }
    public void payment(){
        setEarn(getPayment());
        nowPassenger=0;
    }
    public int getPayment(){
        addFee = (getDestinationDistance()-this.basicDistance)*this.feePerDistance;
        return getBasicFee()+addFee;
    }
}
