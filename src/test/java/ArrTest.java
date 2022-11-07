import static org.junit.Assert.*;

public class ArrTest {
    private final char[] charArr1 = {'a'};
    private final char[] charArr2 = {'b'};

    private Str str1;
    private Str str2;

    private Arr correctArr;

    @org.junit.Before
    public void setUp() {
        str1 = new Str(charArr1.length, charArr1, Language.ENG);
        str2 = new Str(charArr2.length, charArr2, Language.ENG);

        Str[] data = {str1, str2};

        correctArr = new Arr(data);
    }

    @org.junit.Test
    public void getLength() {
        assertEquals(charArr1.length + charArr2.length, correctArr.getLength());
        assertEquals(str1.getLength() + str2.getLength(), correctArr.getLength());
    }

    @org.junit.Test
    public void getData() {
        Str[] expectedData = {str1, str2};
        assertArrayEquals(expectedData, correctArr.getData());
    }

    @org.junit.Test
    public void testEmptyArray() {
        char[] emptyData = {};
        Str[] emptyStrArray = {
                new Str(0, emptyData, Language.UNSET),
                new Str(0, emptyData, Language.UNSET)
        };
        Arr emptyArr = new Arr(emptyStrArray);
        assertEquals(2, emptyArr.getLength());
    }
}
