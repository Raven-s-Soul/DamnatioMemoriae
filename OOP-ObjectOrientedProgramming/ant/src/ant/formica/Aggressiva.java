package ant.formica;
import static ant.costanti.CostantiGUI.IMMAGINE_FORMICA_ROSSA;
import java.awt.Image;
import java.util.Set;

import ant.Ambiente;
import ant.Direzione;

public class Aggressiva extends Formica {
	
	static private int progId=0;
	final private int id;
	
	public Aggressiva(Ambiente ambiente) {
		super(ambiente);
		this.id = Aggressiva.progId++;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_FORMICA_ROSSA;
	}

	@Override
	public Direzione cambioDirezione(Set<Direzione> possibili) {
		if(decideDiCambiareDirezione())
			return super.getAmbiente().getDirezioneCiboVicino(this.getPosizione());
		else
			return Direzione.scegliAcasoTra(possibili);
	}

	@Override
	public boolean deveCambiareDirezione(Set<Direzione> possibili) {
		return true;
	}

	@Override
	public boolean decideDiCambiareDirezione() {
		if(super.getAmbiente().getDirezioneCiboVicino(this.getPosizione()) == null)
			return false;
		else return true;
	}
	
}
