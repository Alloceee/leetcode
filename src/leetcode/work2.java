package leetcode;

import java.util.Scanner;

public class work2 {
    public static void main(String[] args) {
        System.out.println(zhishuNumber(12));
    }

    public static int zhishuNumber(int n) {
        if (n <= 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                if (n % j == 0) {
                    break;
                }
                sum += 1;
            }
        }
        return sum;
    }

    /**
     * 返回单词出现的第一次位置
     *
     * @return
     */
    public static int indexWord() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String data[] = s.split("!");
        byte[] b1 = data[0].getBytes();
        byte[] b2 = data[1].getBytes();
        for (int i = 0; i < b2.length; i++) {
            for (int j = 0; j < b1.length; j++) {
                if (b1[j] == b2[i]) {
                    continue;
                }
            }
        }
        return 0;
    }
}
