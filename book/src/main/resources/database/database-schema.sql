CREATE TABLE T_USER (
	USERID 			VARCHAR(36)  		DEFAULT ''	NOT NULL,
	USERNAME   		VARCHAR(60)   		DEFAULT '',
	EMAIL			VARCHAR(80)			DEFAULT '',
	PWD             VARCHAR(36)         DEFAULT '',
	PRIMARY KEY (USERID)
);