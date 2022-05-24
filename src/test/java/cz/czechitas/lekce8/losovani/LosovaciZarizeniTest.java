package cz.czechitas.lekce8.losovani;

import cz.czechitas.lekce8.losovani.LosovaciZarizeni;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class LosovaciZarizeniTest {
  private final LosovaciZarizeni losovaciZarizeni = new LosovaciZarizeni();

  @RepeatedTest(100)
  void losujSazkuHlavniTah() {
    List<Integer> vylosovanaCisla = losovaciZarizeni.losujSazkuHlavniTah();
    testujSazkuHlavniTah(vylosovanaCisla);
  }

  @RepeatedTest(100)
  void losujSazkuHlavniTahDuplicity() {
    List<Integer> vylosovanaCisla = losovaciZarizeni.losujSazkuHlavniTahDuplicitni();
    testujSazkuHlavniTah(vylosovanaCisla);
  }

  @RepeatedTest(100)
  void losujSudaCislaFilter() {
    IntStream sudaCisla = losovaciZarizeni.losujSeznamSudychCisel(2, 60, 10);
    overSudaCisla(sudaCisla);
  }

  @RepeatedTest(100)
  void losujSudaCislaMap() {
    IntStream sudaCisla = losovaciZarizeni.losujSeznamSudychCiselJakoMapa(2, 60, 10);
    overSudaCisla(sudaCisla);
  }

  private void testujSazkuHlavniTah(List<Integer> vylosovanaCisla) {
    assertEquals(6, vylosovanaCisla.size(), "Vylosovaných čísle není 6.");
    assertTrue(vylosovanaCisla.stream()
                    .allMatch(cislo -> cislo >= 1 && cislo <= 49),
            () -> String.format(
                    "Vylosovaná čísla nejsou v rozsahu 1–49. Nejmenší tažené číslo: %d. největší tažené číslo: %d.",
                    vylosovanaCisla.stream().min(Integer::compareTo).get(),
                    vylosovanaCisla.stream().max(Integer::compareTo).get()
            ));

    assertEquals(6, vylosovanaCisla.stream()
                    .distinct()
                    .count(),
            () ->
                    String.format("Vylosovaná čísla nejsou unikátní: %s", vylosovanaCisla.stream()
                            .map(cislo -> Integer.toString(cislo))
                            .collect(Collectors.joining(", ")))
    );
  }

  private void overSudaCisla(IntStream sudaCisla) {
    sudaCisla.forEach(cislo -> {
      assertEquals(0, cislo % 2, "Vylosované číslo není sudé.");
      assertTrue(cislo >= 2, "Vylosované číslo je menší než 2.");
      assertTrue(cislo <= 60, "Vylosované číslo je větší než 60");
    });
  }
}
