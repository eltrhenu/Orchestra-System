package musicianpackage;

import containers.*;

public class StringInstrumentMusician implements Musician{

	@Override
	public String playPiece(Piece piece) {
		String parts = "";
		for(int i=0; i<piece.getParts().size(); i++)
			parts += "!" + piece.getParts().get(i).toString();
		
		//System.out.println("StringInst: " + parts);
		return parts;
	}

}
