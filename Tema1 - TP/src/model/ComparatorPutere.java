package model;

import java.util.Comparator;

public class ComparatorPutere implements Comparator<Monom>{	

		@Override
		public int compare(Monom a, Monom b) {
			if (a.getPutere() < b.getPutere()){
				return 1;
			}
			else {
				return -1;
			}
		}

}

