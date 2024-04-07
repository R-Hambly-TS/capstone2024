package cap.server;

import java.util.List;

// Thymeleaf Front End

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import cap.server.DataRepository;
import cap.server.model.DefaultIOTData;


@Controller
@RequestMapping("/")
public class WebController {
	
	private DataRepository repository;
	public WebController(DataRepository repo) {
		this.repository = repo;
	}
	
	@GetMapping("/")
	public String home(Model model) {
		List<DefaultIOTData> entries = repository.findAll();
		model.addAttribute("entries", entries);
		
		return "index";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
}
