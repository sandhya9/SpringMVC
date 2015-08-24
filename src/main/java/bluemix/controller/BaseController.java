package bluemix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.log4j.Logger;

import bluemix.service.AccountService;

@Controller
@RequestMapping("/")
public class BaseController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	final static Logger logger = Logger.getLogger(BaseController.class);

	private AccountService accountService;

	@RequestMapping(method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : " + counter);

		model.addAttribute("debugStatement", "AccountService"+accountService);
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;
	}

	@RequestMapping(path="/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", ++counter);
		logger.debug("[welcomeName] counter : " + counter);
 
		model.addAttribute("foundAccounts", accountService.getAccounts());
		return VIEW_INDEX;
	}


	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}


}
