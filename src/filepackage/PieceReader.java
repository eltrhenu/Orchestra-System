package filepackage;

import java.io.*;
import java.util.*;
import containers.*;
import orchestrapackage.Maestro;

public class PieceReader {
	private File file;
	
	public PieceReader(File file) {
		setFile(file);
	}

	public PieceReader(String pathName) {
		File file = new File(pathName);
		
		setFile(file);
	}
	
	public Piece readPiece() {
		List<String> lines = FileIOManager.getLines(file.getName());
		List<Part> parts = new ArrayList<Part>();
		Maestro maestro = new Maestro();
		
		for(int i = 0; i < lines.size(); i++) {
			Part part = constructPart(lines.get(i), i + 1);
			part.setTempo(maestro.getTempo(part));
			parts.add(part);
		}
		
		return new Piece(parts);
		
	}
	
	private Part constructPart(String part, int partNo) {
		StringTokenizer tokenizer = new StringTokenizer(part, " ");
		List<Score> scores = new ArrayList<Score>();
		
		while(tokenizer.hasMoreTokens()) {
			Score score = constructScore(tokenizer.nextToken());
			
			scores.add(score);
		}
		
		return new Part(scores, partNo);
	}
	
	private Score constructScore(String score) {
		
		String note = score.substring(0,1);
		double beat = Double.parseDouble(score.substring(1));
		
		return new Score(note, beat);
	}
	
	public void setFile(File file) {
		this.file = file;
	}
}
