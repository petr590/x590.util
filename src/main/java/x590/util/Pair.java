package x590.util;

import x590.util.annotation.Immutable;

import java.util.Objects;

@Immutable
public record Pair<F, S> (F first, S second) {
	
	private static final Pair<?, ?> EMPTY = new Pair<>(null, null);
	
	@SuppressWarnings("unchecked")
	public static <F, S> Pair<F, S> empty() {
		return (Pair<F, S>)EMPTY;
	}
	
	public static <F, S> Pair<F, S> of(F first, S second) {
		return first == null && second == null ?
				empty() :
				new Pair<>(first, second);
	}
	
	@Override
	public String toString() {
		return "{" + first + ", " + second + "}";
	}
	
	public boolean equals(Pair<? extends F, ? extends S> other) {
		return this == other ||
				Objects.equals(this.first, other.first) &&
				Objects.equals(this.second, other.second);
	}
}