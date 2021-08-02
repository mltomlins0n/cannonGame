import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class InputValidatorTests {

    @Test
    public void is1Valid() {
        // given I am a user
        int inputAngle = 1;
        int inputVelocity = 1;
        // when I input and angle and a velocity of 1
        InputValidator inputValidator = new InputValidator();
        boolean result = inputValidator.validateAngleAndVelocityInput(inputAngle, inputVelocity);
        // then the output is true as 1 is in bounds
        assertTrue(result);
    }

    @Test
    public void AreMaxValuesValid() {
        // given I am a user
        int inputAngle = 90;
        int inputVelocity = 20;
        // when I input and angle of 90 and a velocity of 20
        InputValidator inputValidator = new InputValidator();
        boolean result = inputValidator.validateAngleAndVelocityInput(inputAngle, inputVelocity);
        // then the output is true as 1 is in bounds
        assertTrue(result);
    }


    @Test
    public void is0Valid() {
        // given I am a user
        int inputAngle = 0;
        int inputVelocity = 0;
        // when I input and angle and a velocity of 0
        IInputValidator mockInputValidator = mock(IInputValidator.class);
        boolean result = mockInputValidator.validateAngleAndVelocityInput(inputAngle, inputVelocity);
        // then the output is false as 0 is out of bounds
        assertFalse(result);
    }

    @Test
    public void AreValuesAboveMaxValid() {
        // given I am a user
        int inputAngle = 91;
        int inputVelocity = 21;
        // when I input and angle and a velocity of 0
        IInputValidator mockInputValidator = mock(IInputValidator.class);
        boolean result = mockInputValidator.validateAngleAndVelocityInput(inputAngle, inputVelocity);
        // then the output is false as 0 is out of bounds
        assertFalse(result);
    }
}
