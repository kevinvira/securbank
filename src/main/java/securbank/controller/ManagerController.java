/**
 * 
 */
package securbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import securbank.models.User;
import securbank.services.UserService;

/**
 * @author Ayush Gupta
 *
 */
@Controller
public class ManagerController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/manager/details")
    public String currentUserDetails(Model model) {
		User user = userService.getCurrentUser();
		if (user == null) {
			return "redirect:/error?code=user.notfound";
		}
		
		model.addAttribute("user", user);
			
        return "manager/detail";
    }
}