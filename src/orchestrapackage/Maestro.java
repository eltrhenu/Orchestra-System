package orchestrapackage;

import containers.*;
import java.util.*;

public class Maestro {
	
	public Tempo getTempo(Part part) {
		double numOfBeats = countBeats(part);
		Tempo result = determineTempo(numOfBeats);
		
		return result;
	}
	
	private Tempo determineTempo(double numOfBeats) {
		if(numOfBeats < 8)
			return Tempo.Prestissimo;
		else if(numOfBeats < 16)
			return Tempo.Vivace;
		else if(numOfBeats < 18)
			return Tempo.Allegretto;
		else if(numOfBeats < 22)
			return Tempo.Moderato;
		else if(numOfBeats < 23)
			return Tempo.Adagietto;
		else if(numOfBeats < 24)
			return Tempo.Andante;
		else if(numOfBeats < 27)
			return Tempo.Larghetto;
		else if(numOfBeats < 29)
			return Tempo.Lento;
		else if(numOfBeats < 33)
			return Tempo.Grave;
		else if(numOfBeats < 37)
			return Tempo.Larghissimo;
		else
			throw new IllegalArgumentException("Given part has more than 37 beats");
		
	}
	
	public ChangeInTempo getChangeInTempo(Piece piece) {
		double numOfBeats = countBeats(piece);
		ChangeInTempo result = determineChangeInTempo(numOfBeats);
		
		return result;
	}
	
	private ChangeInTempo determineChangeInTempo(double numOfBeats) {
		if(numOfBeats < 83) 
			return ChangeInTempo.Lentando;
		else if(numOfBeats < 125)
			return ChangeInTempo.Ritenuto;
		else if(numOfBeats < 132)
			return ChangeInTempo.Stretto;
		else if(numOfBeats < 152)
			return ChangeInTempo.Accelerando;
		else
			throw new IllegalArgumentException("Given piece has more than 152 beats.");
	}

	private double countBeats(Piece piece) {
		List<Part> parts = piece.getParts();
		double sum = 0;
		
		for(Part part : parts) {
			sum += countBeats(part);
		}
		
		return sum;
	}
	
	private double countBeats(Part part) {
		List<Score> scores = part.getScores();
		
		return countBeats(scores);
	}
	
	private double countBeats(List<Score> scores) {
		double sum = 0;
		
		for(Score score : scores) {
			sum += score.getBeat();
		}
		
		return sum;
	}
}
