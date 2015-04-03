package com.northwindx.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This static utility class creates an returns the same EntityManager for everyone.
 * Allows code simplification; instead of doing the try/catch everytime we need to 
 * access the database (wasting time and resources), we'll do it once and return that
 * same manager each time it's needed. 
 *
 */
public class PersistenceUtil {

	private static final EntityManager entityManger = buildEntityManager();

	/**
	 * Builds the EntityManager.
	 * <p>
	 * Only needed to run once and set to private so it can't be ran again.
	 * 
	 * @return	The built EntityManager
	 * @throws	ExceptionInInitializerError
	 */
	private static EntityManager buildEntityManager() {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("northwindx");
			return emf.createEntityManager();
		} catch (Throwable e) {
			System.err.println("Initial EntityManger Creation. " + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	/**
	 * @return The already created EntityManager 
	 */
	public static EntityManager getEntityManager() {
		return entityManger;
	}
	
	public static void shutdown() {
		getEntityManager().close();
	}
}