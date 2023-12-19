public class FindMaxValue {
    public static void main(String[] args) {
        // 정수 배열 생성
        int[] numbers = {23, 47, 55, 99, 89, 34, 76};

        // 최댓값 찾기
        int maxValue = findMax(numbers);

        // 결과 출력
        System.out.println("배열의 최댓값은 " + maxValue + "입니다.");
    }

    // 배열에서 최댓값을 찾는 메서드
    public static int findMax(int[] array) {

        int max = array[0]; // 초기값 설정

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i]; // 더 큰 값으로 업데이트
            }
        }

        return max;
    }
}
