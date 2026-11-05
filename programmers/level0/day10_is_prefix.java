package level0;

public class day10_is_prefix {
/*접두사인지 확인하기
어떤 문자열에 대해서 접두사는 특정 인덱스까지의 문자열을 의미합니다. 예를 들어, "banana"의 모든 접두사는 "b", "ba", "ban", "bana", "banan", "banana"입니다.
문자열 my_string과 is_prefix가 주어질 때, is_prefix가 my_string의 접두사라면 1을, 아니면 0을 return 하는 solution 함수를 작성해 주세요.
my_string	is_prefix	result
"banana"	"ban"	1
"banana"	"nan"	0
"banana"	"abcd"	0
"banana"	"bananan"	0
*/
    // 1. 작성하신 풀이 (startsWith 활용 - 접두사 판별에 가장 최적화된 우수한 방식!)
    static class SolutionMy {
        public int solution(String my_string, String is_prefix) {
            int answer = 0;
            // contains를 쓰면 중간에 포함된 문자열("nan" 등)도 true가 되므로 startsWith가 정답입니다!
            if (my_string.startsWith(is_prefix)) {
                answer = 1;
            }
            return answer;
        }
    }

    // 2. 다른 사람의 풀이 (`indexOf` 활용 - 첫 등장 위치가 0인지 확인)
    static class SolutionIndexOf {
        public int solution(String my_string, String is_prefix) {
            int a = my_string.indexOf(is_prefix);
            return a == 0 ? 1 : 0;
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스 1: my_string = "banana", is_prefix = "ban" -> 결과: 1
        System.out.println("테스트 1 결과: " + sol.solution("banana", "ban") + " (기대값: 1)");

        // 테스트 케이스 2: my_string = "banana", is_prefix = "nan" -> 결과: 0
        System.out.println("테스트 2 결과: " + sol.solution("banana", "nan") + " (기대값: 0)");
    }
}