/*
 * CriticComparator
 * 
 */
package ar.com.infocompany.model;

import java.util.Comparator;

public class CriticComparator implements Comparator<Critic> {

	public int compare(Critic c1, Critic c2) {
		int result = 0;
		if (c1.getCriticScore() < c2.getCriticScore()) {
			result = -1;
		} else if (c1.getCriticScore() > c2.getCriticScore()) {
			result = 1;
		}
		return result;
	}

}

// eof
