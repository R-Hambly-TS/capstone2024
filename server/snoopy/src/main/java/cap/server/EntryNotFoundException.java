package cap.server;

public class EntryNotFoundException extends RuntimeException {
	EntryNotFoundException(Long id) {
		super("Could not find entry " + id);
	}
}
