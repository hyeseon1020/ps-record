package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class day7_making_array_4 {
/*
* 배열 만들기 4

정수 배열 arr가 주어집니다. arr를 이용해 새로운 배열 stk를 만드려고 합니다.

변수 i를 만들어 초기값을 0으로 설정한 후 i가 arr의 길이보다 작으면 다음 작업을 반복합니다.

만약 stk가 빈 배열이라면 arr[i]를 stk에 추가하고 i에 1을 더합니다.

stk에 원소가 있고, stk의 마지막 원소가 arr[i]보다 작으면 arr[i]를 stk의 뒤에 추가하고 i에 1을 더합니다.

stk에 원소가 있는데 stk의 마지막 원소가 arr[i]보다 크거나 같으면 stk의 마지막 원소를 stk에서 제거합니다.

위 작업을 마친 후 만들어진 stk를 return 하는 solution 함수를 완성해 주세요.

따라서 [1, 2, 3]을 return 합니다.
* */
    // 1. 작성하신 풀이 (ArrayList + while문 - 조건 분기가 명확하여 가독성이 뛰어남)
    static class SolutionMy {
        public int[] solution(int[] arr) {
            ArrayList<Integer> list = new ArrayList<>();
            int i = 0;

            // i가 arr의 길이보다 작을 때만 반복
            // (참고 주석으로 남겨주신 "원소 제거 시 i를 증가시키지 않는다"는 규칙을 while문으로 훌륭하게 해결하셨습니다!)
            while (i < arr.length) {
                if (list.isEmpty()) {
                    // 1. stk가 빈 배열이면 arr[i] 추가 후 i 증가
                    list.add(arr[i]);
                    i++;
                } else if (list.get(list.size() - 1) < arr[i]) {
                    // 2. 마지막 원소가 arr[i]보다 작으면 arr[i] 추가 후 i 증가
                    list.add(arr[i]);
                    i++;
                } else {
                    // 3. 마지막 원소가 arr[i]보다 크거나 같으면 마지막 원소 제거
                    list.remove(list.size() - 1);
                }
            }

            // ArrayList를 int[] 배열로 변환
            int[] stk = new int[list.size()];
            for (int j = 0; j < stk.length; j++) {
                stk[j] = list.get(j);
            }

            return stk;
        }
    }

    // 2. 다른 사람의 풀이 (Stack 활용 및 향상된 for문 조합 - 코드가 매우 간결함)
    static class SolutionStack {
        public int[] solution(int[] arr) {
            Stack<Integer> stack = new Stack<>();

            for (int num : arr) {
                while (!stack.isEmpty() && num <= stack.peek()) {
                    stack.pop();
                }
                stack.push(num);
            }

            return stack.stream().mapToInt(i -> i).toArray();
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스: arr = [1, 4, 2, 5, 3] -> 결과: [1, 2, 3]
        int[] arr = {1, 4, 2, 5, 3};

        int[] result = sol.solution(arr, queries = ...); // 테스트 실행 확인용
        System.out.println("테스트 결과: " + Arrays.toString(result));
    }
}