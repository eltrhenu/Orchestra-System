package containers;

public class Score {
	String note;
	double beat;
	
	public String toStringwBeat() {
		String score = note + String.valueOf(beat);
		return score;
	}
	
	public Score() {
		throw new UnsupportedOperationException();
	}

	public Score(String note, double beat) {
		setNote(note);
		setBeat(beat);
	}
	
	public Score(Score other) {
		this(other.note, other.beat);
	}

	public String getNote() {
		return note;
	}

	private void setNote(String note) { //Immutable Object
		this.note = note;
	}

	public double getBeat() {
		return beat;
	}

	private void setBeat(double beat) { //Immutable Object
		this.beat = beat;
	}
}
