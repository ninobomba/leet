package io.github.ninobomba;

public class Matrix4 {

	static int[][] matrix2 = new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 9 }
	};

	static int[][] matrix = new int[][] {
			{ 5, 1, 9, 11 },
			{ 2, 4, 8, 10 },
			{ 13, 3, 6, 7 },
			{ 15, 14, 12, 16 }
	};

	public static void main ( String[] args ) {

		int lr_row = 0;
		int lr_column = 0;

		int td_row = 0;
		int td_column = matrix.length - 1;

		int rl_row = matrix.length - 1;
		int rl_column = matrix.length - 1;

		int dt_row = matrix.length - 1;
		int dt_column = 0;

		int matrix_length = matrix.length - 1;

		int iterations = matrix.length / 2;

		int counter_up = 0;
		int counter_down = matrix_length;

		print ( );

		System.out.println ( "iterations " + iterations );

		while ( iterations-- > 0 ) {

			System.out.println ( ">>>>>>>>>>>>>>>>>\n next cycle matrix " + matrix_length );

			for ( int index = 0 ; index < matrix_length ; index++ ) {

				System.out.println ( "---------------------------------------------" );
				System.out.println ( "index : " + index + " matrix: " + matrix_length );

				int currentValue_leftToRight = matrix[ lr_row ][ lr_column ];
				int currentValue_topDown = matrix[ td_row ][ td_column ];
				int currentValue_rightToLeft = matrix[ rl_row ][ rl_column ];
				int currentValue_downToTop = matrix[ dt_row ][ dt_column ];

				// top - down
				matrix[ td_row ][ td_column ] = currentValue_leftToRight;
				// right to left
				matrix[ rl_row ][ rl_column ] = currentValue_topDown;
				// down to top
				matrix[ dt_row ][ dt_column ] = currentValue_rightToLeft;
				// left to right
				matrix[ lr_row ][ lr_column ] = currentValue_downToTop;

				lr_column++;
				td_row++;
				rl_column--;
				dt_row--;

				print ( );
			}

			matrix_length -= 2;

			counter_up++;
			counter_down--;

			lr_row = counter_up;
			lr_column = counter_up;

			td_row = counter_up;
			td_column = counter_down;

			rl_row = counter_down;
			rl_column = counter_down;

			dt_row = counter_down;
			dt_column = counter_up;
		}
	}

	static void print ( ) {
		for ( int x = 0 ; x < matrix.length ; x++ ) {
			System.out.println ( );
			for ( int y = 0 ; y < matrix.length ; y++ ) {
				System.out.print ( matrix[ x ][ y ] + " " );
			}
		}
		System.out.println ( "\n\n" );
	}

}
