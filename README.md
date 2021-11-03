SahamOrderBook Web Application
==============================

### Requirement
1. PostgreSQL 14.x or latest version
2. Oracle JDK version 17.x (LTS)
3. Apache Tomcat 9.x


### Installation
Diasumsikan PostgreSQL, Oracle JDK dan Apache Tomcat sudah terinstalasi dengan baik dan
sempurna. Jika belum, baca panduan pada website berikut ini:

- [PostgreSQL Database](https://www.postgresql.org)
- [Apache Tomcat](http://tomcat.apache.org)

#### Procedure
1. Create database `db_saham` pada PostgreSQL server.
2. Update konfigurasi file `application.yml` untuk variabel berikut:

   a. `logging.file.name : <FULLPATH>/saham-demo.log`    
   b. `spring.datasource.username : <db-user>`    
   c. `spring.datasource.password : <db-password>`
