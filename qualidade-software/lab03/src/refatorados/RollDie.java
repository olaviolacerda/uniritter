package refatorados;

import java.util.Random;

public class RollDie {
	private static final int NUMBER_OF_FACES = 20;
	private static final int NUMBER_OF_ROLLS = 1000;
	private static int[] frequencies = new int[NUMBER_OF_FACES];
	

	public static void incrementsFrequencieOfFaces(int face) {
		frequencies[face - 1]++;
	}

	public static void showFrequences() {
		System.out.println("Face\tFrequency");
		for (int face = 0; face < frequencies.length; face++) {
			System.out.println((face + 1) + " \t" + frequencies[face]);
		}
	}

	public static void rollDie() {
		Random randomNumbers = new Random();
		int face;

		for (int roll = 1; roll <= NUMBER_OF_ROLLS; roll++) {
			face = 1 + randomNumbers.nextInt(NUMBER_OF_FACES);
			incrementsFrequencieOfFaces(face);
		}
	}

	public static void main(String[] args) {

		rollDie();
		showFrequences();

	}
}
