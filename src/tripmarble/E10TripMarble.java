package tripmarble;

import javax.swing.*;
import java.awt.*;
import java.util.*;

class Marble extends JFrame {
    ArrayList<Block> blockArrayList = new ArrayList<>();
    int FRAME_WIDTH = 1200;
    ArrayList<GoldKey> allGoldKey = new ArrayList<>();

    // === [주사위 기능 시작] ===
    JButton diceButton;
    JLabel diceResultLabel;
    Random random = new Random();
    // === [주사위 기능 끝] ===
    int position;
    //블럭들 전역변수로 생성
    private DiceBlock diceBlock;
    private CharityBlock charityPay;
    private CharityBlock charityGet;
    private CityBlock hongkong;
    private GoldKeyBlock goldKeyBlock1;
    private GoldKeyBlock goldKeyBlock2;
    private GoldKeyBlock goldKeyBlock3;
    private GoldKeyBlock goldKeyBlock4;
    private CityBlock beijing;
    private CityBlock athens;
    private CityBlock tokyo;
    private StartBlock startBlock;
    private CityBlock seoul;
    private CityBlock taipei;
    private CityBlock stockholm;
    private CityBlock madrid;
    private CityBlock newYork;
    private CityBlock singapore;
    private CityBlock cairo;
    private CityBlock rome;
    private AirportBlock airport;
    private CityBlock buenosAires;
    private CityBlock sydney;
    private CityBlock berlin;
    private CityBlock istanbul;
    

    class Block{

    // === [주사위 기능 시작] ===
    // === [주사위 기능 끝] ===
        
        int x;
        int y;
        String cityName = "블럭";
        Color color;
        int width = 200;
        int height = 125;

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

    class StartBlock extends Block {
        public StartBlock() {
            this.color = Color.BLACK;
            this.x = 0;
            this.y = 750;
            this.cityName = "Start";
        }
    }

    class DiceBlock extends Block {
        public DiceBlock() {
            this.color = Color.GRAY;
            this.x = 200 * 3;
            this.y = 125 * 3;
            this.cityName = "주사위";
        }
    }

    class CharityBlock extends Block {
        public CharityBlock(int x, int y, String cityName) {
            this.x = x;
            this.y = y;
            this.cityName = cityName;
            this.color = Color.GRAY;
        }
    }

    class AirportBlock extends Block {
        public AirportBlock(int x, int y) {
            this.x = x;
            this.y = y;
            this.cityName = "Airport";
            this.color = Color.GRAY;
        }
    }

    class User {
        int x = 0;
        int y = 750;
        int money;
    }


    enum GoldKey {
        세칸뒤("세칸뒤로 이동"), 두칸뒤("두칸뒤로 이동"), 한칸뒤("한칸뒤로 이동"),
        세칸앞("세칸앞으로 이동"), 두칸앞("두칸앞으로 이동"), 한칸앞("한칸앞으로 이동"),
        세계여행("Airport로 이동"), 서울로("서울로 이동"), 출발지로("Start로 이동"),
        세계일주("세계일주를 합니다."),
        노벨평화상("노벨 평화상 수상 +30만원"), 복권당첨("복권당첨 +20만원"), 장학금("장학금 획득 +10만원"),
        반액대매출("가장 비싼 건물을 반값에 팝니다."),
        해외유학("해외유학 -10만원"), 병원비("병원 입원비 -5만원"), 과속운전("과속운전 벌금 -5만원"),
        건물유지관리비("건물 유지관리비 납부. -(소유건물 x2)만원"),
        우대권1("우대권"), 우대권2("우대권");

        String text;
        GoldKey(String text) {
            this.text = text;
        }
    }

    class GoldKeyBlock extends Block {
        public GoldKeyBlock(int x, int y) {
            this.color = Color.ORANGE;
            this.cityName = "황금열쇠";
            this.x = x;
            this.y = y;
        }
    }

    class CityBlock extends Block {
        enum CityClass {아시아, 유럽, 명승지, 대도시, 한국}
        int buildingPrice;
        CityClass cityClass;

        public CityBlock(int x, int y, String cityName, CityClass cityClass) {
            this.x = x;
            this.y = y;
            this.cityName = cityName;
            this.cityClass = cityClass;
            switch (cityClass) {
                case 아시아 -> { color = Color.RED; buildingPrice = 5; }
                case 유럽 -> { color = Color.YELLOW; buildingPrice = 10; }
                case 명승지 -> { color = Color.GREEN; buildingPrice = 15; }
                case 대도시 -> { color = Color.BLUE; buildingPrice = 20; }
                case 한국 -> { color = Color.BLACK; buildingPrice = 100; }
            }
        }
    }

    class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            if (blockArrayList == null) return;
            for (Block b : blockArrayList) {
                if (b.cityName == null) continue;
                g.setColor(b.color);
                g.fillRect(b.x, b.y, b.width, b.height);
                g.setColor(Color.white);
                g.drawString(b.cityName, b.x + 75, b.y + 62);
            }
        }
    }

    private Canvas canvas;
    
    public Marble(){
        super("TripMarble");
        System.out.println("시작");
        this.diceBlock = new DiceBlock();
        blockArrayList.add(diceBlock);
        this.charityPay = new CharityBlock(0,0,"기부금 기부");
        blockArrayList.add(charityPay);
        this.hongkong = new CityBlock(0,125,"Hongkong", CityBlock.CityClass.아시아);
        blockArrayList.add(hongkong);
        this.goldKeyBlock1 = new GoldKeyBlock(0,125*2);
        blockArrayList.add(goldKeyBlock1);
        this.beijing = new CityBlock(0,125*3, "Beijing", CityBlock.CityClass.아시아);
        blockArrayList.add(beijing);
        this.athens = new CityBlock(0,125*4,"Athens", CityBlock.CityClass.유럽);
        blockArrayList.add(athens);
        this.tokyo = new CityBlock(0,125*5,"Tokyo", CityBlock.CityClass.대도시);
        blockArrayList.add(tokyo);


        this.startBlock = new StartBlock();
        blockArrayList.add(startBlock);
        this.seoul = new CityBlock(200,125*6,"Seoul", CityBlock.CityClass.한국);
        blockArrayList.add(seoul);
        this.taipei = new CityBlock(200*2,125*6,"Taipei", CityBlock.CityClass.아시아);
        blockArrayList.add(taipei);
        this.goldKeyBlock2 = new GoldKeyBlock(200*3,125*6);
        blockArrayList.add(goldKeyBlock2);
        this.stockholm = new CityBlock(200*4,125*6, "Stockholm", CityBlock.CityClass.유럽);
        blockArrayList.add(stockholm);
        this.madrid = new CityBlock(200*5,125*6,"Madrid", CityBlock.CityClass.명승지);
        blockArrayList.add(madrid);
        this.charityGet = new CharityBlock(200*6,125*6,"기부금 받기");
        blockArrayList.add(charityGet);


        this.newYork = new CityBlock(200*6,125*5,"NewYork", CityBlock.CityClass.대도시);
        blockArrayList.add(newYork);
        this.singapore = new CityBlock(200*6,125*4,"Singapore", CityBlock.CityClass.아시아);
        blockArrayList.add(singapore);
        this.goldKeyBlock3 = new GoldKeyBlock(200*6,125*3);
        blockArrayList.add(goldKeyBlock3);
        this.cairo = new CityBlock(200*6,125*2,"Cairo", CityBlock.CityClass.아시아);
        blockArrayList.add(cairo);
        this.rome = new CityBlock(200*6,125,"Rome", CityBlock.CityClass.대도시);
        blockArrayList.add(rome);
        this.airport = new AirportBlock(200*6,0);
        blockArrayList.add(airport);

        this.buenosAires =new CityBlock(200*5,0,"Buenos Aires", CityBlock.CityClass.명승지);
        blockArrayList.add(buenosAires);
        this.sydney = new CityBlock(200*4,0,"Sydney", CityBlock.CityClass.대도시);
        blockArrayList.add(sydney);
        this.goldKeyBlock4 = new GoldKeyBlock(200*3,0);
        blockArrayList.add(goldKeyBlock4);
        this.berlin = new CityBlock(200*2,0,"Berlin", CityBlock.CityClass.유럽);
        blockArrayList.add(berlin);
        this.istanbul = new CityBlock(200,0,"Istanbul", CityBlock.CityClass.아시아);
        blockArrayList.add(istanbul);

        
        canvas = new MyCanvas();

        // === [주사위 기능 시작] ===
        diceButton = new JButton("🎲 주사위 굴리기");
        diceResultLabel = new JLabel("결과: ", SwingConstants.CENTER);
        diceResultLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));

        diceButton.addActionListener(e -> {
            int dice = random.nextInt(6) + 1;
            diceResultLabel.setText("결과: " + dice);
            move(dice);
        });

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setPreferredSize(new Dimension(200, getHeight()));
        rightPanel.add(Box.createVerticalStrut(100));
        rightPanel.add(diceButton);
        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(diceResultLabel);
        // === [주사위 기능 끝] ===

        this.setLayout(new BorderLayout());
        this.add(canvas, BorderLayout.CENTER);
        // === [주사위 기능 시작] ===
        this.add(rightPanel, BorderLayout.EAST);
        // === [주사위 기능 끝] ===

        this.setBounds(0, 0, 1920, 1080);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void move(int diceRoll) {
        System.out.println("주사위 값: " + diceRoll + "칸 이동");
        // 추후 말 이동 기능 구현
    }
}

public class E10TripMarble {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Marble::new);
    }
}
