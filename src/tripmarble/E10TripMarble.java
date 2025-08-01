package tripmarble;


import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.sql.Array;
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
        String cityName;
        Color color;
        int width =200;
        int height =125;

    }
    class StartBlock extends Block{

    }
    class CharityBlock extends Block{

    }
    class AirportBlock extends Block{

    }
    class User{
        List<GoldKey> goldKeys=new ArrayList<>();
    }
    enum GoldKey{
        세칸뒤("유저는 세칸뒤로 이동하세요"), 두칸뒤, 한칸뒤, 한칸앞, 두칸앞, 세칸앞,     //유저 이동
        세계여행, 서울로, 출발지로, 세계일주,              //특정 장소로 이동
        노벨평화상, 복권당첨, 장학금,                     //현금 ++
        반액대매출,                                          //가장비싼 건물을 반값에 팔기
        해외유학, 병원비, 과속운전,                       //현금 --
        건물유지관리비,                                       // -- 소유한 건물 x 2만원
        우대권1("우대권입니다."), 우대권2("우대권입니다.");//우대권 (통행료 무료)
        String text;
        GoldKey(){}
        GoldKey(String text){
            this.text=text;
        }
    }
    class GoldKeyBlock extends Block{
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
//                case 병원비 ->  //user cash-- 5만
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
            for (Block b: blockArrayList){
                g.setColor(b.color);
                g.drawRect(b.x,b.y,b.width,b.height);
                g.drawString(b.cityName,b.x+25,b.y+25);
            }
        }
    }
    private Canvas canvas;
    public Marble(){
        super("TripMarble");
        canvas = new MyCanvas();
        CityBlock seoul = new CityBlock(0,200,"Seoul", CityBlock.CityClass.한국);
        blockArrayList.add(seoul);
//        CityBlock taipei = new CityBlock()
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
