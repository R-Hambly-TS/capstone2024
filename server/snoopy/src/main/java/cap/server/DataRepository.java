package cap.snoopy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<DefaultIOTData, Long> {

}
