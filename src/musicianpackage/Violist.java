package musicianpackage;

import java.util.Arrays;
import java.util.List;

import containers.Piece;
import orchestrapackage.*;

public class Violist extends StringInstrumentMusician{
	@Override
	public String playPiece(Piece piece) {
		String partsStr = super.playPiece(piece);
		List<String> parts = Arrays.asList(partsStr.split("!"));
		
		if(piece.getChangeInTempo() == ChangeInTempo.Ritenuto) {
				for(int i=0; i<piece.getParts().size(); i++) 
					if(i>1)
						parts.set(i,"none");
		}
		
		
		//System.out.println("asdasdss: " + String.join("!",parts));
		return String.join("!",parts);
	}
	
}
