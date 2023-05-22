import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] firstLine = br.readLine().split(" ");
    int R = Integer.parseInt(firstLine[0]);
    int L = Integer.parseInt(firstLine[1]);
        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split(" ");
            int p = Integer.parseInt(line[0]);
            int d = Integer.parseInt(line[1]);
        }
        for (int i = 0; i < L; i++) {
            String[] line = br.readLine().split(" ");
            int p = Integer.parseInt(line[0]);
            int d = Integer.parseInt(line[1]);
        }
        int safeRegion = Integer.parseInt(br.readLine());
    }
}

