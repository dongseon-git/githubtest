package DAEHWAN;

import java.sql.Array;
import java.util.*;
public class Baseball {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        List<Integer> list = new ArrayList<>(10);
        Random rnd = new Random();
        int[] numbers = new int[3];

        //1.랜덤숫자만들기
        for(int i = 0; i < 10; ++i)
        {
            list.add(i);
        }
        Collections.shuffle(list, rnd);
        for(int i = 0; i < 3; ++i)
        {
            numbers[i] = list.get(i);
        }
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        int ball = 0;
        int strike = 0;
        String answer = "";
        int[] answers = new int[3];
        //2.각 자리수를 비교해 b와 s수 측정
        while(strike!=3)
        {
            answer = scan.next();
            for(int i = 0; i < 3; ++i)
            {
                answers[i] = Character.getNumericValue(answer.charAt(i));
                if(answers[i] == numbers[i])
                    ++strike;
                else if(answers[i] == numbers[0] || answers[i] == numbers[1] || answers[i] == numbers[2])
                    ++ball;
            }
            ++count;

            System.out.println(count+"번째 시도 : "+answer);
            if(ball == 3)
                System.out.println(ball+"B");
            else if(strike == 3)
                System.out.println(strike+"S");
            else
                System.out.println(ball+"B"+strike+"S");

            if(strike == 3)
                break;

            ball = 0;
            strike = 0;
        }

        if(strike == 3)
        {
            System.out.println(count+"번만에 맞히셨습니다.");
            System.out.print("게임을 종료합니다.");
        }

    }
}

