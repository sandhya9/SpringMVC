copy target\bluemix-springmvc.war C:\apache-tomcat-8.0.24\webapps
del *.log
set DERBY_HOME=%TOMCAT_HOME%\Databases
%CATALINA_HOME%\bin\catalina.bat run > tomcat.log 2>&1
