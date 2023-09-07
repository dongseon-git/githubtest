package src.kimjaehan;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class baseBallTest {
    public static void main(String[] args){
        int[] cp = new int[3];
        int[] user = new int[3];
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int count = 0;

        while (cp[0] == 0){
            cp[0] = r.nextInt(10);
        }
        while (cp[0] == cp[1] || cp[1] == 0){
            cp[1] = r.nextInt(10);
        }
        while (cp[1] == cp[2] || cp[2] == 0){
            cp[2] = r.nextInt(10);
        }
        System.out.println("숫자 3개를 입력하세요");
        while (true){
            int strike = 0; //스타리이크 저장
            int ball = 0; // 볼 저장
            count++; // 횟수 저장

            for(int i = 0; i<user.length; i++){
                System.out.print((i+1)+"번째 숫자를 입력 : ");
                user[i] = sc.nextInt();
                if(user[i] > 9 || user[i] < 0){
                    System.out.println("범위는 0~9 입니다."); // 0~9 범위 외 입력 시 출력
                }
            }System.out.print(count+"번째 시도 " + Arrays.toString(user));
            System.out.println();

            for(int i=0; i<cp.length; i++) {
                for(int j=0; j<user.length; j++) {
                    if(cp[i] == user[j] && i==j) { // 숫자와 위치가 일치
                        strike++;
                    } else if(cp[i] ==user[j] && i!=j) { // 위치는 다르나 숫자는 일치
                        ball++;
                    }
                }
            }
            System.out.println("생성된 숫자 = "+Arrays.toString(cp));// 생성된 숫자 확인
            System.out.println(strike+" S "+ball+" B ");
            if(strike == 3){
                System.out.println("3S");
                System.out.println(count+" 번만에 맞추셨습니다.");
                break;
            }
        }
    }
}
