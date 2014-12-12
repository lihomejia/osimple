package com.norming.rpc.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.norming.bo.ISyncSth;
import com.norming.bo.ISyncSthElse;
import com.norming.bo.impl.SyncSthElseImpl;
import com.norming.bo.impl.SyncSthImpl;


public class RmiServerUtil {
	
	private static Log LOG = LogFactory.getLog(RmiServerUtil.class);

	private static Registry createRegistry() {
		Registry registry = null;

		int port = 1099;
		
		try {
			registry = LocateRegistry.getRegistry(port);
			registry.list();
			
			System.out.println("Register the exist server!");
		} catch (final Exception e) {
			try {
				registry = LocateRegistry.createRegistry(port);
				System.out.println("Register the server!port=" + port);
			} catch (final Exception ee) {
				LOG.error("SyncRMIServer.createRegistry() - " + ee);
			}
		}
		return registry;
	}

	/**
	 * 将对象注册到rmi服务器上
	 */
	public static void bind() {
		Registry registry = null;
		registry = createRegistry();
		try {
			registry.rebind(ISyncSth.class.getSimpleName(),			new SyncSthImpl());
			registry.rebind(ISyncSthElse.class.getSimpleName(), 	new SyncSthElseImpl());
			
			System.out.println("synchronizeTask server start!");
		} catch (Exception e) {
			LOG.error("SyncRMIServer.bind() - " + e);
		}
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		try {
			bind();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Integer i = -1;
		
		synchronized (i) {
			i.wait();
		}
		
	}

}
