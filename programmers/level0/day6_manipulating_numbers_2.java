package level0;

public class day6_manipulating_numbers_2 {

    // 1. 작성하신 풀이 (diff 차이값 + switch문)
    static class SolutionMy {
        public String solution(int[] numLog) {
            String answer = "";
            for (int i = 1; i < numLog.length; i++) {
                // 현재 값에서 이전 값을 빼서 변화량을 구함
                int diff = numLog[i] - numLog[i - 1];
                switch (diff) {
                    case 1: answer += "w"; break;
                    case -1: answer += "s"; break;
                    case 10: answer += "d"; break;
                    case -10: answer += "a"; break;
                    default: break;
                }
            }
            return answer;
        }
    }

    // 2. 성능 최적화 풀이 (StringBuilder 활용 - 추천!)
    static class SolutionStringBuilder {
        public String solution(int[] numLog) {
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < numLog.length; i++) {
                int diff = numLog[i] - numLog[i - 1];
                switch (diff) {
                    case 1 -> sb.append('w');
                    case -1 -> sb.append('s');
                    case 10 -> sb.append('d');
                    case -10 -> sb.append('a');
                }
            }

            return sb.toString();
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스: [0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1] -> 결과: "wsdaddawsdsa"
        int[] numLog = {0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1};
        String res = sol.solution(numLog);
        System.out.println("테스트 결과: " + res + " (기대값: wsdaddawsdsa)");
    }
}