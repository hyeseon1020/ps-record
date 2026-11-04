package level0;

public class day10_first_n_chars {
/* 문자열의 앞 n글자
문자열 my_string과 정수 n이 매개변수로 주어질 때, my_string의 앞의 n글자로 이루어진 문자열을 return 하는 solution 함수를 작성해 주세요.
my_string  			 n   	result
"ProgrammerS123"  	11  	"ProgrammerS"
"He110W0r1d" 		5	"He110"
*/
    // 1. 작성하신 풀이 (substring 활용 - 가장 간결하고 정확한 정석 풀이!)
    static class SolutionMy {
        public String solution(String my_string, int n) {
            String answer = my_string.substring(0, n);
            return answer;
        }
    }

    // 2. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스 1: my_string = "ProgrammerS123", n = 11 -> 결과: "ProgrammerS"
        String my_string1 = "ProgrammerS123";
        int n1 = 11;
        System.out.println("테스트 1 결과: " + sol.solution(my_string1, n1) + " (기대값: ProgrammerS)");

        // 테스트 케이스 2: my_string = "He110W0r1d", n = 5 -> 결과: "He110"
        String my_string2 = "He110W0r1d";
        int n2 = 5;
        System.out.println("테스트 2 결과: " + sol.solution(my_string2, n2) + " (기대값: He110)");
    }
}