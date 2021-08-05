import org.junit.jupiter.api.*;

import java.io.*;

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

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setup() {
        mockShotCounter = mock(IShotCounter.class);
        mockTargetGenerator = mock(ITargetGenerator.class);
        mockShot = mock(IShot.class);
        mockIntegerChecker = mock(IIntegerChecker.class);
        mockJudge = mock(IJudge.class);
        mockInputValidator = mock(IInputValidator.class);
        mockShotFlow = mock(IShotFlow.class);
        roundFlow = new RoundFlow(mockTargetGenerator, mockIntegerChecker, mockInputValidator, mockShotFlow);
    }

    @BeforeEach
    public void setupOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInput() {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    public void givenGameStartThenGetTarget() {
        //given: I start a game
        String angle = "45";
        String velocity = "10";
        //when: I call flowClass method
        int[] testTarget = {1,2};
        given(mockTargetGenerator.generateTarget()).willReturn(testTarget);
        provideInput(angle + "\n" + velocity);
        given(mockIntegerChecker.isInt(angle, velocity)).willReturn(true);
        given(mockInputValidator.validateAngleAndVelocityInput(45, 10)).willReturn(true);
        given(mockShotFlow.shotFlow(45, 10, testTarget)).willReturn(true);

        roundFlow.roundFlow(angle, velocity);
        //then: target method called once
        verify(mockTargetGenerator, times(1)).generateTarget();
    }

    @Test
    public void givenVelocityAndAngleThenCallShotFlow() {
        //given: I enter a velocity and angle
        String velocity = "1";
        String angle = "45";
        //when: I call the shot flow class
        int[] testTarget = {1,2};
        given(mockTargetGenerator.generateTarget()).willReturn(testTarget);
        provideInput(angle + "\n" + velocity);
        given(mockIntegerChecker.isInt(angle, velocity)).willReturn(true);
        given(mockInputValidator.validateAngleAndVelocityInput(45, 10)).willReturn(true);
        given(mockShotFlow.shotFlow(45, 10, testTarget)).willReturn(true);

        roundFlow.roundFlow(angle, velocity);

        //then: shot flow is called 1 time
        verify(mockShotFlow, times(1)).shotFlow(45, 10, testTarget);
    }

    @Test
    public void givenVelocityAndAngleThenCallIntCheck() {
        //given: I enter a velocity and angle
        String angle = "45";
        String velocity = "1";
        //when: I call shot flow class
        int[] testTarget = {1,2};
        given(mockTargetGenerator.generateTarget()).willReturn(testTarget);
        provideInput(angle + "\n" + velocity);

        roundFlow.roundFlow(angle, velocity);
        //then: IntegerChecker method is called
        verify(mockIntegerChecker, times(1)).isInt(angle, velocity);
    }

    @Test
    public void givenInvalidInputThenShotFlowNeverCalled() {
        //given: I enter an invalid velocity and angle
        String angle = "abc";
        String velocity = "def";
        //when: I call the shot flow class
        int[] testTarget = {1,2};
        given(mockTargetGenerator.generateTarget()).willReturn(testTarget);
        provideInput(angle + "\n" + velocity);
        given(mockIntegerChecker.isInt(angle, velocity)).willReturn(false);

        roundFlow.roundFlow(angle, velocity);
        //then: the shot flow method is never called
        verify(mockShotFlow, never()).shotFlow(45, 10, testTarget);
    }
}
