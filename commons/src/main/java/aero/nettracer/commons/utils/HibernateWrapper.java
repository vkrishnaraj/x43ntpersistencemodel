package aero.nettracer.commons.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public interface HibernateWrapper {

	public SessionFactory getSession();
	
	public Session createSession();
	
	public Session createSessionIfEmpty(Session session);
	
	public SessionFactory getDirtySession();
	
	public SessionFactory getReportingSession();

	public Configuration getConfig();
}