import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
public class PathsTest{
	// PathDB db = new PathDB();
	// TravelAgent.data = db.createDB();

	@Test
	public void test_should_give_true_for_banglore_to_singapore()throws Exception{
		assertEquals(true, TravelAgent.hasFlightAvailable("Banglore","Singapore"));
	}
	@Test
	public void test_should_give_false_for_banglore_to_tokyo()throws Exception{
		assertEquals(false, TravelAgent.hasFlightAvailable("Banglore","Tokyo"));
	}
	@Test
	public void test_should_give_true_for_singapore_to_seoul()throws Exception{
		assertEquals(true,TravelAgent.hasFlightAvailable("Singapore","Seoul"));
	}
	@Test
	public void test_should_give_true_for_singapore_to_dubai()throws Exception{
		assertEquals(true,TravelAgent.hasFlightAvailable("Singapore","Dubai"));
	}
	@Test
	public void test_should_give_false_for_singapore_to_beijing()throws Exception{
		assertEquals(false, TravelAgent.hasFlightAvailable("Singapore","Beijing"));
	}
	@Test
	public void test_should_give_noCity_for_singapore_to_lucknow()throws Exception{
		try{
			TravelAgent.hasFlightAvailable("Singapore","Lucknow");
		}
		catch(Exception e){
			assertEquals("Lucknow City not found", e.getMessage());
		}
	}
	@Test
	public void test_should_give_noCity_for_Lucknow_to_Bangalore(){
		try{
			TravelAgent.hasFlightAvailable("Lucknow", "Bangalore");
		}
		catch(Exception e){
			assertEquals("Lucknow City not found", e.getMessage());
		}	
	}
	@Test
	public void TravelAgent_tells_that_their_any_path_btwn_Bangalore_to_Tokyo()throws Exception{
		boolean predicate = TravelAgent.isThereAnyFlightAvailable("Banglore","Tokyo");
		assertEquals(true,predicate);
	}
	@Test
	public void paths_tell_that_their_any_path_btwn_Tokyo_to__Bangalore()throws Exception{
		boolean predicate = TravelAgent.isThereAnyFlightAvailable("Tokyo","Banglore");
		assertEquals(false,predicate);
	}

	@Test
	public void paths_tell_that_their_any_path_From_Bangalore_to_Finland()throws Exception{
		boolean predicate = TravelAgent.isThereAnyFlightAvailable("Banglore","Finland");
		assertEquals(true,predicate);
	}

	@Test
	public void paths_tell_that_their_any_path_From_Finland_to_Bangalore()throws Exception{
		try{
			boolean predicate = TravelAgent.isThereAnyFlightAvailable("China","Banglore");
		}catch(Exception e){

			assertEquals("China city not found",e.getMessage());
		}
	}

}