package inventory.controller;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import inventory.model.Auth;
import inventory.model.Menu;
import inventory.model.Role;
import inventory.model.UserRole;
import inventory.model.Users;
import inventory.service.UserService;
import inventory.util.Constant;
import inventory.validate.LoginValidator;

@Controller
public class LoginController {
	@Autowired 
	private UserService userService;
	@Autowired
	private LoginValidator loginValidator;
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		if(binder.getTarget()==null) return;
		if(binder.getTarget().getClass() == Users.class) {
			binder.setValidator(loginValidator);
		}
	}
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginForm", new Users());
		return "login/login";
	}
	@PostMapping("/processLogin")
	public String processLogin(Model model , @ModelAttribute("loginForm")@Validated Users users , BindingResult result , HttpSession session) {
		if(result.hasErrors()) {
			return "login/login";
		}
	
		Users user  = userService.findByProperty("userName", users.getUserName()).get(0);
		UserRole userRole = (UserRole) user.getUserRoles().iterator().next();
		List<Menu> menuList = new ArrayList<>();
		Role role = userRole.getRole();
		List<Menu> menuChildList = new ArrayList<>();
		for(Object obj : role.getAuths()) {
			Auth auth = (Auth) obj;
			Menu menu = auth.getMenu();
			if(menu.getParent()==0 && menu.getOrderIndex()!=-1 && menu.getActiveLag()==1 && auth.getPremission()==1 && auth.getActiveLag()==1) {
				menu.setIdMenu(menu.getUrl().replace("/", "")+"Id"); 
				menuList.add(menu);
			}else if( menu.getParent()!=0 && menu.getOrderIndex()!=-1 && menu.getActiveLag()==1 && auth.getPremission()==1 && auth.getActiveLag()==1) {
				menu.setIdMenu(menu.getUrl().replace("/", "")+"Id"); 
				menuChildList.add(menu);
			}
		}
		for(Menu menu : menuList) {
			List<Menu> childList = new ArrayList<>();
			for(Menu childMenu : menuChildList) {
				if(childMenu.getParent()== menu.getId()) {
					childList.add(childMenu);
				}
			}
			menu.setChild(childList);
		}
		sortMenu(menuList);
		for(Menu menu : menuList) {
			sortMenu(menu.getChild());
		}
		session.setAttribute(Constant.MENU_SESSION, menuList);
		session.setAttribute(Constant.USER_INFO, user);
		return "redirect:/";
	}
	public void sortMenu(List<Menu> menus) {
		Collections.sort(menus, new Comparator<Menu>() {
			@Override
			public int compare(Menu o1, Menu o2) {
				return o1.getOrderIndex() - o2.getOrderIndex();
			}
		});
	}

}
