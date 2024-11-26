
--
-- Structure for table project_table
--

DROP TABLE IF EXISTS project_table;
CREATE TABLE project_table (
id_project int AUTO_INCREMENT,
un_entier int default '0',
deux_sh varchar(50) default '',
trois_md varchar(255) default '',
quatre_lg long varchar,
cinq_mail varchar(255) default '',
six_url varchar(255) default '',
sept_date date,
huit_b SMALLINT,
neuf_file varchar(50),
PRIMARY KEY (id_project)
);
