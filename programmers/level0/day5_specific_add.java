package level0;

import java.util.stream.IntStream;

public class day5_specific_add {
/* 등차수열의 특정한 항만 더하기
두 정수 a, d와 길이가 n인 boolean 배열 included가 주어집니다. 첫째항이 a, 공차가 d인 등차수열에서 included[i]가 i + 1항을 의미할 때, 이 등차수열의 1항부터 n항까지 included가 true인 항들만 더한 값을 return 하는 solution 함수를 작성해 주세요.
*/
    // 1. 프로그래머스에 제출할 Solution 클래스
    static class Solution {

        // 방법 A: 작성하신 반복문(for문) 방식
        public int solution(int a, int d, boolean[] included) {
            int answer = 0;
            for (int i = 0; i < included.length; i++) {
                if (included[i]) { // boolean 값이라 == true 생략 가능
                    answer += a + (i * d);
                }
            }
            return answer;
        }

        // 방법 B: 다른 사람의 풀이 (IntStream 방식)
        public int solutionStream(int a, int d, boolean[] included) {
            return IntStream.range(0, included.length)
                    .map(idx -> included[idx] ? a + (idx * d) : 0)
                    .sum();
        }
    }

    // 2. IntelliJ에서 실행하고 테스트하기 위한 main 메서드
    public static void main(String[] args) {
        Solution sol = new Solution();

        // [테스트 케이스 1] 예시 데이터
        int a1 = 3;
        int d1 = 4;
        boolean[] included1 = {true, false, false, true, true};
        // 기대되는 결과: 3 + 15 + 19 = 37

        int result1 = sol.solution(a1, d1, included1);
        System.out.println("테스트 1 결과: " + result1 + " (기대값: 37)");

        // [테스트 케이스 2] 예시 데이터
        int a2 = 7;
        int d2 = 1;
        boolean[] included2 = {false, false, false, true, false, false, true};
        // 기대되는 결과: 10 + 13 = 23

        int result2 = sol.solution(a2, d2, included2);
        System.out.println("테스트 2 결과: " + result2 + " (기대값: 23)");
    }
}