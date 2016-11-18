package net.madvirus.spring4.member;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.madvirus.spring4.member.vo.Member;

@Service
public class MemberService {
	@Autowired
	private MemberDao mDao;
	
	public Member selectOne(String id){
		return mDao.selectOne(id);
	}
	public List<Member> selectMembers(){
		return mDao.selectMembers();
	}
}
