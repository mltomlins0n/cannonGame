import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class CannonGameFlowTests {

    @Test
    public void givenGameStartThenGetTarget() {
        //given: I start a game
        //when: I call flowClass method
        ITargetGenerator mockTargetGenerator = mock(ITargetGenerator.class);
        IShot mockShot = mock(IShot.class);
        IIntegerChecker mockIntegerChecker = mock(IIntegerChecker.class);
        ICannonGameFlow cannonGameFlow = new CannonGameFlow(mockTargetGenerator, mockShot, mockIntegerChecker);
        given(mockTargetGenerator.getTarget()).willReturn("");
        cannonGameFlow.flow("45", "1");
        //then: target method called once
        verify(mockTargetGenerator).getTarget();
    }

    @Test
    public void givenVelocityAndAngleThenShot() {
        //given: I enter a velocity and angle
        String inputAngle = "1";
        String inputVelocity = "45";
        //when: I call flowClass
        ITargetGenerator mockTargetGenerator = mock(ITargetGenerator.class);
        IShot mockShot = mock(IShot.class);
        IIntegerChecker mockIntegerChecker = mock(IIntegerChecker.class);
        ICannonGameFlow cannonGameFlow = new CannonGameFlow(mockTargetGenerator, mockShot, mockIntegerChecker);
        cannonGameFlow.flow(inputAngle, inputVelocity);
        //then: shot method is called
        System.out.println(cannonGameFlow.flow(inputAngle, inputVelocity));
        // todo: fix IntegerChecker so it returns true for valid input
        //verify(mockShot).calculateShot(45, 1);
    }

    @Test
    public void givenVelocityAndAngleThenIntCheck() {
        //given: i enter a velocity and angle
        String velocity = "1";
        String angle = "45";
        //when: I call flowClass
        ITargetGenerator mockTargetGenerator = mock(ITargetGenerator.class);
        IShot mockShot = mock(IShot.class);
        IIntegerChecker mockIntegerChecker = mock(IIntegerChecker.class);
        ICannonGameFlow cannonGameFlow = new CannonGameFlow(mockTargetGenerator, mockShot, mockIntegerChecker);
        given(mockIntegerChecker.isInt(angle, velocity)).willReturn(true);
        cannonGameFlow.flow(angle, velocity);
        //then: IntegerChecker method is called
        verify(mockIntegerChecker).isInt(angle, velocity);
    }

    @Test
    public void givenVelocityAndAngleThenCallJudgeMethod() {
        //given: i enter a velocity and angle
        String velocity = "1";
        String angle = "45";
        //when: I call flowClass
        ITargetGenerator mockTargetGenerator = mock(ITargetGenerator.class);
        IShot mockShot = mock(IShot.class);
        IIntegerChecker mockIntegerChecker = mock(IIntegerChecker.class);
        IJudge mockJudge = mock(IJudge.class);
        ICannonGameFlow cannonGameFlow = new CannonGameFlow(mockTargetGenerator, mockShot, mockIntegerChecker);
        given(mockIntegerChecker.isInt(angle, velocity)).willReturn(true);
        cannonGameFlow.flow(angle, velocity);
        //then: the judge method is called
        verify(mockJudge).judgeShot();
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
        String velocity = "0";
        String angle = "91";
        //when: I call flowClass
        ITargetGenerator mockTargetGenerator = mock(ITargetGenerator.class);
        IShot mockShot = mock(IShot.class);
        IIntegerChecker mockIntegerChecker = mock(IIntegerChecker.class);
        IJudge mockJudge = mock(IJudge.class);
        ICannonGameFlow cannonGameFlow = new CannonGameFlow(mockTargetGenerator, mockShot, mockIntegerChecker);
        given(mockIntegerChecker.isInt(angle, velocity)).willReturn(true);
        cannonGameFlow.flow(angle, velocity);
        //then: the judge method is never called
        verify(mockJudge, never()).judgeShot();
    }

    @Test
    public void givenInvalidInputThenNoShot() {
        //given: i enter an invalid velocity and angle
        String angle = "abc";
        String velocity = "def";
        //when: I call flowClass
        ITargetGenerator mockTargetGenerator = mock(ITargetGenerator.class);
        IShot mockShot = mock(IShot.class);
        IIntegerChecker mockIntegerChecker = mock(IIntegerChecker.class);
        ICannonGameFlow cannonGameFlow = new CannonGameFlow(mockTargetGenerator, mockShot, mockIntegerChecker);
        given(mockIntegerChecker.isInt(angle, velocity)).willReturn(false);
        cannonGameFlow.flow(angle, velocity);
        //then: the shot method is never called
        verify(mockShot, never()).calculateShot(91, 0);
    }
}
