create index IX_F167F036 on amf_registration_audit_log (event_type[$COLUMN_LENGTH:75$], screen_name[$COLUMN_LENGTH:75$]);
create index IX_7A6A5A87 on amf_registration_audit_log (event_type[$COLUMN_LENGTH:75$], user_id);
create index IX_8A385249 on amf_registration_audit_log (screen_name[$COLUMN_LENGTH:75$]);
create index IX_B90CBE1A on amf_registration_audit_log (user_id);