package battlefield;

import java.util.*;

public class Battlefield {

	static final private Class<?>[] TIPOLOGIE = { Walker.class, Chaser.class } ;

	static final private int NUMERO_TIPOLOGIE = TIPOLOGIE.length;

	static final private double OCCUPAZIONE_INIZIALE = 0.01d; // 1%

	private int dim;

	private Random random;
	
	private Map<Position, Robot> posizione2robot;
	//private Map<Position, Walker> posizione2walker;
	//private Map<Position, Chaser> posizione2chaser;

	public Battlefield(int dimensione) {
		this.dim = dimensione;
		//this.posizione2walker = new HashMap<>();
		//this.posizione2chaser = new HashMap<>();
		this.posizione2robot = new HashMap<>();
		this.random = new Random();
	}

	public void addWalker(Walker w) {
		// (vedi DOMANDA 1)
		//posizione2walker.put(w.getPosizione(), w);
		posizione2robot.put(w.getPosizione(), w);
	}

	public void addChaser(Chaser c) {
		// (vedi DOMANDA 1)
		//posizione2chaser.put(c.getPosizione(), c);
		posizione2robot.put(c.getPosizione(), c);
	}

	public Walker getWalker(Position p) {
		if (posizione2robot.get(p) instanceof Walker) 
			return (Walker) posizione2robot.get(p);
		return null;
	}

	public Chaser getChaser(Position p) {
		if (posizione2robot.get(p) instanceof Chaser) 
			return (Chaser) posizione2robot.get(p);
		return null;
	}

	public Collection<? extends Robot> getAllWalkers() {
		@SuppressWarnings("rawtypes")
		Map<Class, Set<Robot>> map = raggruppaRobotPerTipo();
		if(map.get(Walker.class) == null) {
			Set<Robot> b = new HashSet<>();
			return b;
		}
		return map.get(TIPOLOGIE[0]);
	}

	public Collection<? extends Robot> getAllChasers() {
		@SuppressWarnings("rawtypes")
		Map<Class, Set<Robot>> map = raggruppaRobotPerTipo();
		if(map.get(TIPOLOGIE[1]) == null) {
			Set<Robot> b = new HashSet<>();
			return b;
		}
		return map.get(TIPOLOGIE[1]);
	}

	@SuppressWarnings("rawtypes")
	public Map<Class, Set<Robot>> raggruppaRobotPerTipo() {
		// (vedi DOMANDA 3)
		Map<Class, Set<Robot>> map = new HashMap<>();
		
		for( Robot a : posizione2robot.values()) {
			if( map.get(a.getClass())  == null) {
				map.put(a.getClass(), new HashSet<Robot>());
				map.get(a.getClass()).add(a);
			}
			map.get(a.getClass()).add(a);
			//System.out.println(TIPOLOGIE[1]);
			//System.out.println(TIPOLOGIE[0]);
			//System.out.println(a.getClass());
		}
		return map;
	}
	
	public List<Robot> getRobotOrdinatiPerPosizione() {
		// (vedi DOMANDA 4)
		cmpRobotOrdinatiPerPosizione cmp = new cmpRobotOrdinatiPerPosizione();
		List<Robot> lista = new ArrayList<>(this.posizione2robot.values());
		//lista.sort(cmp);
		Collections.sort(lista,cmp);
		return lista;
	}
	
	public SortedSet<Robot> getRobotOrdinatiPerLongevita() {
		
		SortedSet<Robot> set = new TreeSet<>();
		set.addAll(posizione2robot.values());
		
		// (vedi DOMANDA 6)
		return set;
	}
	
	public List<Position> adiacenti(Position perno) {
		final List<Position> adiacenti = new LinkedList<>();
		int x = perno.getX();
		int y = perno.getY();

		for(int i = -1; i<2; i++) {
			for(int j = -1; j<2; j++) {
				Position adiacente = new Position(x+i, y+j);
				if (inCampo(adiacente))
					adiacenti.add(adiacente);
			}
		}
		adiacenti.remove(perno);  // coincidono: quindi non sono adiacenti
		
		Collections.shuffle(adiacenti); /* ordine casuale */
		return adiacenti;
	}

	private boolean inCampo(Position p) {
		return  p.getX()>=0 && p.getX()<this.dim && 
				p.getY()>=0 && p.getY()<this.dim  ;
				
	} 

	public Position posizioneLiberaVicino(Position posizione) {
		for(Position p : this.adiacenti(posizione)) {
			if (this.isLibera(p)) {
				return p;
			}
		}
		return null;
	}

	public boolean isLibera(Position posizione) {
		return ( this.getWalker(posizione)==null && this.getChaser(posizione)==null);
	}

	public int getDimensione() {
		return this.dim;
	}

	public void riempi() {
		long numeroIniziale = Math.round(OCCUPAZIONE_INIZIALE * dim * dim);
		for(int i=0 ; i<numeroIniziale; i++) {
			int x = this.random.nextInt(this.dim);
			int y = this.random.nextInt(this.dim);
			Position posizione = new Position(x, y);
			if (this.isLibera(posizione)) {
				switch (this.random.nextInt(NUMERO_TIPOLOGIE)) {
				case 0: Chaser chaser = new Chaser(posizione);
						this.addChaser(chaser);
				break;
				case 1: Walker walker = new Walker(posizione);
						this.addWalker(walker);
				break;
				//case: NUMERO_TIPOLOGIE-1...
				default: throw new IllegalStateException();
				} 
			}
		}
	}

}
