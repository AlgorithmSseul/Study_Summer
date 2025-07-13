import java.io.*;

public class 김규빈_1316{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (isGroupWord(word)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean isGroupWord(String word) {
        boolean[] seen = new boolean[26];
        char prev = word.charAt(0);
        seen[prev - 'a'] = true;

        for (int i = 1; i < word.length(); i++) {
            char current = word.charAt(i);
            if (current != prev) {
                if (seen[current - 'a']) {
                    return false;
                }
                seen[current - 'a'] = true;
                prev = current;
            }
        }

        return true;
    }
}

