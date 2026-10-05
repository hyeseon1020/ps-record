package level0;

public class day6_manipulating_numbers_1 {
/*정수 n과 문자열 control이 주어집니다. control은 "w", "a", "s", "d"의 4개의 문자로 이루어져 있으며, control의 앞에서부터 순서대로 문자에 따라 n의 값을 바꿉니다.

"w" : n이 1 커집니다.
"s" : n이 1 작아집니다.
"d" : n이 10 커집니다.
"a" : n이 10 작아집니다.
위 규칙에 따라 n을 바꿨을 때 가장 마지막에 나오는 n의 값을 return 하는 solution 함수를 완성해 주세요.
*/
    // 1. 작성하신 풀이 (switch문 활용)
    static class SolutionMy {
        public int solution(int n, String control) {
            for (int i = 0; i < control.length(); i++) {
                switch (control.charAt(i)) {
                    case 'w':
                        n += 1;
                        break;
                    case 's':
                        n -= 1;
                        break;
                    case 'd':
                        n += 10;
                        break;
                    case 'a':
                        n -= 10;
                        break;
                    default:
                        break;
                }
            }
            return n;
        }
    }

    // 2. 다른 사람의 풀이 1 (toCharArray + switch)
    static class SolutionCharArray {
        public int solution(int n, String control) {
            int answer = n;
            for (char ch : control.toCharArray()) {
                switch (ch) {
                    case 'w': answer += 1; break;
                    case 's': answer -= 1; break;
                    case 'd': answer += 10; break;
                    case 'a': answer -= 10; break;
                    default: break;
                }
            }
            return answer;
        }
    }

    // 3. 다른 사람의 풀이 2 (삼항 연산자 중첩)
    static class SolutionTernary {
        public int solution(int n, String control) {
            for (char c : control.toCharArray()) {
                n += c == 'w' ? 1 : c == 's' ? -1 : c == 'd' ? 10 : -10;
            }
            return n;
        }
    }

    // 4. 모던 자바 방식 (Java 12+ Switch Expression - 깔끔해서 많이 쓰는 방식)
    static class SolutionModern {
        public int solution(int n, String control) {
            for (char c : control.toCharArray()) {
                n += switch (c) {
                    case 'w' -> 1;
                    case 's' -> -1;
                    case 'd' -> 10;
                    case 'a' -> -10;
                    default -> 0;
                };
            }
            return n;
        }
    }

    // 5. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스 1: n = 0, control = "wsdadda" -> 결과: -1
        int res1 = sol.solution(0, "wsdadda");
        System.out.println("테스트 1 결과: " + res1 + " (기대값: -1)");
    }
}