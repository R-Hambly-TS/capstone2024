package cap.server;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.hateoas.CollectionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cap.server.model.DefaultIOTData;
import cap.server.DataRepository;

//tag::hateoas-imports[]
//end::hateoas-imports[]


@RestController
@RequestMapping("/entries")
public class DataController implements DataService {

	@Autowired
	private DataRepository repository;
	
	private final EntryModelAssembler assembler;
	
	DataController(DataRepository repository, EntryModelAssembler assembler) {
		this.repository = repository;
		this.assembler = assembler;
	}
	
	
	// Aggregate Root
	// Get All Items
	
	// tag::get-aggregate-root[]
	@GetMapping
	public CollectionModel<EntityModel<DefaultIOTData>> allEntries(){
		
		List<EntityModel<DefaultIOTData>> entries = repository.findAll().stream()
				.map(assembler::toModel) //
				.collect(Collectors.toList());
		
		return CollectionModel.of(entries,
				linkTo(methodOn(DataController.class).allEntries()).withSelfRel());
	}
	
	// end::get-aggregate-root[]
	
	// Post Item
	
	@PostMapping
	public ResponseEntity<?> newEntry(@RequestBody DefaultIOTData newEntry) {
		EntityModel<DefaultIOTData> entityModel = assembler.toModel(repository.save(newEntry));
		
		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}
	// Get Single item by ID
	
	@GetMapping("/{id}")
	public EntityModel<DefaultIOTData> entryByID(@PathVariable Long id){
		DefaultIOTData entry = repository.findById(id) //
				.orElseThrow(() -> new EntryNotFoundException(id));
		
		return assembler.toModel(entry);
	}
	
	// Update Item
	
	@PutMapping("/{id}")
	public ResponseEntity<?> replaceEntry(@RequestBody DefaultIOTData newEntry, @PathVariable Long id){
		DefaultIOTData updatedEntry = repository.findById(id) //
				.map(entry -> {
					entry.setDeviceID(newEntry.getDeviceID());
					entry.setData(newEntry.getData());
					return repository.save(entry);
				}) //
				.orElseGet(() -> {
					newEntry.setID(id);
					return repository.save(newEntry);
				});
		
		EntityModel<DefaultIOTData> entityModel = assembler.toModel(updatedEntry);
		
		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}
	
	// Delete Item
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEntry(@PathVariable Long id){
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
