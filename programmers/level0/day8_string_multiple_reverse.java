package level0;

public class day8_string_multiple_reverse {
/*문자열 my_string과 이차원 정수 배열 queries가 매개변수로 주어집니다. queries의 원소는 [s, e] 형태로, my_string의 인덱스 s부터 인덱스 e까지를 뒤집으라는 의미입니다.
my_string에 queries의 명령을 순서대로 처리한 후의 문자열을 return 하는 solution 함수를 작성해 주세요.*/
    // 1. 작성하신 풀이 (StringBuilder의 substring, reverse, replace 활용 - 직관적이고 깔끔함)
    static class SolutionMy {
        public String solution(String my_string, int[][] queries) {
            // 문자열 조작을 위해 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder(my_string);

            for (int i = 0; i < queries.length; i++) {
                int s = queries[i][0];
                int e = queries[i][1];

                // 1. s부터 e까지의 부분 문자열을 가져옴
                String sub = sb.substring(s, e + 1);

                // 2. 그 부분 문자열을 뒤집음 (StringBuilder의 reverse 활용)
                String reversed = new StringBuilder(sub).reverse().toString();

                // 3. 원래 위치(s부터 e까지)에 뒤집은 문자열을 덮어씌움
                sb.replace(s, e + 1, reversed);
            }

            return sb.toString();
        }
    }

    // 2. 다른 사람의 풀이 (char 배열과 투 포인터를 이용한 Swap 방식 - 메모리 및 속도 최적화)
    static class SolutionArray {
        char[] arr;

        public String solution(String my_string, int[][] queries) {
            arr = my_string.toCharArray();

            for (int[] query : queries) {
                reverse(query[0], query[1]);
            }

            return new String(arr);
        }

        private void reverse(int s, int e) {
            while (s < e) {
                char temp = arr[s];
                arr[s++] = arr[e];
                arr[e--] = temp;
            }
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스: my_string = "rermgorpsamg", queries = [[2, 3], [0, 7], [5, 9], [6, 10]]
        String my_string = "rermgorpsamg";
        int[][] queries = {
                {2, 3},
                {0, 7},
                {5, 9},
                {6, 10}
        };

        String result = sol.solution(my_string, queries);
        System.out.println("테스트 결과: " + result + " (기대값: programmers)");
    }
}