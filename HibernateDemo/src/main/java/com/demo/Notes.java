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


	  
	  
*/}
