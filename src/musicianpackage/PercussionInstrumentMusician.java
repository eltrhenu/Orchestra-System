package musicianpackage;

import containers.Piece;

public class PercussionInstrumentMusician implements Musician{

	@Override
	public String playPiece(Piece piece) {
		String parts = "";
		int size = piece.getParts().size();
		for(int i=0; i<size; i++) {
			if((i==size-1) || (i == size-2))
				parts += "!" + piece.getParts().get(i).toString();
			else
				parts += "!none";
		}
		//System.out.println("StringInst: " + parts);
		return parts;
	}

}
