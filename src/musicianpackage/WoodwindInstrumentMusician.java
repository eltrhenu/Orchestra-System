package musicianpackage;

import containers.Piece;

public class WoodwindInstrumentMusician implements Musician{

	public int haveChorus(Piece piece) {
		int index = -1;
		for(int i=0; i<piece.getParts().size(); i++) {
			for(int j=i+1; j<piece.getParts().size(); j++) {
				if(piece.getParts().get(i).toStringwBeat().equals(piece.getParts().get(j).toStringwBeat())) {
					index = i;
					return index;
				}
			}
		}
		
		return index;
	}
	@Override
	public String playPiece(Piece piece) {
		int index = haveChorus(piece);
		System.out.println("Index: " + String.valueOf(index));
		String whole = "";
		if(index != -1) { // There is chorus
			for(int i=0; i<piece.getParts().size(); i++) {
				if(piece.getParts().get(index).toStringwBeat().equals(piece.getParts().get(i).toStringwBeat()))
					whole = whole + "!" + piece.getParts().get(i).toString();
				else
					whole += "!none";
			}
				
		}
		
		else { // no chorus
			for(int i=0; i<piece.getParts().size(); i++)
				whole += "!none";
		}
		
		return whole;
	}

}
