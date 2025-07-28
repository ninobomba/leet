package io.github.ninobomba;

public class SpiralMatrix_2 {

	public static void main ( String[] args ) {
		
		int n = 5;
		int[][] matrix = new int[ n ][ n ];

		int row_start = 0;
		int row_end = matrix.length - 1;

		int column_start = 0;
		int column_end = matrix.length - 1;

		int counter = 1;

		while ( row_start <= row_end && column_start <= column_end ) {

			counter = from_left_to_right ( column_start, column_end, row_start, matrix, counter );

			row_start++;
			counter = from_top_down ( column_start, column_end, row_start, row_end, matrix, counter );

			column_end--;
			counter = from_right_to_left ( column_start, column_end, row_end, matrix, counter );

			row_end--;
			counter = from_bottom_top ( row_start, row_end, column_start, matrix, counter );

			column_start++;
		}

		System.out.println ( "final matrix " + counter );
		print ( matrix );

	}

	static int from_left_to_right ( int column_start, int column_end, int row_start, int[][] matrix, int counter ) {
		System.out.println ( "from_left_to_right - column value increases and row is the same" );
		while ( column_start <= column_end ) {
			matrix[ row_start ][ column_start++ ] = counter++;
		}
		print ( matrix );
		return counter;
	}

	static int from_right_to_left ( int column_start, int column_end, int row_end, int[][] matrix, int counter ) {
		System.out.println ( "from_right_to_left - column value decreases and row is the same" );
		while ( column_end >= column_start ) {
			matrix[ row_end ][ column_end-- ] = counter++;
		}
		print ( matrix );
		return counter;
	}

	static int from_top_down ( int column_start, int column_end, int row_start, int row_end, int[][] matrix, int counter ) {
		System.out.println ( "from_top_down - column is the same, row increases" );
		while ( row_start <= row_end ) {
			matrix[ row_start++ ][ column_end ] = counter++;
		}
		print ( matrix );
		return counter;
	}


	static int from_bottom_top ( int row_start, int row_end, int column_start, int[][] matrix, int counter ) {
		System.out.println ( "from_down_top - column is the same, row decreases" );
		while ( row_end >= row_start ) {
			matrix[ row_end-- ][ column_start ] = counter++;
		}
		print ( matrix );
		return counter;
	}

	static void print ( int[][] matrix ) {
		for ( int x = 0 ; x < matrix.length ; x++ ) {
			System.out.println ( );
			for ( int y = 0 ; y < matrix.length ; y++ ) {
				System.out.print ( matrix[ x ][ y ] + " " );
			}
		}
		System.out.println ( );
		System.out.println ( );
	}

}
