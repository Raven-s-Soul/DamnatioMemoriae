package battlefield;

import java.util.Comparator;

public class cmpRobotOrdinatiPerPosizione implements Comparator<Robot> {

	@Override
	public int compare(Robot o1, Robot o2) {
		// TODO Auto-generated method stub
		if(o1.getPosizione().getX()==o2.getPosizione().getX())
			return o1.getPosizione().getY()-o2.getPosizione().getY();
		return o1.getPosizione().getX()-o2.getPosizione().getX();
	}


}
