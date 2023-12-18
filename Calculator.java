import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = scanner.nextInt();

        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = scanner.nextInt();

        int sum = add(num1, num2);
        int sum2  = multiply(num1, num2);

        System.out.println("덧셈 결과: " + sum);
        System.out.println("곱셈 결과: " + sum2);

        scanner.close();
    }

    // 덧셈을 수행하는 메서드
    public static int add(int a, int b) {
        return a + b;
    }

    // 곱셈을 수행하는 메서드
    public static int multiply(int a, int b) {
        return a * b;
    }
}
