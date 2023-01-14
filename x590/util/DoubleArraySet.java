package x590.util;

import java.util.Arrays;
import java.util.PrimitiveIterator.OfDouble;
import java.util.stream.DoubleStream;

import x590.util.annotation.Sorted;

/**
 * Класс, описывающий набор примитивов {@literal double}.
 * Не потокобезопасный.
 * Всегда содержит уникальные и отсорированные значения.
 */
public class DoubleArraySet implements DoubleSet {
	
	private static final int DEFAULT_CAPACITY = 4;
	
	@Sorted
	private static final double[] EMPTY_DATA = {};
	
	@Sorted
	private double[] data;
	private int size;
	
	public DoubleArraySet() {
		data = EMPTY_DATA;
		size = 0;
	}
	
	public DoubleArraySet(int initalCapacity) {
		data = new double[initalCapacity];
		size = 0;
	}
	
	public DoubleArraySet(DoubleArraySet other) {
		data = Arrays.copyOf(other.data, other.size + 1);
		size = other.size;
	}
	
	private DoubleArraySet(@Sorted double[] data, int size) {
		this.data = data;
		this.size = size;
	}
	
	
	public static DoubleArraySet of() {
		return new DoubleArraySet();
	}
	
	public static DoubleArraySet of(double value1) {
		double[] data = new double[DEFAULT_CAPACITY];
		data[0] = value1;
		return new DoubleArraySet(data, 1);
	}
	
	public static DoubleArraySet of(double value1, double value2) {
		if(value1 == value2)
			return DoubleArraySet.of(value1);
		
		double[] data = new double[DEFAULT_CAPACITY];
		if(value2 < value1) {
			data[0] = value2;
			data[1] = value1;
		} else {
			data[0] = value1;
			data[1] = value2;
		}
		
		return new DoubleArraySet(data, 2);
	}
	
	public static DoubleArraySet of(double value1, double value2, double value3) {
		double[] data = new double[DEFAULT_CAPACITY];
		data[0] = value1;
		data[1] = value2;
		data[2] = value3;
		
		Arrays.sort(data, 0, 3);
		
		return new DoubleArraySet(data, 3);
	}
	
	public static DoubleArraySet of(double... values) {
		Arrays.sort(values);
		return new DoubleArraySet(values, values.length);
	}
	
	
	private void extendIfFull(int reqiuredSize) {
		if(data.length < reqiuredSize)
			data = Arrays.copyOf(data, Math.max(Math.max(reqiuredSize, DEFAULT_CAPACITY), data.length * 3 / 2));
	}
	
	private void checkIndex(int index) {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException(index);
	}
	
	@Override
	public boolean add(double value) {
		var size = this.size;
		
		extendIfFull(size + 1);
		
		var data = this.data;
		
		int index = 0;
		while(index < size && value > data[index])
			index++;
		
		for(int i = size; i > index; i--)
			data[i] = data[i - 1];
		
		data[index] = value;
		++this.size;
		
		return true;
	}
	
	@Override
	public void addAll(DoubleSet other) {
		if(other instanceof DoubleArraySet arraySet)
			addAll(arraySet);
		else
			addAll(other.iterator());
	}
	
	public void addAll(DoubleArraySet other) {
		addAll(other.data, other.size);
	}
	
	@Override
	public void addAll(double... array) {
		addAll(array, array.length);
	}
	
	private void addAll(double[] otherData, int otherSize) {
		var	thisSize = this.size;
		
		extendIfFull(thisSize + otherSize);
		
		var thisData = this.data;
		
		int newSize = thisSize;
		
		for(int i = 0; i < otherSize; i++) {
			double newValue = otherData[i];
			
			if(!this.containsRaw(newValue, newSize))
				thisData[newSize++] = newValue;
		}
		
		if(thisSize != newSize) {
			this.size = newSize;
			Arrays.sort(thisData, 0, newSize);
		}
	}
	
	@Override
	public void addAll(OfDouble iterator) {
		var	thisSize = this.size;
		
		int newSize = thisSize;
		
		while(iterator.hasNext()) {
			double newValue = iterator.nextDouble();
			
			if(!this.containsRaw(newValue, newSize)) {
				extendIfFull(newSize + 1);
				
				data[newSize++] = newValue;
			}
		}
		
		if(thisSize != newSize) {
			this.size = newSize;
			Arrays.sort(data, 0, newSize);
		}
	}

	@Override
	public void intersectWith(DoubleSet other) {
		intersectWith(other.toArray());
	}
	
	public void intersectWith(DoubleArraySet other) {
		intersectWith(this.data, this.size, other.data, other.size);
	}
	
	@Override
	public void intersectWith(double... array) {
		Arrays.sort(array);
		intersectWith(array, array.length);
	}
	
	private void intersectWith(double[] data, int size) {
		if(this.size > size)
			intersectWith(data, size, this.data, this.size);
		else
			intersectWith(this.data, this.size, data, size);
	}
	
	// size1 всегда должен быть меньше size2
	private void intersectWith(double[] data1, int size1, double[] data2, int size2) {
		double[] newData = new double[size1];
		
		int newSize = 0;
		
		for(int i = 0; i < size1; i++) {
			double value = data1[i];
			
			if(contains(data2, size2, value))
				newData[newSize++] = value;
		}
		
		this.data = newData;
		this.size = newSize;
	}
	
	@Override
	public double get(int index) {
		checkIndex(index);
		return data[index];
	}
	
	@Override
	public void removeByIndex(int index) {
		checkIndex(index);
		
		for(int i = index, max = --size; i < max; i++) {
			data[i] = data[i + 1];
		}
	}
	
	private boolean containsRaw(double num, int size) {
		var data = this.data;
		
		for(int i = 0; i < size; i++) {
			if(num == data[i])
				return true;
		}
		
		return false;
	}
	
	@Override
	public boolean contains(double num) {
		return contains(data, size, num);
	}
	
	
	private static boolean contains(double[] data, int size, double num) {
		for(int i = 0; i < size; i++) {
			double value = data[i];
			
			if(value == num)
				return true;
			
			if(value > num)
				return false;
		}
		
		return false;
	}
	
	
	@Override
	public DoubleStream stream() {
		return DoubleStream.of(data).limit(size);
	}
	
	
	@Override
	public void clear() {
		data = EMPTY_DATA;
		size = 0;
	}
	
	@Override
	public void clear(int newCapacity) {
		data = new double[newCapacity];
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public int capacity() {
		return data.length;
	}
	
	
	@Override
	public int compareTo(DoubleSet other) {
		if(this == other)
			return 0;
		
		for(OfDouble iter1 = this.iterator(), iter2 = other.iterator(); iter1.hasNext() && iter2.hasNext();) {
			int diff = Double.compare(iter1.nextDouble(), iter2.nextDouble());
			if(diff != 0)
				return diff;
		}
		
		return this.size - other.size();
	}
	
	
	@Override
	public DoubleIterator iterator() {
		return new DoubleIterator();
	}
	
	
	public class DoubleIterator implements DoubleSet.DoubleIterator {
		
		private int i = -1;
		
		@Override
		public boolean hasNext() {
			return i < size - 1;
		}
		
		@Override
		public Double next() {
			return nextDouble();
		}

		@Override
		public double nextDouble() {
			return data[++i];
		}
		
		@Override
		public void remove() {
			removeByIndex(i);
			--i;
		}
	}
	
	
	@Override
	public double[] toArray() {
		return Arrays.copyOf(data, size);
	}
	
	
	@Override
	public DoubleArraySet clone() {
		return new DoubleArraySet(this);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		return this == obj || obj instanceof DoubleSet set && this.equals(set);
	}
	
	@Override
	public boolean equals(DoubleSet other) {
		if(size == other.size()) {
			OfDouble otherIterator = other.iterator();
			return this.stream().allMatch(value -> Double.compare(value, otherIterator.nextDouble()) == 0);
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder().append('[');
		
		final int size = this.size;
		
		if(size > 0) {
			for(int i = 0;;) {
				str.append(data[i]);
				if(++i >= size) break;
				str.append(", ");
			}
		}
		
		return str.append(']').toString();
	}
}