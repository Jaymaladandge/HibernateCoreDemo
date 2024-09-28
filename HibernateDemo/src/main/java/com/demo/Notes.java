package com.demo;

public class Notes {
/*
	  
The @JoinColumn annotation in Hibernate is used to specify the mapping of a foreign key column in a relationship between two entities. 
The @JoinColumn annotation is applied on the owning side of the association to define the foreign key column name and 
other attributes which are related to the join column.
	  
Unidirectional Relationships: Use @JoinColumn on the owning side of a unidirectional relationship to specify the foreign key column.

Bidirectional Relationships: Use @JoinColumn on the owning side of the relationship (@ManyToOne side) to specify 
the join column. The inverse side (@OneToMany or @OneToOne side) uses mappedBy to reference the owning side.
the value of mappedBy is the name of the association-mapping attribute on the owning side. so that foreign key will be created in 	  
owning side only not in inverse side.


----------HQL-----------

Database independent. use entity name instead of table name. 




Bidirectional Mapping:

Definition: In bidirectional mapping, both sides of the relationship are aware of each other.
Foreign Key:
If you define a @ManyToOne relationship in the Post entity (along with @JoinColumn), a foreign key column (e.g., user_id) will be created 
in the Post table that references the primary key of the User table.
This establishes a direct relationship in the database, allowing you to easily join the two tables and maintain referential integrity.


Unidirectional Mapping:
Definition: In unidirectional mapping, only one side of the relationship has knowledge of the other side.
Foreign Key:
If you have a @OneToMany relationship (e.g., User has many Post), but the Post entity does not have a reference back to the User 
(meaning no @ManyToOne and @JoinColumn), no foreign key will be created in the Post table.
As a result, the Post table will be independent of the User table, and there won’t be any direct linkage between the two at the database level.













	  hr@clover
	  hr.helpdesk@
	 
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
*/}
