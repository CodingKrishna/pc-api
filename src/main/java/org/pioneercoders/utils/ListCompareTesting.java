package org.pioneercoders.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class ListCompareTesting {
	public static void main(String[] args) {

	          Collection<String> listOne = Arrays.asList("apple","banana","grapes","carrot");

	          Collection<String> listTwo = Arrays.asList("apple","banana");

	          Collection<String> similar = new HashSet<String>( listOne );
	          Collection<String> different = new HashSet<String>();
	          different.addAll( listOne );
	          different.addAll( listTwo );

	          similar.retainAll( listTwo );
	          different.removeAll( similar );

	          System.out.printf("One:%s%nTwo:%s%nSimilar:%s%nDifferent:%s%n", listOne, listTwo, similar, different);
	      }
	}
