package tripmarble;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Marble extends JFrame{
    ArrayList<CityBlock> blockArrayList = new ArrayList<>();
    int FRAME_WIDTH = 1200;


    class CityBlock {
        enum CityClass{
            아시아, 유럽, 명승지, 대도시, 한국
        }
        int x;
        int y;
        String cityName;
        int width =200;
        int height =125;
        Color color;
        int buildingPrice;
        boolean isSoldHouse;
        boolean isSoldBuilding;
        boolean isSoldHotel;
        CityClass cityClass;

        public CityBlock(int x, int y, String cityName, int width, int height, CityClass cityClass) {
            this.x = x;
            this.y = y;
            this.cityName = cityName;
            this.width = width;
            this.height = height;
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

            }
        }
    }
    class MyCanvas extends Canvas{
        MyCanvas(){

        }
        @Override
        public void paint(Graphics g) {
            for (CityBlock b: blockArrayList){
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
        CityBlock seoul = new CityBlock(0,200,"Seoul",200,125, CityBlock.CityClass.한국);
        blockArrayList.add(seoul);
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
