package net.madvirus.spring4.member;

import java.util.List;


import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.madvirus.spring4.HomeController;
import net.madvirus.spring4.member.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/members/{id}")
	@ResponseBody
	public Object selectOne(@PathVariable String id){
		Member member = memberService.selectOne(id);
		logger.info("memberService.selectOne : "+member.getId());
		return member;
	}
	
	@RequestMapping("/members")
	@ResponseBody
	public List<Member>  select(@PathVariable String id){
		List<Member> members = memberService.selectMembers();
		for(Member m : members){
			logger.info("fetch members : "+m.getId());
		}
		return members;
	}
}
