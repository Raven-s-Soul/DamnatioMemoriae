package war.tank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import war.Campo;

/** 
 * Controllare che questi test abbiano successo sia
 * prima che dopo aver operato le modifiche suggerite<BR/>
 */
public class TankTest {

	private Campo campo;
	
	@Before
	public void setUp() throws Exception {
		this.campo = new Campo();
		Factory.reset();
	}
	
	@After
	public void tearDown() throws Exception{
		Factory.reset();
	}

	@Test
	public void testIdProgressiviPerIlPrimoTipoDinamico() {
		//fail("COMPLETARE QUESTO TEST-CASE VEDI DOMANDA 2c");
		this.campo.getTank().add(new Explorer(campo));
		this.campo.getTank().add(new Explorer(campo));
		//this.campo.getTank().add(new Shooter(campo));
		assertEquals(campo.getTank().getFirst().getId(), 0);
		assertEquals(campo.getTank().getLast().getId(), 1);
	}

	@Test
	public void testIdProgressiviPerAltroTipoDinamico() {
		//fail("COMPLETARE QUESTO TEST-CASE VEDI DOMANDA 2c");
		this.campo.getTank().add(new Explorer(campo));
		this.campo.getTank().add(new Explorer(campo));
		this.campo.getTank().add(new Shooter(campo));
		this.campo.getTank().add(new Shooter(campo));
		assertEquals(campo.getTank().getFirst().getId(), 0);
		assertEquals(campo.getTank().getLast().getId(), 1);
	}

}
