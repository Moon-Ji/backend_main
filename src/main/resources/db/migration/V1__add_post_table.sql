CREAtE TABLE `post`
(
    `post_id`          BIGINT          NOT NULL AUTO_INCREMENT,
    `user_id`          BIGINT          NOT NULL ,
    `location`         VARCHAR(20)              ,
    `title`            VARCHAR(255)             ,
    `represent_img`    VARCHAR(255)             ,
    `created_at`       DATETIME                 ,
    `modified_at`       DATETIME                 ,
    PRIMARY KEY (`post_id`)
)   DEFAULT CHARSET = UTF8M

CREAtE TABLE `content`
(
    `content_id`       BIGINT          NOT NULL AUTO_INCREMENT,
    `post_id`          BIGINT          NOT NULL ,
    `img`              VARCHAR(255)             ,
    'description'      VARCHAR(255)             ,
    `created_at`       DATETIME                 ,
    `modified_at`       DATETIME                 ,
    PRIMARY KEY (`content_id`)
)   DEFAULT CHARSET = UTF8M