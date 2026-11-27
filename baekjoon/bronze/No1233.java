package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1233 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    public static void main(String[] args) throws IOException {
        int s1 = Integer.parseInt(next());
        int s2 = Integer.parseInt(next());
        int s3 = Integer.parseInt(next());

        int[] count = new int[s1 + s2 + s3 + 1];

        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) {
                    count[i + j + k]++;
                }
            }
        }

        // 세 주사위 합이 될 수 있는 최솟값은 3 (1 + 1 + 1)
        int answer = 3;
        for (int i = 4; i < count.length; i++) {
            if (count[i] > count[answer]) {
                answer = i;
            }
        }

        System.out.println(answer);
    }
}

