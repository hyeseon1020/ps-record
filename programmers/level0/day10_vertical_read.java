package level0;

public class day10_vertical_read {
/*세로읽기
문자열 my\_string과 두 정수 m, c가 주어집니다. my\_string을 한 줄에 m 글자씩 가로로 적었을 때 왼쪽부터 세로로 c번째 열에 적힌 글자들을 문자열로 return 하는 solution 함수를 작성해 주세요.

my\_string	m	c	result

"ihrhbakrfpndopljhygc"	4	2	"happy"

"programmers"	1	1	"programmers"*/
    // 1. 작성하신 풀이 (시작 인덱스와 m 간격 반복을 활용한 가장 직관적이고 깔끔한 방식!)
    static class SolutionMy {
        public String solution(String my_string, int m, int c) {
            String answer = "";

            // c - 1 번째 인덱스부터 시작해서 m씩 증가하며 문자열 길이 전까지 반복
            for (int i = c - 1; i < my_string.length(); i += m) {
                answer += my_string.charAt(i);
            }

            return answer;
        }
    }

    // 2. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스 1: my_string = "ihrhbakrfpndopljhygc", m = 4, c = 2 -> 결과: "happy"
        String my_string1 = "ihrhbakrfpndopljhygc";
        int m1 = 4;
        int c1 = 2;
        System.out.println("테스트 1 결과: " + sol.solution(my_string1, m1, c1) + " (기대값: happy)");

        // 테스트 케이스 2: my_string = "programmers", m = 1, c = 1 -> 결과: "programmers"
        String my_string2 = "programmers";
        int m2 = 1;
        int c2 = 1;
        System.out.println("테스트 2 결과: " + sol.solution(my_string2, m2, c2) + " (기대값: programmers)");
    }
}