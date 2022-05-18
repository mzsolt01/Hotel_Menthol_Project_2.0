package hu.unideb.inf.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    Room room = new Room();

    @Test
    void get_setIdTest() {
        room.setId(4564);
        assertEquals(room.getId(), 4564);
    }

    @Test
    void get_setTypeTest() {
        room.setType("Normál");
        assertEquals(room.getType(), "Normál");
    }
}