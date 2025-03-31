import Collections.Container;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UnitTest {
    private final Container container = new Container();

    @BeforeEach
    void start() {
        container.add(1);
        container.add(2);
        container.add(3);
        container.add(4);
    }

    @Test
    void addAndGet() {
        assertEquals(1, container.get(0));
        assertEquals(2, container.get(1));
    }

    @Test
    void remove() {
        container.remove(1);
        assertEquals(1, container.get(0));
        assertEquals(3, container.get(1));
        assertEquals(4, container.get(2));
        assertEquals(3, container.size());
    }

    @Test
    void size() {
        assertEquals(4, container.size());
        container.add(1);
        assertEquals(5, container.size());
    }

    @Test
    void resize() {
        for (int i = 0; i < 8; i++)
            container.add(i);
        assertEquals(12, container.size());
        assertEquals(6, container.get(10));
        assertEquals(7, container.get(11));
    }

    @Test
    void indexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(13));
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(99));
    }
}