package programming.interviews.exposed.junit.weakreferences;

public class ValueContainer {
	private String value;

	public ValueContainer(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.printf("Finalizing for [%s]%n", toString());
	}

	@Override
	public boolean equals(Object object) {
		return object instanceof ValueContainer && value.equals(((ValueContainer)object).value);
	}
}
