package war.simulatore;

import java.util.Comparator;

import war.tank.Explorer;
import war.tank.Factory;
import war.tank.Shooter;
import war.tank.Factory.Fazione;

public class cmpStrategieDiCombattimento implements Comparator<Fazione> {

	public cmpStrategieDiCombattimento() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public int compare(Fazione o1, Fazione o2) {
		// TODO Auto-generated method stub
		if(o1 == o2)
			return 0;
		if((o1 == Factory.getFazione(Shooter.class)))
			return 1;
		return -1;
	}

}
