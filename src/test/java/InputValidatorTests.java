import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class InputValidatorTests {

    @Test
    public void is1Valid() {
        // given I am a user
        int inputAngle = 1;
        int inputVelocity = 1;
        // when I input and angle and a velocity of 1
        IInputValidator mockInputValidator = mock(IInputValidator.class);
        boolean result = mockInputValidator.validateAngleAndVelocityInput(inputAngle, inputVelocity);
        // then the output is true as 1 is in bounds
        assertTrue(result);
    }
}
