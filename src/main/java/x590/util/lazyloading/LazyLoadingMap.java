package x590.util.lazyloading;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Обёртка над картой. Инициализирует карту только при обращении к ней,
 * при этом инициализирует сразу всю карту, т.е. нельзя инициализировать её частично
 */
public class LazyLoadingMap<K, V> implements Map<K, V> {
	
	private Supplier<Map<K, V>> supplier;
	private Map<K, V> map;
	
	/**
	 * @param supplier объект, который вызывается только при первом обращении к карте
	 */
	public LazyLoadingMap(Supplier<Map<K, V>> supplier) {
		this.supplier = supplier;
	}
	
	private Map<K, V> getMap() {
		var map = this.map;
		
		if (map != null) {
			return map;
		}
		
		map = this.map = supplier.get();
		supplier = null;
		return map;
	}
	
	@Override
	public void clear() {
		getMap().clear();
	}
	
	@Override
	public boolean containsKey(Object key) {
		return getMap().containsKey(key);
	}
	
	@Override
	public boolean containsValue(Object value) {
		return getMap().containsValue(value);
	}
	
	@Override
	public Set<Entry<K, V>> entrySet() {
		return getMap().entrySet();
	}
	
	@Override
	public V get(Object key) {
		return getMap().get(key);
	}
	
	@Override
	public boolean isEmpty() {
		return getMap().isEmpty();
	}
	
	@Override
	public Set<K> keySet() {
		return getMap().keySet();
	}
	
	@Override
	public V put(K key, V value) {
		return getMap().put(key, value);
	}
	
	@Override
	public void putAll(Map<? extends K, ? extends V> map) {
		getMap().putAll(map);
	}
	
	@Override
	public V remove(Object key) {
		return getMap().get(key);
	}
	
	@Override
	public int size() {
		return getMap().size();
	}
	
	@Override
	public Collection<V> values() {
		return getMap().values();
	}
}
