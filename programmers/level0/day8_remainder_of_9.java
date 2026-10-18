package level0;

public class day8_remainder_of_9 {
/*음이 아닌 정수를 9로 나눈 나머지는 그 정수의 각 자리 숫자의 합을 9로 나눈 나머지와 같은 것이 알려져 있습니다.
이 사실을 이용하여 음이 아닌 정수가 문자열 number로 주어질 때, 이 정수를 9로 나눈 나머지를 return 하는 solution 함수를 작성해주세요.

예제 1번의 number는 123으로 각 자리 숫자의 합은 6입니다. 6을 9로 나눈 나머지는 6이고, 실제로 123 = 9 × 13 + 6입니다. 따라서 6을 return 합니다.
예제 2번의 number는 78720646226947352489으로 각자리 숫자의 합은 101입니다. 101을 9로 나눈 나머지는 2이고, 실제로 78720646226947352489 = 9 × 8746738469660816943 + 2입니다. 따라서 2를 return 합니다.
*/
    // 1. 작성하신 풀이 (for문을 통한 각 자리 문자 합산 후 % 9 연산 - 매우 직관적이고 정확한 방식!)
    static class SolutionMy {
        public int solution(String number) {
            int sum = 0;

            for (int i = 0; i < number.length(); i++) {
                sum += number.charAt(i) - '0'; // 문자를 숫자로 변환 (예: '5' -> 5)
            }

            return sum % 9;
        }
    }

    // 2. 다른 사람의 풀이 (자바 Stream 활용 - 코드가 매우 간결함)
    static class SolutionStream {
        public int solution(String number) {
            return number.chars().map(c -> (c - '0') % 9).sum() % 9;
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스 1: number = "123" -> 결과: 6
        String num1 = "123";
        int res1 = sol.solution(num1);
        System.out.println("테스트 1 결과: " + res1 + " (기대값: 6)");

        // 테스트 케이스 2: number = "78720646226947352489" -> 결과: 2
        String num2 = "78720646226947352489";
        int res2 = sol.solution(num2);
        System.out.println("테스트 2 결과: " + res2 + " (기대값: 2)");
    }
}