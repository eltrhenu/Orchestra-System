package containers;

import java.util.*;

import orchestrapackage.*;

public class Part {
	private int no; //1st part, 2nd part ...
	private List<Score> scores;
	private Tempo tempo;
	
	public String toStringwBeat() {
		String part = "";
		for(int i=0; i<scores.size(); i++) {
			part += scores.get(i).toStringwBeat() + " ";
		}
		part += tempo;
		return part;
	}
	
	public String toString() {
		String part = "Part " + String.valueOf(this.no) + ": ";
		for(int i=0; i<scores.size(); i++) {
			part += scores.get(i).note + " ";
		}
		part += tempo;
		return part;
	}
	
	public Part() {
		throw new UnsupportedOperationException();
	}
	
	public Part(List<Score> scores, int no) {
		setScores(scores);
		setNo(no);
	}

	private void setScores(List<Score> scores) {
		this.scores = (List<Score>) new ArrayList<Score>(scores);	
	}
	
	public List<Score> getScores() {
		return (List<Score>) new ArrayList<Score>(scores);
	}
	
	public void setTempo(Tempo tempo) {
		this.tempo = tempo;
	}
	
	public Tempo getTempo() {
		return tempo;
	}
	
	private void setNo(int no) {
		this.no = no;
	}
	
	public int getNo() {
		return no;
	}
}
