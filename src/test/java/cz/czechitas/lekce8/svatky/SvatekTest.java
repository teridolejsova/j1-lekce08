package cz.czechitas.lekce8.svatky;

import org.junit.jupiter.api.Test;

import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatekTest {


  @Test
  void testToString() {
   Svatek svatek = new Svatek(MonthDay.of(2, 1), "Hynek", Gender.MUZ);
   assertEquals("1. 2. Hynek", svatek.toString());
  }
}
