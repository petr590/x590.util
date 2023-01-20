package x590.util;

import java.util.Iterator;
import java.util.PrimitiveIterator.OfDouble;
import java.util.stream.DoubleStream;

public interface DoubleSet extends Cloneable, Iterable<Double>, Comparable<DoubleSet> {
	
	public boolean add(double value);
	
	public void addAll(DoubleSet other);
	
	public void addAll(double... array);
	
	public void addAll(OfDouble iterator);
	
	public void intersectWith(DoubleSet other);
	
	public void intersectWith(double... array);
	
	public double get(int index);
	
	public void removeByIndex(int index);
	
	public boolean contains(double num);
	
	@Override
	public DoubleIterator iterator();
	
	public DoubleStream stream();
	
	public void clear();
	
	public void clear(int newCapacity);
	
	public boolean isEmpty();
	
	public int size();
	
	public int capacity();
	
	public double[] toArray();
	
	public boolean equals(DoubleSet other);
	
	public DoubleSet clone();
	
	public static interface DoubleIterator extends Iterator<Double>, OfDouble {}
}