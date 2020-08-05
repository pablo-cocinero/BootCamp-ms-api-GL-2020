/**
 * 
 */
package mockito.example.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mockito.example.services.exceptions.ZeroDivisionException;
import mockito.example.services.impl.BasicOperationsServiceImpl;
import mockito.example.services.impl.CalculatorServiceImpl;
import mockito.example.services.impl.DataServiceImpl;


@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

	@InjectMocks
	private CalculatorServiceImpl calculator;
	@Mock
	private BasicOperationsService basicOperationsService;
	@Mock 
	static private DataService dataService;
	
	private static int[] array;
	
	@BeforeAll
	public static void setup() {
		array = new int[] {1,2,3,4,5};
	}

	
	@Test
	@DisplayName("Basic Operations Add")
	public void test_basicOperationsAdd()
	{		
		when(basicOperationsService.add(45, 70)).thenReturn(115.0);
		assertEquals(115.0, calculator.calculateSum(45, 70),0.1);
		verify(basicOperationsService).add(45, 70);
	}
	
	@Test
	@DisplayName("Basic Operations substraction")
	public void test_basicOperationsSub()
	{
		when(basicOperationsService.subtract(45, 12)).thenReturn(33.0);
		assertEquals(33.0, calculator.calculateSubstraction(45, 12),0.1);
		verify(basicOperationsService).subtract(45, 12);
	}
	
	@Test
	@DisplayName("Basic Operations Multiply")
	public void test_basicOperationsMul()
	{
		when(basicOperationsService.multiply(45, 3)).thenReturn(135.0);
		assertEquals(135.0, calculator.calculateMultiplication(45, 3),0.1);
		verify(basicOperationsService).multiply(45, 3);
	}
	
	@Test
	@DisplayName("Basic Operations Divide")
	public void test_basicOperationsDiv()
	{
		when(basicOperationsService.divide(45, 5)).thenReturn(9.0);
		try {
			assertEquals(9.0, calculator.calculateDivision(45, 5),0.1);
		} catch (ZeroDivisionException e) {
			e.printStackTrace();
		}
		verify(basicOperationsService).divide(45, 5);
	}
	
	@Test
	@DisplayName("Calculate Average")
	public void test_calculateAverage()
	{
		//when(dataService.getListOfNumbers()).thenReturn(new int[] {1,2,3,4,5});
		when(dataService.getListOfNumbers()).thenReturn(array);
		assertEquals(3,calculator.calculateAverage());
	}
	
	@Test
	@DisplayName("List of numbers return null")
	public void test_listReturnNull()
	{
		when(dataService.getListOfNumbers()).thenReturn(null);
		try {
		assertEquals(3,calculator.calculateAverage());
		}catch(NullPointerException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
	
	@Test
	@DisplayName("Divide by zero")
	public void test_divideByZero()
	{
		try {
			calculator.calculateDivision(45, 0);
		} catch (ZeroDivisionException e) {
			e.printStackTrace();
		}
		verify(basicOperationsService, never()).divide(45, 5);
	}
	
	@Test
	@DisplayName("Test print result")
	public void tst_printResult()
	{
		when(basicOperationsService.add(45, 70)).thenReturn(115.0);
		assertEquals("El resultado es: 115.0", calculator.printResult(calculator.calculateSum(45, 70)));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1,3,5,7,8,9})
	@DisplayName("Odd test")
	public void test_odd(int number) {
		assertEquals(0 != number%2,calculator.isOdd(number));
	}
	
	@Test
	public void test_espia()
	{
		BasicOperationsService basicService = new BasicOperationsServiceImpl();
		BasicOperationsService spyMyBasicService = spy(basicService);
		calculator.setBasicOperationsService(spyMyBasicService);
		
		calculator.calculateMultiplication(3, 4);
		
		verify(spyMyBasicService).multiply(3.0d, 4.0d);
	}
	
	@Test
	public void test_dataService()
	{
		DataServiceImpl dataService = new DataServiceImpl();
		DataServiceImpl spyDataService = spy(dataService);
		calculator.setDataService(spyDataService);
		
		when(spyDataService.getListOfNumbers()).thenReturn(new int[] {1,2,3,4,5,6});
		spyDataService.setListOfNumbers(new int[] {1,2,3,4,5});
		assertEquals(6,spyDataService.getListOfNumbers().length);
	}
	
}
