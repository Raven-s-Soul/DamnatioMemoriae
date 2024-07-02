package war.tank;

import war.simulatore.GeneratoreCasuale;
import static war.costanti.CostantiSimulazione.*;
import static war.simulatore.GeneratoreCasuale.siVerificaEventoDiProbabilita;


//import java.awt.Image;
import java.util.Set;

import war.Campo;
import war.Direzione;
//import war.tank.Factory.Fazione;

public class Explorer extends Tank {

	public Explorer(Campo campo) {
		super(campo, Explorer.class );
		// TODO Auto-generated constructor stub
	}

	public boolean decideDiSparare(int passo) {
		return GeneratoreCasuale.siVerificaEventoDiProbabilita(PROBABILITA_SPARO) ;
	}

	public boolean decideDiCambiareDirezione(int passo) {
		return (siVerificaEventoDiProbabilita(PROBABILITA_CAMBIO_DIREZIONE) ) ;
	}

	public Direzione cambioDirezione(Set<Direzione> possibili) {
		return Direzione.scegliAcasoTra(possibili);
	}
	
	/*
	 * public Image getImage() {
	 
		final Fazione fazione = Factory.getFazione(this.getClass());
        return fazione.getTankImage();
	}
	*/
	
}
