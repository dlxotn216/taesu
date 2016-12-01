package com.mustache.webservice.account.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by kim on 2016-11-30.
 */
@Data
public class AccountForUpdate {
    private String userId;
    private String passwd;
    private String userName;
    private String userEmail;
    private Timestamp requestDate;
    private Timestamp permitDate;

    private String authName;
    private String permit;
}
