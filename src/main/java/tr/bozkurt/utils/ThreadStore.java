package tr.bozkurt.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bozkurt Project
 */
public class ThreadStore{

	public static final Map<String, Object> store = new ConcurrentHashMap<>();

}
