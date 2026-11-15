package level0;

public class day10_qr_code {
/*qr code

두 정수 q, r과 문자열 code가 주어질 때, code의 각 인덱스를 q로 나누었을 때 나머지가 r인 위치의 문자를 앞에서부터 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.*/
    // 1. 작성하신 풀이 (모든 인덱스를 순회하며 나머지가 r인 경우 추출 - 직관적이고 확실한 방식!)
    static class SolutionMy {
        public String solution(int q, int r, String code) {
            String answer = "";
            for (int i = 0; i < code.length(); i++) {
                if (i % q == r) {
                    answer += code.charAt(i);
                }
            }
            return answer;
        }
    }

    // 2. 다른 사람의 풀이 (r에서 시작해 q씩 증가하며 StringBuilder에 추가 - 성능 최적화)
    static class SolutionJump {
        public String solution(int q, int r, String code) {
            StringBuilder sb = new StringBuilder();
            for (int i = r; i < code.length(); i += q) {
                sb.append(code.charAt(i));
            }
            return sb.toString();
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스 1: q = 3, r = 1, code = "qjnwezgrpirldywt" -> 결과: "jerry"
        int q1 = 3;
        int r1 = 1;
        String code1 = "qjnwezgrpirldywt";
        System.out.println("테스트 1 결과: " + sol.solution(q1, r1, code1) + " (기대값: jerry)");

        // 테스트 케이스 2: q = 1, r = 0, code = "programmers" -> 결과: "programmers"
        int q2 = 1;
        int r2 = 0;
        String code2 = "programmers";
        System.out.println("테스트 2 결과: " + sol.solution(q2, r2, code2) + " (기대값: programmers)");
    }
}