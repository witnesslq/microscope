package com.vipshop.microscope.storage.hbase.factory;

import org.apache.hadoop.conf.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vipshop.microscope.storage.hbase.repository.AppTableRepository;
import com.vipshop.microscope.storage.hbase.repository.ExceptionTableRepository;
import com.vipshop.microscope.storage.hbase.repository.JVMTableRepository;
import com.vipshop.microscope.storage.hbase.repository.ServletTableRepository;
import com.vipshop.microscope.storage.hbase.repository.SpanTableRepository;
import com.vipshop.microscope.storage.hbase.repository.TopTableRepository;
import com.vipshop.microscope.storage.hbase.repository.TraceTableRepository;
import com.vipshop.microscope.storage.hbase.repository.UserTableRepository;

/**
 * Hbase Factory responsible for create Repository.
 * 
 * @author Xu Fei
 * @version 1.0
 */
public class RepositoryFactory {
	
	private static final AppTableRepository   APP_TABLE;
	private static final TraceTableRepository TRACE_TABLE;
	private static final SpanTableRepository  SPAN_TABLE;
	
	private static final ExceptionTableRepository EXCEPTION_TABLE;
	private static final JVMTableRepository JVM_TABLB;
	private static final ServletTableRepository SERVLET_TABLB;
	
	
	private static final TopTableRepository TOP_TABLE;
	
	private static final UserTableRepository USER_TABLE;
	
	/**
	 * Initialize hbase tables. 
	 */
	static {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext-storage-hbase.xml", RepositoryFactory.class);
		APP_TABLE   = context.getBean(AppTableRepository.class);
		TRACE_TABLE = context.getBean(TraceTableRepository.class);
		SPAN_TABLE  = context.getBean(SpanTableRepository.class);
		EXCEPTION_TABLE = context.getBean(ExceptionTableRepository.class);
		JVM_TABLB = context.getBean(JVMTableRepository.class);
		TOP_TABLE = context.getBean(TopTableRepository.class);
		USER_TABLE = context.getBean(UserTableRepository.class);
		SERVLET_TABLB = context.getBean(ServletTableRepository.class);
		
		APP_TABLE.initialize();
		TRACE_TABLE.initialize();
		SPAN_TABLE.initialize();
		EXCEPTION_TABLE.initialize();
		TOP_TABLE.initialize();
		JVM_TABLB.initialize();
		USER_TABLE.initialize();
		SERVLET_TABLB.initialize();
		
		context.close();
	}
	
	/**
	 * Return {@link AppTableRepository}
	 * 
	 * @return
	 */
	public static AppTableRepository getAppTableRepository() {
		return APP_TABLE;
	}
	
	/**
	 * Return {@link TraceTableRepository}
	 * 
	 * @return
	 */
	public static TraceTableRepository getTraceTableRepository() {
		return TRACE_TABLE;
	}
	
	/**
	 * Return {@link SpanTableRepository}
	 * 
	 * @return
	 */
	public static SpanTableRepository getSpanTableRepository() {
		return SPAN_TABLE;
	}
	
	/**
	 * Return {@link ExceptionTableRepository}
	 * 
	 * @return
	 */
	public static ExceptionTableRepository getExceptionTableRepository() {
		return EXCEPTION_TABLE;
	}
	
	/**
	 * Return {@link JVMTableRepository}
	 * 
	 * @return
	 */
	public static JVMTableRepository getJVMTableRepository() {
		return JVM_TABLB;
	}
	
	/**
	 * Return {@link TopTableRepository}
	 * 
	 * @return
	 */
	public static TopTableRepository getTopTableRepository() {
		return TOP_TABLE;
	}
	
	/**
	 * Return {@link UserTableRepository}
	 * @return
	 */
	public static UserTableRepository getUserTableRepository() {
		return USER_TABLE;
	}
	
	/**
	 * 
	 * @return
	 */
	public static ServletTableRepository getServletTableRepository() {
		return SERVLET_TABLB;
	}
	
	public static Configuration getConfiguration() {
		return USER_TABLE.getConfiguration();
	}
	
}
