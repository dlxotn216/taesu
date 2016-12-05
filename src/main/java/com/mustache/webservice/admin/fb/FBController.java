package com.mustache.webservice.admin.fb;

import com.mustache.webservice.admin.fb.vo.FBSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Neonexsoft on 2016-12-01.
 */
@Controller
@RequestMapping("/admin/fb")
public class FBController {

	@Autowired
	private FBService fbService;

	@RequestMapping(value={"", "/"}, method= RequestMethod.GET)
	public String fbIndex(){
		return "redirect:list";
	}

	@RequestMapping(value="/list", method= RequestMethod.GET)
	public String fbList(Model model){
		model.addAttribute("FB", fbService.selectAllFBAccount());
		return "admin/fb/list";
	}

	@RequestMapping(value="/add", method= RequestMethod.GET)
	public String fbAdd(Model model){
		return "admin/fb/add";
	}


	@RequestMapping(value="/add", method= RequestMethod.POST)
	public Object fbAddProcess(Model model, @ModelAttribute FBSelect fbSelect){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("[DEBUG] : SESSION NAME : " + user.getUsername());
		fbSelect.setRegUserId(user.getUsername());

		fbService.insertFBAccount(fbSelect);
		return "redirect:list";
	}

	@RequestMapping(value="/{fbAccountId}", method= RequestMethod.GET)
	public String fbDetail(@PathVariable Integer fbAccountId, Model model){
		FBSelect fbAccount = fbService.selectFBAccountByFBAccountId(fbAccountId);
		if( fbAccount == null ){
			return "admin/fb/empty";
		} else {
			model.addAttribute("FB", fbAccount);
			return "admin/fb/detail";
		}
	}

	@RequestMapping(value="/{fbAccountId}", method= RequestMethod.PUT)
	@ResponseBody
	public Object fbUpdate(@PathVariable Integer fbAccountId, @RequestBody FBSelect fbAccount, Model model){
		Map<String, Object> response = new HashMap<>();
		fbAccount.setFbAccountId(fbAccountId);
		fbService.updateFBAccount(fbAccount);
		response.put("STATUS", "200");
		return response;
	}

	@RequestMapping(value="/{fbAccountId}", method= RequestMethod.DELETE)
	@ResponseBody
	public Object fbDelete(@PathVariable Integer fbAccountId, Model model){
		Map<String, Object> response = new HashMap<>();
		fbService.deleteFBAccountByFBAccountId(fbAccountId);
		response.put("STATUS", "200");
		return response;
	}

}
