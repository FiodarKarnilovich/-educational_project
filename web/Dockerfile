FROM tomcat:10.1.6-jdk17

#app
ADD target/java-mac.war /usr/local/tomcat/webapps/rentalcar.war


#manager
RUN cp -r webapps.dist/manager webapps
#RUN cp -r webapps.dist/ROOT webapps
#RUN cp -r webapps.dist/examples webapps
#RUN cp -r webapps.dist/host-manager webapps
#RUN cp -r webapps.dist/docs webapps


#settings
ADD tomcat-settings/tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
ADD tomcat-settings/context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml

EXPOSE 8080