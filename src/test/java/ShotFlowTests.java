import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class ShotFlowTests {

    IShot mockShot;
    IInputValidator mockInputValidator;
    IJudge mockJudge;
    IShotCounter mockShotCounter;
    IIntegerChecker mockIntegerChecker;
    IShotFlow shotFlow;

    @BeforeEach
    public void setup() {

        mockShot = mock(IShot.class);
        mockInputValidator = mock(IInputValidator.class);
        mockJudge = mock(IJudge.class);
        mockShotCounter = mock(IShotCounter.class);
        mockIntegerChecker = mock(IIntegerChecker.class);
        shotFlow = new ShotFlow (mockShot, mockInputValidator, mockJudge, mockShotCounter, mockIntegerChecker);


    }

    @Test
    public void givenValidShotCallShotCalculate1Time() {
        //Given: I have a valid shot
        String validAngle = "60";
        String validVelocity = "10";
        //When: I call the flow method in ShotFlow Class
        shotFlow.flow(validAngle, validVelocity);
        //Then: shot.calculate  is called 1 time
        given(mockIntegerChecker.isInt(validAngle, validVelocity)).willReturn(true);
        verify(mockShot, times(1)).calculateShot(60,10);
    }

    @Test
    public void givenValidShotCallJudgeShot1Time() {
        //Given: I have a valid shot
        String validAngle = "60";
        String validVelocity = "10";
        //When: I call the flow method in ShotFlowTests Class
        shotFlow.flow(validAngle, validVelocity);
        //Then: judge.judgeShot is called 1 time
        int[] testShot = {1, 2};
        int[] testTarget = {1, 2};
        verify(mockJudge, times(1)).judgeShot(testShot, testTarget);
    }

    @Test
    public void givenValidShotCallIncrementCounter1Time() {
        //Given: I have a valid shot
        String validAngle = "60";
        String validVelocity = "10";
        //When: I call the flow method in ShotFlowTests Class
        shotFlow.flow(validAngle, validVelocity);
        //Then: shotCounter.incrementCounter is called 1 time
        verify(mockShotCounter, times(1)).incrementCounter();
    }

    @Test
    public void givenHitCallGetCounter1Time() {
        //Given: I have a shot that hits the target
        String validAngle = "60";
        String validVelocity = "10";
        //When: I call the flow method in ShotFlowTests Class
        shotFlow.flow(validAngle, validVelocity);
        //Then: shotCounter.getCounter is called 1 time
        int[] testShot = {1, 2};
        int[] testTarget = {1, 2};
        given(mockJudge.judgeShot(testShot, testTarget)).willReturn(true);
        verify(mockShotCounter, times(1)).getCounter();
    }

    @Test
    public void givenInvalidShotCallShotCalculate1Time() {
        //Given: I have a invalid shot
        String inValidAngle = "91";
        String inValidVelocity = "21";
        //When: I call the flow method in ShotFlowTests Class
        shotFlow.flow(inValidAngle, inValidVelocity);
        //Then: shot.calculate is not called
        verify(mockShot, never()).calculateShot(91, 21);
    }

/*
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
        //Then: shotCounter.incrementCounter is not called
        verify(mockTargetGenerator).generateTarget();
    }
     */
}



