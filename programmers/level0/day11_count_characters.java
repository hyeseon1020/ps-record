package level0;

import java.util.Arrays;

public class day11_count_characters {

    // 1. 작성하신 풀이 (아스키코드 및 대소문자 판별을 이용한 가장 깔끔하고 효율적인 방식!)
    static class SolutionMy {
        public int[] solution(String my_string) {
            // 크기가 52인 정수 배열 선언 (자동으로 0으로 초기화됨)
            int[] answer = new int[52];

            for (char c : my_string.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    // 대문자는 0 ~ 25번 인덱스에 저장 ('A'는 0)
                    answer[c - 'A']++;
                } else if (c >= 'a' && c <= 'z') {
                    // 소문자는 26 ~ 51번 인덱스에 저장 ('a'는 26)
                    answer[c - 'a' + 26]++;
                }
            }
            return answer;
        }
    }

    // 2. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스: my_string = "Programmers"
        String my_string = "Programmers";

        int[] result = sol.solution(my_string);
        System.out.println("테스트 결과: " + Arrays.toString(result));
    }
}