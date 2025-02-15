import org.json.JSONObject;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecretSharing {
    public static JSONObject readInput(String filePath) throws Exception {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
        }
        scanner.close();
        return new JSONObject(sb.toString());
    }

    public static int decodeValue(String b, String v) {
        return Integer.parseInt(v, Integer.parseInt(b));
    }

    public static List<int[]> getPoints(JSONObject json) {
        List<int[]> pts = new ArrayList<>();
        int n = json.getJSONObject("keys").getInt("n");

        for (int i = 1; i <= n; i++) {
            if (json.has(String.valueOf(i))) {
                JSONObject p = json.getJSONObject(String.valueOf(i));
                int x = i;
                int y = decodeValue(p.getString("base"), p.getString("value"));
                pts.add(new int[]{x, y});
            }
        }
        return pts;
    }

    public static int calcSecret(List<int[]> pts) {
        int c = 0;
        int n = pts.size();

        for (int i = 0; i < n; i++) {
            int num = 1;
            int denom = 1;

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    num *= -pts.get(j)[0];
                    denom *= (pts.get(i)[0] - pts.get(j)[0]);
                }
            }
            c += (pts.get(i)[1] * num) / denom;
        }

        return c;
    }

    public static void main(String[] args) {
        try {
            JSONObject json = readInput("input.json");
            List<int[]> pts = getPoints(json);
            int secret = calcSecret(pts);
            System.out.println("Secret (c) is: " + secret);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
