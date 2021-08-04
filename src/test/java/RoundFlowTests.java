import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class RoundFlowTests {

    IShotCounter mockShotCounter;
    ITargetGenerator mockTargetGenerator;
    IShot mockShot;
    IIntegerChecker mockIntegerChecker;
    IJudge mockJudge;
    IInputValidator mockInputValidator;
    IShotFlow mockShotFlow;
    IRoundFlow roundFlow;

    @BeforeEach
    public void setup() {
        mockShotCounter = mock(IShotCounter.class);
        mockTargetGenerator = mock(ITargetGenerator.class);
        mockShot = mock(IShot.class);
        mockIntegerChecker = mock(IIntegerChecker.class);
        mockJudge = mock(IJudge.class);
        mockInputValidator = mock(IInputValidator.class);
        mockShotFlow = mock(IShotFlow.class);
        roundFlow = new RoundFlow(mockShotCounter, mockTargetGenerator,
                mockShot, mockIntegerChecker, mockJudge, mockInputValidator, mockShotFlow);
    }

    @Test
    public void givenGameStartThenGetTarget() {
        //given: I start a game
        //when: I call flowClass method
        roundFlow.roundFlow("45", "1");
        //then: target method called once
        verify(mockTargetGenerator, times(1)).generateTarget();
    }

    @Test
    public void givenVelocityAndAngleThenShot() {
        //given: I enter a velocity and angle
        String velocity = "1";
        String angle = "45";
        //when: I call flowClass
        //then: shot method is called
        given(mockIntegerChecker.isInt(angle, velocity)).willReturn(true);
        System.out.println(roundFlow.roundFlow(angle, velocity));
        verify(mockShot, times(1)).calculateShot(45, 1);
    }

    @Test
    public void givenVelocityAndAngleThenIntCheck() {
        //given: i enter a velocity and angle
        String angle = "45";
        String velocity = "1";
        //when: I call flowClass
        roundFlow.roundFlow(angle, velocity);
        //then: IntegerChecker method is called
        verify(mockIntegerChecker, times(1)).isInt(angle, velocity);
    }

    @Test
    public void givenVelocityAndAngleThenCallJudgeMethod() {
        //given: i enter a velocity and angle
        String angle = "45";
        String velocity = "1";
        //when: I call flowClass
        roundFlow.roundFlow(angle, velocity);
        given(mockIntegerChecker.isInt(angle, velocity)).willReturn(true);
        given(mockInputValidator.validateAngleAndVelocityInput(45, 1)).willReturn(true);
        //then: the judge method is called
        int[] testShot = {1, 2};
        int[] testTarget = {1, 2};
        // todo: fix so judge method is called
        verify(mockJudge, times(1)).judgeShot(testShot, testTarget);
    }

    @Test
    public void givenHitThenReturnGetCounterMethod() {
        //Given: I have a shot that hits
        int[] testShot = {1, 2};
        int[] testTarget = {1, 2};
        //When: I call flowClass
        roundFlow.roundFlow("1" ,"1");
        given(mockJudge.judgeShot(testShot,testTarget)).willReturn(true);
        //Then: The get counter method is called 1 time
        verify(mockShotCounter, times(1)).getCounter();

    }

    @Test
    public void givenMissThenIncrementCounterMethod() {
        //Given: I have a miss
        int[] testShot = {2, 3};
        int[] testTarget = {1, 2};
        //When: I call flowClass
        roundFlow.roundFlow("1" ,"1");
        given(mockJudge.judgeShot(testShot,testTarget)).willReturn(false);
        //Then: The increment counter method is called 1 time
        verify(mockShotCounter, times(1)).incrementCounter();

    }


    @Test
    public void givenInvalidInputThenNeverCallJudgeMethod() {
        //given: i enter invalid angle and velocity
        String angle = "91";
        String velocity = "0";
        //when: I call flowClass
        given(mockInputValidator.validateAngleAndVelocityInput(91, 0)).willReturn(false);
        roundFlow.roundFlow(angle, velocity);
        //then: the judge method is never called
        int[] testShot = {1, 2};
        int[] testTarget = {1, 2};
        verify(mockJudge, never()).judgeShot(testShot, testTarget);
    }

    @Test
    public void givenInvalidInputThenNoShot() {
        //given: i enter an invalid velocity and angle
        String angle = "abc";
        String velocity = "def";
        //when: I call flowClass
        given(mockIntegerChecker.isInt(angle, velocity)).willReturn(false);
        roundFlow.roundFlow(angle, velocity);
        //then: the shot method is never called
        verify(mockShot, never()).calculateShot(91, 0);
    }
}
