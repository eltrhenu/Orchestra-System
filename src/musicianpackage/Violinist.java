package musicianpackage;

import java.util.Arrays;
import java.util.*;
import containers.*;
import orchestrapackage.Tempo;


public class Violinist extends StringInstrumentMusician{

	@Override
	public String playPiece(Piece piece) {
		// TODO Auto-generated method stub
		String partsStr = super.playPiece(piece);
		List<String> parts = Arrays.asList(partsStr.split("!"));
		for(int i=0; i<piece.getParts().size(); i++) {
			if(piece.getParts().get(i).getTempo() == Tempo.Prestissimo) {
				parts.set(i+1, "none");
			}
				
		}
		
		//System.out.println("asdasdss: " + String.join("!",parts));
		return String.join("!",parts);
		
	}
	
}
