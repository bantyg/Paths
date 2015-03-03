import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
public class PathsTest{
	@Test
	public void test_should_give_true_for_banglore_to_singapore()throws Exception{
		assertEquals(true, Paths.hasFlight("Banglore","Singapore"));
	}
	@Test
	public void test_should_give_false_for_banglore_to_tokyo()throws Exception{
		assertEquals(false, Paths.hasFlight("Banglore","Tokyo"));
	}
	@Test
	public void test_should_give_true_for_singapore_to_seoul()throws Exception{
		assertEquals(true,Paths.hasFlight("Singapore","Seoul"));
	}
	@Test
	public void test_should_give_true_for_singapore_to_dubai()throws Exception{
		assertEquals(true,Paths.hasFlight("Singapore","Dubai"));
	}
	@Test
	public void test_should_give_false_for_singapore_to_beijing()throws Exception{
		assertEquals(false, Paths.hasFlight("Singapore","Beijing"));
	}
	@Test
	public void test_should_give_noCity_for_singapore_to_lucknow()throws Exception{
		try{
			Paths.hasFlight("Singapore","Lucknow");
		}
		catch(Exception e){
			assertEquals("Lucknow City not found", e.getMessage());
		}
	}
	@Test
	public void test_should_give_noCity_for_Lucknow_to_Bangalore(){
		try{
			Paths.hasFlight("Lucknow", "Bangalore");
		}
		catch(Exception e){
			assertEquals("Lucknow City not found", e.getMessage());
		}	
	}
}