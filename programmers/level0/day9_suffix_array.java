package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class day9_suffix_array {
/* 접미사 배열
어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다. 예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
문자열 my_string이 매개변수로 주어질 때, my_string의 모든 접미사를 사전순으로 정렬한 문자열 배열을 return 하는 solution 함수를 작성해 주세요.
*/
    // 1. 작성하신 풀이 (ArrayList와 substring, Collections.sort 활용 - 매우 직관적이고 안정적인 방식!)
    static class SolutionMy {
        public String[] solution(String my_string) {
            ArrayList<String> list = new ArrayList<>();

            // 1. 모든 접미사를 리스트에 담기
            for (int i = 0; i < my_string.length(); i++) {
                list.add(my_string.substring(i));
            }

            // 2. 사전순(오름차순)으로 정렬하기
            Collections.sort(list);

            return list.toArray(new String[0]);
        }
    }

    // 2. 다른 사람의 풀이 (고정 크기 배열 + Arrays.sort 활용)
    static class SolutionArray {
        public String[] solution(String my_string) {
            String[] answer = new String[my_string.length()];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = my_string.substring(i);
            }

            Arrays.sort(answer);
            return answer;
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스: my_string = "banana" -> 기대값: [a, ana, anana, banana, na, nana]
        String my_string = "banana";

        String[] result = sol.solution(my_string);
        System.out.println("테스트 결과: " + Arrays.toString(result));
    }
}