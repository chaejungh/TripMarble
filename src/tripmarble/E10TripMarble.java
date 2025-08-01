package tripmarble;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Marble extends JFrame{
    ArrayList<Block> blockArrayList = new ArrayList<>();
    int FRAME_WIDTH = 1200;
    ArrayList<GoldKeyBlock.GoldKey> keyList = new ArrayList<>();
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
    class DiceBlock extends Block{
        public DiceBlock(){
            this.color = Color.GRAY;
            this.x = 200*3;
            this.y = 125*3;
            this.cityName = "주사위";
            //병합 테스트용 수정
            //병합 테스트용 수정
            //병합 테스트용 수정
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
    class GoldKeyBlock extends Block{
        public GoldKeyBlock(int x, int y){
            this.color = Color.ORANGE;
            this.cityName = "황금열쇠";
            this.x = x;
            this.y = y;
        }
        enum GoldKey{
            세칸뒤, 한칸뒤, 세칸앞, 한칸앞,  세계여행
        }
        GoldKey goldKey;

        public void play(){
            switch (goldKey){
                case 세칸뒤 -> threeBack();
                //~~
            }
        }
        public void threeBack(){
            //User 객체를 받아서 유저의 위치를 옮기기
        }
        //~~~~~
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
        DiceBlock diceBlock = new DiceBlock();
        blockArrayList.add(diceBlock);
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
