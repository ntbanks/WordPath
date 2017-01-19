import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by ntbanks on 1/19/17.
 */
public class WordGraph {

    public ArrayList<WordNode> words = new ArrayList<>();

    public WordGraph(String file){

        FileReader fr;
        BufferedReader br;
        try{
            fr = new FileReader(new File(file));
            br = new BufferedReader(fr);
            String word;
            while ((word = br.readLine()) != null){
                makeNode(word);
            }
            System.out.println(words.size());
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }

    public void makeNode(String word){
        WordNode newNode = new WordNode(word);
        words.add(newNode);
        newNode.printNode();
    }

}
