public class Card{
    int number; //1 to 13 mean 1 to K, 14, 15 mean joker
    int suit;   //0: diamonds, 1: clubs, 2: hearts, 3: spades

    public Card(int num, int suit){
        number = num;
        this.suit = suit;
    }

    //print the card number and suit
    void print(){
        System.out.println("(" + number + ", " + suit + ")");
    }
}
