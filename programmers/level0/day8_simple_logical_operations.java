package level0;

public class day8_simple_logical_operations {
/*boolean 변수 x1, x2, x3, x4가 매개변수로 주어질 때, 다음의 식의 true/false를 return 하는 solution 함수를 작성해 주세요.
(x1 ∨ x2) ∧ (x3 ∨ x4)
입출력 예 #1
예제 1번의 x1, x2, x3, x4로 식을 계산하면 다음과 같습니다.
(x1 ∨ x2) ∧ (x3 ∨ x4) ≡ (F ∨ T) ∧ (T ∨ T) ≡ T ∧ T ≡ T
따라서 true를 return 합니다.

입출력 예 #2
예제 2번의 x1, x2, x3, x4로 식을 계산하면 다음과 같습니다.
(x1 ∨ x2) ∧ (x3 ∨ x4) ≡ (T ∨ F) ∧ (F ∨ F) ≡ T ∧ F ≡ F
따라서 false를 return 합니다.
*/
    // 1. 작성하신 풀이 (조건문으로 (x1 ∨ x2)와 (x3 ∨ x4)의 논리 관계를 직접 구현한 방식)
    static class SolutionMy {
        public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
            boolean answer = true;
            boolean a = true;
            boolean b = true;

            if (x1 == true) {
                a = x1;
            } else if (x2 == true) {
                a = x2;
            } else {
                a = false;
            }

            if (x3 == true) {
                b = x3;
            } else if (x4 == true) {
                b = x4;
            } else {
                b = false;
            }

            if (a == false) {
                answer = a;
            } else if (b == false) {
                answer = b;
            }

            return answer;
        }
    }

    // 2. 다른 사람의 풀이 (자바 논리 연산자 `||`, `&&` 활용 - 가장 직관적이고 간결함)
    static class SolutionLogical {
        public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
            // (x1 또는 x2) 그리고 (x3 또는 x4)
            boolean answer = (x1 || x2) && (x3 || x4);
            return answer;
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionLogical sol = new SolutionLogical();

        // 테스트 케이스 1: x1 = false, x2 = true, x3 = true, x4 = true -> 결과: true
        boolean res1 = sol.solution(false, true, true, true);
        System.out.println("테스트 1 결과: " + res1 + " (기대값: true)");

        // 테스트 케이스 2: x1 = true, x2 = false, x3 = false, x4 = false -> 결과: false
        boolean res2 = sol.solution(true, false, false, false);
        System.out.println("테스트 2 결과: " + res2 + " (기대값: false)");
    }
}