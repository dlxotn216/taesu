package net.madvirus.spring4.eq;
import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.madvirus.spring4.HomeController;
import net.madvirus.spring4.common.SearchOption;
import net.madvirus.spring4.eq.vo.EqForSelect;

@Controller
public class EqController {
	
	@Autowired
	private EqService eService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/eq", method=RequestMethod.GET)
	@ResponseBody
	public Object selectOne(SearchOption searchOption){
		
		List<EqForSelect> eq = eService.selectEq(searchOption);
		logger.info("eq fetch success");
		
		if(eq == null){
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		
		return eq;
	}
}
