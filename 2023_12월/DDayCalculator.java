/**
 * d-day 계산기
 *
 * 1. D-Day 날짜 입력 받기
 * 2. 현재 날짜 받아오기
 * 3. D-Day 에서 현재 날짜 계산하기
 * 4. D-Day 출력
 *
 */

public class DDayCalculator {
    public static void main(String[] args){
        // D-Day 설정 (YYYY, MM, DD 형식)
        LocalDate dDay = LocalDate.of(2024, 03, 31);

        // 현재 날짜 받아오기
        LocalDate today = LocalDate.now();

        // D-Day까지의 날짜 계산
        Period period = Period.between(today, dDay);

        // D-Day 출력
        System.out.println("D-Day까지 남은 일수: " + period.getDays() + "일");

    }
}