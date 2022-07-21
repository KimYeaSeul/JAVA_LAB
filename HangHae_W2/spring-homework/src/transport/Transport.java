package transport;

import java.util.UUID;

public class Transport {
    UUID licenseNum;
    String transport = "";
    int oil = 100;
    int maxPassenger = 0;
    int nowPassenger = 0;
    int earn = 0;
    int fee = 0;
    StatusEnum status;

    Transport(UUID licenseNum){
        this.licenseNum = licenseNum;
    }

    public void changeStatus(){
        this.nowPassenger = 0;
        this.earn = 0;
        if(transport.equals("BUS")){
            if(status == StatusEnum.운행중) status = StatusEnum.차고지행;
            else if(status == StatusEnum.차고지행) status = StatusEnum.운행중;
        }else if(transport.equals("TAXI")){
            if(status == StatusEnum.운행중) status = StatusEnum.일반;
            else if(status == StatusEnum.일반) status = StatusEnum.운행중;
        }
    }

    public void changeOil(int oil){
        this.oil = this.oil + oil;
        if(this.oil < 10) {
            System.out.println("주유 필요!!");
            changeStatus();
        }
    }

    public int remainPassenger(){
        return this.maxPassenger - this.nowPassenger;
    }

    public void setEarn(int fee){
        this.earn += fee;
    }
    public int getOil(){
        return this.oil;
    }

    public void boardPassenger(int passenger){
        if((this.nowPassenger+ passenger) > this.maxPassenger) {
            System.out.println("최대 승객 수 초과!");
        }else{
            this.nowPassenger = this.nowPassenger + passenger;
        }
    }

    public int getEarn(){
        return this.earn;
    }

    public String getStatus(){
        return status.toString();
    }
}
