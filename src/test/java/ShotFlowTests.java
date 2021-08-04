import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;

public class ShotFlowTests {


    @BeforeEach
    public void setup() {


    }

    @Test
    public void givenValidShotCallShotCalculate1Time() {
        //Given: I have a valid shot
        //When: I call the flow method in ShotFlow Class
        cannonGameFlow.getTargetValues();
        //Then: shot.calculate  is called 1 time
        verify(mockTargetGenerator).generateTarget();
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



