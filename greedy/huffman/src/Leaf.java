public class Leaf extends Tree {

    public char buchstabe;


    public Leaf(char buchstabe, int relevanz){
        setBuchstabe(buchstabe);
        setRelevanz(relevanz);
    }

    public char getBuchstabe() {
        return buchstabe;
    }

    public void setBuchstabe(char buchstabe) {
        this.buchstabe = buchstabe;
    }
}
