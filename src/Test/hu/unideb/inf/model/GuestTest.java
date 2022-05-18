package hu.unideb.inf.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GuestTest {

    Guest guest = new Guest();

    @Test
    public void LastNameTest() {
        guest.setLastName("Kovacs");
        assertTrue(guest.getLastName().length() == 6);
        String lastname = guest.getLastName();
        char first = lastname.charAt(0);
        assertTrue(Character.isUpperCase(first));
    }

    @Test
    public void FirstNameTest() {
        guest.setFirstName("Géza");
        assertTrue(guest.getFirstName().length() == 4);
        String firstname = guest.getFirstName();
        char first = firstname.charAt(0);
        assertTrue(Character.isUpperCase(first));
    }

    @Test
    public void SzemIgSzamTest() {
        guest.setSzemIgSzam("363545DE");
        assertTrue(guest.getSzemIgSzam().length() == 8);
        String id = guest.getSzemIgSzam();
        char last = id.charAt(id.length()-1);
        char Blast = id.charAt(id.length()-2);
        assertTrue(Character.isLetter(last) && Character.isLetter(Blast));
    }

    @Test
    public void TelTest() {
        guest.setTel("0630955714");
        assertTrue(guest.getTel().length() == 10);
    }

    @Test
    public void EmailTest() {
        guest.setEmail("hello@gmail.com");
        String mail = guest.getEmail();
        assertTrue(guest.getEmail().length() == 15);
        assertTrue(mail.contains("@"));
        assertTrue(mail.contains("."));
    }
}
