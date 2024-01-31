package exercise1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SmoothieBarTest {
    private SmoothieBar createSmoothieBar(int numOrange, int numApple, int numBanana) {
        SmoothieBar smoothieBar = new SmoothieBar();

        if (numOrange > 0) {
            smoothieBar.restockOranges(numOrange);
        }

        if (numApple > 0) {
            smoothieBar.restockApples(numApple);
        }

        if (numBanana > 0) {
            smoothieBar.restockBananas(numBanana);
        }

        return smoothieBar;
    }

    @Test
    public void canBlendOrangeAndAppleSmoothie() {
        // Given
        SmoothieBar smoothieBar = createSmoothieBar(2, 2, 0);

        // When
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);

        // Then
        assertEquals(SmoothieKind.OrangeAndAppleSmoothie, smoothie.getKind());
    }

    @Test
    public void blendingOrangeAndAppleSmoothieConsumesOrangesAndApples() {
        // Then
        SmoothieBar smoothieBar = createSmoothieBar(2, 2, 0);

        // When
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);

        // Then
        assertEquals(0, smoothieBar.getApplesInStock());
        assertEquals(0, smoothieBar.getOrangesInStock());
    }

    @Test
    public void canBlendBananaAndAppleSmoothie() {
        // Given
        SmoothieBar smoothieBar = createSmoothieBar(0, 2, 1);

        // When
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.BananaAndAppleSmoothie);

        // Then
        assertEquals(SmoothieKind.BananaAndAppleSmoothie, smoothie.getKind());
    }

    @Test
    public void blendingBananaAndAppleSmoothieConsumesBananasAndApples() {
        //Given
        SmoothieBar smoothieBar = createSmoothieBar(0, 2, 1);

        // When
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.BananaAndAppleSmoothie);

        // Then
        assertEquals(0, smoothieBar.getApplesInStock());
        assertEquals(0, smoothieBar.getBananasInStock());
    }

    @Test
    public void canBlendOrangeAndBananaSmoothie() {
        // Given
        SmoothieBar smoothieBar = createSmoothieBar(3, 0, 1);
        // When
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndBananaSmoothie);

        // Then
        assertEquals(SmoothieKind.OrangeAndBananaSmoothie, smoothie.getKind());
    }

    @Test
    public void blendingOrangeAndBananaSmoothieConsumesOrangeAndBananas() {
        // Given
        SmoothieBar smoothieBar = createSmoothieBar(3, 0, 1);

        // When
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndBananaSmoothie);

        // Then
        assertEquals(0, smoothieBar.getOrangesInStock());
        assertEquals(0, smoothieBar.getBananasInStock());
    }

    @Test
    public void smoothieBarIllegalStateCheck() {
        // Given
        SmoothieBar smoothieBar = createSmoothieBar(1, 2, 0);

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
