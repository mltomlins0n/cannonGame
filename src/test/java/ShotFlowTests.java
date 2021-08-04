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
        shotFlow = new ShotFlow (mockShot, mockJudge, mockShotCounter);
    }

    @Test
    public void givenValidShotCallShotCalculate1Time() {
        //Given: I have a valid shot
        int validAngle = 60;
        int validVelocity = 10;
        int[] target = {1, 2};
        //When: I call the flow method in ShotFlow Class
        given(mockInputValidator.validateAngleAndVelocityInput( 60, 10)).willReturn(true);
        shotFlow.shotFlow(validAngle, validVelocity, target);
        //Then: shot.calculate  is called 1 time
        verify(mockShot, times(1)).calculateShot(60,10);
    }

    @Test
    public void givenValidShotCallJudgeShot1Time() {
        //Given: I have a valid shot
        int validAngle = 60;
        int validVelocity = 10;
        int[] target = {1, 2};
        int[] testShot = {1, 2};
        int[] testTarget = {1, 2};
        //When: I call the flow method in ShotFlowTests Class
        given(mockInputValidator.validateAngleAndVelocityInput( 60, 10)).willReturn(true);
        given(mockShot.calculateShot(60, 10)).willReturn(testShot);
        shotFlow.shotFlow(validAngle, validVelocity, target);
        //Then: judge.judgeShot is called 1 time
        verify(mockJudge, times(1)).judgeShot(testShot, testTarget);
    }

    @Test
    public void givenValidShotCallIncrementCounter1Time() {
        //Given: I have a valid shot
        int validAngle = 60;
        int validVelocity = 10;
        int[] target = {1, 2};
        //When: I call the flow method in ShotFlowTests Class
        given(mockInputValidator.validateAngleAndVelocityInput( 60, 10)).willReturn(true);
        shotFlow.shotFlow(validAngle, validVelocity, target);
        //Then: shotCounter.incrementCounter is called 1 time
        verify(mockShotCounter, times(1)).incrementCounter();
    }

    @Test
    public void givenHitCallGetCounter1Time() {
        //Given: I have a shot that hits the target
        int validAngle = 60;
        int validVelocity = 10;
        int[] target = {1, 2};
        //When: I call the flow method in ShotFlowTests Class
        //given(mockIntegerChecker.isInt(validAngle, validVelocity)).willReturn(true);
        int[] testShot = {1, 2};
        int[] testTarget = {1, 2};
        given(mockInputValidator.validateAngleAndVelocityInput( 60, 10)).willReturn(true);
        given(mockShot.calculateShot(60,10)).willReturn(testShot);
        given(mockJudge.judgeShot(testShot, testTarget)).willReturn(true);

        shotFlow.shotFlow(validAngle, validVelocity, target);
        //Then: shotCounter.getCounter is called 1 time
        verify(mockShotCounter, times(1)).getCounter();
    }

    @Test
    public void givenInvalidShotThenShotCalculateNeverCalled() {
        //Given: I have a invalid shot
        int invalidAngle = 91;
        int invalidVelocity = 21;
        int[] target = {1, 2};
        //When: I call the flow method in ShotFlowTests Class
        shotFlow.shotFlow(invalidAngle, invalidVelocity, target);
        //Then: shot.calculate is not called
        verify(mockShot, never()).calculateShot(91, 21);
    }

    @Test
    public void givenInvalidShotNeverCallJudgeShot() {
        //Given: I have a invalid shot
        int invalidAngle = 91;
        int invalidVelocity = 21;
        int[] target = {1, 2};
        int[] testShot = {91, 21};
        int[] testTarget = {91, 21};
        //When: I call the flow method in ShotFlowTests Class
        given(mockShot.calculateShot(91, 21)).willReturn(testShot);
        shotFlow.shotFlow(invalidAngle, invalidVelocity, target);
        //Then: judge.judgeShot is not called
        verify(mockJudge, never()).judgeShot(testShot, testTarget);
    }

    @Test
    public void givenInvalidShotNeverCallIncrementCounter() {
        //Given: I have a invalid shot
        int invalidAngle = 91;
        int invalidVelocity = 21;
        int[] target = {1, 2};
        int[] testShot = {91, 21};
        int[] testTarget = {91, 21};
        //When: I call the flow method in ShotFlowTests Class
        given(mockShot.calculateShot(91, 21)).willReturn(testShot);
        given(mockJudge.judgeShot(testShot, testTarget)).willReturn(false);
        shotFlow.shotFlow(invalidAngle, invalidVelocity, target);
        //Then: shotCounter.incrementCounter is not called
        verify(mockShotCounter, never()).incrementCounter();
    }

    @Test
    public void givenInvalidShotNeverCallGetCounter() {
        //Given: I have a invalid shot
        int invalidAngle = 91;
        int invalidVelocity = 21;
        int[] target = {1, 2};
        int[] testShot = {91, 21};
        int[] testTarget = {91, 21};
        //When: I call the flow method in ShotFlowTests Class
        given(mockShot.calculateShot(91, 21)).willReturn(testShot);
        given(mockJudge.judgeShot(testShot, testTarget)).willReturn(false);
        shotFlow.shotFlow(invalidAngle, invalidVelocity, target);
        //Then: shotCounter.getCounter is not called
        verify(mockShotCounter, never()).getCounter();
    }

}



