package com.norming.domain;


public class PoolProperties {
	
	/**
	 * (String) Database Server 
	 * Not counting pool property.
	 */
	private String dbServer;
	
	/**
	 * (String) Database Name 
	 * Not counting pool property.
	 */
	private String dbName;
	
	/**
	 * (int) Database port
	 * Not counting pool property.
	 */
	private int dbPort;
	
	/**
	 * ************************************************************************
	 */
	
	
	/**
	* (boolean) The default auto-commit state of connections created by this pool. If not set, default is JDBC driver default (If not set then the setAutoCommit method will not be called.)
	*/
	private boolean defaultAutoCommit;
	

	/**
	 * (boolean) The default read-only state of connections created by this pool. If not set then the setReadOnly method will not be called. (Some drivers don't support read only mode, ex: Informix)
	 */
	private boolean defaultReadOnly;
	

	/**
	 * (String) The default TransactionIsolation state of connections created by this pool. One of the following: (see javadoc )
	 * NONE
	 * READ_COMMITTED
	 * READ_UNCOMMITTED
	 * REPEATABLE_READ
	 * SERIALIZABLE
	 * If not set, the method will not be called and it defaults to the JDBC driver.
	 */
	private String defaultTransactionIsolation;
	

	/**
	 * (String) The default catalog of connections created by this pool.
	 */
	private String defaultCatalog;
	

	/**
	 * (String) The fully qualified Java class name of the JDBC driver to be used. The driver has to be accessible from the same classloader as tomcat-jdbc.jar
	 */
	private String driverClassName;	
	

	/**
	 * (String) The connection username to be passed to our JDBC driver to establish a connection. Note that method DataSource.getConnection(username,password) by default will not use credentials passed into the method, but will use the ones configured here. See alternateUsernameAllowed property for more details.
	 */
	private String username;	
	

	/**
	 * (String) The connection password to be passed to our JDBC driver to establish a connection. Note that method DataSource.getConnection(username,password) by default will not use credentials passed into the method, but will use the ones configured here. See alternateUsernameAllowed property for more details.
	 */
	private String password;	
	
	/**
	 * (int) The maximum number of active connections that can be allocated from this pool at the same time. The default value is 100
	 */
	private int maxActive = 100;	
	

	/**
	 * (int) The maximum number of connections that should be kept in the pool at all times. Default value is maxActive:100 Idle connections are checked periodically (if enabled) and connections that been idle for longer than minEvictableIdleTimeMillis will be released. (also see testWhileIdle)
	 */
	private int maxIdle;	
	

	/**
	 * (int) The minimum number of established connections that should be kept in the pool at all times. The connection pool can shrink below this number if validation queries fail. Default value is derived from initialSize:10 (also see testWhileIdle)
	 */
	private int minIdle;
	

	/**
	 * (int)The initial number of connections that are created when the pool is started. Default value is 10
	 */
	private int initialSize = 10;	
	

	/**
	 * (int) The maximum number of milliseconds that the pool will wait (when there are no available connections) for a connection to be returned before throwing an exception. Default value is 30000 (30 seconds)
	 */
	private int maxWait = 30000;	
	
	/**
	 * (boolean) The indication of whether objects will be validated before being borrowed from the pool. If the object fails to validate, it will be dropped from the pool, and we will attempt to borrow another. NOTE - for a true value to have any effect, the validationQuery parameter must be set to a non-null string. In order to have a more efficient validation, see validationInterval. Default value is false
	 */
	private boolean testOnBorrow = false;	
	

	/**
	 * (boolean) The indication of whether objects will be validated before being returned to the pool. NOTE - for a true value to have any effect, the validationQuery parameter must be set to a non-null string. The default value is false.
	 */
	private boolean testOnReturn = false;
	

	/**
	 * (boolean) The indication of whether objects will be validated by the idle object evictor (if any). If an object fails to validate, it will be dropped from the pool. NOTE - for a true value to have any effect, the validationQuery parameter must be set to a non-null string. The default value is false and this property has to be set in order for the pool cleaner/test thread is to run (also see timeBetweenEvictionRunsMillis)
	 */
	private boolean testWhileIdle;	
	

	/**
	 * (String) The SQL query that will be used to validate connections from this pool before returning them to the caller. If specified, this query does not have to return any data, it just can't throw a SQLException. The default value is null. Example values are SELECT 1(mysql), select 1 from dual(oracle), SELECT 1(MS Sql Server)
	 */
	private String validationQuery;	
	

	/**
	 * (int) The timeout in seconds before a connection validation queries fail. This works by calling java.sql.Statement.setQueryTimeout(seconds) on the statement that executes the validationQuery. The pool itself doesn't timeout the query, it is still up to the JDBC driver to enforce query timeouts. A value less than or equal to zero will disable this feature. The default value is -1.
	 */
	private int validationQueryTimeout = - 1;	
	

	/**
	 * (String) The name of a class which implements the org.apache.tomcat.jdbc.pool.Validator interface and provides a no-arg constructor (may be implicit). If specified, the class will be used to create a Validator instance which is then used instead of any validation query to validate connections. The default value is null. An example value is com.mycompany.project.SimpleValidator.
	 */
	private String validatorClassName;	
	

	/**
	 * (int) The number of milliseconds to sleep between runs of the idle connection validation/cleaner thread. This value should not be set under 1 second. It dictates how often we check for idle, abandoned connections, and how often we validate idle connections. The default value is 5000 (5 seconds).
	 */
	private int timeBetweenEvictionRunsMillis = 5000;
	
	/**
	 * (int) Property not used in tomcat-jdbc-pool.
	 */
	private int numTestsPerEvictionRun;

	/**
	 * (int) The minimum amount of time an object may sit idle in the pool before it is eligible for eviction. The default value is 60000 (60 seconds).
	 */
	private int minEvictableIdleTimeMillis = 6000;
	

	/**
	 * (boolean) Property not used. Access can be achieved by calling unwrap on the pooled connection. see javax.sql.DataSource interface, or call getConnection through reflection or cast the object as javax.sql.PooledConnection
	 */
	private boolean accessToUnderlyingConnectionAllowed;
	

	/**
	 * (boolean) Flag to remove abandoned connections if they exceed the removeAbandonedTimeout. If set to true a connection is considered abandoned and eligible for removal if it has been in use longer than the removeAbandonedTimeout Setting this to true can recover db connections from applications that fail to close a connection. See also logAbandoned The default value is false.
	 */
	private boolean removeAbandoned = false;
	

	/**
	 * (int) Timeout in seconds before an abandoned(in use) connection can be removed. The default value is 60 (60 seconds). The value should be set to the longest running query your applications might have.
	 */
	private int removeAbandonedTimeout;
	

	/**
	 * (boolean) Flag to log stack traces for application code which abandoned a Connection. Logging of abandoned Connections adds overhead for every Connection borrow because a stack trace has to be generated. The default value is false.
	 */
	private boolean logAbandoned = false;
	

	/**
	 * (String) The connection properties that will be sent to our JDBC driver when establishing new connections. Format of the string must be [propertyName=property;]* NOTE - The "user" and "password" properties will be passed explicitly, so they do not need to be included here. The default value is null.
	 */
	private String connectionProperties;

	/**
	 * (boolean) Property not used.
	 */
	private boolean poolPreparedStatements;	

	/**
	 * (int) Property not used.
	 */
	private int maxOpenPreparedStatements;
	
	
	/**
	 * **********************************************************************
	 *  Getting & Setting
	 * **********************************************************************
	 */

	public String getDbServer() {
		return dbServer;
	}

	public void setDbServer(String dbServer) {
		this.dbServer = dbServer;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public int getDbPort() {
		return dbPort;
	}

	public void setDbPort(int dbPort) {
		this.dbPort = dbPort;
	}


	/**
	 * ******************************************************************************
	 */
	
	
	public boolean isDefaultAutoCommit() {
		return defaultAutoCommit;
	}

	public void setDefaultAutoCommit(boolean defaultAutoCommit) {
		this.defaultAutoCommit = defaultAutoCommit;
	}

	public boolean isDefaultReadOnly() {
		return defaultReadOnly;
	}

	public void setDefaultReadOnly(boolean defaultReadOnly) {
		this.defaultReadOnly = defaultReadOnly;
	}

	public String getDefaultTransactionIsolation() {
		return defaultTransactionIsolation;
	}

	public void setDefaultTransactionIsolation(String defaultTransactionIsolation) {
		this.defaultTransactionIsolation = defaultTransactionIsolation;
	}

	public String getDefaultCatalog() {
		return defaultCatalog;
	}

	public void setDefaultCatalog(String defaultCatalog) {
		this.defaultCatalog = defaultCatalog;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

	public int getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public boolean isTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}

	public int getValidationQueryTimeout() {
		return validationQueryTimeout;
	}

	public void setValidationQueryTimeout(int validationQueryTimeout) {
		this.validationQueryTimeout = validationQueryTimeout;
	}

	public String getValidatorClassName() {
		return validatorClassName;
	}

	public void setValidatorClassName(String validatorClassName) {
		this.validatorClassName = validatorClassName;
	}

	public int getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public int getNumTestsPerEvictionRun() {
		return numTestsPerEvictionRun;
	}

	public void setNumTestsPerEvictionRun(int numTestsPerEvictionRun) {
		this.numTestsPerEvictionRun = numTestsPerEvictionRun;
	}

	public int getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public boolean isAccessToUnderlyingConnectionAllowed() {
		return accessToUnderlyingConnectionAllowed;
	}

	public void setAccessToUnderlyingConnectionAllowed(
			boolean accessToUnderlyingConnectionAllowed) {
		this.accessToUnderlyingConnectionAllowed = accessToUnderlyingConnectionAllowed;
	}

	public boolean isRemoveAbandoned() {
		return removeAbandoned;
	}

	public void setRemoveAbandoned(boolean removeAbandoned) {
		this.removeAbandoned = removeAbandoned;
	}

	public int getRemoveAbandonedTimeout() {
		return removeAbandonedTimeout;
	}

	public void setRemoveAbandonedTimeout(int removeAbandonedTimeout) {
		this.removeAbandonedTimeout = removeAbandonedTimeout;
	}

	public boolean isLogAbandoned() {
		return logAbandoned;
	}

	public void setLogAbandoned(boolean logAbandoned) {
		this.logAbandoned = logAbandoned;
	}

	public String getConnectionProperties() {
		return connectionProperties;
	}

	public void setConnectionProperties(String connectionProperties) {
		this.connectionProperties = connectionProperties;
	}

	public boolean isPoolPreparedStatements() {
		return poolPreparedStatements;
	}

	public void setPoolPreparedStatements(boolean poolPreparedStatements) {
		this.poolPreparedStatements = poolPreparedStatements;
	}

	public int getMaxOpenPreparedStatements() {
		return maxOpenPreparedStatements;
	}

	public void setMaxOpenPreparedStatements(int maxOpenPreparedStatements) {
		this.maxOpenPreparedStatements = maxOpenPreparedStatements;
	}	
}