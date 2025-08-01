package tripmarble;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Marble extends JFrame{
    ArrayList<Block> blockArrayList = new ArrayList<>();
    int FRAME_WIDTH = 1200;
    ArrayList<GoldKey> allGoldKey = new ArrayList<>();
    class Block{
        int x;
        int y;
        String cityName="블럭";
        Color color;
        int width =200;
        int height =125;

        @Override
        public String toString() {
            return "Block{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cityName='" + cityName + '\'' +
                    ", color=" + color +
                    ", width=" + width +
                    ", height=" + height +
                    '}';
        }
    }
    class StartBlock extends Block{
        public StartBlock() {
            this.color = Color.BLACK;
            this.x = 0;
            this.y = 750;
            this.cityName = "Start";
        }
    }
    class CharityBlock extends Block{
        public CharityBlock(int x, int y, String cityName){
            this.x = x;
            this.y = y;
            this.cityName =cityName;
            this.color = Color.GRAY;
        }
    }
    class AirportBlock extends Block{
        public AirportBlock(int x, int y) {
            this.x = x;
            this.y = y;
            this.cityName = "Airport";
            this.color = Color.GRAY;
        }

    }
    class User{
        List<GoldKey> goldKeys=new ArrayList<>();
    }
    enum GoldKey {
        //유저 이동
        세칸뒤("세칸뒤로   이동"), 두칸뒤("두칸뒤로  이동"), 한칸뒤("두칸뒤로   이동"),
        세칸앞("세칸앞으로 이동"), 두칸앞("두칸앞으로 이동"), 한칸앞("한칸앞으로 이동"),

        //특정 장소로 이동
        세계여행("Airport로 이동"), 서울로("서울로 이동"),
        출발지로("Start로 이동"), 세계일주("세계일주를 합니다."),

        //현금 ++
        노벨평화상("노벨 평화상 수상 +30만원"), 복권당첨("복권당첨 +20만원"), 장학금("장학금 획득 +10만원"),
        반액대매출("가장 비싼 건물을 반값에 팝니다."),

        //현금 --
        해외유학("해외유학 -10만원"), 병원비("병원 입원비 -5만원"), 과속운전("과속운전 벌금 -5만원"),
        건물유지관리비("건물 유지관리비 납부. -(소유건물 x2)만원"),


        우대권1("우대권"), 우대권2("우대권");    //우대권 (통행료 무료)
        String text;

        GoldKey() {
        }

        GoldKey(String text) {
            this.text = text;
        }
    }
    class GoldKeyBlock extends Block{
        public GoldKeyBlock(int x, int y){
            this.color = Color.ORANGE;
            this.cityName = "황금열쇠";
            this.x = x;
            this.y = y;
        }
        GoldKey goldKey;

        public void play(){
            switch (goldKey){

                //유저이동                      기존 이동 에서 가져오기
                //case 세칸뒤 -> //threeBack();
                //case 두칸뒤 -> //twoBack();
                //case 한칸뒤 -> //oneBack();
                //case 한칸앞 -> //oneFront();
                //case 두칸앞 -> //twoFront();
                //case 세칸앞 -> //threeFront();

                //특정장소로 이동
                //case 세계여행 -> //Move(AirportBlock);
                //case 서울로 ->   //Move(한국);
                //case 출발지로 -> //Move(StartingPoint);
                //case 세계일주 -> //getcash.Charity; cash.Charity=0;  +20만

                //현금++
//                case 노벨평화상 ->  //user cash++ 30만
//                case 복권당첨 ->    //user cash++ 20만
//                case 장학금 ->      //user cash++ 10만
//                case 반액대매출 ->   //user.sell highest building, user.cash += cost(this.building)/2
//
//                //현금--
//                case 해외유학 ->  //user cash-- 10만
//                case 병원비 ->    //user cash-- 5만
//                case 과속운전 ->  //user cash-- 5만
//                case 건물유지관리비 -> // user.cash = cash - (user.소유중 건물 x2만)
//
//                //우대권
//                case 우대권 -> //user.우대권 true _ 통행료 = 0;      우대권은 게임내에 2개까지 존재
                //case 우대권2 -> //user.우대권 true _ 통행료 = 0;      우대권은 게임내에 2개까지 존재
                //~~
            }
        }

        private void twoBack() {
        }

        public void threeBack(){
            //User 객체를 받아서 유저의 위치를 옮기기
        }
        //~~~~~

        private LinkedList<GoldKey> deck; //골드키를 뽑고 다시 넣을 덱

        private List<GoldKey> playerHands; //플레이어가 소유한 카드 : 우대권

        public GoldKeyBlock() {
            //enum의 모든 카드 추가
            for(GoldKey goldkey : GoldKey.values()){
                allGoldKey.add(goldkey);
            }
            Collections.shuffle(allGoldKey);  //카드 섞기
        }
    }
    class CityBlock extends Block {
        enum CityClass{
            아시아, 유럽, 명승지, 대도시, 한국
        }
        int buildingPrice;
        boolean isSoldHouse;
        boolean isSoldBuilding;
        boolean isSoldHotel;
        CityClass cityClass;

        public CityBlock(int x, int y, String cityName, CityClass cityClass) {
            this.x = x;
            this.y = y;
            this.cityName = cityName;
            switch (cityClass){
                case 아시아:
                    color = Color.RED;
                    buildingPrice=5;
                    break;
                case 유럽 :
                    color=Color.YELLOW;
                    buildingPrice=10;
                    break;
                case 명승지:
                    color = Color.GREEN;
                    buildingPrice = 15;
                    break;
                case 대도시:
                    color = Color.BLUE;
                    buildingPrice = 20;
                    break;
                case 한국:
                    color = Color.BLACK;
                    buildingPrice = 100;
                    break;
            }
        }
    }
    class MyCanvas extends Canvas{
        MyCanvas(){

        }
        @Override
        public void paint(Graphics g) {
            if (blockArrayList==null)return;
            for (Block b: blockArrayList){
                if(b.cityName==null) continue;
                System.out.println(b);
                g.setColor(b.color);
                g.fillRect(b.x,b.y,b.width,b.height);
                g.setColor(Color.white);
                g.drawString(b.cityName, b.x+75,b.y+62);
            }
        }
    }
    private Canvas canvas;
    public Marble(){
        super("TripMarble");
        System.out.println("시작");
        CharityBlock charityPay = new CharityBlock(0,0,"기부금 기부");
        blockArrayList.add(charityPay);
        CityBlock hongkong = new CityBlock(0,125,"Hongkong", CityBlock.CityClass.아시아);
        blockArrayList.add(hongkong);
        GoldKeyBlock goldKeyBlock1 = new GoldKeyBlock(0,125*2);
        blockArrayList.add(goldKeyBlock1);
        CityBlock beijing = new CityBlock(0,125*3, "Beijing", CityBlock.CityClass.아시아);
        blockArrayList.add(beijing);
        CityBlock athens = new CityBlock(0,125*4,"Athens", CityBlock.CityClass.유럽);
        blockArrayList.add(athens);
        CityBlock tokyo = new CityBlock(0,125*5,"Tokyo", CityBlock.CityClass.대도시);
        blockArrayList.add(tokyo);


        StartBlock startBlock = new StartBlock();
        blockArrayList.add(startBlock);
        System.out.println(startBlock);
        CityBlock seoul = new CityBlock(200,125*6,"Seoul", CityBlock.CityClass.한국);
        blockArrayList.add(seoul);
        CityBlock taipei = new CityBlock(200*2,125*6,"Taipei", CityBlock.CityClass.아시아);
        blockArrayList.add(taipei);
        GoldKeyBlock goldKeyBlock2 = new GoldKeyBlock(200*3,125*6);
        blockArrayList.add(goldKeyBlock2);
        CityBlock stockholm = new CityBlock(200*4,125*6, "Stockholm", CityBlock.CityClass.유럽);
        blockArrayList.add(stockholm);
        CityBlock madrid = new CityBlock(200*5,125*6,"Madrid", CityBlock.CityClass.명승지);
        blockArrayList.add(madrid);
        CharityBlock charityGet = new CharityBlock(200*6,125*6,"기부금 받기");
        blockArrayList.add(charityGet);


        CityBlock newYork = new CityBlock(200*6,125*5,"NewYork", CityBlock.CityClass.대도시);
        blockArrayList.add(newYork);
        CityBlock singapore = new CityBlock(200*6,125*4,"Singapore", CityBlock.CityClass.아시아);
        blockArrayList.add(singapore);
        GoldKeyBlock goldKeyBlock3 = new GoldKeyBlock(200*6,125*3);
        blockArrayList.add(goldKeyBlock3);
        CityBlock cairo = new CityBlock(200*6,125*2,"Cairo", CityBlock.CityClass.아시아);
        blockArrayList.add(cairo);
        CityBlock rome = new CityBlock(200*6,125,"Rome", CityBlock.CityClass.대도시);
        blockArrayList.add(rome);
        AirportBlock airport = new AirportBlock(200*6,0);
        blockArrayList.add(airport);

        CityBlock buenosAires =new CityBlock(200*5,0,"Buenos Aires", CityBlock.CityClass.명승지);
        blockArrayList.add(buenosAires);
        CityBlock sydney = new CityBlock(200*4,0,"Sydney", CityBlock.CityClass.대도시);
        blockArrayList.add(sydney);
        GoldKeyBlock goldKeyBlock4 = new GoldKeyBlock(200*3,0);
        blockArrayList.add(goldKeyBlock4);
        CityBlock berlin = new CityBlock(200*2,0,"Berlin", CityBlock.CityClass.유럽);
        blockArrayList.add(berlin);
        CityBlock istanbul = new CityBlock(200,0,"Istanbul", CityBlock.CityClass.아시아);
        blockArrayList.add(istanbul);




        canvas = new MyCanvas();

        this.add(canvas);


        this.setBounds(0,0,1920,1080);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }



    public void move(int diceRoll){


    }
}

public class E10TripMarble {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new Marble();
        });
    }
}
