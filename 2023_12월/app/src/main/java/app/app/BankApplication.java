import java.util.Scanner;

/**
 * 은행 계좌 관리 프로그램
 * 1. 사용자로부터 계좌번호, 예금주, 잔액을 입력받음
 * 2. 입금 출금 조회 종료 하기
 */
public class BankApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("계좌번호를 입력하세요: ");
        String accountNumber = scanner.nextLine();

        System.out.print("예금주를 입력하세요: ");
        String accountHolder = scanner.nextLine();

        System.out.print("초기 잔액을 입력하세요: ");
        double initialBalance = scanner.nextDouble();

    }
}