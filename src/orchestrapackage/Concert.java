package orchestrapackage;

import java.util.*;

import containers.*;
import filepackage.*;
import musicianpackage.*;

public class Concert {
	List<Piece> pieces;
	Maestro maestro;
	List<Musician> musicians;
	
	public Concert(List<String> piecePathNames) {
		init(piecePathNames);
	}
	
	public void start() {
		//System.out.println("Change in Tempo: " + pieces.get(0).getChangeInTempo());
		Iterator<Piece> pieceItr = pieces.iterator();
		int counter = 1;
		while (pieceItr.hasNext()) {
			Piece piece = pieceItr.next();
			
			System.out.println("Piece " + String.valueOf(counter) + " is played " + piece.getChangeInTempo());
			
			String violinSheet = musicians.get(0).playPiece(piece);
			List<String> violinParts = Arrays.asList(violinSheet.substring(1).split("!"));
			
			String violaSheet = musicians.get(1).playPiece(piece);
			List<String> violaParts = Arrays.asList(violaSheet.substring(1).split("!"));
			
			String celloSheet = musicians.get(2).playPiece(piece);
			List<String> celloParts = Arrays.asList(celloSheet.substring(1).split("!"));
			
			String fluteSheet = musicians.get(3).playPiece(piece);
			List<String> fluteParts = Arrays.asList(fluteSheet.substring(1).split("!"));
			
			String drumSheet = musicians.get(4).playPiece(piece);
			List<String> drumParts = Arrays.asList(drumSheet.substring(1).split("!"));
			
			String bellSheet = musicians.get(5).playPiece(piece);
			List<String> bellParts = Arrays.asList(bellSheet.substring(1).split("!"));
			
			for(int i=0; i<piece.getParts().size(); i++) {
				if(!violinParts.get(i).equals("none")) 	
					System.out.println("Violin is played\n" + violinParts.get(i));
				
				if(!violaParts.get(i).equals("none"))
					System.out.println("Viola is played\n" + violaParts.get(i));
				
				if(!celloParts.get(i).equals("none"))
					System.out.println("Cello is played\n" + celloParts.get(i));
				
				if(!fluteParts.get(i).equals("none"))
					System.out.println("Flute is played\n" + fluteParts.get(i));
				
				if(!drumParts.get(i).equals("none"))
					System.out.println("Drum is played\n" + drumParts.get(i));
				
				if(!bellParts.get(i).equals("none"))
					System.out.println(bellParts.get(i));
			}
			System.out.println("\n");
			counter++;
		}
		
	}
	
	private void init(List<String> piecePathNames) {
		constructPieces(piecePathNames);
		constructMaestro();
		constructMusicians();
	}

	private void constructMusicians() {
		musicians = new ArrayList<Musician>();
		musicians.add(new Violinist());
		musicians.add(new Violist());
		musicians.add(new Celloist());
		musicians.add(new Flutist());
		musicians.add(new Drummer());
		musicians.add(new BellPlayer());
		//TODO
	}

	private void constructMaestro() {
		this.maestro = new Maestro();
	}

	private void constructPieces(List<String> piecePathNames) {
		List<Piece> pieces = new ArrayList<Piece>();
		Maestro maestro = new Maestro();
		
		for(String pathName : piecePathNames) {
			PieceReader reader = new PieceReader(pathName);
			Piece piece = reader.readPiece();
			
			piece.setChangeInTempo(maestro.getChangeInTempo(piece));
			pieces.add(piece);
		}
		
		this.pieces = pieces;
	}
	

	
	
}
