package exercise1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SmoothieBarTest {
    //TODO: refactor repeated code into method... excercise 3
    @Test
    public void canBlendOrangeAndAppleSmoothie() {
        // Given
        SmoothieBar smoothieBar = new SmoothieBar();
        smoothieBar.restockApples(2);
        smoothieBar.restockOranges(2);

        // When
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);

        // Then
        assertEquals(SmoothieKind.OrangeAndAppleSmoothie, smoothie.getKind());
    }

    @Test
    public void blendingOrangeAndAppleSmoothieConsumesOrangesAndApples() {
        // Then
        SmoothieBar smoothieBar = new SmoothieBar();
        smoothieBar.restockApples(2);
        smoothieBar.restockOranges(2);

        // When
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);

        // Then
        assertEquals(0, smoothieBar.getApplesInStock());
        assertEquals(0, smoothieBar.getOrangesInStock());
    }

    @Test
    public void canBlendBananaAndAppleSmoothie() {
        // Given
        SmoothieBar smoothieBar = new SmoothieBar();
        smoothieBar.restockApples(2);
        smoothieBar.restockBananas(1);

        // When
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.BananaAndAppleSmoothie);

        // Then
        assertEquals(SmoothieKind.BananaAndAppleSmoothie, smoothie.getKind());
    }

    @Test
    public void blendingBananaAndAppleSmoothieConsumesBananasAndApples() {
        //Given
        SmoothieBar smoothieBar = new SmoothieBar();
        smoothieBar.restockApples(2);
        smoothieBar.restockBananas(1);

        // When
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.BananaAndAppleSmoothie);

        // Then
        assertEquals(0, smoothieBar.getApplesInStock());
        assertEquals(0, smoothieBar.getBananasInStock());
    }

    @Test
    public void canBlendOrangeAndBananaSmoothie() {
        // Given
        SmoothieBar smoothieBar = new SmoothieBar();
        smoothieBar.restockOranges(3);
        smoothieBar.restockBananas(1);

        // When
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndBananaSmoothie);

        // Then
        assertEquals(SmoothieKind.OrangeAndBananaSmoothie, smoothie.getKind());
    }

    @Test
    public void blendingOrangeAndBananaSmoothieConsumesOrangeAndBananas() {
        // Given
        SmoothieBar smoothieBar = new SmoothieBar();
        smoothieBar.restockOranges(3);
        smoothieBar.restockBananas(1);

        // When
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndBananaSmoothie);

        // Then
        assertEquals(0, smoothieBar.getOrangesInStock());
        assertEquals(0, smoothieBar.getBananasInStock());
    }

    @Test
    public void smoothieBarIllegalStateCheck() {
        // Given
        SmoothieBar smoothieBar = new SmoothieBar();
        smoothieBar.restockApples(2);
        smoothieBar.restockOranges(1);

        // When and Then
        assertThrows(IllegalStateException.class, () -> {
            smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);
        });
    }

    @Test
    public void smoothieBarIllegalArgumentCheck() {
        // Given
        SmoothieBar smoothieBar = new SmoothieBar();

        // When and Then
        assertThrows(IllegalArgumentException.class, () -> {
            smoothieBar.restockOranges(0);
        });
    }
}
