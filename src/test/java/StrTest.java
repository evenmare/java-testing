import static org.junit.Assert.*;

public class StrTest {
    private char[] correctStrData = {'a', 'b', 'c'};
    private int correctStrLength;
    private Language correctStrLanguage = Language.ENG;

    private Str correctStr;

    @org.junit.Before
    public void setUp() {
        correctStrLength = correctStrData.length;
        correctStr = new Str(correctStrLength, correctStrData, correctStrLanguage);
    }

    @org.junit.Test
    public void getLength() {
        assertEquals(correctStr.getLength(), correctStrLength);
    }

    @org.junit.Test
    public void setLength() {
        int newLength = correctStrLength + 5;
        correctStr.setLength(newLength);
        assertEquals(correctStr.getLength(), newLength);
    }

    @org.junit.Test
    public void getData() {
        assertArrayEquals(correctStr.getData(), correctStrData);
    }

    @org.junit.Test
    public void getLanguage() {
        assertEquals(correctStr.getLanguage(), correctStrLanguage);
    }

    @org.junit.Test
    public void setLanguage() {
        Language newLanguage = Language.UNSET;
        correctStr.setLanguage(newLanguage);
        assertEquals(correctStr.getLanguage(), newLanguage);
    }

    @org.junit.Test
    public void merge() {
        char[] expectedData = {'a', 'b', 'c', 'a', 'b', 'c'};

        Str mergedStr = Str.merge(correctStr, correctStr);

        assertEquals(mergedStr.getLength(), correctStrLength * 2);
        assertArrayEquals(mergedStr.getData(), expectedData);
        assertEquals(mergedStr.getLanguage(), correctStrLanguage);
    }

    @org.junit.Test
    public void testEmptyStringCreation() {
        char[] emptyData = {};
        Str emptyStr = new Str(0, emptyData, correctStrLanguage);

        assertEquals(emptyStr.getLength(), 0);
        assertArrayEquals(emptyStr.getData(), emptyData);
    }

    @org.junit.Test(expected = NegativeArraySizeException.class)
    public void testNegativeLengthStringCreation() {
        char[] emptyData = {};
        Str negativeStr = new Str(-1, emptyData, correctStrLanguage);
    }

    @org.junit.Test
    public void testStringWithLengthLessThenData() {
        int lengthLessStrLength = 2;
        char[] expectedData = {'a', 'b'};

        Str lengthLessStr = new Str(lengthLessStrLength, correctStrData, correctStrLanguage);

        assertEquals(lengthLessStr.getLength(), lengthLessStrLength);
        assertArrayEquals(lengthLessStr.getData(), expectedData);
    }
}
