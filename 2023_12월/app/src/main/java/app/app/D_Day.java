package app.app;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class D_Day {

    public static void main(String[] args) {
        // D-Day 설정 (YYYY, MM, DD 형식)
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("D-Day를 입력하세요 (YYYY-MM-DD) : ");
            String dDayString = sc.nextLine();

            // 문자열로 입력받은 D-Day를 LocalDate로 변환
            LocalDate dDay = LocalDate.parse(dDayString);

            // 현재 날짜와 시간 가져오기
            LocalDateTime now = LocalDateTime.now();

            // D-Day까지 남은 시간 계산
            Duration duration = Duration.between(now, dDay.atStartOfDay());
            long days = now.until(dDay.atStartOfDay(), ChronoUnit.DAYS);
            long hours = now.until(dDay.atStartOfDay(), ChronoUnit.HOURS);
            long minutes = now.until(dDay.atStartOfDay(), ChronoUnit.MINUTES);
            long seconds = now.until(dDay.atStartOfDay(), ChronoUnit.SECONDS);

            // 주중과 주말에 대한 공부 시간 계산
            long 주중 = countWeekdays(now.toLocalDate(), dDay);
            long 주말 = days - 주중;
            long 총공부시간 = 주중 * 4 + 주말 * 6;

            // D-Day 및 공부 시간 출력
            System.out.println("D-Day까지 남은 일수: " + days + "일");
            System.out.println("D-Day까지 남은 시간: " + hours + "시간");
            System.out.println("D-Day까지 남은 분: " + minutes + "분");
            System.out.println("D-Day까지 남은 초: " + seconds + "초");
            System.out.println("평일 공부 시간: " + 주중 * 4 + "시간");
            System.out.println("주말 공부 시간: " + 주말 * 6 + "시간");
            System.out.println("총 공부 시간: " + 총공부시간 + "시간");

        } catch (DateTimeParseException e) {
            System.out.println("잘못된 날짜 형식입니다. YYYY-MM-DD 형식으로 입력하세요.");
        }
    }

    private static long countWeekdays(LocalDate startDate, LocalDate endDate) {
        long 주중 = 0;
        LocalDate date = startDate;

        while (!date.isAfter(endDate)) {
            if (date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY) {
                주중++;
            }
            date = date.plusDays(1);
        }

        return 주중;
    }
}