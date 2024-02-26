package cap.snoopy;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class EntryModelAssembler implements RepresentationModelAssembler<DefaultIOTData, EntityModel<DefaultIOTData>> {
	@Override
	public EntityModel<DefaultIOTData> toModel(DefaultIOTData entry) {
		return EntityModel.of(entry, //
				linkTo(methodOn(DataController.class).one(entry.getID())).withSelfRel(),
				linkTo(methodOn(DataController.class).all()).withRel("entries"));
	}
}
