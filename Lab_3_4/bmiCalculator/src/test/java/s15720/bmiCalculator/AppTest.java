package s15720.bmiCalculator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import s15720.model.HealthResult;
import s15720.model.HealthResultTimeDTO;
import s15720.model.HealthResultsOwner;
import s15720.repository.HealthResultDao;
import s15720.service.HealthResultFactory;
import s15720.service.HealthResultsListService;

@RunWith(MockitoJUnitRunner.class)
public class AppTest 
{
	private CalculateBmi calculateBMI;
	private CalculateBmi displayBMI;
	private CalculateBmi calculateBHC;
    
	private HealthResultDao repository = HealthResultDao.getInstance();
    private HealthResultsListService healthResultsListService = new HealthResultsListService();

    @Mock
    private HealthResultTimeDTO healthResultTimeDTO;
    @Mock
    private HealthResultsListService healthResultsListServiceMock;
    @Mock
    private HealthResult resultMock;
    
	@Before
	public void setUp() {
		calculateBMI = new CalculateBmi();
		displayBMI = new CalculateBmi();
		calculateBHC = new CalculateBmi();
		 repository.collectionAccess().add(new HealthResult(1, "BMI", 24.69f));
	     repository.collectionAccess().add(new HealthResult(2, "BMI", 19.53f));
	     repository.collectionAccess().add(new HealthResult(3, "BMI", 18.53f));
	     repository.collectionAccess().add(new HealthResult(4, "BMR", 1335.73f));
	     repository.collectionAccess().add(new HealthResult(5, "BMR", 1435.73f));
		
	}
	
	@After
	public void tearDown() {
		calculateBMI = null;
		displayBMI = null;
		calculateBHC = null;
		repository.setHealthResultsList(new ArrayList<>());
	}
	
	
	@Test
    public void bmi_isCorrect() {
        float result = calculateBMI.CalculateBMI(182.0f, 80.0f, 20.0f);
		assertEquals(24.151672f, result, 0);
		System.out.println("Test bmi_isCorrect result: " + result);
    }
	
	@Test
	public void bmiDataIsNotNull() {
		float result = calculateBMI.CalculateBMI(182.0f, 80.0f, 20.0f);
		assertNotNull("Result ", result);
	}
	
	@Test
	public void bmiInfo_isCorrect() {
		String result = displayBMI.DisplayBMI(26.0f);
		assertEquals("nadwaga", result);
	}
	
	//New
	
	@Test
    public void bhc_isCorrect() {
        float result = calculateBHC.CalculateBHC("160", "50", "20", "female");
		assertEquals(1335.73f, result, 0);
		System.out.println("Test bhc_isCorrect result: " + result);
    }
	
	@Test
	public void bhcDataIsNotNull() {
		float result = calculateBHC.CalculateBHC("160", "50", "20", "male");
		assertNotNull("Result ", result);
	}
	
    @Test
    public void addHealthResultToList_correct_case() {
        int healthResultCountBeforeAdd = repository.collectionAccess().size();
        healthResultsListService.addHealthResultToList(new HealthResult(6, "BHC", 1339.5f));
        Assert.assertEquals(healthResultCountBeforeAdd + 1, repository.collectionAccess().size());
    }
	
    @Test
    public void getHealthResultById_correct_case() {
    	HealthResult result = healthResultsListService.getResultById(1);
        Assert.assertEquals(result.getResultName(), "BMI");
    }
	
    @Test(expected = NoSuchElementException.class)
    public void getHealthResultById_NoSuchElementException_expected() {
    	HealthResult result = healthResultsListService.getResultById(19);
    }
    
    @Test
    public void deleteHealthResulById_correct_case() {
        int elementNumbersBeforeTest = repository.collectionAccess().size();
        Assert.assertTrue(healthResultsListService.deleteHealthResultById(1));
        Assert.assertEquals(elementNumbersBeforeTest, repository.collectionAccess().size() + 1);
    }
    
    @Test
    public void deleteHealthResulById_no_element_to_delete() {

        Assert.assertFalse(healthResultsListService.deleteHealthResultById(99));
    }
    
    @Test
    public void getAllHealthResult_correct_case() {
        List<HealthResult> result = healthResultsListService.getAllHealthResults();
        Assert.assertEquals(result.size(), 5);
    }
    
    @Test
    public void updateHealthResult_correct_case() {

    	HealthResult result = new HealthResult(99, "BMI", 29.45f);
    	result.setDone(true);
    	HealthResult resultToUpdate = healthResultsListService.getResultById(1);
    	result.setHealthResultsOwner(new HealthResultsOwner((long) 1,"Adam","Adamowicz", "asd@wp.pl", true));
    	healthResultsListService.updateHealthResult(1, result);

        Assert.assertEquals(resultToUpdate.getResultName(), result.getResultName());
        Assert.assertEquals(resultToUpdate.isDone(), result.isDone());
    }

    @Test(expected = NoSuchElementException.class)
    public void updateHealthResult_NoSuchElementException_expected() {

    	HealthResult result = new HealthResult(99, "BHC", 1200.45f);
    	result.setDone(true);
    	result.setHealthResultsOwner(new HealthResultsOwner((long) 1,"Adam","Adamowicz", "qwerty@wp.pl" ,true));
    	healthResultsListService.updateHealthResult(98, result);
    	

    }
    
    @Test(expected = WrongInputParametersException.class)
    public void validateResultNameInput_blankResult_case() {
    	
        healthResultsListService.validateResultNameInput("   ");
        
    }
    
    @Test(expected = WrongInputParametersException.class)
    public void validateResultInput_result_0_case() {
    	
        healthResultsListService.validateResultInput(0f);
        
    }
    
    @Test(expected = WrongInputParametersException.class)
    public void validateEmailInput_wrongEmail_case() {
    	
        healthResultsListService.validateEmailInput("zly_email");
        
    }
    
    @Test
    public void validateEmailInput_correct_case() {
    	
        healthResultsListService.validateEmailInput("asd@wp.pl");
        
    }
    
    @Test
    public void readDataOnGetObject_correct_case() {
        LocalDateTime time = LocalDateTime.now();
        when(healthResultsListServiceMock.getResultById(1)).thenReturn(resultMock);
        when(healthResultsListServiceMock.getResultById(1).getLastReadTime()).thenReturn(time);

        Assert.assertEquals(healthResultsListServiceMock.getResultById(1).getLastReadTime(), time);
    }
    
    @Test
    public void readDataOnGetObject_wrong_case() {
        ZoneId zone2 = ZoneId.of("Brazil/East");

        LocalDateTime time = LocalDateTime.now();
        LocalDateTime timeBrazil = LocalDateTime.now(zone2);
        
        when(healthResultsListServiceMock.getResultById(1)).thenReturn(resultMock);
        when(healthResultsListServiceMock.getResultById(1).getLastReadTime()).thenReturn(timeBrazil);

        Assert.assertNotEquals(healthResultsListServiceMock.getResultById(1).getLastReadTime(), time);
    }
    
    @Test
    public void addedDateDuringAddToCollection_correct_case() {
    	healthResultsListServiceMock.addHealthResultToList(HealthResultFactory.create(55, "BMR", 1235.73f));
        LocalDateTime time = LocalDateTime.now();

        when(healthResultsListServiceMock.getResultById(55)).thenReturn(resultMock);

        when(healthResultsListServiceMock.getResultById(55).getLastReadTime()).thenReturn(time);
        Assert.assertEquals(healthResultsListServiceMock.getResultById(55).getLastReadTime(), time);
    }
    
    @Test
    public void updatedDateDuringUpdateObject_correct_case() {
        LocalDateTime time = LocalDateTime.now();
        when(healthResultTimeDTO.getUpdatedTime()).thenReturn(time);

        HealthResult result = healthResultsListService.updateHealthResult(1, healthResultsListService.getResultById(2));
        Assert.assertEquals(healthResultTimeDTO.getUpdatedTime(), time);
    }

    @Test
    public void updatedDateDuringUpdateObject_wrong_case() {
        ZoneId zone2 = ZoneId.of("Brazil/East");
        LocalDateTime timeBrazil = LocalDateTime.now(zone2);
        LocalDateTime time = LocalDateTime.now();
        
        when(healthResultTimeDTO.getUpdatedTime()).thenReturn(timeBrazil);

        HealthResult result = healthResultsListService.updateHealthResult(1, healthResultsListService.getResultById(2));
        Assert.assertNotEquals(healthResultTimeDTO.getUpdatedTime(), time);
    }
    
    @Test
    public void getTimesByResultId() {
        ZoneId zone2 = ZoneId.of("Brazil/East");
        LocalDateTime timeBrazil = LocalDateTime.now(zone2);
    	LocalDateTime time = LocalDateTime.now();
    	
    	HealthResultTimeDTO result = new HealthResultTimeDTO(time, timeBrazil, time);
        when(healthResultsListServiceMock.getTimesById(1)).thenReturn(result);
        Assert.assertNotNull(healthResultsListServiceMock.getTimesById(1));
    }
    
	 
}
