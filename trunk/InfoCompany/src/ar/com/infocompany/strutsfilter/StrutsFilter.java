package ar.com.infocompany.strutsfilter;


import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import ar.com.infocompany.persistence.HibernateUtil;

import org.hibernate.HibernateException;

public class StrutsFilter extends StrutsPrepareAndExecuteFilter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
		try {
			HibernateUtil.createSessionFactory();
			System.out.print("aplicacion iniciada exitosamente");
		} catch (HibernateException e) {
			throw new ServletException(e);
		}
	}

}
