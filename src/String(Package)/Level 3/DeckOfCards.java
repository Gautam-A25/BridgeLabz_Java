import java.util.Scanner;

public class DeckOfCards {

    public static String[] createDeck() {
        String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

        String[] deck = new String[suits.length * ranks.length];
        int index = 0;

        for (String s : suits)
            for (String r : ranks)
                deck[index++] = r + " of " + s;

        return deck;
    }

    public static void shuffle(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int r = i + (int)(Math.random() * (deck.length - i));
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }
    }

    public static String[][] distribute(String[] deck, int players, int cards) {
        if (players * cards > deck.length) return null;

        String[][] result = new String[players][cards];
        int index = 0;

        for (int i = 0; i < players; i++)
            for (int j = 0; j < cards; j++)
                result[i][j] = deck[index++];

        return result;
    }

    public static void display(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.print("Player " + (i+1) + ": ");
            for (String card : players[i]) System.out.print(card + ", ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = createDeck();
        shuffle(deck);
        display(distribute(deck, sc.nextInt(), sc.nextInt()));
    }
}
