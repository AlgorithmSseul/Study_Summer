import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int count = 0;

        for (int tc = 0; tc < n; tc++){
            String word = br.readLine().trim();
            char[] alphabets = new char[26];

            for (int i = 0; i < alphabets.length; i++){
                alphabets[i] = (char)(97 + i);
            }

            breakPoint1:
            for (int i = 0; i < word.length();){
                for (int j = 0; j < alphabets.length; j++) {
                    if (alphabets[j] == word.charAt(i)) {
                        for (i += 1; i < word.length(); i++) {
                            if (alphabets[j] != word.charAt(i)){
                                for (; j < alphabets.length -1; j++){
                                    alphabets[j] = alphabets[j+1];
                                }
                                alphabets[j] = '-';
                                break;
                            }
                        }
                        break;
                    }
                    if (j == 25){
                        count--;
                        break breakPoint1;
                    }
                }
            }
            count++;
        }
        System.out.println(count);

        }

    }
