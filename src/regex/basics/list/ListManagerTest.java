package javacollectionstreams.regex.basics.list;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListManagerTest {

    // Object of ListManager class
    ListManager manager = new ListManager();

    // Test adding element
    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 10);
        assertEquals(1, list.size());
    }

    // Test removing element
    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        manager.removeElement(list, 10);
        assertEquals(0, list.size());
    }

    // Test list size
    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        assertEquals(2, manager.getSize(list));
    }
}

