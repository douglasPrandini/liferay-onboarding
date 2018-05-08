create table amf_registration_audit_log (
	id LONG not null primary key,
	action_time DATE null,
	screen_name VARCHAR(75) null,
	user_id LONG,
	ip_address VARCHAR(75) null,
	event_type VARCHAR(75) null
);