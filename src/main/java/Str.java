public class Str {
    private int length;
    private char[] data;
    private Language language;

    public int calculateCharArrayLength(int newLength, int oldLength) {
        int length;
        if (oldLength > newLength) {
            length = newLength;
        }
        else {
            length = oldLength;
        }

        return length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int newLength) {
        int oldLength = this.length;
        char[] oldData = data;

        char[] newData = new char[newLength];

        int length = calculateCharArrayLength(newLength, oldLength);

        System.arraycopy(oldData, 0, newData, 0, length);

        this.data = newData;
        this.length = newLength;
    }

    public char[] getData() {
        return data;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Str(int length, char[] data, Language language) {
        char[] dataWithLength = new char[length];

        int copyArrayLength = calculateCharArrayLength(length, data.length);
        System.arraycopy(data, 0, dataWithLength, 0, copyArrayLength);

        this.length = length;
        this.data = dataWithLength;
        this.language = language;
    }

    public static Str merge(Str firstStr, Str secondStr) {
        int mergedStrLength = firstStr.getLength() + secondStr.getLength();
        char[] mergedStrData = new char[mergedStrLength];
        Language mergedStrLanguage = firstStr.getLanguage();

        System.arraycopy(firstStr.data, 0, mergedStrData, 0, firstStr.getLength());
        System.arraycopy(secondStr.data, 0, mergedStrData, firstStr.getLength(), secondStr.getLength());

        return new Str(mergedStrLength, mergedStrData, mergedStrLanguage);
    }
}
