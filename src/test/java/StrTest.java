import static org.junit.Assert.*;

public class StrTest {
    final char[] correctStrData = {'a', 'b', 'c'};
    int correctStrLength;
    final Language correctStrLanguage = Language.ENG;

    Str correctStr;

    @org.junit.Before
    public void setUp() {
        correctStrLength = correctStrData.length;
        correctStr = new Str(correctStrLength, correctStrData, correctStrLanguage);
    }

    @org.junit.Test
    public void getLength() {
        assertEquals(correctStrLength, correctStr.getLength());
    }

    @org.junit.Test
    public void setLength() {
        int newLength = correctStrLength + 5;
        correctStr.setLength(newLength);
        assertEquals(newLength, correctStr.getLength());
    }

    @org.junit.Test
    public void getData() {
        assertArrayEquals(correctStrData, correctStr.getData());
    }

    @org.junit.Test
    public void getLanguage() {
        assertEquals(correctStrLanguage, correctStr.getLanguage());
    }

    @org.junit.Test
    public void setLanguage() {
        Language newLanguage = Language.UNSET;
        correctStr.setLanguage(newLanguage);
        assertEquals(newLanguage, correctStr.getLanguage());
    }

    @org.junit.Test
    public void merge() {
        char[] expectedData = {'a', 'b', 'c', 'a', 'b', 'c'};

        Str mergedStr = Str.merge(correctStr, correctStr);

        assertEquals(correctStrLength * 2, mergedStr.getLength());
        assertArrayEquals(expectedData, mergedStr.getData());
        assertEquals(correctStrLanguage, mergedStr.getLanguage());
    }

    @org.junit.Test
    public void testEmptyStringCreation() {
        char[] emptyData = {};
        Str emptyStr = new Str(0, emptyData, correctStrLanguage);

        assertEquals(0, emptyStr.getLength());
        assertArrayEquals(emptyData, emptyStr.getData());
    }

    @org.junit.Test(expected = NegativeArraySizeException.class)
    public void testNegativeLengthStringCreation() {
        char[] emptyData = {};
        new Str(-1, emptyData, correctStrLanguage);
    }

    @org.junit.Test
    public void testStringWithLengthLessThenData() {
        int lengthLessStrLength = 2;
        char[] expectedData = {'a', 'b'};

        Str lengthLessStr = new Str(lengthLessStrLength, correctStrData, correctStrLanguage);

        assertEquals(lengthLessStrLength, lengthLessStr.getLength());
        assertArrayEquals(expectedData, lengthLessStr.getData());
    }
}
