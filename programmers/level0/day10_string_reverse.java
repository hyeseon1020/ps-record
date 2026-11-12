package level0;

public class day10_string_reverse {
/***문자열뒤집기**

 문자열 my\_string과 정수 s, e가 매개변수로 주어질 때, my\_string에서 인덱스 s부터 인덱스 e까지를 뒤집은 문자열을 return 하는 solution 함수를 작성해 주세요.

 my\_string	s	e	result

 "Progra21Sremm3"	6	12	"ProgrammerS123"

 "Stanley1yelnatS"	4	10	"Stanley1yelnatS"*/
    // 1. 작성하신 풀이 (StringBuilder의 substring, reverse, replace 활용 - 매우 안정적이고 직관적인 방식!)
    static class SolutionMy {
        public String solution(String my_string, int s, int e) {
            // StringBuilder 객체를 생성하여 특정 구간을 쉽게 다루도록 함
            StringBuilder sb = new StringBuilder(my_string);
            String sub = sb.substring(s, e + 1);

            // reverse() 이용하여 문자열 뒤집기
            String reversed = new StringBuilder(sub).reverse().toString();

            // replace() 이용하여 치환하기
            sb.replace(s, e + 1, reversed);
            return sb.toString();
        }
    }

    // 2. 다른 사람의 풀이 (앞, 뒤 잘라내기와 reverse 결합 방식)
    static class SolutionSubstring {
        public String solution(String my_string, int s, int e) {
            StringBuilder answer = new StringBuilder(my_string.substring(s, e + 1));
            answer.reverse();
            return my_string.substring(0, s) + answer + my_string.substring(e + 1);
        }
    }

    // 3. 다른 사람의 풀이 (char 배열과 투 포인터를 이용한 Swap 방식 - 메모리 및 속도 최적화)
    static class SolutionArray {
        public String solution(String my_string, int s, int e) {
            char[] arr = my_string.toCharArray();
            while (s < e) {
                char temp = arr[s];
                arr[s++] = arr[e];
                arr[e--] = temp;
            }
            return new String(arr);
        }
    }

    // 4. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스 1: my_string = "Progra21Sremm3", s = 6, e = 12 -> 결과: "ProgrammerS123"
        String my_string = "Progra21Sremm3";
        int s = 6;
        int e = 12;

        String result = sol.solution(my_string, s, e);
        System.out.println("테스트 결과: " + result + " (기대값: ProgrammerS123)");
    }
}