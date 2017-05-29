package pl.game.cluster.entity;

public enum Status {

    NOWA("NOWA"),
    WYMIANA("WYMIANA");

    public static final Status[] ALL = { NOWA, WYMIANA};

    private final String text;

    private Status(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
