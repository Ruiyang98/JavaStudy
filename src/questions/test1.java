package questions;


public class test1 {
    public static void main(String[] args) {
        System.out.println("2");
    }


    public int solution(int a, int b, int c) {
        int res = 0;
        int day = 1;	//记录周几
        while(true) {
            if(day == 1 || day == 5 || day == 6) {
                a = a - 8;
            } else if(day == 2 || day == 7) {
                b = b - 5;
            }
            else {
                c = c - 7;
            }

            if(a <= 0 || b <= 0 || c <=0) break;	//

            if(day ==7) {day = 1;
            }else {day++;}
            res++;
        }


        return res;

    }
}
