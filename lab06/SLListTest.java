import org.junit.Test;

import static org.junit.Assert.*;

public class SLListTest {

    @Test
    public void testSLListAdd() {
        SLList test1 = SLList.of(1, 3, 5);
        SLList test2 = new SLList();

        test1.add(1, 2);
        test1.add(3, 4);
        assertEquals(5, test1.size());
        assertEquals(3, test1.get(2));
        assertEquals(4, test1.get(3));

        test2.add(1, 1);
        assertEquals(1, test2.get(0));
        assertEquals(1, test2.size());

        test2.add(10, 10);
        assertEquals(10, test2.get(1));
        test1.add(0, 0);
        assertEquals(SLList.of(0, 1, 2, 3, 4, 5), test1);
    }

    @Test
    public void testSLListReverse() {
        SLList s1 = SLList.of(1, 2, 3, 4, 5, 6, 7);
        SLList s2 = SLList.of(1);
        SLList s3 = SLList.of();

        s1.reverse();
        s2.reverse();
        s3.reverse();

        assertEquals(0, s3.size());
        assertEquals(1, s2.size());
        assertEquals(1, s2.get(0));

        assertEquals(7, s1.size());
        assertEquals(1, s1.get(6));
        assertEquals(4, s1.get(3));
        assertEquals(7, s1.get(0));
    }
}
