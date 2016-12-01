package com.mustache.webservice.account.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by kim on 2016-12-01.
 */
@Data
public class AccountForSelect {
    private String userId;
    private String passwd;
    private String userName;
    private String userEmail;
    private Timestamp requestDate;
    private Timestamp permitDate;

    private String authName;
    private String permit;
}
