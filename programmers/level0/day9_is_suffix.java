package level0;

public class day9_is_suffix {
/*접미사인지 확인하기

어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다. 예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
문자열 my_string과 is_suffix가 주어질 때, is_suffix가 my_string의 접미사라면 1을, 아니면 0을 return 하는 solution 함수를 작성해 주세요.
*/
    // 1. 작성하신 풀이 (모든 접미사를 구하며 비교 - 직관적이고 확실한 방식!)
    static class SolutionMy {
        public int solution(String my_string, String is_suffix) {
            String[] str = new String[my_string.length()];
            for (int i = 0; i < str.length; i++) {
                str[i] = my_string.substring(i);

                // 일치하는 접미사를 찾으면 즉시 1을 리턴
                if (str[i].equals(is_suffix)) {
                    return 1;
                }
            }
            // 반복문을 다 돌았는데도 일치하는 게 없다면 0 리턴
            return 0;
        }
    }

    // 2. 다른 사람의 풀이 (`endsWith` 활용 - 가장 간결하고 우아한 방식)
    static class SolutionEndsWith {
        public int solution(String my_string, String is_suffix) {
            // my_string이 is_suffix로 끝나면 true(1), 아니면 false(0) 반환
            return my_string.endsWith(is_suffix) ? 1 : 0;
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스 1: my_string = "banana", is_suffix = "ana" -> 결과: 1
        String my_string1 = "banana";
        String is_suffix1 = "ana";
        System.out.println("테스트 1 결과: " + sol.solution(my_string1, is_suffix1) + " (기대값: 1)");

        // 테스트 케이스 2: my_string = "banana", is_suffix = "nan" -> 결과: 0
        String my_string2 = "banana";
        String is_suffix2 = "nan";
        System.out.println("테스트 2 결과: " + sol.solution(my_string2, is_suffix2) + " (기대값: 0)");
    }
}