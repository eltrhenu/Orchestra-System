package musicianpackage;

import java.util.Arrays;
import java.util.List;

import containers.Piece;
import orchestrapackage.ChangeInTempo;
import orchestrapackage.Tempo;

public class BellPlayer extends PercussionInstrumentMusician{
	@Override
	public String playPiece(Piece piece) {
		String partsStr = super.playPiece(piece);
		List<String> parts = Arrays.asList(partsStr.split("!"));
		for(int i=0; i<piece.getParts().size(); i++) {
			Tempo tempo = piece.getParts().get(i).getTempo();
			ChangeInTempo changeInTempo = piece.getChangeInTempo();
			if(!(tempo == Tempo.Grave  && changeInTempo == ChangeInTempo.Stretto)) {
				parts.set(i+1, "none");
			}
				
		}
		
		for(int i=1; i<parts.size(); i++) {
			//System.out.println("Drumline is: " + parts.get(i));
			if(!parts.get(i).equals("none")) {
				parts.set(i,parts.get(i).replace('C','X').replace('D','X').replace('E','X').replace('H','X'));
			}
			
		}
		
		//System.out.println("asdasdss: " + String.join("!",parts));
		return String.join("!",parts);
	}
}
