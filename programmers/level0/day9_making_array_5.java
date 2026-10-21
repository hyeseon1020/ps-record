package level0;

import java.util.ArrayList;
import java.util.Arrays;

public class day9_making_array_5 {
/*문자열 배열 intStrs와 정수 k, s, l가 주어집니다. intStrs의 원소는 숫자로 이루어져 있습니다.
배열 intStrs의 각 원소마다 s번 인덱스에서 시작하는 길이 l짜리 부분 문자열을 잘라내 정수로 변환합니다. 이때 변환한 정수값이 k보다 큰 값들을 담은 배열을 return 하는 solution 함수를 완성해 주세요.
intStrs	k	s	l	result
["0123456789","9876543210","9999999999999"]	50000	5	5	[56789, 99999]
*/
    // 1. 작성하신 풀이 (for문 + substring + Integer.parseInt - 직관적이고 훌륭한 방식!)
    static class SolutionMy {
        public int[] solution(String[] intStrs, int k, int s, int l) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < intStrs.length; i++) {
                // 1. substring으로 s번 인덱스부터 길이 l만큼 자르기 (끝 인덱스: s + l)
                // 2. Integer.parseInt로 정수로 변환하기
                int slicedNum = Integer.parseInt(intStrs[i].substring(s, s + l));

                // 3. 변환한 값이 k보다 클 때만 추가
                if (slicedNum > k) {
                    list.add(slicedNum);
                }
            }

            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    // 2. 다른 사람의 풀이 (향상된 for문 활용)
    static class SolutionForEach {
        public int[] solution(String[] intStrs, int k, int s, int l) {
            ArrayList<Integer> list = new ArrayList<>();

            for (String myStr : intStrs) {
                int num = Integer.parseInt(myStr.substring(s, s + l));
                if (k < num) {
                    list.add(num);
                }
            }

            return list.stream().mapToInt(i -> i).toArray();
        }
    }

    // 3. 다른 사람의 풀이 (자바 스트림 활용 - 한 줄로 표현하는 모던 자바 스타일)
    static class SolutionStream {
        public int[] solution(String[] intStrs, int k, int s, int l) {
            return Arrays.stream(intStrs)
                    .mapToInt(value -> Integer.parseInt(value.substring(s, s + l)))
                    .filter(value -> value > k)
                    .toArray();
        }
    }

    // 4. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스
        String[] intStrs = {"0123456789", "9876543210", "9999999999999"};
        int k = 50000;
        int s = 5;
        int l = 5;

        int[] result = sol.solution(intStrs, k, s, l);
        System.out.println("테스트 결과: " + Arrays.toString(result) + " (기대값: [56789, 99999])");
    }
}