package net.madvirus.spring4.member;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.madvirus.spring4.member.vo.Member;

public interface MemberDao {
	Member selectOne(String id);
	List<Member> selectMembers();
}
