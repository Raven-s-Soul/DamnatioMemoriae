package battlefield;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class RobotOrdinatiPerPosizioneTest {

	// (vedi DOMANDA 5)
	private Battlefield field;

	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(10);
	}

	// scrivere dei test-case minimali per il metodo
	// Battlefield.getRobotOrdinatiPerPosizione()
	//public List<Robot> getRobotOrdinatiPerPosizione() {
	@Test
	public void testRobotOrdinatiCampoVuoto() {
		assertEquals(new ArrayList<Robot>() ,field.getRobotOrdinatiPerPosizione());
	}
	//(ii) campo contenente un singolo robot
	@Test
	public void testRobotOrdinati2() {
		Walker A = new Walker(new Position(2,2));
		field.addWalker(A);
		List<Robot> list = new ArrayList<>();
		list.add(A);
		assertEquals( list ,field.getRobotOrdinatiPerPosizione());
	}
	//(iii) campo contenente due robot in posizioni di X diversa
	@Test
	public void testRobotOrdinati3() {
		Walker A = new Walker(new Position(0,2));
		Walker B = new Walker(new Position(1,2));
		field.addWalker(A);
		field.addWalker(B);
		List<Robot> list = new ArrayList<>();
		list.add(A);
		list.add(B);
		assertEquals(list ,field.getRobotOrdinatiPerPosizione());
	}
	//(iv) campo contenente due robot in posizione di pari X ma Y diversa
	@Test
	public void testRobotOrdinati4() {
		Walker A = new Walker(new Position(1,1));
		Walker B = new Walker(new Position(1,2));
		field.addWalker(A);
		field.addWalker(B);
		List<Robot> list = new ArrayList<>();
		list.add(A);
		list.add(B);
		assertEquals(list ,field.getRobotOrdinatiPerPosizione());
	}
	//(v) campo contenente quattro robot
	@Test
	public void testRobotOrdinati5() {
		Walker A = new Walker(new Position(0,0));
		Walker B = new Walker(new Position(0,1));
		Walker C = new Walker(new Position(1,0));
		Walker D = new Walker(new Position(1,1));
		field.addWalker(A);
		field.addWalker(B);
		field.addWalker(C);
		field.addWalker(D);
		List<Robot> list = new ArrayList<>();
		list.add(A);
		list.add(B);
		list.add(C);
		list.add(D);
		assertEquals(list ,field.getRobotOrdinatiPerPosizione());
	}

}
