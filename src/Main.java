import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] firstLine = br.readLine().split(" ");
    int R = Integer.parseInt(firstLine[0]);
    int L = Integer.parseInt(firstLine[1]);
    List<Pair> edges = new ArrayList<>();
    int [] departureCapacities = new int[R+1];
    int [] populations = new int[R+1];
        for (int i = 1; i <= R; i++) {
            String[] line = br.readLine().split(" ");
            populations[i] = Integer.parseInt(line[0]);
            departureCapacities[i] = Integer.parseInt(line[1]);
        }
        for (int i = 0; i < L; i++) {
            String[] line = br.readLine().split(" ");
            int o = Integer.parseInt(line[0]);
            int d = Integer.parseInt(line[1]);
            edges.add(new Pair(o,d));
        }
        int safeRegion = Integer.parseInt(br.readLine());

        Problem p = new Problem(edges, R, populations, departureCapacities, safeRegion);
        System.out.println(p.solve());
    }

}

