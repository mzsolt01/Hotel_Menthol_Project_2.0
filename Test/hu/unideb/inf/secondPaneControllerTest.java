package hu.unideb.inf;

import hu.unideb.inf.model.Guest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class secondPaneControllerTest {

    secondPaneController control = new secondPaneController();





    @Test
    void isValidEmail() {

        assertTrue(control.isValidEmail("zkymartin0307@gmail.com"));
        assertTrue(control.isValidEmail("vas.gabicii@gmail.com"));
        assertTrue(control.isValidEmail("szentpeti0201@freemail.hu"));
        assertTrue(control.isValidEmail("alice_bob@example.co.in"));
        assertTrue(control.isValidEmail("lopoka_zoli@citromail.hu"));
        assertTrue(control.isValidEmail("zubora08@gmail.com"));

        assertFalse(control.isValidEmail("@example.com"));
        assertFalse(control.isValidEmail("aliceexample.com"));


    }

    @Test
    void isValidId() {

        assertTrue(control.isValidId("611306SA"));
        assertTrue(control.isValidId("143733TA"));

        assertFalse(control.isValidId("TA4646"));
        assertFalse(control.isValidId("12345SA"));
        assertFalse(control.isValidId("TAS"));
        assertFalse(control.isValidId("12345SAT"));





    }

    @Test
    void isValidTel() {

        assertTrue(control.isValidTel("+36307217621"));
        assertTrue(control.isValidTel("36307217621"));
        assertTrue(control.isValidTel("+363072176212"));
        assertFalse(control.isValidTel("+3630"));
        assertFalse(control.isValidTel("+36307217abav"));
        assertFalse(control.isValidTel("+3630721762113131313"));
    }

    @Test
    void isValidFName() {
    }

    @Test
    void isValidLName() {
    }

    @Test
    void textHandler() {
    }
}