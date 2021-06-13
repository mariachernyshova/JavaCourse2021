package homework7.csvparser;

public class ParseError {
    private String line;
    private String errorText;

    public ParseError(String line, String errorText) {
        this.line = line;
        this.errorText = errorText;
    }

    public String getLine() {
        return line;
    }

    public String getErrorText() {
        return errorText;
    }
}
