package org.openbravo.nlp.dataset;

import java.io.IOException;

import org.openbravo.nlp.loader.DataLoader;
import org.openbravo.nlp.model.NavarraLanParty;

public class NavarraLanPartyStore {

	private static NavarraLanParty nlp;
	
	protected static NavarraLanParty getNavarraLanParty() throws IOException {
		if (nlp == null) {
			DataLoader loader = new DataLoader();
			nlp = loader.loadNavarraLanParty();
		}
		return nlp;
	}
}
