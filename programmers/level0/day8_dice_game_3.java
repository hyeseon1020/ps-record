package level0;

import java.util.Arrays;

public class day8_dice_game_3 {
/*1부터 6까지 숫자가 적힌 주사위가 네 개 있습니다. 네 주사위를 굴렸을 때 나온 숫자에 따라 다음과 같은 점수를 얻습니다.

네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점을 얻습니다.
세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.
주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.
어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서 나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.
네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중 가장 작은 숫자 만큼의 점수를 얻습니다.
네 주사위를 굴렸을 때 나온 숫자가 정수 매개변수 a, b, c, d로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.
*/
    // 1. 작성하신 풀이 (오름차순 정렬을 활용한 가장 직관적이고 깔끔한 방식!)
    static class SolutionMy {
        public int solution(int a, int b, int c, int d) {
            int[] dice = {a, b, c, d};
            Arrays.sort(dice); // 오름차순 정렬

            // 1. 모두 같은 경우 (dice[0] == dice[3])
            if (dice[0] == dice[3]) {
                return 1111 * dice[0];
            }

            // 2. 3개가 같고 1개가 다른 경우
            // 정렬했으므로 [0,1,2]가 같거나 [1,2,3]이 같음
            if (dice[0] == dice[2] || dice[1] == dice[3]) {
                int p = dice[1]; // 3개가 같은 숫자는 무조건 가운데(dice[1])에 위치합니다.
                int q = (dice[0] == dice[2]) ? dice[3] : dice[0];
                return (10 * p + q) * (10 * p + q);
            }

            // 3. 2개씩 같은 값이 나오는 경우 (p, p, q, q)
            if (dice[0] == dice[1] && dice[2] == dice[3]) {
                int p = dice[0];
                int q = dice[2];
                return (p + q) * Math.abs(p - q);
            }

            // 4. 2개는 같고, 나머지 2개는 각각 다른 경우 (p, p, q, r)
            if (dice[0] == dice[1]) {
                return dice[2] * dice[3];
            } else if (dice[1] == dice[2]) {
                return dice[0] * dice[3];
            } else if (dice[2] == dice[3]) {
                return dice[0] * dice[1];
            }

            // 5. 모두 다른 경우
            return dice[0]; // 가장 작은 숫자가 첫 번째에 위치함
        }
    }

    // 2. 다른 사람의 풀이 (조건문 분기 및 헬퍼 메서드 활용)
    static class SolutionMethod {
        public int solution(int a, int b, int c, int d) {
            if (a == b && b == c && c == d) {
                return 1111 * a;
            }
            if (a == b && b == c) return triple(a, d);
            if (a == b && b == d) return triple(a, c);
            if (b == c && c == d) return triple(b, a);
            if (a == c && c == d) return triple(a, b);

            if (a == b && c == d) return double1(a, c);
            if (a == c && b == d) return double1(a, b);
            if (a == d && b == c) return double1(a, b);

            if (a == b) return double2(c, d);
            if (a == c) return double2(b, d);
            if (a == d) return double2(b, c);
            if (b == c) return double2(a, d);
            if (b == d) return double2(a, c);
            if (c == d) return double2(a, b);

            return Math.min(Math.min(a, b), Math.min(c, d));
        }

        private int double2(int q, int r) {
            return q * r;
        }

        private int double1(int p, int q) {
            return (p + q) * Math.abs(p - q);
        }

        private int triple(int p, int q) {
            return (10 * p + q) * (10 * p + q);
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스: a = 2, b = 2, c = 2, d = 3 -> 3개가 같고 1개가 다른 경우
        int result = sol.solution(2, 2, 2, 3);
        System.out.println("테스트 결과: " + result + " (기대값: 529 -> (10*2+3)^2 = 23^2 = 529)");
    }
}