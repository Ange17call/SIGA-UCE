package ec.com.siga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ec.com.siga.entity.Preguntas;
import ec.com.siga.entity.User;
import ec.com.siga.service.QuestService;

@Controller
public class TableQuestController {

	@Autowired
	@Qualifier("questServicio")
	private QuestService questServicio;

	@GetMapping("/tableQuest")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView("tableQuest");
		mav.addObject("contacts", questServicio.findAllQuest());
		return mav;
	}

	@GetMapping("/editQuest")
	public String showEditAdminForm() {
		return "editAdmin";
	}

	@PostMapping("/saveQuest")
	public String saveAdmin(User admin) {
		// questServicio.saveAdmin(admin);
		return "redirect:/dashboardAdmin";
	}

	@GetMapping("/findQuest")
	@ResponseBody
	public Preguntas findOne(Integer id) {
		return questServicio.findQuestion(id);
	}

	@GetMapping("/cancelQuest")
	public String cancel() {
		return "redirect:/dashboardAdmin";
	}

	@GetMapping("/deleteQuest")
	public void deleteCountry(Integer adminId) {
		questServicio.deleteQuestion(adminId);
	}

}
