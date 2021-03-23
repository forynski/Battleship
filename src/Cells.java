package battleship;

public enum Cells {
    EMPTY('~'),
    SHIP('O'),
    HIT('X'),
    MISS('M');

    private final char symbol;

    Cells(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
