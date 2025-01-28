package battlefield;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/* Modificare la classe Position affinche' 
 * il primo test abbia successo (vedi DOMANDA 1) 
 */
public class BattlefieldTest {
	
	private Battlefield field;
	
	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(2);
	}

	@Test
	public void testAddWalker() {
		assertEquals(0, this.field.getAllWalkers().size());
		this.field.addWalker(new Walker(new Position(0,0)));
		assertEquals(1, this.field.getAllWalkers().size());
	}
	
	@Test
	public void testRaggruppaRobotDiDueTipiDiversi() {
		
		field.addChaser(new Chaser(new Position(0,1)) );
		field.addChaser(new Chaser(new Position(1,1)) );
		field.addWalker(new Walker(new Position(1,0)) );
		field.addWalker(new Walker(new Position(2,2)) );
		assertEquals(2, this.field.getAllWalkers().size());
		assertEquals(2, this.field.getAllChasers().size());
		//fail("vedi DOMANDA 3");
	}
	
	
}
