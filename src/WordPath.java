/**
 * Created by Nathan on 1/19/2017.
 */

import java.io.*;

public class WordPath {

    public class WordNode{
        public String word;
        public WordNode(String word){
            this.word = word;
        }
        public void printNode(){
            System.out.println(this.word);
        }
    }

    public WordPath(){
        try {
            FileReader fr = new FileReader(new File("OpenEnglishWordList.txt"));
            BufferedReader br = new BufferedReader(fr);
            String word;
            while ((word = br.readLine()) != null){
                WordNode wordNode = new WordNode(word);
                wordNode.printNode();
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        WordPath wp = new WordPath();
    }
}
