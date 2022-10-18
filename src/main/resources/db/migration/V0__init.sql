CREATE TABLE `users`
(
    `id`                BIGINT          NOT NULL AUTO_INCREMENT,
    `nick_name`         VARCHAR(255)    NOT NULL ,
    `email`             VARCHAR(255)    NOT NULL ,
    `name`              VARCHAR(255)             ,
    `gender`            VARCHAR(20)              ,
    `profile_img`       VARCHAR(255)             ,
    `user_roles`        VARCHAR(20)              ,
    `birth_day`         VARCHAR(20)              ,
    `auth_provider`     VARCHAR(255)             ,
    `created_at`        DATETIME                 ,
    `modified_at`       DATETIME                 ,
    PRIMARY KEY (`id`)
)   DEFAULT CHARSET = UTF8MB4;

CREATE TABLE `post`
(
    `post_id`          BIGINT          NOT NULL AUTO_INCREMENT,
    `user_id`          BIGINT          NOT NULL ,
    `location`         VARCHAR(20)              ,
    `title`            VARCHAR(255)             ,
    `represent_img`    VARCHAR(255)             ,
    `start_date`       DATETIME                 ,
    `end_date`         DATETIME                 ,
    `created_at`       DATETIME                 ,
    `modified_at`      DATETIME                 ,
    PRIMARY KEY (`post_id`)                     ,
    FOREIGN KEY (`user_id`) REFERENCES `users` (id)
)   DEFAULT CHARSET = UTF8MB4;

CREATE TABLE `content`
(
    `content_id`       BIGINT          NOT NULL AUTO_INCREMENT,
    `post_id`          BIGINT          NOT NULL ,
    `img`              VARCHAR(255)             ,
    `description`      TEXT                     ,
    `start_date`       DATETIME                 ,
    `end_date`         DATETIME                 ,
    `created_at`       DATETIME                 ,
    `modified_at`      DATETIME                 ,
    PRIMARY KEY (`content_id`)                  ,
    FOREIGN KEY (`post_id`) REFERENCES `post` (post_id)
)   DEFAULT CHARSET = UTF8MB4;