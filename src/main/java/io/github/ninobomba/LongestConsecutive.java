package io.github.ninobomba;

import java.util.ArrayList;
import java.util.Collections;

public class LongestConsecutive {

	static int lastIndex = - 1;

	public static void main ( String[] args ) {

//		int[] sequence = new int[] { 100, 4, 200, 1, 2, 3 };
		int[] sequence = new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
//		int[] sequence = new int[] { 1, 0, 1, 2 };


		var list = new ArrayList < Integer > ( );
		for ( int e : sequence ) list.add ( e );
		Collections.sort ( list );

		System.out.println ( "Sorted Array: " + list );

		for ( int index = 0 ; index < list.size ( ) ; index++ ) {
			int actual = list.get ( index );
			int next = index < list.size ( ) - 1 ? list.get ( index + 1 ) : - 1;
			if ( actual == next ) {
				list.remove ( actual );
			}
		}


		System.out.println ( "Clean - Sorted Array: " + list );

		int finalCount = 0;
		int counter = 0;

		while ( lastIndex++ < list.size ( ) - 1 ) {

			System.out.println ( "---------------------------- " );

			int actual = list.get ( lastIndex );
			int next = lastIndex < list.size ( ) - 1 ? list.get ( lastIndex + 1 ) : - 1;
			System.out.println ( "actual: " + actual + " next: " + next + " lastIndex: " + lastIndex );
			counter++;
			if ( ! ( actual < next && actual + 1 == next ) ) {
				System.out.println ( "breaking" );
				if ( finalCount < counter ) {
					finalCount = counter;
				}
				counter = 0;
			}
		}

		System.out.println ( "longest sequence: " + finalCount );

	}

}
