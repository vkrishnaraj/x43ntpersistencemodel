-- These columns are not used anywhere in the application
alter table agent drop column exclude_from_autoload;
alter table agent drop column subcompany_id;
alter table bdo drop column delivery_comments;
alter table item drop column categorytype_ID;
alter table item drop column keycontents;
alter table item drop column oversize;
alter table item drop column overweight;
alter table ohd drop column wt_status;
alter table ohd drop column oversize;
alter table ohd drop column overweight;
alter table ohd_inventory drop COLUMN ohd_itemtype_id;
