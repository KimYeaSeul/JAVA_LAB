### 항해 2주차 프로그래밍 기초

### [Spring 과제](https://teamsparta.notion.site/Spring-21e4ad6ab38841b894bbecd842fa623d)

<br>

### 2주차 목표

- 자바 언어 공부
- 알고리즘 기초 공부
- 과제를 통한 객체지향 공부

### 과제

- 택시와 버스 객체 구현
  <br>

transport.java (공통클래스)

```
  UUID licenseNum;        // 객체 별 고유 ID생성
  String transport = "";  // 이동 수단 종류(버스,택시)
  int oil = 100;          // 주유량
  int maxPassenger = 0;   // 최대 수용 가능 승객 수
  int nowPassenger = 0;   // 현재 승객 수
  int earn = 0;           // 총 수입
  int fee = 0;            // 현재 요금
  StatusEnum status;      // 운행 상태, Enum

  public void boardPassenger(int passenger){} // 승객 탑승
  public void changeStatus(){}      // 상태 변경
  public void changeOil(int oil){}  // 주유량 변경
  public int remainPassenger(){}    // 남아있는 승객 수
  public void setEarn(int fee){}    // 수입 설정
  public String getStatus(){}       // 상태 가져오기
  public int getOil(){}             // 주유량 가져오기
  public int getEarn(){}            // 총 수입 가져오기
```

출력 결과

```
==== BUS ====
bus1 번호 = cf807efa-0866-4324-ae26-9382eeddd140
bus2 번호 = f33500dc-300e-4946-8b03-3286b0c44349
==== BUS1 ====
탑승 승객 수 = 2
잔여 승객 수 = 28
요금 확인 = 2000
주유량 = 50
상태 = 차고지행
주유량 = 60
최대 승객 수 초과!
탑승 승객 수 = 5
잔여 승객 수 = 25
요금 = 5000
주유 필요!!
주유량 = 5
상태 = 차고지행

==== TAXI ====
taxi1 번호 = d9658884-72f1-4f8b-a1d1-46ead8cf1cb9
taxi1 주유량 = 100
taxi1 상태 = 일반
taxi2 번호 = 4168c6be-f337-4870-ab61-fa195996c12f
taxi2 주유량 = 100
taxi2 상태 = 일반
==== TAXI1 ====
탑승 승객 수 = 2
잔여 승객 수 = 2
기본 요금 확인 = 3000
목적지 = 서울역
목적까지 거리 = 2km
지불할 요금 = 4000
상태 = 일반
주유량 = 20
누적 요금 = 4000
최대 승객 수 초과!
탑승 승객 수 = 3
잔여 승객 수 = 1
기본 요금 확인 = 3000
목적지 = 구로디지털단지역
목적까지 거리 = 12km
지불할 요금 = 14000
주유 필요!!
주유량 = 0
상태 = 운행중
누적 요금 = 14000
```
