package com.websystique.springmvc.controller;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
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
import java.text.SimpleDateFormat;
import java.time.LocalTime;



@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

	private static final int BUFFER_SIZE = 0;

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
	
	@RequestMapping(value = "/download/{id}" , method = RequestMethod.GET)
	public void doDownload(@PathVariable Integer id,HttpServletRequest request,Map<String, Object> model,
	       HttpServletResponse response) throws IOException, DocumentException {
		ServletContext context = request.getSession().getServletContext();
		
		String presentationtype = "pdf";
		// step 1
		System.out.println("---inside servelit----");
		//PageSize.A3.rotate()
		Document document = new Document(new Rectangle(700.0f, 1000.0f), 10, 10, 10, 10);
		PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
		try {
		// step 2: we set the ContentType and create an instance of the corresponding Writer
		if ("pdf".equals(presentationtype)) {
		response.setContentType("application/pdf");
		 PdfWriter.getInstance(document, response.getOutputStream());
		}
		else if ("html".equals(presentationtype)) {
		response.setContentType("text/html");
		PdfWriter.getInstance(document, response.getOutputStream());
		}
		else {
		response.sendRedirect("http://www.lowagie.com/iText/tutorial/ch01.html#step2");
		}
		// step 3
		document.open();
		
		
		AllClients all = allclientsService.findById(id);
		String t=all.getType();
		Ticket ticket = ticketService.findByType(t);
		
		
		
		 PdfPTable table = new PdfPTable(5);
	        // the cell object
		 table.setPaddingTop(10.0f);
		 
		 Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(BaseColor.WHITE);
		 
	        PdfPCell cell =new PdfPCell();
	        // we add a cell with colspan 3
	        cell.setBackgroundColor(BaseColor.BLACK);
	        cell.setPadding(5);
	     // write table header
	        
	        cell.setPhrase(new Phrase("FAKTURA", font));
	        cell.setVerticalAlignment(Element.ALIGN_CENTER);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	       
	        cell.setColspan(5);
	        table.addCell(cell);
	        // now we add a cell with rowspan 2
	        cell = new PdfPCell(new Phrase(""));
	        cell.setBorderColor(BaseColor.WHITE);
	        cell.setColspan(5);
	       // cell.setRowspan(2);
	        cell.setMinimumHeight(20.0f);
	        table.addCell(cell);
	        
	        
	        cell = new PdfPCell(new Phrase("Identyfikator:  " + all.getId().toString()+'\n' + "Imie:               " + all.getFirstName()+'\n'+ "Nazwisko:      "+ all.getLastName()+ '\n'));
	        cell.setBorderColor(BaseColor.WHITE);
	        cell.setColspan(2);
	       // cell.setRowspan(2);
	        cell.setMinimumHeight(100.0f);
	        table.addCell(cell);
	        
	        Image img = Image.getInstance("http://www.naquarius.naklo.pl/uploads/pub/ads_files/ads_3/logo.png");
	        img.setWidthPercentage(100.0f);
	        //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
	        cell = new PdfPCell(img, true);
	        cell.setBorderColor(BaseColor.WHITE);
	        cell.setColspan(3);
	        cell.setMinimumHeight(100.0f);
	        cell.setPaddingLeft(100.0f);
	        cell.setPaddingBottom(100.0f);
	       // cell.setRowspan(2);
	        table.addCell(cell);
	        
	        
	        
	        cell = new PdfPCell(new Phrase(""));
	        cell.setBorderColor(BaseColor.WHITE);
	        cell.setColspan(5);
	       // cell.setRowspan(2);
	        cell.setMinimumHeight(20.0f);
	        table.addCell(cell);
	        
                //<->
                PdfPCell cell4 = new PdfPCell(new Phrase(""));
        cell4.setBorderColor(BaseColor.WHITE);
        cell4.setColspan(5);
        table.addCell(cell4);
        table.addCell(cell4);
        cell4 = new PdfPCell(new Phrase(""));
        cell4.setBorderColor(BaseColor.WHITE);
        cell4.setColspan(2);
        table.addCell(cell4);
        cell4 = new PdfPCell(new Phrase("Data"));
	cell4.setBorderColor(BaseColor.BLACK);
	cell4.setColspan(1);
        table.addCell(cell4);
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dateString = dateFormat.format(currentDate);
        cell4 = new PdfPCell(new Phrase(dateString));
	cell4.setBorderColor(BaseColor.BLACK);
	cell4.setColspan(2);
        table.addCell(cell4);
        cell4 = new PdfPCell(new Phrase(""));
        cell4.setBorderColor(BaseColor.WHITE);
        cell4.setColspan(2);
        table.addCell(cell4);
        cell4 = new PdfPCell(new Phrase("Kwota"));
	cell4.setBorderColor(BaseColor.BLACK);
	cell4.setColspan(1);
        table.addCell(cell4);
        cell4 = new PdfPCell(new Phrase(ticket.getPrice() + " PLN"));
	cell4.setBorderColor(BaseColor.BLACK);
	cell4.setColspan(2);
        table.addCell(cell4);
      
        //<->
        cell4 = new PdfPCell(new Phrase(""));
	cell4.setBorderColor(BaseColor.WHITE);
	cell4.setColspan(5);
        table.addCell(cell4);
                //<->
	        
	        Font font2 = FontFactory.getFont(FontFactory.HELVETICA);
	        font2.setColor(BaseColor.BLACK);
                font2.isBold();
	        font2.setSize(20.0f);
	        
	        //przerwa
	        cell = new PdfPCell(new Phrase("NAQUARIUS\nNAKLO NAD NOTECIA",font2));
	        cell.setBorderColor(BaseColor.WHITE);
	        cell.setColspan(5);
	       // cell.setRowspan(2);
	       
	        cell.setVerticalAlignment(Element.ALIGN_LEFT);
	        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cell.setMinimumHeight(70.0f);
	        table.addCell(cell);
	        
	        //<->
                
                //<->
        PdfPCell cell3 = new PdfPCell(new Phrase(""));
        cell3.setBorderColor(BaseColor.WHITE);
        cell3.setColspan(5);
        table.addCell(cell3);
        cell3 = new PdfPCell(new Phrase("Rodzaj"));
        cell3.setColspan(2);
        table.addCell(cell3);
        cell3 = new PdfPCell(new Phrase(ticket.getType()));
	cell3.setBorderColor(BaseColor.BLACK);
	cell3.setColspan(3);
        table.addCell(cell3);
        cell3 = new PdfPCell(new Phrase("Opis"));
        cell3.setColspan(2);
        table.addCell(cell3);
        cell3 = new PdfPCell(new Phrase("-"));
	cell3.setBorderColor(BaseColor.BLACK);
	cell3.setColspan(3);
        table.addCell(cell3);
        cell3 = new PdfPCell(new Phrase("Cena za godzine"));
        cell3.setColspan(2);
        table.addCell(cell3);
        cell3 = new PdfPCell(new Phrase(ticket.getPrice() + " PLN"));
	cell3.setBorderColor(BaseColor.BLACK);
	cell3.setColspan(3);
        table.addCell(cell3);
        cell3 = new PdfPCell(new Phrase("Ilosc"));
        cell3.setColspan(2);
        table.addCell(cell3);
        cell3 = new PdfPCell(new Phrase("1"));
	cell3.setBorderColor(BaseColor.BLACK);
	cell3.setColspan(3);
        table.addCell(cell3);
        cell3 = new PdfPCell(new Phrase("Cena ogolna"));
        cell3.setColspan(2);
        table.addCell(cell3);
        cell3 = new PdfPCell(new Phrase(ticket.getPrice() + " PLN"));
	cell3.setBorderColor(BaseColor.BLACK);
	cell3.setColspan(3);
        table.addCell(cell3);
        cell3 = new PdfPCell(new Phrase(""));
        cell3.setBorderColor(BaseColor.WHITE);
        cell3.setColspan(5);
        table.addCell(cell3);
                //<->
               //przerwa
	        cell = new PdfPCell(new Phrase(""));
	        cell.setBorderColor(BaseColor.WHITE);
	        cell.setColspan(5);
	       // cell.setRowspan(2);
	        cell.setMinimumHeight(60.0f);
	        table.addCell(cell); 
                
        PdfPCell cell7 = new PdfPCell(new Phrase(""));
        cell7.setBorderColor(BaseColor.WHITE);
        cell7.setColspan(5);
        table.addCell(cell7);
        cell7 = new PdfPCell(new Phrase(""));
        cell7.setBorderColor(BaseColor.WHITE);
        cell7.setColspan(2);
        table.addCell(cell7);
        cell7 = new PdfPCell(new Phrase("Cena netto"));
	cell7.setBorderColor(BaseColor.BLACK);
	cell7.setColspan(1);
        table.addCell(cell7);
        cell7 = new PdfPCell(new Phrase(ticket.getPrice() + " PLN"));
	cell7.setBorderColor(BaseColor.BLACK);
	cell7.setColspan(2);
        table.addCell(cell7);
        cell7 = new PdfPCell(new Phrase(""));
        cell7.setBorderColor(BaseColor.WHITE);
        cell7.setColspan(2);
        table.addCell(cell7);
        cell7 = new PdfPCell(new Phrase("Podatek"));
	cell7.setBorderColor(BaseColor.BLACK);
	cell7.setColspan(1);
        table.addCell(cell7);
        cell7 = new PdfPCell(new Phrase("23%"));
	cell7.setBorderColor(BaseColor.BLACK);
	cell7.setColspan(2);
        table.addCell(cell7);
        cell7 = new PdfPCell(new Phrase(""));
        cell7.setBorderColor(BaseColor.WHITE);
        cell7.setColspan(2);
        table.addCell(cell7);
        cell7 = new PdfPCell(new Phrase("Cena brutto"));
	cell7.setBorderColor(BaseColor.BLACK);
	cell7.setColspan(1);
        table.addCell(cell7);
        //Brutto
        double netto = Double.parseDouble(ticket.getPrice());
        double brutto = netto + (netto*0.23);
        String total = Double.toString(brutto);
        cell7 = new PdfPCell(new Phrase(total + " PLN"));
	cell7.setBorderColor(BaseColor.BLACK);
	cell7.setColspan(2);
        table.addCell(cell7);
      
        //<->
        cell7 = new PdfPCell(new Phrase(""));
	cell7.setBorderColor(BaseColor.WHITE);
	cell7.setColspan(5);
        table.addCell(cell7);
        //<->
               //przerwa
	        cell = new PdfPCell(new Phrase(""));
	        cell.setBorderColor(BaseColor.WHITE);
	        cell.setColspan(5);
	       // cell.setRowspan(2);
	        cell.setMinimumHeight(60.0f);
	        table.addCell(cell); 
                
                Font font3 = FontFactory.getFont(FontFactory.HELVETICA);
	        font3.setColor(BaseColor.BLACK);
                font3.isStrikethru();
	        font3.setSize(15.0f);
        
                PdfPCell cell8 = new PdfPCell(new Phrase("                                    I N N E   U W A R U N K O W A N I A",font3));
        cell8.setBorderColor(BaseColor.WHITE);
        cell8.setColspan(5);
        table.addCell(cell8);
        
	        
	        //przerwa
	        cell = new PdfPCell(new Phrase(""));
	        cell.setBorderColor(BaseColor.WHITE);
	        cell.setColspan(5);
	       // cell.setRowspan(2);
	        cell.setMinimumHeight(60.0f);
	        table.addCell(cell);
	        
	        cell = new PdfPCell(new Phrase(""));
	        cell.setBorderColor(BaseColor.WHITE);
	        cell.setColspan(3);
	       // cell.setRowspan(2);
	        
	        table.addCell(cell);
	        //1
	                   
	              
	      	         
	       
		
		//document.add(new Paragraph(new Date().toString()));
		document.add(table);
		
		
		}
		catch(DocumentException de) {
		de.printStackTrace();
		System.err.println("document: " + de.getMessage());
		}
		// step 5: we close the document (the outputstream is also closed internally)
		document.close();
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