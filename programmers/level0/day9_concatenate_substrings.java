package level0;

public class day9_concatenate_substrings {
/* 부분 문자열 이어 붙여 문자열 만들기
* 길이가 같은 문자열 배열 my_strings와 이차원 정수 배열 parts가 매개변수로 주어집니다. parts[i]는 [s, e] 형태로, my_string[i]의 인덱스 s부터 인덱스 e까지의 부분 문자열을 의미합니다. 각 my_strings의 원소의 parts에 해당하는 부분 문자열을 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.
my_strings	parts	result
["progressive", "hamburger", "hammer", "ahocorasick"]	[[0, 4], [1, 2], [3, 5], [7, 7]]	"programmers"

* */
    // 1. 작성하신 풀이 (StringBuilder와 substring 활용 - 성능과 가독성 모두 잡은 훌륭한 방식!)
    static class SolutionMy {
        public String solution(String[] my_strings, int[][] parts) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < my_strings.length; i++) {
                int start = parts[i][0];
                int end = parts[i][1];
                sb.append(my_strings[i].substring(start, end + 1));
            }

            return sb.toString();
        }
    }

    // 2. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스
        String[] my_strings = {"progressive", "hamburger", "hammer", "ahocorasick"};
        int[][] parts = {
                {0, 4},
                {1, 2},
                {3, 5},
                {7, 7}
        };

        String result = sol.solution(my_strings, parts);
        System.out.println("테스트 결과: " + result + " (기대값: programmers)");
    }
}