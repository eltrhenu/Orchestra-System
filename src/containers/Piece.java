package containers;

import java.util.*;

import orchestrapackage.*;

public class Piece {
	private List<Part> parts;
	private ChangeInTempo changeInTempo;
	//TODO
	
	List<Integer> findChorus() {
		List<Integer> indexes = new ArrayList<Integer>();
		
		
		return indexes;
	}
	
	public Piece(List<Part> parts) {
		setParts(parts);
	}
	
	private void setParts(List<Part> parts){
		this.parts = parts;
	}
	
	public List<Part> getParts(){
		return (List<Part>) new ArrayList<Part>(parts);
	}
	
	public void setChangeInTempo(ChangeInTempo change) {
		changeInTempo = change;
	}
	
	public ChangeInTempo getChangeInTempo() {
		return changeInTempo;
	}
}
