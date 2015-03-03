import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
public class PathsTest{
	@Test
	public void test_should_give_true_for_banglore_to_singapore()throws Exception{
		assertEquals(true, Paths.showResult("Banglore","Singapore"));
	}
	@Test
	public void test_should_give_false_for_banglore_to_tokyo()throws Exception{
		assertEquals(false, Paths.showResult("Banglore","Tokyo"));
	}
	@Test
	public void test_should_give_true_for_singapore_to_seoul()throws Exception{
		assertEquals(true,Paths.showResult("Singapore","Seoul"));
	}
	@Test
	public void test_should_give_true_for_singapore_to_dubai()throws Exception{
		assertEquals(true,Paths.showResult("Singapore","Dubai"));
	}
	@Test
	public void test_should_give_false_for_singapore_to_beijing()throws Exception{
		assertEquals(false, Paths.showResult("Singapore","Beijing"));
	}
	@Test
	public void test_should_give_noCity_for_singapore_to_lucknow()throws Exception{
		try{
			Paths.showResult("Singapore","Lucknow");
		}
		catch(Exception e){
			assertEquals("Lucknow City not found", e.getMessage());
		}
	}
	@Test
	public void test_should_give_noCity_for_Lucknow_to_Bangalore(){
		try{
			Paths.showResult("Lucknow", "Bangalore");
		}
		catch(Exception e){
			assertEquals("Lucknow City not found", e.getMessage());
		}	
	}
}