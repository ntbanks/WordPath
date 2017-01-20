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

    public boolean checkEven(WordNode wordone, WordNode wordtwo){
        int counter = 0;
        for (int i = 0; i < wordone.getLength(); i++){
            if (wordone.word.charAt(i) != wordtwo.word.charAt(i)) counter++;
        }
        switch (counter) {
            case 0 :
                return true;

            case 1 :
                return true;

        }
        return false;
    }

    public boolean checkUneven(WordNode wordone, WordNode wordtwo){
        int offset = 0;
        for (int i = 0; i < wordone.getLength(); i++){
            if (wordone.word.charAt(i + offset) != wordtwo.word.charAt(i)){
                if (offset == 0) offset = 1;
                else return false;
                //TODO if the offset is 1 and it gets to the end of the word it throws an error...
            }
        }
        return true;
    }


    public void makeNode(String word){
        WordNode newNode = new WordNode(word);
        words.add(newNode);
        newNode.printNode();

        for (WordNode w : words) {
            int difference = newNode.getLength() - w.getLength();
            System.out.println("check: " + newNode.word + " " + w.word + " " + difference);
            switch (difference) {
                case -1:
                    if (checkUneven(w,newNode)) {
                        newNode.onemore.add(w);
                        w.oneless.add(newNode);
                    }
                    break;
                case 0:
                    if(checkEven(w,newNode)) {
                        newNode.equal.add(w);
                        w.equal.add(newNode);
                    }
                    break;
                case 1:
                    if(checkUneven(newNode,w)) {
                        newNode.oneless.add(w);
                        w.equal.add(newNode);
                    }
                    break;
            }

        }

    }

}
