import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ShotFlowTests {

    IShot mockShot;
    IInputValidator mockInputValidator;
    IJudge mockJudge;
    IShotCounter mockShotCounter;
    IShotFlow shotFlow;

    @BeforeEach
    public void setup() {

        mockShot = mock(IShot.class);
        mockInputValidator = mock(IInputValidator.class);
        mockJudge = mock(IJudge.class);
        mockShotCounter = mock(IShotCounter.class);
        shotFlow = new ShotFlow (mockShot, mockInputValidator, mockJudge, mockShotCounter);


    }

    @Test
    public void givenValidShotCallShotCalculate1Time() {
        //Given: I have a valid shot
        String validAngle = "60";
        String validVelocity = "10";
        //When: I call the flow method in ShotFlow Class
        shotFlow.flow(validAngle, validVelocity);
        //Then: shot.calculate  is called 1 time
        verify(mockShot).calculateShot(60,10);
    }


  /*  @Test
    public void givenValidShotJudgeShot1Time() {
        //Given: I have a valid shot
        //When: I call the flow method in ShotFlowTests Class
        cannonGameFlow.getTargetValues();
        //Then: judge.judgeShot is called 1 time
        verify(mockTargetGenerator).generateTarget();
    }


    @Test
    public void givenValidShotShotCounter1Time() {
        //Given: I have a valid shot
        //When: I call the flow method in ShotFlowTests Class
        cannonGameFlow.getTargetValues();
        //Then: shotCounter.incrementCounter is called 1 time
        verify(mockTargetGenerator).generateTarget();
    }


    @Test
    public void givenInvalidShotCallShotCalculate1Time() {
        //Given: I have a invalid shot
        //When: I call the flow method in ShotFlowTests Class
        cannonGameFlow.getTargetValues();
        //Then: shot.calculate is not called
        verify(mockTargetGenerator).generateTarget();
    }


    @Test
    public void givenInvalidShotJudgeShot1Time() {
        //Given: I have a invalid shot
        //When: I call the flow method in ShotFlowTests Class
        cannonGameFlow.getTargetValues();
        //Then: judge.judgeShot is not called
        verify(mockTargetGenerator).generateTarget();
    }

    @Test
    public void givenInvalidShotShotCounter1Time() {
        //Given: I have a invalid shot
        //When: I call the flow method in ShotFlowTests Class
        cannonGameFlow.getTargetValues();
        //Then: shotCounter.incrementCounter in not called
        verify(mockTargetGenerator).generateTarget();
    }
     */
}



