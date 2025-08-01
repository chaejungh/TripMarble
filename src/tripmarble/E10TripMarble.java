package tripmarble;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Marble extends JFrame{
    ArrayList<Block> blockArrayList = new ArrayList<>();
    int FRAME_WIDTH = 1200;

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
        CityBlock taipei = new CityBlock()
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
