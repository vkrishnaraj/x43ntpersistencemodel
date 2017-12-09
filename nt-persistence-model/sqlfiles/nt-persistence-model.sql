-- These columns are not used anywhere in the application
alter table agent drop column exclude_from_autoload;
alter table agent drop column subcompany_id;
alter table bdo drop column delivery_comments;