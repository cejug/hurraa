# Hurraa

Opensource project to resource management

### Datasource configuration

#### General Configuration

Get module wildfly here: https://docs.google.com/file/d/0B25_MAAKa3jEVFRCRnp5Sm9zZE0/edit 
and unpack in WILDFLY_HOME/modules/system/layers/base/com

Like the following video shows: http://www.youtube.com/watch?v=l1daP7PZxNA#t=2729 After 45 minutes

#### Configuration of the Datasource through jboss cli

After **General Configuration** section: 

1. Start Windfly server
2. In the folder WILDFLY_HOME/bin run the jboss-cli.sh or .bat
3. Enter the CLI next steps
4. connect localhost:9990
5. ./subsystem=datasources/jdbc-driver=com.mysql:add(driver-name="com.mysql", driver-module-name="com.mysql", driver-xa-datasource-class-name="com.mysql.jdbc.jdbc2.optional.MysqlXADataSource" )
6. ./subsystem=datasources/data-source=hurraaDS:add(enabled=true , jndi-name="java:/hurraaDS" , use-java-context=true, driver-name="com.mysql" , min-pool-size=10 , max-pool-size=100 , pool-prefill=true, user-name="root" , connection-url="jdbc:mysql://localhost:3306/hurraa" )

### Configuration environment vars.
Create a env variable WILDFLY_HOME for arquillian.xml config

1. LINUX - most of linux distributions: create a file wf.sh in /etc/profile.d with this content export WILDFLY_HOME=/your_path_to/wildfly-8.0.0.CR1
2. MAC - add contect WILDFLY_HOME=/your_path_to/wildfly-8.0.0.CR1 into /etc/profile



#### Configuration of the datasource at standalone.xml file

```xml
<datasource jndi-name="java:/hurraaDS" pool-name="hurraaDS" enabled="true" use-java-context="true">
  <connection-url>jdbc:mysql://localhost:3306/hurraa</connection-url>
  <driver>com.mysql</driver>
  <pool>
    <min-pool-size>10</min-pool-size>
    <max-pool-size>100</max-pool-size>
    <prefill>true</prefill>
  </pool>
  <security>
    <user-name>root</user-name>
  </security>
</datasource>
<drivers>
  <driver name="com.mysql" module="com.mysql">
    <xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
  </driver>
</drivers>
```
#### Wildfly Restriction
Workaround to resolve the problem of the wildfly with the class MultableResponse. Edit the file standalone.xml for to add in the tag servlet-container the property bellow:
```xml
allow-non-standard-wrappers="true"
```
