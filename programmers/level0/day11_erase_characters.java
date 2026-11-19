package level0;

import java.util.Arrays;

public class day11_erase_characters {
/*글자지우기

문자열 my_string과 정수 배열 indices가 주어질 때, my_string에서 indices의 원소에 해당하는 인덱스의 글자를 지우고 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.*/
    // 1. 작성하신 풀이 (정렬 후 불리언 체크를 통해 인덱스 문자를 제외하고 StringBuilder에 담는 방식)
    static class SolutionMy {
        public String solution(String my_string, int[] indices) {
            Arrays.sort(indices);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < my_string.length(); i++) {
                // 현재 인덱스 i가 indices에 포함되어 있는지 확인
                boolean remove = false;
                for (int idx : indices) {
                    if (idx == i) {
                        remove = true;
                        break;
                    }
                }
                // 포함되지 않은 경우에만 추가
                if (!remove) {
                    sb.append(my_string.charAt(i));
                }
            }
            return sb.toString();
        }
    }

    // 2. 다른 사람의 풀이 (StringBuilder와 setCharAt 및 replace를 활용한 직관적인 방식)
    static class SolutionReplace {
        public String solution(String my_string, int[] indices) {
            StringBuilder sb = new StringBuilder(my_string);
            for (int i : indices) {
                sb.setCharAt(i, ' '); // 지워야 할 위치를 공백으로 변경
            }
            return sb.toString().replace(" ", ""); // 공백 제거
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스: my_string = "apporoograpemmemprs", indices = [1, 16, 6, 15, 0, 10, 11, 3]
        String my_string = "apporoograpemmemprs";
        int[] indices = {1, 16, 6, 15, 0, 10, 11, 3};

        String result = sol.solution(my_string, indices);
        System.out.println("테스트 결과: " + result + " (기대값: programmers)");
    }
}