package com.mustache.webservice.account;

import com.mustache.webservice.account.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by kim on 2016-11-29.
 */
@Mapper
public interface AccountDao {

    int createAccount(AccountForInsert account);
    int createAccountAythorityMapping(AccountForAuthorityMapping accountForAuthorityMapping);

    AccountForSecurity readAccountForSecurity(String userId);
    AccountForSelect readAccountById(String userId);
    List<AccountForSelect>  readAccount();

    int updateAccountById(AccountForUpdate account);
    int updateUserAccountById(AccountForUpdate account);
    int updateAccountAuthorityMapping(AccountForAuthorityMapping accountForAuthorityMapping);

    int deleteAccountById(String userId);
    int deleteAccountAuthorityMapping(String userId);
}
