package ant;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class AmbienteTest {

	//Set<Direzione> ant.Ambiente.getPossibiliDirezioni(Coordinate riferimento)
	
	
	private Ambiente ambiente;
	
	@Before
	public void SetUp() {
		this.ambiente = new Ambiente();
	}
	
	private Cibo creaCibo() {
		Random rnd = new Random();
		final Cibo cibo = new Cibo(new Coordinate(rnd.nextInt()%30, rnd.nextInt()%30));
		return cibo;
	}
	
	@Test
	void test(){
		
	}
}
