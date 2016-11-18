package net.madvirus.spring4.account;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class); 
	
	@RequestMapping("/accounts")
	@ResponseBody
	public Object getAllAccount(){
		logger.info("fetch accounts success");
		return accountService.selectAll();
	}
	
	@RequestMapping("/accounts/count")
	@ResponseBody
	public Object getAllAccountCount(){
		logger.info("fetch accounts success");
		return accountService.selectAllCount();
	}
}
