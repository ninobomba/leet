package io.github.ninobomba;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

	public static int longestPalindrome ( String[] words ) {
		Map < String, Integer > counts = new HashMap <> ( );
		// Count the frequency of each word.
		for ( String word : words ) {
			counts.put ( word, counts.getOrDefault ( word, 0 ) + 1 );
		}

		int length = 0;
		boolean centralWordUsed = false;

		for ( String word : counts.keySet ( ) ) {
			int count = counts.get ( word );

			// Case 1: The word is a palindrome (e.g., "gg").
			if ( word.charAt ( 0 ) == word.charAt ( 1 ) ) {
				// Add all even pairs to the length.
				length += ( count / 2 ) * 4;
				// If there's an odd count, one can be a central word.
				if ( count % 2 == 1 ) {
					centralWordUsed = true;
				}
			} else if ( word.charAt ( 0 ) < word.charAt ( 1 ) ) {
				// Case 2: The word is not a palindrome (e.g., "lc").
				// We check word.charAt(0) < word.charAt(1) to process pairs only once (e.g., we process "lc" but skip "cl").
				String reversedWord = "" + word.charAt ( 1 ) + word.charAt ( 0 );
				if ( counts.containsKey ( reversedWord ) ) {
					// Find the number of pairs we can form.
					int reversedCount = counts.get ( reversedWord );
					length += Math.min ( count, reversedCount ) * 4;
				}
			}
		}

		// If a central word can be used, add 2 to the final length.
		if ( centralWordUsed ) {
			length += 2;
		}

		return length;
	}

	public static void main ( String[] args ) {
		// Example 1:
		String[] words1 = { "lc", "cl", "gg" };
		System.out.println ( "Input: [\"lc\", \"cl\", \"gg\"]" );
		System.out.println ( "Output: " + longestPalindrome ( words1 ) ); // Expected: 6

		System.out.println ( );

		// Example 2:
		String[] words2 = { "ab", "ty", "yt", "lc", "cl", "ab" };
		System.out.println ( "Input: [\"ab\", \"ty\", \"yt\", \"lc\", \"cl\", \"ab\"]" );
		System.out.println ( "Output: " + longestPalindrome ( words2 ) ); // Expected: 8

		System.out.println ( );

		// Example 3:
		String[] words3 = { "cc", "ll", "xx" };
		System.out.println ( "Input: [\"cc\", \"ll\", \"xx\"]" );
		System.out.println ( "Output: " + longestPalindrome ( words3 ) ); // Expected: 2
	}
}

/*

package io.github.ninobomba;

import java.util.Arrays;

public class LongestPalindrome {


	public static void main ( String[] args ) {

//		String[] words = { "lc", "cl", "gg" };
		String[] words = { "ab", "ty", "yt", "lc", "cl", "ab" };

		boolean repeatOnce = false;
		int counter = 0;

		for ( int index = 0 ; index < words.length ; index++ ) {
			System.out.println ( );
			String actual = words[ index ];
			int v = findDuplicate ( actual, index, words );

			if ( v == - 1 ) {
				boolean itemIsUniqueAndPalindrome = areArrayItemsEquals ( actual );
				if ( ! itemIsUniqueAndPalindrome ) {
					System.out.println ( "Not a Palindrome, item is unequals: " + actual + " at index: " + index );
					return;
				}

				if ( repeatOnce ) {
					System.out.println ( "Not a Palindrome" );
					System.exit ( 0 );
				}
				repeatOnce = true;
			} else {
				counter++;
				System.out.println ( "counter: " + counter );
			}
		}

		System.out.println ( "==================================" );
		System.out.println ( counter + " duplicates found" );


		System.out.println ( "Palindrome: " + ( counter * words.length ) );

	}

	static boolean areArrayItemsEquals ( String input ) {
		if ( input.length ( ) == 1 )
			return false;
		for ( int index = 0 ; index < input.length ( ) ; index++ ) {
			var a = input.charAt ( index );
			var b = index + 1 >= input.length ( ) ? 0 : input.charAt ( index + 1 );
			System.out.println ( "a: " + a + " b: " + b );
			if ( b != 0 && ! ( a == b ) )
				return false;
		}
		System.out.println ( "Item is Palindrome: " + input );
		return true;
	}

	static int findDuplicate ( String actual, int actualIndex, String[] words ) {
		System.out.println ( "---------------" );
		System.out.println ( "evaluating - actual: " + actual + " words: " + Arrays.toString ( words ) );
		for ( int index = 0 ; index < words.length ; index++ ) {
			if ( index == actualIndex ) continue;
			String comparable = new StringBuilder ( words[ index ] ).reverse ( ).toString ( );
			if ( actual.equals ( comparable ) ) {
				System.out.println ( "Duplicate found: " + words[ index ] + " at index: " + index );
				return index;
			}
		}
		System.out.println ( "No duplicates found: " + actual + " at index: " + actualIndex + " words: " + Arrays.toString ( words ) );
		return - 1;
	}

}

 */
