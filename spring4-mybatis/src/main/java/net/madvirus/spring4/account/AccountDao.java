package net.madvirus.spring4.account;

import java.util.List;

import net.madvirus.spring4.account.vo.AccountForSelect;

public interface AccountDao {
	List<AccountForSelect> selectAll();
	Long selectAllCount();
}
