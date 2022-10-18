CREATE TABLE `user_refresh_token`
(
    `refresh_token_seq` BIGINT         NOT NULL AUTO_INCREMENT,
    `user_id`           VARCHAR(64)    NOT NULL ,
    `refresh_token`     VARCHAR(255)   NOT NULL ,
    PRIMARY KEY (`refresh_token_seq`)
)   DEFAULT CHARSET = UTF8MB4;