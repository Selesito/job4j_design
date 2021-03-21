package ru.job4j.finder;

public class FinderValid {
    private final String[] args;

    public FinderValid(String[] args) {
        this.args = args;
    }

    public boolean isValid() {
        return isValidNull() && isValidFormat();
    }

    private boolean isValidNull() {
        return args[0] != null && args[1] != null && args[2] != null
                && args[3] != null;
    }

    private boolean isValidFormat() {
        return args[0].contains("-d") && args[1].contains("-n") && args[2].contains("-t")
                && args[3].contains("-o");
    }
}
