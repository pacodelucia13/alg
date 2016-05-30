/**
 * Created by aepp on 30.05.2016.
 */
import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.Map;

public class WordNet {
    private Map<String, Integer> nouns = new HashMap<String, Integer>();

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        In synsetsIn = new In(synsets);
        In hypernymsIn = new In(hypernyms);
        String line;
        while ((line = synsetsIn.readLine()) != null) {
            //36,AND_circuit AND_gate,a circuit in a computer that fires only when all of its inputs fire
            int synsetId = Integer.parseInt(line.split(",")[0]);
            for (String noun : line.split(",")[1].split(" ")) {
                nouns.put(noun, synsetId);
            }

        }
    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return nouns.keySet();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        checkArgument(word);
        return nouns.get(word) != null;
    }

    private void checkArgument(Object object) {
        if(object == null){
            throw new NullPointerException();
        }
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        return 0;
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        return null;
    }

    // do unit testing of this class
    public static void main(String[] args) {
        WordNet wordNet = new WordNet("synsets3.txt", "hypernyms15Tree.txt");
        System.out.println("a " + wordNet.isNoun("a"));

        for (String s : wordNet.nouns()){
            System.out.println(s);
        }
    }
}