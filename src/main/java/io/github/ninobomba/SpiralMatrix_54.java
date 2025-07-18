package io.github.ninobomba;

public class SpiralMatrix_54 {

	private final int[][] matrix;

	public SpiralMatrix_54 ( int[][] matrix ) {
		this.matrix = matrix;
	}

	void execute ( ) {

		int row_start = 0;
		int row_end = matrix.length - 1;

		int column_start = 0;
		int column_end = matrix[ 0 ].length - 1;

		while ( isNotComplete ( row_start, row_end, column_start, column_end ) ) {

			print_left_to_right ( row_start, column_start, column_end );
			System.out.println ( "-" );

			row_start++;
			print_top_down ( column_end, row_start, row_end );
			System.out.println ( "-" );

			column_end--;
			row_start++;
			print_right_left ( row_start, column_start, column_end );
			System.out.println ( "-" );

			row_start--;
			row_end--;
			print_bottom_top ( column_start, row_start, row_end );

			column_start++;
		}

	}

	boolean isNotComplete ( int row_start, int row_end, int column_start, int column_end ) {
		return row_start <= row_end && column_start <= column_end;
	}

	void print_left_to_right ( int row, int column_start, int column_end ) {
		for ( ; column_start <= column_end ; column_start++ ) {
			System.out.print ( matrix[ row ][ column_start ] + " " );
		}
	}

	void print_right_left ( int row, int column_start, int column_end ) {
		for ( ; column_end >= column_start ; column_end-- ) {
			System.out.print ( matrix[ row ][ column_end ] + " " );
		}
	}

	void print_top_down ( int column, int row_start, int row_end ) {
		for ( ; row_start <= row_end ; row_start++ ) {
			System.out.print ( matrix[ row_start ][ column ] + " " );
		}
	}

	void print_bottom_top ( int column, int row_start, int row_end ) {
		for ( ; row_end >= row_start ; row_end-- ) {
			System.out.print ( matrix[ row_end ][ column ] + " " );
		}
	}

	public static void main ( String[] args ) {
		int[][] matrix1 = new int[][] {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};

		int[][] matrix = new int[][] {
				{ 1, 2, 3, 4 },
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }
		};
		new SpiralMatrix_54 ( matrix ).execute ( );
	}


}
