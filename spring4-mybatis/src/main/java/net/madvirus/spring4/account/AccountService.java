package net.madvirus.spring4.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.madvirus.spring4.account.vo.AccountForSelect;

@Service
public class AccountService {
	@Autowired
	private AccountDao accountDao;
	
	public List<AccountForSelect> selectAll(){
		return accountDao.selectAll();
	}
	
	public Long selectAllCount(){
		return accountDao.selectAllCount();
	}
}
