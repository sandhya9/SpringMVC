SET DERBY_JARS=C:\apache-tomcat-8.0.24\lib

java -cp %DERBY_JARS%/derby.jar;%DERBY_JARS%/derbytools.jar -Dderby.system.home=%TOMCAT_HOME%\Databases -Dij.database=jdbc:derby:cust_acct;create=true org.apache.derby.tools.ij sampleRowsInsert.sql
	