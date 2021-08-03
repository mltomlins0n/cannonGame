import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class CannonGameFlowTests {

    IShotCounter mockShotCounter;
    ITargetGenerator mockTargetGenerator;
    IShot mockShot;
    IIntegerChecker mockIntegerChecker;
    IJudge mockJudge;
    IInputValidator mockInputValidator;
    ICannonGameFlow cannonGameFlow;

    @BeforeEach
    public void setup() {
        mockTargetGenerator = mock(ITargetGenerator.class);
        mockShot = mock(IShot.class);
        mockIntegerChecker = mock(IIntegerChecker.class);
        mockJudge = mock(IJudge.class);
        mockInputValidator = mock(IInputValidator.class);
        cannonGameFlow = new CannonGameFlow(mockShotCounter, mockTargetGenerator,
                mockShot, mockIntegerChecker, mockJudge, mockInputValidator);
    }

    @Test
    public void givenGameStartThenGetTarget() {
        //given: I start a game
        //when: I call flowClass method
        cannonGameFlow.getTargetValues();
        //then: target method called once
        verify(mockTargetGenerator).generateTarget();
    }

    @Test
    public void givenVelocityAndAngleThenShot() {
        //given: I enter a velocity and angle
        String angle = "45";
        String velocity = "1";
        //when: I call flowClass
        //then: shot method is called
        System.out.println(cannonGameFlow.flow(angle, velocity));
        // todo: fix IntegerChecker so it returns true for valid input
        verify(mockShot).calculateShot(45, 1);
    }

    @Test
    public void givenVelocityAndAngleThenIntCheck() {
        //given: i enter a velocity and angle
        String angle = "45";
        String velocity = "1";
        //when: I call flowClass
        cannonGameFlow.flow(angle, velocity);
        //then: IntegerChecker method is called
        verify(mockIntegerChecker).isInt(angle, velocity);
    }

    @Test
    public void givenVelocityAndAngleThenCallJudgeMethod() {
        //given: i enter a velocity and angle
        String angle = "45";
        String velocity = "1";
        //when: I call flowClass
        cannonGameFlow.flow(angle, velocity);
        given(mockIntegerChecker.isInt(angle, velocity)).willReturn(true);
        given(mockInputValidator.validateAngleAndVelocityInput(91, 0)).willReturn(true);
        //then: the judge method is called
        int[] testShot = {1, 2};
        int[] testTarget = {1, 2};
        // todo: fix so judge method is called
        verify(mockJudge).judgeShot(testShot, testTarget);
    }

    //given: I have a miss
    //When: I call flowClass
    //then: 1 is added to the counter

    //given: I have a shot that hits
    //when: I call flowClass
    //then: the counter is returned

    @Test
    public void givenInvalidInputThenNeverCallJudgeMethod() {
        //given: i enter invalid angle and velocity
        String angle = "91";
        String velocity = "0";
        //when: I call flowClass
        given(mockInputValidator.validateAngleAndVelocityInput(91, 0)).willReturn(false);
        cannonGameFlow.flow(angle, velocity);
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
        cannonGameFlow.flow(angle, velocity);
        //then: the shot method is never called
        verify(mockShot, never()).calculateShot(91, 0);
    }
}
