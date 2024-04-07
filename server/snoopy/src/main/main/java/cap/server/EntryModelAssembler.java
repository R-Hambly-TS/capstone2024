package cap.server;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import cap.server.model.DefaultIOTData;

@Component
public class EntryModelAssembler implements RepresentationModelAssembler<DefaultIOTData, EntityModel<DefaultIOTData>> {
	@Override
	public EntityModel<DefaultIOTData> toModel(DefaultIOTData entry) {
		return EntityModel.of(entry, //
				linkTo(methodOn(DataController.class).entryByID(entry.getID())).withSelfRel(),
				linkTo(methodOn(DataController.class).allEntries()).withRel("entries"));
	}
}
