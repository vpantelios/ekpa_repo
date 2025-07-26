
package com.registry;

import com.registry.model.Citizen;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CitizenEntityTest {

    @Test
    public void testCitizenConstructorAndFields() {
        Citizen citizen = new Citizen();
        citizen.setAt("12345678");
        citizen.setFirstName("Γιάννης");
        citizen.setLastName("Παπαδόπουλος");
        citizen.setGender("Άνδρας");
        citizen.setBirthDate(LocalDate.of(1990, 1, 1));
        citizen.setAfm("123456789");
        citizen.setAddress("Αθήνα");

        assertEquals("12345678", citizen.getAt());
        assertEquals("Γιάννης", citizen.getFirstName());
        assertEquals("Παπαδόπουλος", citizen.getLastName());
        assertEquals("Άνδρας", citizen.getGender());
        assertEquals(LocalDate.of(1990, 1, 1), citizen.getBirthDate());
        assertEquals("123456789", citizen.getAfm());
        assertEquals("Αθήνα", citizen.getAddress());
    }
}
