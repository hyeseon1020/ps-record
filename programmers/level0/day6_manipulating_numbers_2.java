package level0;

public class day6_manipulating_numbers_2 {
/*정수 배열 numLog가 주어집니다. 처음에 numLog[0]에서 부터 시작해 "w", "a", "s", "d"로 이루어진 문자열을 입력으로 받아 순서대로 다음과 같은 조작을 했다고 합시다.

"w" : 수에 1을 더한다.
"s" : 수에 1을 뺀다.
"d" : 수에 10을 더한다.
"a" : 수에 10을 뺀다.
그리고 매번 조작을 할 때마다 결괏값을 기록한 정수 배열이 numLog입니다. 즉, numLog[i]는 numLog[0]로부터 총 i번의 조작을 가한 결과가 저장되어 있습니다.

주어진 정수 배열 numLog에 대해 조작을 위해 입력받은 문자열을 return 하는 solution 함수를 완성해 주세요.
*/
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