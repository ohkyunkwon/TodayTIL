/**
 * reverse 메서드에서는 문자열을 char 배열로 변환한 후
 * 배열의 처음과 끝을 서로 교환하는 방식으로 문자열을 거꾸로 반환
 */

import java.util.Scanner;

public class ReverseString2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("문자열을 입력하세요: ");
        String inputString = scanner.nextLine();

        String reversedString = reverse(inputString);

        System.out.println("입력한 문자열의 역순: " + reversedString);

        scanner.close();
    }

    // 문자열을 거꾸로 만들어 반환하는 메서드
    public static String reverse(String str) {
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            // 문자를 서로 교환
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;

            // 다음으로 이동
            start++;
            end--;
        }

        // char 배열을 다시 문자열로 변환
        return new String(charArray);
    }
}