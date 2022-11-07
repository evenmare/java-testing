import static org.junit.Assert.*;

public class StringFromStrTest {
    final char[] correctStrData = {'a', 'b', 'c'};
    int correctStrLength;
    final Language correctStrLanguage = Language.ENG;

    StringFromStr correctStr;

    @org.junit.Before
    public void setUp() {
        correctStrLength = correctStrData.length;
        correctStr = new StringFromStr(correctStrLength, correctStrData, correctStrLanguage);
    }


    @org.junit.Test
    public void getString() {
        String expectedString = new String(correctStrData);
        assertEquals(expectedString, correctStr.getString());
        assertEquals(expectedString.length(), correctStr.getLength());
    }

    @org.junit.Test
    public void setLength() {
        int newLength = 4;
        correctStr.setLength(newLength);
        assertEquals(newLength, correctStr.getLength());
        assertEquals(newLength, correctStr.getData().length);
        assertEquals(newLength, correctStr.getString().length());
    }
}
