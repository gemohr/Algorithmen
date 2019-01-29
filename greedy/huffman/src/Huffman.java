import java.util.ArrayList;
import java.util.HashMap;

public class Huffman {
    private ArrayList<Tree> list;
    public HashMap<String,String > charMap = new HashMap<>();

    public Huffman(){
        this.list = new ArrayList<Tree>();
    }



    public void printTree(){
        System.out.println("Aktuelle Baum größe: "+ list.size());
        for (int i=0; i< list.size();i++) {
            System.out.println(list.get(i).getRelevanz());
        }
        System.out.println("------------------------------------------------");
    }
    public void add(char buchstabe){
        boolean isInlist = false;
    for (int i=0; i< list.size();i++){
        if(((Leaf)list.get(i)).getBuchstabe() == buchstabe){
            list.get(i).setRelevanz(list.get(i).getRelevanz()+1);
            isInlist = true;
            break;
        }
    }
    if(!isInlist){
        Leaf leaf = new Leaf(buchstabe,1);
        list.add(leaf);
    }

    }

    public Tree createTree(){
        if(list.size()<=0){
            return null;
        }
        if (list.size()>2){
            //die Indexe mit den kleinsten Relevanzen
        int lowrel1=0,lowrel2;

            for (int i=0; i< list.size();i++) {
                if(list.get(i).getRelevanz()<list.get(lowrel1).getRelevanz()) lowrel1 = i;
            }

            if(lowrel1 == 0)
                lowrel2 = 1;
            else lowrel2=0;

            for (int i=0; i< list.size();i++) {
                if(list.get(i).getRelevanz()<list.get(lowrel2).getRelevanz() && i != lowrel1) lowrel2 = i;
            }

            if (lowrel1 == lowrel2) return null;

            // zusammenfügen der beiden Bäume
            int relevanz = list.get(lowrel1).getRelevanz() + list.get(lowrel2).getRelevanz();

            Node node = new Node(
                    list.get(lowrel1),
                    list.get(lowrel2),
                    relevanz
            );

            list.set(lowrel1,node);
            list.remove(lowrel2);

            return createTree();
        }

        if (list.size() == 2){
            int lowrel1=0,lowrel2=1;

            int relevanz = list.get(lowrel1).getRelevanz() + list.get(lowrel2).getRelevanz();
            Node node = new Node(
                    list.get(lowrel1),
                    list.get(lowrel2),
                    relevanz
            );

            list.set(lowrel1,node);
            list.remove(lowrel2);
            return createTree();

        }
        return list.get(0);
    }

    public HashMap<String, String> getCharMap(Tree root) {
        charMap.clear();
        setCharMap(root,"");
        return charMap;

    }

    public void setCharMap(Tree tree, String path){
        if (tree instanceof Leaf) charMap.put(String.valueOf(((Leaf)tree).getBuchstabe()),path);
        if (tree instanceof Node){
            setCharMap(((Node) tree).left,path+"0");
            setCharMap(((Node) tree).right,path+"1");
        }
    }

    public String getCompressedCode(Tree tree, String input){
        String  output ="";
        HashMap<String,String> lib = getCharMap(tree);
        for(int i =0; i< input.length();i++){
            output = output+ lib.get(String.valueOf(input.charAt(i)));
        }
        return output;
    }

    public void clear(){
        list.clear();
    }

}
