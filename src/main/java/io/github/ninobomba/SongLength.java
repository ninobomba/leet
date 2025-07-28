package io.github.ninobomba;

public class SongLength {

	public static void main ( String[] args ) {

		int[] input = { 30, 20, 150, 100, 40 };

		//int[] input = { 60, 60, 60 };

		int counter = 0;
		for ( int index = 0 ; index < input.length ; index++ ) {
			int pivot = input[ index ];
			counter += findPairs ( pivot, index, input );
		}

		System.out.println ( " Total pairs: " + counter );

	}

	static int findPairs ( int pivot, int pivotPosition, int[] input ) {
		System.out.println ( "--------------------------" );
		int counter = 0;
		for ( int index = pivotPosition ; index < input.length ; index++ ) {
			if ( index != pivotPosition ) {
				int actualTimeValue = input[ index ];
				int sum = ( pivot + actualTimeValue );
				if ( sum % 60 == 0 ) {
					System.out.println ( "pivot: " + pivot + " pairs with: " + actualTimeValue + " position: " + index + " length: " + sum );
					counter++;
				}
			}
		}
		return counter;
	}
	
}
