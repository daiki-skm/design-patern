public enum Hand {
    ROCK("Rock", 0),
    SCISSORS("Scissors", 1),
    PAPER("Paper", 2);

    private String name;
    private int handvalue;

    private static Hand[] hands = {
            ROCK, SCISSORS, PAPER
    };

    private Hand(String name, int handvalue) {
        this.name = name;
        this.handvalue = handvalue;
    }

    public static Hand getHand(int handvalue) {
        return hands[handvalue];
    }

    public boolean isStrongerThan(Hand hand) {
        return fight(hand) == 1;
    }

    public boolean isWeakerThan(Hand hand) {
        return fight(hand) == -1;
    }

    private int fight(Hand hand) {
        if (this == hand) {
            return 0;
        } else if ((this.handvalue + 1) % 3 == hand.handvalue) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}