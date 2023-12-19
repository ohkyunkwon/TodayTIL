public class FindMinValue {
    public static void main(String[] args) {
        // 정수 배열 생성
        int[] numbers = {23, 47, 55, 99, 89, 34, 76};

        // 최소값 찾기
        int minValue = findMin(numbers);

        // 결과 출력
        System.out.println("배열의 최소값은 " + minValue + "입니다.");
    }

    // 배열에서 최소값을 찾는 메서드
    public static int findMin(int[] array) {

        int min = array[0]; // 초기값 설정

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i]; // 더 작은 값으로 업데이트
            }
        }

        return min;
    }
}
