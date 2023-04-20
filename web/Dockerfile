FROM tomcat:10.1.6-jdk17

ARG hikaricp_URL
ARG sfl4j_api_URL
ARG mysql_connector_j_URL

#app
ADD target/java-mac.war /usr/local/tomcat/webapps/rentalcar.war

WORKDIR /usr/local/tomcat

# JDBC datasource configuration
ADD tomcat-settings/conf/server.xml conf/
ADD tomcat-settings/conf/context.xml conf/

# required to start HikariCP inside Apache Tomcat
RUN wget -O lib/hikaricp.jar ${hikaricp_URL}
RUN wget -O lib/slf4j-api.jar ${sfl4j_api_URL}
RUN wget -O lib/mysql-connector-j.jar ${mysql_connector_j_URL}


#manager
RUN cp -r webapps.dist/manager webapps
RUN cp -r webapps.dist/ROOT webapps
RUN cp -r webapps.dist/examples webapps
RUN cp -r webapps.dist/host-manager webapps
RUN cp -r webapps.dist/docs webapps


#settings
ADD tomcat-settings/tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
ADD tomcat-settings/conf/context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml

EXPOSE 8080