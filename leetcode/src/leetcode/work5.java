package leetcode;

import java.util.Scanner;

public class work5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String str2 = input.nextLine();
        System.out.println(demo(str + "\r\n" + str2));
    }
    static int demo(String str)
    {
        //请在这里完成代码
        return  str.length();
    }
}
