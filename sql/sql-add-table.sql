--create blog
create table blog(
	id bigint NOT NULL auto_increment,
    content text,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;