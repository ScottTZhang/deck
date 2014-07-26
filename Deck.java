import java.util.*;
public class Deck{
    private Card[] cards;
    HashSet<Card> used; //put the used card in the set, if selected, add it to set

    public Deck(){
        cards = new Card[54];
        int index = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 1; j <= 13; j++){
                cards[index] = new Card(j, i);
                index++;
            }
        }
        cards[52] = new Card(14, 0);
        cards[53] = new Card(15, 1);
        used = new HashSet<Card>();
    }

    //shuffle a deck
    void shuffle(){
        for(int i = 53; i >= 1; i--){
            int rand = (int)(Math.random() * i);
            swap(cards, i, rand);
        }
    }
    void swap(Card[] c, int i, int j){
        Card tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    //print the deck
    void print(){
        for(Card c : cards){
            System.out.println("(" + c.number + ", " + c.suit + ")");
        }
    }

    //get a random card, not a good way because when used is large. Fewer card can be used by random select
    Card rand(){
        if(used.size() == 54){
            System.out.println("all used");
            return null;
        }
        while(true){
            Card res = cards[(int)(Math.random() * 54)];
            if(used.contains(res)){
                continue;
            }else{
                used.add(res);
                res.print();
                return res;
            }
        }
    }

    //reset
    void reset(){
        used.clear();
    }

    //execute command
    /*  options:
     *  1: shuffle
     *  2: get a card randomly
     *  3: print deck
     *  4: reset
     *  5: exit
     */
    void execute(){
        String intro = "";
        intro += "Welcome. Select an option and input the number(1 - 5):\n";
        intro += "\t1: shuffle\n";
        intro += "\t2: get a card\n";
        intro += "\t3: print the deck\n";
        intro += "\t4: reset\n";
        intro += "\t5: exit";
        System.out.println(intro);
        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();
        while(opt >= 1 && opt <= 5){
            switch(opt){
                case 1: shuffle();
                        break;
                case 2: print();
                        break;
                case 3: rand();
                        break;
                case 4: reset();
                        break;
                case 5: System.exit(0);
                        break;
            }
            System.out.println("select another option:");
            opt = sc.nextInt();
        }
    }

    public static void main (String [] args){
        Deck deck = new Deck();
        deck.execute();
    }
}
