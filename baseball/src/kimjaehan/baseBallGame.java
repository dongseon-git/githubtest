package kimjaehan;

import java.util.Arrays;
import java.util.Scanner;
public class baseBallGame {
    public static void main(String[] args) {
        int[] user = new int[3];
        Scanner sc = new Scanner(System.in);
        int c = 0;

        int[] ball = new int[10];

        //배열에 1부터 순서대로 저장
        for (int i = 0; i < ball.length; i++)
            ball[i] = i;
        // System.out.println(Arrays.toString(ball));
        int temp = 0; // 두수를 바꾸는 데 임시로 저장할 변수
        int j = 0; // 임의의 값을 얻어 저장할 변수

        for (int i = 0; i < 6; i++) {
            j = (int) (Math.random() * 10);//0~9까지의 임의이 값을 얻는다
            temp = ball[i];
            ball[i] = ball[j];
            ball[j] = temp;
        }

        int[] loto = Arrays.copyOfRange(ball, 0, 3); //copyOfRange 메서드를 통해 0~5까지 요소 외 자르기
        //System.out.println(Arrays.toString(ball));
        //System.out.println(Arrays.toString(loto));
        System.out.println("숫자 3개를 입력하세요");
        while (true) {
            int s = 0;
            int b = 0;
            c++;
            for (int i = 0; i < user.length; i++) {
                user[i] = sc.nextInt();
                if (user[i] > 9 || user[i] < 0) {
                    System.out.println("범위는 0~9 입니다."); // 0~9 범위 외 입력 시 출력
                }
            }
            System.out.print(c + "번째 시도 " + Arrays.toString(user));
            System.out.println();
            for(int i = 0; i<loto.length; i++){
                for(int d = 0; d<user.length; d++){
                    if(loto[i] == user[d] && i == d){
                        s++;
                    } else if(loto[i] == user[d] && i == d){
                        b++;
                    }
                }
            }
            System.out.println("생성된 숫자 = "+Arrays.toString(loto));// 생성된 숫자 확인
            System.out.println(s+" S "+b+" B ");
            if(s == 3){
                System.out.println("3S");
                System.out.println(c+" 번만에 맞추셨습니다.");
                break;

            }
        }
    }
}

