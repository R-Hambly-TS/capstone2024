package cap.snoopy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {
	private final DataRepository dataRepo;
	
	@Autowired
	public DataService(DataRepository dataRepo) {
		this.dataRepo = dataRepo;
	}
	
	public void saveData(DefaultIOTData data) {
		dataRepo.save(data);
	}
}
