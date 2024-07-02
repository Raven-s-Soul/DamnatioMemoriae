package war.simulatore;


import java.util.*;

import war.Campo;
import war.Fortino;
import war.Proiettile;
import war.tank.Explorer;
import war.tank.Factory;
import war.tank.Shooter;
import war.tank.Factory.Fazione;
import war.tank.Tank;

public class Statistiche {

	synchronized public void stampaStatisticheFinali(Campo campo) {
		
		/* tutti i proiettili, di qualsiasi provenienza */
		final Set<Proiettile> proiettili = new HashSet<>();

		/* ELABORA STATISTICHE RAGGRUPPATE PER FORTINO */
		
		for(Fortino fortino : campo.getFortini()) {
			final Set<Proiettile> daQuestoFortino = fortino.getProiettili();
			proiettili.addAll(daQuestoFortino);
			System.out.println("******** "+fortino.getTipo().getSimpleName()+" *******");
			System.out.println("Proiettili sparati da "+fortino.getTipo().getSimpleName()+": " + daQuestoFortino.size());
			System.out.println();

			// (VEDI DOMANDE)
			System.out.println("Distrutti da tank proveniente da questo fortino:");
			final Map<Tank,Integer> tank2quantita = distruttiPerTank(daQuestoFortino);
			stampaDistruttiPerTank(tank2quantita);
			System.out.println();

			// (VEDI DOMANDE)
			System.out.println("Vulnerabilita' per fazione ai proiettili da questo fortino:");
			final Map<Fazione,Set<Proiettile>> tipo2vulnerabilita = vulnerabilitaPerTipo(daQuestoFortino);
			stampaProiettiliPerTipo(tipo2vulnerabilita);
			System.out.println();

			// (VEDI DOMANDE)
			System.out.println("Classifica delle fazioni per vulnerabilita' ai proiettili da questo fortino:");
			final List<Fazione> classificaVulnerabilita = ordinaStrategieDiCombattimento(tipo2vulnerabilita);
			stampaClassificaStrategie(classificaVulnerabilita,tipo2vulnerabilita);
			System.out.println();

		}
		System.out.println();
		System.out.println("*****************************");		
		
		/* ELABORA STATISTICHE COMPLESSIVE (TUTTI I FORTINI) */

		// (VEDI DOMANDE)
		System.out.println("Vulnerabilita' (tutti i proiettili) per tipologia:");
		final Map<Fazione,Set<Proiettile>> tipo2vulnerabilita = vulnerabilitaPerTipo(proiettili);
		stampaProiettiliPerTipo(tipo2vulnerabilita);
		System.out.println();

		// (VEDI DOMANDE)
		System.out.println("Classifica finale per vulnerabilita':");
		final List<Fazione> classificaVulnerabilita = ordinaStrategieDiCombattimento(tipo2vulnerabilita);
		stampaClassificaStrategie(classificaVulnerabilita,tipo2vulnerabilita);
		System.out.println("-----------------------------");
		System.out.println();

	}


	/**
	 * @param letali - insieme di proiettili che hanno distrutto unita' nemiche
	 * @return una mappa che conti per ogni tank quante unita' nemiche ha distrutto
	 */
	public Map<Tank, Integer> distruttiPerTank(Set<Proiettile> letali) {
		// DA COMPLETARE VEDI DOMANDA 3
		Map<Tank, Integer> map = new HashMap<>();
		for(Proiettile a : letali) {
			if(map.get(a.getLanciatore()) == null) {
				map.put(a.getLanciatore(), 1);
			}
			else {
				map.put(a.getLanciatore(), map.get(a.getLanciatore())+1 );
			}
		}
		return map;
	}


	/**
	 *  <EM>N.B. UTILE PER STAMPARE RISULTATI</EM>
	 * @param tank2numero
	 */
	private void stampaDistruttiPerTank(final Map<Tank, Integer> tank2numero) {
		for(Object tank : tank2numero.keySet()) {
			Integer numero = tank2numero.get(tank);
			if (numero==null)
				numero = 0;
			System.out.println("Il tank "+tank+" ha distrutto "+numero+" tank");
		}
	}

	/**
	 * @param letali - l'insieme di proiettili esplosi
	 * @return una mappa che riporta per ciascuna tipologia di tank 
	 *         quali proiettili li hanno colpiti
	 */
	public Map<Fazione, Set<Proiettile>> vulnerabilitaPerTipo(Set<Proiettile> letali) {
		// DA COMPLETARE VEDI DOMANDA 4
		Map<Fazione, Set<Proiettile>> map = new HashMap<>();
		
		//Set<Class<? extends Tank>> h = Factory.getSingleton().getAllTipiDiTank();
		//for(Class<? extends Tank> g : h) {
			//map.put( Factory.getSingleton().getFazione(g)  , new HashSet<Proiettile>() );
		//}
		//Factory.getFazione(Explorer.class);
		//Factory.getFazione(Shooter.class);
		map.put( Factory.getFazione(Explorer.class)  , new HashSet<Proiettile>() );
		map.put( Factory.getFazione(Shooter.class)  , new HashSet<Proiettile>() );
		
		for(Proiettile a : letali) {
			if(a.getDistrutto()!=null)
				map.get( Factory.getFazione(a.getDistrutto().getClass()) ).add(a);
		}
		
		
		return map;
	}
	
	/**
	 *  <EM>N.B. UTILE PER STAMPARE RISULTATI</EM>
	 * @param tipo2proiettili
	 */
	private void stampaProiettiliPerTipo(final Map<Fazione, Set<Proiettile>> tipo2proiettili) {
		if (tipo2proiettili==null) return;

		for(Fazione fazione : tipo2proiettili.keySet()) {
			Set<Proiettile> proiettili = tipo2proiettili.get(fazione);
			System.out.println("Tank "+fazione+" -- "+proiettili.size());
		}
	}

	/**
	 * @param c2p una mappa che per ogni tipologia di tank riporta i proiettili che li hanno colpiti
	 * @return una lista ordinata degli oggetti {@link Class} associati ai diversi tipi di {@link Tank}
	 */
	public List<Fazione> ordinaStrategieDiCombattimento(final Map<Fazione, Set<Proiettile>> c2p) {
		// DA COMPLETARE VEDI DOMANDA 5
		
		//TODO Onesto non ho capito cosa vuole che faccio :palmface:
		List<Fazione> list = new ArrayList<>();
		list.addAll(c2p.keySet());
		cmpStrategieDiCombattimento cmp = new cmpStrategieDiCombattimento();
		list.sort(cmp);
		//for(Fazione a :c2p.keySet()) {
		//	vulnerabilitaPerTipo(c2p.get(a));
		//}
		
		//vulnerabilitaPerTipo(c2p.get(Factory.getFazione(Shooter.class)));
		//vulnerabilitaPerTipo(c2p.get(Factory.getFazione(Explorer.class)));
		return list;
	}

	/**
	 * <EM>N.B. UTILE PER STAMPARE RISULTATI</EM>
	 * @param classifica
	 * @param tipo2proiettili
	 */
	private void stampaClassificaStrategie(List<Fazione> classifica, Map<Fazione, Set<Proiettile>> tipo2proiettili) {
		if (classifica==null) return;

		for(int i=1; i<classifica.size()+1; i++) {
			final Fazione fazione = classifica.get(i-1);
			final Set<Proiettile> set = tipo2proiettili.get(fazione);
			final int size = ( set==null ? 0 : set.size() );
			System.out.println(i+") "+fazione+" -- "+size);
		}
	}
}
