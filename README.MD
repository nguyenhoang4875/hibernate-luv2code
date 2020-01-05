@Entity
Java class that is mapped database table
<hr>
Java Annotations
Step 1: Map class to database table
Step 2: Map field to database columns
<br>
SessionFactory: Reads the hibernate config file Creates Session object 
Heavy-weight object only create in your application
<br>
Session: Wraps a JDBC connection main object used to save/retrieve object
Short-lived object retrieve from SessionFactory
<br>
<hr>
Primary Key: Uniquely identifies each row in a table must be a unique value cannot contain NULL value
<hr>
GenerationType.AUTO: Pick an appropriate strategy for the particular database
<br>
GenerationType.IDENTITY: Assign primary keys using database identity column
<br>
GenerationType.SEQUENCE: Assign primary keys using a database sequence
<br>
GenerationType.TABLE: Assign primary keys using underlying database table to ensure uniqueness
<hr>
<hr>
set primary key auto increment stat 3000
<br> ALTER TABLE student AUTO_INCREMENT=3000;
<br> reset start with 1: truncate student;
<hr>
Show log hibernate with more information
<hr>
1. Add log4j to your project classpath 
<br>
2. Add log4j.properties to your “src” directory
<br>
<hr>
Entity Lifecycle<br>
Detach: If entity is detached, it is not associated with a Hibernate session <br>
Merge: If instance is detached from session, then merge will reattach to session <br>
Persist: Transitions new instances to managed state. Next flush/commit will save in db <br>
Remove: Transitions managed entity to be removed. Next flush/commit will delete from db.
Refresh: Reload/synch object with data from db. Prevents stale data <br>
<hr>
@OneToOne - Cascade Types <br>
Persist: If entity is persisted/saved, related entity will also be persisted <br>
Remove: If entity is removed/deleted, related entity will also be deleted <br>
Refresh: If entity is refreshed, related entity will also be refreshed <br>
Detach: If entity is detached (not associated w/ session) <br>
Merge: If entity is merged, then related entity will also be merge <br>
All: All of above cascade types. <br>
<hr>
Create user in mysql <br>
create: CREATE USER 'hbstudent'@'localhost' IDENTIFIED BY 'hbstudent'; <br>
permission: GRANT ALL PRIVILEGES ON * . * TO 'hbstudent'@'localhost'; <br>
<hr>
Fetch Types: Eager vs Lazy Loading <br>
When we fetch/retrieve data, show we retrieve EVERYTHING? <br>
Eager: will retrieve everything <br>
Lazy: will retrieve on request <br>
<hr>
Eager Loading <br>
Eager loading will load all dependent entities <br>
Load instruction and all of their courses at once <br>
<hr>
Lazy Loading <br>
Lazy loading will load the main entity first <br>
Load dependent entities on demand (lazy) <br>
<hr>
Default Fetch Types <br>
@OneToOne: FetchType.EAGER <br>
@OneToMany: FetchType.LAZY <br>
@ManyToOne: FetchType.EAGER <br>
@ManyToMany: FetchType.LAZy <br>
<hr>

