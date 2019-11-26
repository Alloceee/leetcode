package leetcode;

import java.util.Scanner;

/**
 * 计算字符串长度
 */
public class work4 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println(str_len(str));
    }
    static int str_len(String str)
    {
        //请在这里完成代码
        return  str.length();
    }
}
