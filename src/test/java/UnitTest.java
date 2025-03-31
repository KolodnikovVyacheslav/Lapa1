import Collections.Container;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UnitTest {
    @Test
    void addAndGet() {
        Container container = new Container();
        container.add(1);
        container.add(2);
        assertEquals(1, container.get(0));
        assertEquals(2, container.get(1));
    }

    @Test
    void remove() {
        Container container = new Container();
        container.add(1);
        container.add(2);
        container.add(3);
        container.remove(1);
        assertEquals(1, container.get(0));
        assertEquals(3, container.get(1));
        assertEquals(2, container.size());
    }

    @Test
    void size() {
        Container container = new Container();
        assertEquals(0, container.size());
        container.add(1);
        assertEquals(1, container.size());
    }

    @Test
    void indexOutOfBoundsException() {
        Container container = new Container();
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(0));
    }
}