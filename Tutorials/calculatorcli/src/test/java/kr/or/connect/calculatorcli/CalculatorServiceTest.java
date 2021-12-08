package kr.or.connect.calculatorcli;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class) // JUnit이 제공하는 Annotaion 확장기능
@ContextConfiguration(classes = {ApplicationConfig.class}) // Spring Bean Container가 사용할 파일 지정
public class CalculatorServiceTest {
	
	@Autowired // 자동적으로 할당하도록 설정
    CalculatorService calculatorService;

//    @Before
//    public void init(){
//        this.calculatorService = new CalculatorService();
//    }

    @Test
    public void plus() throws Exception{
        // given
        int value1 = 10;
        int value2 = 5;

        // when
        int result = calculatorService.plus(value1, value2);

        // then
        Assert.assertEquals(15, result); // 결과와 15가 같을 경우에만 성공
    }

    @Test
    public void divide() throws Exception{
        // given
        int value1 = 10;
        int value2 = 5;

        // when
        int result = calculatorService. divide (value1, value2);

        // then
        Assert.assertEquals(2,result); // 결과와 2가 같을 경우에만 성공
    }

    @Test
    public void divideExceptionTest() throws Exception{
        // given
        int value1 = 10;
        int value2 = 0;

        try {
            calculatorService.divide(value1, value2);
        }catch (ArithmeticException ae){
            Assert.assertTrue(true); // 이부분이 실행되었다면 성공
            return; // 메소드를 더이상 실행하지 않는다.
        }
        Assert.fail(); // 이부분이 실행되면 무조건 실패다.

    }
}