package programming.interviews.exposed.serialization;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

public class WritingObjects {

	private static class Pair implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private final int number;
		private final String name;

		public Pair(int number, String name) {
			this.number = number;
			this.name = name;
		}

		public int getNumber() {
			return number;
		}

		public String getName() {
			return name;
		}

		@Override
		public boolean equals(Object object) {
			if (object instanceof Pair) {
				Pair p = (Pair) object;
				return p.number == number && p.name.equals(name);
			}
			
			return false;
		}
	}

	@Test
	public void readWriteObjects() throws IOException, ClassNotFoundException {
		int expectedInt = 101;
		boolean expectedBoolean = false;
		String expectedUTF = "Writing a string";
		Pair expectedPair = new Pair(42, "Forty two");
		
		final FileOutputStream fos = new FileOutputStream("/tmp/file");
		final ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeInt(expectedInt);
		oos.writeBoolean(expectedBoolean);
		oos.writeUTF(expectedUTF);
		oos.writeObject(expectedPair);
		oos.flush();
		oos.close();
		fos.close();

		final FileInputStream fis = new FileInputStream("/tmp/file");
		final ObjectInputStream ois = new ObjectInputStream(fis);
		final int number = ois.readInt();
		final boolean bool = ois.readBoolean();
		final String string = ois.readUTF();
		final Pair pair = (Pair) ois.readObject();

		assertEquals(expectedInt, number);
		assertEquals(expectedBoolean, bool);
		assertEquals(expectedUTF, string);
		assertEquals(expectedPair, pair);
	}
}
