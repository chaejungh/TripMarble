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
        int width;
        int height;
        Color color;

        public Block(int x, int y,int width,int height) { //drawRect 그릴때
            this.x = x;
            this.y = y;
            this.height = height;
            this.width = width;
        }

        public Block(int x, int y, String cityName, int width, int height, Color color) {
            this.x = x;
            this.y = y;
            this.cityName = cityName;
            this.width = width;
            this.height = height;
            this.color = color;
        }

        Block(){

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
        Block seoul = new Block(0,200,"Seoul",200,125,Color.BLACK);
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
