package tripmarble;

import java.util.Random;

public class D01Dice {
    public static void main(String[] args) {

        Random random = new Random();
        int dice = random.nextInt(6) + 1; // 1부터 6까지 숫자 생성
        System.out.println("주사위 눈: " + dice);
    }

}
