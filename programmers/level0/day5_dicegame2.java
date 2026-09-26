package level0;

public class day5_dicegame2 {
    /*주사위 게임 2
    1부터 6까지 숫자가 적힌 주사위가 세 개 있습니다. 세 주사위를 굴렸을 때 나온 숫자를 각각 a, b, c라고 했을 때 얻는 점수는 다음과 같습니다.

    세 숫자가 모두 다르다면 a + b + c 점을 얻습니다.
    세 숫자 중 어느 두 숫자는 같고 나머지 다른 숫자는 다르다면 (a + b + c) × (a2 + b2 + c2 )점을 얻습니다.
    세 숫자가 모두 같다면 (a + b + c) × (a2 + b2 + c2 ) × (a3 + b3 + c3 )점을 얻습니다.
    세 정수 a, b, c가 매개변수로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.
    */
    // 1. 작성하신 풀이 (Math.pow 활용 - 형변환 처리)
    static class SolutionMy {
        public int solution(int a, int b, int c) {
            int answer = 0;
            if (a == b && b == c) {
                answer = (int) ((a + b + c) * (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)) * (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3)));
            } else if (a == b || b == c || a == c) {
                answer = (int) ((a + b + c) * (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)));
            } else {
                answer = a + b + c;
            }
            return answer;
        }
    }

    // 2. 다른 사람의 풀이 - 단순 곱셈 연산 활용 (Math.pow 및 형변환 없이 깔끔한 방식)
    static class SolutionSimple {
        public int solution(int a, int b, int c) {
            int answer = a + b + c;

            if (a == b && b == c) {
                answer = answer * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
            } else if (a == b || a == c || b == c) {
                answer = answer * (a * a + b * b + c * c);
            }

            return answer;
        }
    }

    // 3. 다른 사람의 풀이 - 반복문 및 거듭제곱 함수 활용
    static class SolutionLoop {
        public int solution(int a, int b, int c) {
            int answer = 1;
            int count = 1;

            if (a == b || a == c || b == c) {
                count++;
            }
            if (a == b && b == c) {
                count++;
            }

            for (int i = 1; i <= count; i++) {
                answer *= (pow(a, i) + pow(b, i) + pow(c, i));
            }

            return answer;
        }

        private int pow(int base, int exp) {
            if (exp == 0) return 1;
            return base * pow(base, exp - 1);
        }
    }

    // 4. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스 1: 세 숫자가 모두 다른 경우 (a = 2, b = 6, c = 1) -> 결과: 9
        int res1 = sol.solution(2, 6, 1);
        System.out.println("테스트 1 결과: " + res1 + " (기대값: 9)");

        // 테스트 케이스 2: 두 숫자가 같은 경우 (a = 5, b = 3, c = 3) -> 결과: 473
        int res2 = sol.solution(5, 3, 3);
        System.out.println("테스트 2 결과: " + res2 + " (기대값: 473)");

        // 테스트 케이스 3: 세 숫자가 모두 같은 경우 (a = 4, b = 4, c = 4) -> 결과: 110592
        int res3 = sol.solution(4, 4, 4);
        System.out.println("테스트 3 결과: " + res3 + " (기대값: 110592)");
    }
}
