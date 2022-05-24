package cz.czechitas.lekce8.svatky;

import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Informace o svátku (jmeninách).
 */
public class Svatek {
  private static final DateTimeFormatter DAY_FORMATTER = DateTimeFormatter.ofPattern("d. M.");
  private final MonthDay den;
  private final String jmeno;
  private final Gender gender;

  public Svatek(MonthDay den, String jmeno, Gender gender) {
    this.den = den;
    this.jmeno = jmeno;
    this.gender = gender;
  }

  public MonthDay getDen() {
    return den;
  }

  public String getJmeno() {
    return jmeno;
  }

  public Gender getGender() {
    return gender;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Svatek)) return false;
    Svatek svatek = (Svatek) o;
    return den.equals(svatek.den) && jmeno.equals(svatek.jmeno);
  }

  @Override
  public int hashCode() {
    return Objects.hash(den, jmeno);
  }

  @Override
  public String toString() {
    return String.format("%s %s", den.format(DAY_FORMATTER), jmeno);
  }
}
