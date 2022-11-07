public class StringFromStr extends Str {
    private String string;

    public String getString() {
        return string;
    }

    public void setLength(int newLength) {
        super.setLength(newLength);
        this.string = new String(this.getData());
    }

    public StringFromStr(int length, char[] data, Language language) {
        super(length, data, language);
        this.string = new String(data);
    }
}
