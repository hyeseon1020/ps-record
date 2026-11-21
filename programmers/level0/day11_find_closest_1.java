package level0;

public class day11_find_closest_1 {
/*가까운1찾기
정수 배열 arr가 주어집니다. 이때 arr의 원소는 1 또는 0입니다. 정수 idx가 주어졌을 때, idx보다 크거나 같으면서 배열의 값이 1인 가장 작은 인덱스를 찾아서 반환하는 solution 함수를 완성해 주세요.
단, 만약 그러한 인덱스가 없다면 -1을 반환합니다.

arr idx result
[0, 0, 0, 1] 1 3
[1, 0, 0, 1, 0, 0] 4 -1
[1, 1, 1, 1, 0] 3 3*/
    // 1. 작성하신 풀이 (시작 인덱스 idx부터 탐색해 가장 먼저 만나는 1의 인덱스를 즉시 반환 - 가장 깔끔한 정석 풀이!)
    static class SolutionMy {
        public int solution(int[] arr, int idx) {
            for (int i = idx; i < arr.length; i++) {
                if (arr[i] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    // 2. 다른 사람의 풀이 (루프 종료 후 인덱스 경계값과 삼항 연산자로 판별)
    static class SolutionBreak {
        public int solution(int[] arr, int idx) {
            for (; idx < arr.length; idx++) {
                if (arr[idx] == 1) {
                    break;
                }
            }
            return idx == arr.length ? -1 : idx;
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스 1: arr = [0, 0, 0, 1], idx = 1 -> 결과: 3
        System.out.println("테스트 1 결과: " + sol.solution(new int[]{0, 0, 0, 1}, 1) + " (기대값: 3)");

        // 테스트 케이스 2: arr = [1, 0, 0, 1, 0, 0], idx = 4 -> 결과: -1
        System.out.println("테스트 2 결과: " + sol.solution(new int[]{1, 0, 0, 1, 0, 0}, 4) + " (기대값: -1)");

        // 테스트 케이스 3: arr = [1, 1, 1, 1, 0], idx = 3 -> 결과: 3
        System.out.println("테스트 3 결과: " + sol.solution(new int[]{1, 1, 1, 1, 0}, 3) + " (기대값: 3)");
    }
}