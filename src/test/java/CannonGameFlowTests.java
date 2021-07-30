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
        String velocity = "1";
        String angle = "45";
        //when: I call flowClass
        ITargetGenerator mockTargetGenerator = mock(ITargetGenerator.class);
        IShot mockShot = mock(IShot.class);
        IIntegerChecker mockIntegerChecker = mock(IIntegerChecker.class);
        ICannonGameFlow cannonGameFlow = new CannonGameFlow(mockTargetGenerator, mockShot, mockIntegerChecker);
        given(mockShot.calculateShot()).willReturn("");
        cannonGameFlow.flow(angle, velocity);
        //then: shot method is called
        verify(mockShot).calculateShot();
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

    //given: I have a valid shot
    //when: i call my flowClass method
    //then: the judge method is called

    //given: I have a miss
    //When: I call flowClass
    //then: 1 is added to the counter

    //given: I have a shot that hits
    //when: I call flowClass
    //then: the counter is returned

    //given: I have an invalid input
    //When: flowClass
    //Then: judge is never called

    //given: I have an invalid input
    //when: flowClass
    //then: Shot is never called

    //Given: i have an input for a shot
    //when: i call flow
    //then: judge is called
}
