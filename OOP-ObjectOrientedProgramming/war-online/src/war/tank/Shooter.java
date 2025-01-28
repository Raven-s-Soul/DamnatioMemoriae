package war.tank;

import static war.costanti.CostantiSimulazione.PROBABILITA_SPARO;

import java.util.Set;

import war.Campo;
import war.Direzione;
import war.simulatore.GeneratoreCasuale;

public class Shooter extends Tank {

	public Shooter(Campo campo, Class<? extends Tank> tipo) {
		super(campo, tipo);
		// TODO Auto-generated constructor stub
	}

	public Shooter(Campo campo) {
		this(campo,Shooter.class);
	}

	@Override
	public boolean decideDiSparare(int passo) {
		// TODO Auto-generated method stub
		//return false;
		return GeneratoreCasuale.siVerificaEventoDiProbabilita(PROBABILITA_SPARO) ;
	}

	@Override
	public boolean decideDiCambiareDirezione(int passo) {
		// TODO Auto-generated method stub
		for(Direzione a : Direzione.tutte()) {
			if(a != this.getDirezione()) {
				return 0 != super.getCampo().rilevaTracciaVerso(getPosizione(), a);
			}
		}
		return false;
	}

	@Override
	public Direzione cambioDirezione(Set<Direzione> possibili) {
		// TODO Auto-generated method stub
		Direzione found = null;
		int max = 0;
		for(Direzione a : possibili ) {
			int nmax = super.getCampo().rilevaTracciaVerso(getPosizione(), a);
			if(nmax > max) {
				found = a;
				max = nmax;
			}
		}
		if(found != null)
			return found;
		else
			return Direzione.scegliAcasoTra(possibili);
	}

}
