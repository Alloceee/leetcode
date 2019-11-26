package leetcode;

import java.util.Scanner;

public class work26 {
    public static void main(String[] args) {
        System.out.println(sub());
    }

    public static String sub() {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        String[] n = number.split(" ");
        int n1 = Integer.parseInt(n[0]);
        int n2 = Integer.parseInt(n[1]);
        if(n1<1||n2>500){
            return "NO";
        }else {
            if(n1%n2==0){
                return "YES";
            }
        }
        return "NO";
    }
}
