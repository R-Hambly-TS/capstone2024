package cap.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class WebController {
	@GetMapping("/index")
	public String getTemplate(@RequestParam(name="name", required = false, defaultValue ="World") String name, Model model) {
		model.addAttribute("name",name);
		return "index";
	}
}
