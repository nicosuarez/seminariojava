package ar.com.infocompany.repository.hibernate;

import java.io.File;

import org.hibernate.cfg.Configuration;

public class SessionFactory {
	
	private static org.hibernate.SessionFactory _sessionFactory;
	
	private static void init()
	{
		org.hibernate.cfg.Configuration config = null;
		config = new org.hibernate.cfg.Configuration();
//		
		_sessionFactory = config.configure().buildSessionFactory();
		//config.addFile("")
		//Construir la base de datos en base a los archivos de mapeo.
//		org.hibernate.tool.hbm2ddl.SchemaExport se = new org.hibernate.tool.hbm2ddl.SchemaExport(config); 
//		se.execute(false,true,false,false);
//		File f=new File(servlet.getServletContext()
//				.getRealPath("/WEB-INF/classes/hibernate.cfg.xml"));
		
		
	}
	
	public static org.hibernate.SessionFactory getSessionFactory()
	{
		if(_sessionFactory == null)
		{
			init();
		}
		return _sessionFactory;
	}
	
	public static org.hibernate.Session getNewSession()
	{
		return getSessionFactory().openSession();
	}
	
	public static org.hibernate.Session getCurrentSession()
	{
		return getSessionFactory().getCurrentSession();
	}
	
}
