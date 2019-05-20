import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static int DL_estimation(String word1,String word2){
        int word1Length = word1.length();
        int word2Length = word2.length();
        if (word1Length == 0) return word2Length;
        if (word2Length == 0) return word1Length;

        int[][] dist = new int[word1Length + 1][word2Length + 1];

        for (int i = 0; i < word1Length + 1; i++) {
            dist[i][0] = i;
        }
        for (int j = 0; j < word2Length + 1; j++) {
            dist[0][j] = j;
        }
        for (int i = 1; i < word1Length + 1; i++) {
            for (int j = 1; j < word2Length + 1; j++) {
                int cost;
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    cost = 0;
                }else{
                    cost = 1;
                }
                dist[i][j] = Math.min(Math.min(dist[i - 1][j] + 1, dist[i][j - 1] + 1), dist[i - 1][j - 1] + cost);

                if (i > 1 && j > 1 && word1.charAt(i - 1) == word2.charAt(j - 2) && word1.charAt(i - 2) == word2.charAt(j - 1)) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 2][j - 2] + cost);
                }
            }
        }
        return dist[word1Length][word2Length];
    }

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        String word = in.next();
        FileReader file = new FileReader("words.txt");
        Scanner scan = new Scanner(file);

        HashSet<String> dictionary = new HashSet<String>();
        while(scan.hasNext()){
            dictionary.add(scan.next());
        }
        file.close();
        if (dictionary.contains(word)){ // word exists in the dictionary
            System.out.println("The word is written correctly.");
        }else{
            // search for the closest ones
            int min_distance = Integer.MAX_VALUE;
            for (String i : dictionary){
                int distance =DL_estimation(i,word);
                if (distance<min_distance){
                    min_distance = distance;
                }
            }
            System.out.println("Possible words:");
            for (String i : dictionary){
                if (DL_estimation(i,word) == min_distance){
                    System.out.println(i);
                }
            }
        }
    }
}
