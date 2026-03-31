import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Country {
        int number;
        int gold;
        int silver;
        int bronze;

        public Country(int number, int gold, int silver, int bronze) {
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Country> countries = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            countries.add(new Country(number, gold, silver, bronze));
        }

        countries.sort((a, b) -> {
            if(a.gold != b.gold) {
                return Integer.compare(b.gold, a.gold);
            }
            if(a.silver != b.silver) {
                return Integer.compare(b.silver, a.silver);
            }
            return Integer.compare(b.bronze, a.bronze);
        });

        int rank = 1;

        for(int i = 0; i < n; i++) {
            Country cur = countries.get(i);

            if(i > 0) {
                Country prev = countries.get(i - 1);

                if(!(cur.gold == prev.gold
                        && cur.silver == prev.silver
                        && cur.bronze == prev.bronze)) {
                    rank = i + 1;
                }
            }

            if(cur.number == k) {
                System.out.println(rank);
                return;
            }
        }
    }
}
