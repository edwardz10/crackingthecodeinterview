package programming.interviews.exposed.serialization;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

public class TransientExample {
	private static class User implements Serializable {
		private String username;
		private transient String password;

		public User(String username, String password) {
			this.username = username;
			this.password = password;
		}

		public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}
	}

	@Test
	public void transientField() throws IOException, ClassNotFoundException {
		final User user = new User("Noel", "secret321");
		final FileOutputStream fos = new FileOutputStream("/tmp/user");
		final ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(user);
		oos.flush();
		oos.close();
		fos.close();

		final FileInputStream fis = new FileInputStream("/tmp/user");
		final ObjectInputStream ois = new ObjectInputStream(fis);
		final User deserialized = (User) ois.readObject();
		assertEquals("Noel", deserialized.getUsername());
		assertNull(deserialized.getPassword());		
	}
}
