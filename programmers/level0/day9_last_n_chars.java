package level0;

public class day9_last_n_chars {
    /*문자열의 뒤의 n글자
        문자열 my_string과 정수 n이 매개변수로 주어질 때, my_string의 뒤의 n글자로 이루어진 문자열을 return 하는 solution 함수를 작성해 주세요.
    */
    // 1. 작성하신 풀이 (substring 활용 - 가장 간결하고 직관적인 정석 풀이!)
    static class SolutionMy {
        public String solution(String my_string, int n) {
            return my_string.substring(my_string.length() - n);
        }
    }

    // 2. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스 1: my_string = "ProgrammerS123", n = 11 -> 결과: "grammerS123"
        String my_string = "ProgrammerS123";
        int n = 11;

        String result = sol.solution(my_string, n);
        System.out.println("테스트 결과: " + result + " (기대값: grammerS123)");
    }
}