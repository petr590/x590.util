package x590.util;

import java.util.Objects;

public record Pair<F, S> (F first, S second) {
	
	public static <F, S> Pair<F, S> of(F first, S second) {
		return new Pair<>(first, second);
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