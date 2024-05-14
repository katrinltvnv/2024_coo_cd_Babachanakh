package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;

import XML.ChargeurMagasin;
import donnees.Magasin;
import org.junit.Test;

public class TestChargeurMagasin {

    @Test

    public void test01_ChargerMagasin_RepertoireValide() {
        // Préparation des données
        String cheminValide = "/musicbrainzSimple.musicbrainzSimple/Gorillaz_.xml";
        ChargeurMagasin chargeur = new ChargeurMagasin(cheminValide);

        try {
            // Méthode testée
            Magasin magasin = chargeur.chargerMagasin();

            // Vérification
            int nombreAttenduDeCds = 5; // Ajustez cette valeur en fonction de votre cas de test
            assertEquals("Le nombre de CDs charges doit etre 5.",
                    nombreAttenduDeCds, magasin.getNombreCds());
        } catch (FileNotFoundException e) {
            fail("Le chargement a échoué.");
        }
    }

    @Test
    public void test02_ChargerMagasin_RepertoireInvalide() throws FileNotFoundException {
        // Préparation des données
        String cheminInvalide = "/musicbrainzSimple.musicbrainzSimple/invalide";

        // Méthode testée
        assertThrows(FileNotFoundException.class, () -> new ChargeurMagasin(cheminInvalide),
                "Une exception doit etre levee");
    }


}
/*
    @Test(expected = FileNotFoundException.class)

     * Test de la méthode chargerMagasin avec un répertoire invalide.

    public void testChargerMagasinAvecRepertoireInvalide() throws FileNotFoundException {
        // Préparation des données
        String cheminInvalide = "/chemin/vers/le/repertoire/invalide";
        ChargeurMagasin chargeur = new ChargeurMagasin(cheminInvalide);

        // Méthode testée
        chargeur.chargerMagasin(); // Doit lever une FileNotFoundException
    }

*/