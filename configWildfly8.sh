#!/bin/bash
echo "STARTING CONFIGURATIONS...";

echo "ENTRE COM O DIRETÓRIO ONDE DESEJA INSTALAR O WILDFLY. EX: /home/usuario";
read WILDFLY_INSTALL;


WILDFLY_DIR=$WILDFLY_INSTALL/wildfly-8.1.0.Final;


echo "DIGITE SUA SENHA PARA UTILIZAÇÃO NO COMANDO SUDO: " 
sudo chmod -R 777 /tmp 																#SERVE APENAS PARA ABILITAR O SUDO NO CACHE

##################### CRIA BANCO DE DADOS E USUÁRIO ####################

echo "DIGITE A SENHA DO USUARIO ROOT DO MYSQL"
read MYSQL_SENHA;
mysql -u root -p$MYSQL_SENHA -e 'create database hurraa'
mysql -u root -p$MYSQL_SENHA -e "grant all privileges on hurraa.* to hurraa@localhost identified by 'hurraa'"

######################### ENVIRONMENT VARIABLE #########################
WF_FILE=/etc/profile.d/wf.sh;

if ! [ -f "$WF_FILE" ]; then
	echo "Setting environment variable";
	echo "creating $WF_FILE...";
	sudo echo "export WILDFLY_HOME=/opt/wildfly-8.1.0.Final" >> $WF_FILE;
fi;


######################### WILDFLY SERVER ###############################
cd /tmp;

WILDFLY_ZIP=wildfly-8.1.0.Final.zip;
 
if ! [ -d "$WILDFLY_DIR" ]; then
	if ! [ -f "$WILDFLY_ZIP" ]; then
		echo "DOWNLOADING WILDFLY 8 FINAL...";
		wget http://download.jboss.org/wildfly/8.1.0.Final/wildfly-8.1.0.Final.zip;
	fi;
	echo "EXTRACTING $WILDFLY_ZIP";
	mkdir -p $WILDFLY_INSTALL;
	unzip wildfly-8.1.0.Final.zip -d $WILDFLY_INSTALL;	
fi;

#################### WILDFLY SERVER CONFIGURATION ######################
echo "SETTING THE SERVER WILDFLY";
echo "STARTING SERVER WILDFLY";

$WILDFLY_DIR/bin/./standalone.sh &

sleep 10


######################### ADD MODULOS #################################

MYSQLDRIVER=/tmp/mysql-connector-java-5.1.29.jar;
if ! [ -f $MYSQLDRIVER ]; then
	echo "DOWNLOADING MYSQL DRIVER 5.1.29";
	wget http://repo1.maven.org/maven2/mysql/mysql-connector-java/5.1.29/mysql-connector-java-5.1.29.jar;

fi;



$WILDFLY_DIR/bin/./jboss-cli.sh --connect --command='module add --name=com.mysql --resources=/tmp/mysql-connector-java-5.1.29.jar --dependencies=javax.api' 


######################### POOL MYSQL #################################
echo "SETTING POOLS";
													  
$WILDFLY_DIR/bin/./jboss-cli.sh --connect --commands='./subsystem=datasources/jdbc-driver=com.mysql:add(driver-name="com.mysql", driver-module-name="com.mysql", driver-xa-datasource-class-name="com.mysql.jdbc.jdbc2.optional.MysqlXADataSource", driver-class-name="com.mysql.jdbc.Driver" )';

######################### DEFININDO DATASOURCES #################################

echo "SETTING DATASOURCES";
$WILDFLY_DIR/bin/./jboss-cli.sh --connect --commands='./subsystem=datasources/data-source=hurraaDS:add(enabled=true , jndi-name="java:/hurraaDS" , use-java-context=true, driver-name="com.mysql" , min-pool-size=10 , max-pool-size=100 , pool-prefill=true, user-name="hurraa", password="hurraa" , connection-url="jdbc:mysql://localhost:3306/hurraa" )'

sleep 2

killall java

sleep 2

echo "#######################################################";
echo "#                                                     #";
echo "# CREATE BY: CLAIRTON CARNEIRO LUZ                    #";
echo "# CREATE TO: CEJUG                                    #";
echo "#                                                     #";
echo "#                    TERMINOU                         #";
echo "#######################################################";





