CREAtE TABLE `post`
(
    `post_id`       BIGINT          NOT NULL AUTO_INCREMENT,


    `created_at`    DATETIME                 ,
    `modified_at`    DATETIME                 ,
    PRIMARY KEY (`post_id`)
)   DEFAULT CHARSET = UTF8M