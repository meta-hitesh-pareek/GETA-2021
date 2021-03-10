package GETA2021.DSA.DSAAssignment3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Test Method of Bowling
 * 
 *@since 11-03-2021
 * @author Hitesh Parek
 */
public class TestsForBowling {

	@Test
	public void test_When_ZeroIsPasses_Expected_NullQueueException() throws Exception {
		try {
			Bowling testBowling =new Bowling(0);
		}catch(NullQueueException e) {
			
		}
	}
	
	@Test
	public void test_When_ValidArgumentsPassed() throws Exception {
		Bowling testBowling =new Bowling(4);
		Bowler bowler1 =new Bowler(1,4);
		Bowler bowler2 =new Bowler(1,6);
		Bowler bowler3 =new Bowler(1,2);
		Bowler bowler4 =new Bowler(1,1);
		List<Bowler> bowlersList=testBowling.bowlersOrder(10);
		
		for(int index=0;index<bowlersList.size()-1;index++) {
			assertTrue(bowlersList.get(index).bowlsLeft>=bowlersList.get(index+1).bowlsLeft);
		}
	}
}
