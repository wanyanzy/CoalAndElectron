package com.example.project3.comons.transporter;

import java.util.HashMap;

/**
 * @author 橙鼠鼠
 */
public class CloneableHashMap extends HashMap<String,Object>implements Cloneable {
	/**
	 * Constructs an empty {@code HashMap} with the specified initial
	 * capacity and the default load factor (0.75).
	 *
	 * @param initialCapacity the initial capacity.
	 * @throws IllegalArgumentException if the initial capacity is negative.
	 */
	public CloneableHashMap (int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * Constructs an empty {@code HashMap} with the default initial capacity
	 * (16) and the default load factor (0.75).
	 */
	public CloneableHashMap () {
	}
}
