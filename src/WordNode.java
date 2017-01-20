import java.util.ArrayList;

/**
 * Created by ntbanks on 1/19/17.
 */
public class WordNode {
    public String word;
    public ArrayList<WordNode> oneless;
    public ArrayList<WordNode> equal;
    public ArrayList<WordNode> onemore;
    public WordNode(String word){
        this.word = word;
        this.oneless = new ArrayList<>();
        this.equal = new ArrayList<>();
        this.onemore = new ArrayList<>();
    }
    public void printNode(){
        System.out.println(this.word);
    }

    public int getLength(){
        return this.word.length();
    }
}
