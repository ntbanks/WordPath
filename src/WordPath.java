/**
 * Created by Nathan on 1/19/2017.
 */

import java.io.*;

public class WordPath {
    public static void main(String[] args){

        try {
            FileReader fr = new FileReader(new File("OpenEnglishWordList.txt"));
            BufferedReader br = new BufferedReader(fr);
            String word = null;
            while ((word = br.readLine()) != null){
                System.out.println(word);
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
