package orchestrapackage;

import java.util.Arrays;
import java.util.*;

public class ConcertApp {
	public static void main(String[] args) {
		List<String> piecePathNames = Arrays.asList("piece1.txt","piece2.txt","piece3.txt","piece4.txt");
		Concert concert = new Concert(piecePathNames);
		concert.start();
	}
}
