package cap.server;

import org.springframework.data.jpa.repository.JpaRepository;

import cap.server.model.DefaultIOTData;

public interface DataRepository extends JpaRepository<DefaultIOTData, Long> {
	
}
