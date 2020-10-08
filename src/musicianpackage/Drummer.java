package musicianpackage;

import java.util.Arrays;
import java.util.List;

import containers.Piece;
import orchestrapackage.Tempo;

public class Drummer extends PercussionInstrumentMusician{
	@Override
	public String playPiece(Piece piece) {
		String partsStr = super.playPiece(piece);
		List<String> parts = Arrays.asList(partsStr.split("!"));
		for(int i=0; i<piece.getParts().size(); i++) {
			Tempo tempo = piece.getParts().get(i).getTempo();
			if(!(tempo == Tempo.Prestissimo  || tempo == Tempo.Vivace || tempo == Tempo.Allegretto)) {
				parts.set(i+1, "none");
			}
				
		}
		
		for(int i=1; i<parts.size(); i++) {
			//System.out.println("Drumline is: " + parts.get(i));
			if(!parts.get(i).equals("none")) {
				parts.set(i,parts.get(i).replace('A','X').replace('B','X').replace('F','X').replace('G','X').replace('H','X'));
			}
			
		}
		
		//System.out.println("asdasdss: " + String.join("!",parts));
		return String.join("!",parts);
	}
}
