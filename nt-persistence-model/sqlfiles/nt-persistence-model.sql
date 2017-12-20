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
alter table proactivenotification drop column membershipairline;
alter table proactivenotification drop column membershipNumber;
alter table table1 rename rule;

alter table signature change column 'date' 'createdate' datetime;

CREATE TABLE IF NOT EXISTS `scanner_data_queue` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `incident_id` varchar(13) NOT NULL,
  `bag_tag_number` varchar(14) NOT NULL,
  `incident_create_dateTime` datetime NOT NULL,
  `create_date` datetime NOT NULL,
  `scanned_dateTime` datetime DEFAULT NULL,
  `scan_status` varchar(20) NOT NULL,
  `error_message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_key` (`bag_tag_number`,`incident_create_dateTime`,`scan_status`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=363 DEFAULT CHARSET=utf8;

alter table scanner_data change column 'datetime' 'createdate' datetime;
drop table if exists special_flag;
drop table if exists wt_fwd_log_itinerary;
drop table if exists wt_fwd_log;

alter table z_b6_claim_settlement drop column amountclaimed;
alter table z_b6_claim_settlement drop column amountOffered;
alter table z_b6_claim_settlement drop column auditVOOffered;
alter table z_b6_claim_settlement drop column totalpaid;
alter table z_b6_claim_settlement drop column totalPaidCertif;
alter table z_b6_claim_settlement drop column totalPaidVouchers;
alter table fsclaim drop column claimprorate_id;
alter table fsclaim drop column ntincident_incident_id;
alter table fsclaim drop column signature_id;
alter table fsclaim drop column questionnaire_id;
alter table segment change column 'date' 'createdate' datetime;



-- Fraud Service Related Changes - Do we have any negative impact if we do this in agentview database.
alter table central_message change column 'timestamp' 'createdate' datetime;
drop table if exists accessrequest;
drop table if exists addresswhitelist;
drop table if exists blacklist;
drop table if exists internalsummary;
drop table if exists phonewhitelist;
drop table if exists whitelist;
drop table if exists central_message








