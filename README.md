Hurraa
======

Opensource project to resource management

Configuration of the datasource at standalone.xml file
---
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

Put Mysql Driver like the following video:
http://www.youtube.com/watch?v=l1daP7PZxNA&feature
After 48 minutes of video.