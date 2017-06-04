package com.websystique.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.primefaces.component.inputtext.InputText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.websystique.springmvc.model.AllClients;
import com.websystique.springmvc.model.Client;
import com.websystique.springmvc.model.Ticket;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.AllClientsService;
import com.websystique.springmvc.service.ClientService;
import com.websystique.springmvc.service.TicketService;
import com.websystique.springmvc.service.UserProfileService;
import com.websystique.springmvc.service.UserService;



@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

	@Autowired
	UserService userService;
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	TicketService ticketService;
	
	@Autowired
	AllClientsService allclientsService;
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	
	
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<Client> clients =  clientService.findAllClient();
		List<Ticket> tickets =  ticketService.findAllTicket();
		List<User> users =  userService.findAllUsers();
		List<AllClients> allclients =  allclientsService.findAllClient();
		
		String stan = String.valueOf(allclients.size());
		
		model.addAttribute("users", users);
		model.addAttribute("clients", clients);
		model.addAttribute("tickets", tickets);
		model.addAttribute("allclients", allclients);
		model.addAttribute("loggedinuser", getPrincipal());
		model.addAttribute("stan",stan);
		return "userslist";
	}
	
	

	
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		AllClients allclients = new AllClients();
		List<Ticket> tickets =  ticketService.findAllTicket();
		model.addAttribute("user", user);
		model.addAttribute("allclients", allclients);
		model.addAttribute("edit", false);
		model.addAttribute("tickets", tickets);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}

	
	@RequestMapping(value = { "/newuserp" }, method = RequestMethod.GET)
	public String newUser2(ModelMap model) {
		User user = new User();
		AllClients allclients = new AllClients();
		List<Ticket> tickets =  ticketService.findAllTicket();
		model.addAttribute("user", user);
		model.addAttribute("allclients", allclients);
		model.addAttribute("edit", false);
		model.addAttribute("add",true);
		model.addAttribute("tickets", tickets);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}

	
	
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid AllClients user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		
		/*if(!allclientsService.isUserSSOUnique(user.getId(),user.getFirstName() )){ 
			FieldError ssoError =new FieldError("user","id",messageSource.getMessage("non.unique.id", new String[]{user.getFirstName()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/
		
		allclientsService.saveClient(user);

		model.addAttribute("success", "Klient  " + user.getFirstName() + " "+ user.getLastName() + " dodany pomyslnie");
		//model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccess";
	}
	
	


	@RequestMapping(value = { "/newuserp" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		
		/*if(!allclientsService.isUserSSOUnique(user.getId(),user.getFirstName() )){ 
			FieldError ssoError =new FieldError("user","id",messageSource.getMessage("non.unique.id", new String[]{user.getFirstName()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/
		
		//allclientsService.saveClient(user);
		userService.saveUser(user);

		model.addAttribute("success", "Uzytkownik  " + user.getFirstName() + " "+ user.getLastName() + " dodany pomyslnie");
		//model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccess";
	}

	@RequestMapping(value = { "/invoke/{id}" }, method = RequestMethod.GET)
	public String invokeUsers(@PathVariable Integer id,ModelMap model) {

		
		
		
		
		AllClients all = allclientsService.findById(id);
		String t=all.getType();
		Ticket ticket = ticketService.findByType(t);
		
		model.addAttribute("all",all);
		model.addAttribute("ticekt",ticket);
		
		
		return "invoke";
	}
	
	
	@RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable Integer id, ModelMap model) {
		AllClients user = allclientsService.findById(id);
		List<Ticket> tickets =  ticketService.findAllTicket();
		model.addAttribute("allclients", user);
		model.addAttribute("tickets",tickets);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}
	
	
	@RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.POST)
	public String updateUser(@Valid AllClients user, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			return "registration";
		}

		/*
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


		//userService.updateUser(user);
allclientsService.updateClient(user);
		model.addAttribute("success", "Klient  " + user.getFirstName() + " "+ user.getLastName() + " edycja pomyslna");
		//model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}
	
	
	@RequestMapping(value = { "/price-ticket-{type}" }, method = RequestMethod.GET)
	public String editPrice(@PathVariable String type, ModelMap model) {
		//AllClients user = allclientsService.findById(type);
		//List<Ticket> ticket = ticketService.findAllTicket();
		Ticket newticket = ticketService.findByType(type);
		//newticket.setType(type);
		//for (Ticket ticket2 : ticket) {
			//if(ticket2.getType()==type){
				//newticket=ticket2;
			//}
		//}
		
		model.addAttribute("tickets", newticket);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}
	
	
	@RequestMapping(value = { "/price-ticket-{type}" }, method = RequestMethod.POST)
	public String updatePrice(@Valid Ticket user, BindingResult result,
			ModelMap model, @PathVariable String type) {

		if (result.hasErrors()) {
			return "registration";
		}

		/*
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


		//userService.updateUser(user);
//allclientsService.updateClient(user);
		ticketService.updateTicket(user);
		
		model.addAttribute("success", "Bilet  " + user.getType() + " cena "+ user.getPrice() + " edycja pomyslna");
		//model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}
	
	
	
	@RequestMapping(value = { "/delete-user-{id}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable Integer id) {
		//userService.deleteUserBySSO(ssoId);
		allclientsService.deleteClientBySSO(id);
		return "redirect:/list";
	}
	
	@RequestMapping(value = { "/delete-userp-{ssoId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String  ssoId) {
		userService.deleteUserBySSO(ssoId);
		//allclientsService.deleteClientBySSO(id);
		return "redirect:/list";
	}
	
	

	
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}
	
	
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";//accessDanied
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
	    } else {
	    	return "redirect:/list";  
	    }
	}

	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}

	
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	
	private boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}


}