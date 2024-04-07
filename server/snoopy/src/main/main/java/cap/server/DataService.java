package cap.server;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import cap.server.model.DefaultIOTData;


public interface DataService {
	// Get All Entries Method
	CollectionModel<EntityModel<DefaultIOTData>> allEntries();
	
	// Post Entry Method
	ResponseEntity<?> newEntry(DefaultIOTData newEntry);
	
	// Get Entry By ID Method
	EntityModel<DefaultIOTData> entryByID(Long id);
	
	// Put Entry Method
	ResponseEntity<?> replaceEntry(DefaultIOTData newEntry, Long id);
	
	// Delete Entry Method
	ResponseEntity<?> deleteEntry(Long id);

}
