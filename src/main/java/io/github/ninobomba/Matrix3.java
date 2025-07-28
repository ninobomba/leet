package io.github.ninobomba;

public class Matrix3 {

	static int[][] matrix = new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 9 }
	};

	int row_start = 0;
	int row_end = matrix.length - 1;

	int column_start = 0;
	int column_end = matrix.length - 1;

	public static void main ( String[] args ) {


		int iterations = matrix.length * 2;
		//	iterations = 5;

		int column = 0;
		int row = 0;

		int actualValue = matrix[ 0 ][ 0 ];
		int nextValue = matrix[ 0 ][ 0 ];
		
		final int left_right = 0;
		final int top_down = 1;
		final int right_left = 2;
		final int down_top = 3;

		int current_direction = left_right;

		for ( int index = 0 ; index < iterations ; index++ ) {

			System.out.println ( "-------\n" + row + ":" + column + "-> av: " + actualValue + "-> nv: " + nextValue );


			switch ( current_direction ) {

				case left_right:
					nextValue = getNextValueFromLeftToRight ( row, column );
					if ( nextValue != - 1 ) {
						matrix[ row ][ column + 1 ] = actualValue;
						actualValue = nextValue;
						column++;
					} else {
						System.out.println ( "new direction -> top-down, av: " + actualValue );
						current_direction = top_down;
					}
					break;
				case top_down:
					nextValue = getNextValueFromTopDown ( row, column );
					if ( nextValue != - 1 ) {
						matrix[ row + 1 ][ column ] = actualValue;
						actualValue = nextValue;
						row++;
					} else {
						System.out.println ( "new direction -> right left, av: " + actualValue );
						current_direction = right_left;
					}
					break;
				case right_left:
					nextValue = getNextValueFromRightToLeft ( row, column );
					if ( nextValue != - 1 ) {
						matrix[ row ][ column - 1 ] = actualValue;
						actualValue = nextValue;
						column--;
					} else {
						System.out.println ( "new direction -> dow top, av: " + actualValue );
						current_direction = down_top;
					}
					break;
				case down_top:
					nextValue = getNextValueFromBottomTop ( row, column );
					if ( nextValue != - 1 ) {
						matrix[ row - 1 ][ column ] = actualValue;
						actualValue = nextValue;
						row--;
					} else {
						current_direction = left_right;
					}
					break;
			}
			print ( );
		}
	}

	static int getNextValueFromLeftToRight ( int x, int y ) {
		if ( y >= matrix.length - 1 || matrix[ x ][ y + 1 ] == - 1 ) return - 1;
		var v = matrix[ x ][ y + 1 ];
		System.out.println ( "getNextValueFromLeftToRight " + v );
		return v;
	}

	static int getNextValueFromTopDown ( int x, int y ) {
		if ( x >= matrix.length - 1 || matrix[ x + 1 ][ y ] == - 1 ) return - 1;
		var v = matrix[ x + 1 ][ y ];
		System.out.println ( "getNextValueFromTopDown " + v );
		return v;
	}

	static int getNextValueFromRightToLeft ( int x, int y ) {
		if ( y <= 0 || matrix[ x ][ y - 1 ] == - 1 ) return - 1;
		var v = matrix[ x ][ y - 1 ];
		System.out.println ( "getNextValueFromRightToLeft " + v );
		return v;
	}

	static int getNextValueFromBottomTop ( int x, int y ) {
		if ( x <= 0 || matrix[ x - 1 ][ y ] == - 1 ) return - 1;
		var v = matrix[ x - 1 ][ y ];
		System.out.println ( "getNextValueFromBottomTop " + v );
		return v;
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


//			if ( nextValue != - 1 ) {
//matrix[ row ][ column + 1 ] = actualValue;
//column++;
//		} else {
//nextValue = getNextValueFromTopDown ( row, column );
//				if ( nextValue != - 1 ) {
//matrix[ row + 1 ][ column ] = actualValue;
//row++;
//		} else {
//nextValue = getNextValueFromRightToLeft ( row, column );
//					if ( nextValue != - 1 ) {
//matrix[ row ][ column - 1 ] = actualValue;
//column--;
//		} else {
//nextValue = getNextValueFromBottomTop ( row, column );
//row--;
//		}
//		}
//		}
//
//		}
