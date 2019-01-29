
//Stellt die Verzweichung dar
public class Node extends Tree {

    public Tree left;
    public Tree right;

    public Node (Tree left, Tree right, int relevanz){
        this.left=left;
        this.right = right;
        setRelevanz(relevanz);
    }

}

