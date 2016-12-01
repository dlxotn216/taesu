package com.mustache.webservice.admin.fb.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by Neonexsoft on 2016-12-01.
CREATE TABLE `fb_account` (
`FB_ACCOUNT_ID` INT(11) NOT NULL AUTO_INCREMENT,
`REG_USER_ID` INT(11) NOT NULL,
`FB_USER_ID` VARCHAR(50) NOT NULL,
`FB_USER_NAME` VARCHAR(50) NOT NULL,
`REG_DATE` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (`FB_ACCOUNT_ID`)
)
 */
@Data
public class FBSelect {
	private Integer fbAccountId;
	private Integer regUserId;
	private String fbUserId;
	private String fbUserName;
	private Timestamp regDate;
}
