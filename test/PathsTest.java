import com.sun.scenario.effect.impl.state.LinearConvolveRenderState;
import org.junit.Test;
import path.TravelAgent;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class PathsTest{
    List<String> path = new ArrayList<String>();
	@Test
	public void test_should_give_true_for_banglore_to_singapore()throws Exception{
        TravelAgent agent = new TravelAgent();
		assertEquals(true, agent.hasFlightAvailable("Banglore", "Singapore"));
	}
	@Test
	public void test_should_give_false_for_banglore_to_tokyo()throws Exception{
        TravelAgent agent = new TravelAgent();
		assertEquals(false, agent.hasFlightAvailable("Banglore","Tokyo"));
	}
	@Test
	public void test_should_give_true_for_singapore_to_seoul()throws Exception{
        TravelAgent agent = new TravelAgent();
		assertEquals(true,agent.isThereAnyFlightAvailable(path,"Singapore", "Seoul"));
	}
	@Test
	public void test_should_give_true_for_singapore_to_dubai()throws Exception{
        TravelAgent agent = new TravelAgent();
		assertEquals(true,agent.hasFlightAvailable("Singapore","Dubai"));
	}
	@Test
	public void test_should_give_false_for_singapore_to_beijing()throws Exception{
        TravelAgent agent = new TravelAgent();
		assertEquals(false, agent.hasFlightAvailable("Singapore", "Beijing"));
	}
	@Test
	public void test_should_give_noCity_for_singapore_to_lucknow()throws Exception{
        TravelAgent agent = new TravelAgent();
		try{
			agent.hasFlightAvailable("Singapore","Lucknow");
		}
		catch(Exception e){
			assertEquals("Lucknow City not found", e.getMessage());
		}
	}
	@Test
	public void test_should_give_noCity_for_Lucknow_to_Bangalore(){
        TravelAgent agent = new TravelAgent();
		try{
			agent.hasFlightAvailable("Lucknow", "Bangalore");
		}
		catch(Exception e){
			assertEquals("Lucknow City not found", e.getMessage());
		}	
	}
	@Test
	public void TravelAgent_tells_that_their_any_path_btwn_Bangalore_to_Tokyo()throws Exception{
        TravelAgent agent = new TravelAgent();
		boolean predicate = agent.isThereAnyFlightAvailable(path,"Banglore", "Tokyo");
		assertEquals(true,predicate);
	}
	@Test
	public void paths_tell_that_their_any_path_btwn_Tokyo_to__Bangalore()throws Exception{
        TravelAgent agent = new TravelAgent();
		boolean predicate = agent.isThereAnyFlightAvailable(path,"Tokyo", "Banglore");
		assertEquals(false,predicate);
	}

	@Test
	public void paths_tell_that_their_any_path_From_Bangalore_to_Finland()throws Exception{
        TravelAgent agent = new TravelAgent();
		boolean predicate = agent.isThereAnyFlightAvailable(path,"Banglore", "Finland");
		assertEquals(true,predicate);
	}

	@Test
	public void paths_tell_that_their_any_path_From_Finland_to_Bangalore()throws Exception{
        TravelAgent agent = new TravelAgent();
		try{
			boolean predicate = agent.isThereAnyFlightAvailable(path,"China", "Banglore");
		}catch(Exception e){

			assertEquals("China city not found",e.getMessage());
		}
	}

}