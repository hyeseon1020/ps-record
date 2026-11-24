package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day12_making_array_3 {
/*배열만들기3
정수 배열 arr와 2개의 구간이 담긴 배열 intervals가 주어집니다.

intervals는 항상 [[a1, b1], [a2, b2]]의 꼴로 주어지며 각 구간은 닫힌 구간입니다. 닫힌 구간은 양 끝값과 그 사이의 값을 모두 포함하는 구간을 의미합니다.

이때 배열 arr의 첫 번째 구간에 해당하는 배열과 두 번째 구간에 해당하는 배열을 앞뒤로 붙여 새로운 배열을 만들어 return 하는 solution 함수를 완성해 주세요.

arr	intervals	result
[1, 2, 3, 4, 5]	[[1, 3], [0, 4]]	[2, 3, 4, 1, 2, 3, 4, 5]*/
    // 1. 작성하신 풀이 (전체 길이 사전 계산 후 고정 배열에 직접 대입 - 메모리 및 속도 최적화!)
    static class SolutionMy {
        public int[] solution(int[] arr, int[][] intervals) {
            int totalLength = 0;
            for (int i = 0; i < intervals.length; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                totalLength += (end - start + 1);
            }

            int[] answer = new int[totalLength];
            int idx = 0;

            for (int i = 0; i < intervals.length; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                for (int j = start; j <= end; j++) {
                    answer[idx++] = arr[j];
                }
            }

            return answer;
        }
    }

    // 2. 다른 사람의 풀이 (List에 담은 뒤 배열로 변환 - 길이를 미리 계산하지 않아도 되어 구현이 단순함)
    static class SolutionList {
        public int[] solution(int[] arr, int[][] intervals) {
            List<Integer> list = new ArrayList<>();

            for (int[] interval : intervals) {
                int start = interval[0];
                int end = interval[1];
                for (int i = start; i <= end; i++) {
                    list.add(arr[i]);
                }
            }

            int[] answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }

    // 3. 테스트 실행용 main 메서드
    public static void main(String[] args) {
        SolutionMy sol = new SolutionMy();

        // 테스트 케이스: arr = [1, 2, 3, 4, 5], intervals = [[1, 3], [0, 4]]
        int[] arr = {1, 2, 3, 4, 5};
        int[][] intervals = {{1, 3}, {0, 4}};

        int[] result = sol.solution(arr, intervals);
        System.out.println("테스트 결과: " + Arrays.toString(result) + " (기대값: [2, 3, 4, 1, 2, 3, 4, 5])");
    }
}