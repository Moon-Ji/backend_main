CREAtE TABLE `users`
(
    `id`            BIGINT          NOT NULL AUTO_INCREMENT,
    `nick_name`     VARCHAR(255)    NOT NULL ,
    `email`         VARCHAR(255)    NOT NULL ,
    `name`          VARCHAR(255)             ,
    `phone_number`  VARCHAR(255)             ,
    `profile_img`    VARCHAR(255)             ,
    `user_roles`    VARCHAR(255)             ,
    `auth_provider` VARCHAR(255)             ,
    `created_at`    DATETIME                 ,
    `modified_at`    DATETIME                 ,
    PRIMARY KEY (`id`)
)   DEFAULT CHARSET = UTF8MB4;