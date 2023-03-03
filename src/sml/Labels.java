package sml;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**
 * The label functions as a marker for lookup; instructions use them
 * @author Doyeon Yoon
 */
public final class Labels {
	private final Map<String, Integer> labels = new HashMap<>();

	/**
	 * Adds a label with the associated address to the map.
	 *
	 * @param label the label
	 * @param address the address the label refers to
	 */
	public void addLabel(String label, int address) {
		Objects.requireNonNull(label);
		for (String key : labels.keySet()) {
			if (key.equals(label)) {
				throw new IllegalArgumentException("Duplicate label");
			}
		}
		labels.put(label, address);
	}

	/**
	 * Returns the address associated with the label.
	 *
	 * @param label the label
	 * @return the address the label refers to
	 */
	public int getAddress(String label) {
		// TODO: Where can NullPointerException be thrown here?
		// Thrown when something is being referenced while it is not there (i.e. "pointing" to nothing)
		for (String key : labels.keySet()) {
			if (key.equals(label)) {
				return labels.get(key);
			}
		}
		return labels.get(label);
	}

	/**
	 * representation of this instance,
	 * in the form "[label -> address, label -> address, ..., label -> address]"
	 *
	 * @return the string representation of the labels map
	 */
	@Override
	public String toString() {
		// TODO: Implement the method using the Stream API (see also class Registers).
		return labels.entrySet().stream()
				.map(entry -> entry.getKey() + " -> " + entry.getValue())
				.reduce("", (a, b) -> a + ", " + b);
	}

	// TODO: Implement equals and hashCode (needed in class Machine).
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Labels labels1 = (Labels) o;
		return Objects.equals(labels, labels1.labels);
	}

	@Override
	public int hashCode() {
		return Objects.hash(labels);
	}
	/**
	 * Removes the labels
	 */
	public void reset() {
		labels.clear();
	}
}
