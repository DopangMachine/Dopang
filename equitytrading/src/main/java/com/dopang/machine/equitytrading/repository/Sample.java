package com.dopang.machine.equitytrading.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dopang.machine.equitytrading.domain.User;

public interface Sample extends JpaRepository<User, Long> {



	// ******************************************Overview***********************************************

	//	Query methods are defined in Responsitory interfaces. A repository interface is a java interface directly or indirectly extended from Spring Data org.springframework.data.repository.Repository(note: this is a marker interface). Spring Data provides pre-defined interfaces like CrudRepository or PagingAndSortingRepository both of them are sub-interfaces of Repository. There are few pre-defined methods in the Repository interfaces. The important thing is the method names have to follow a standard structure and if they do, spring will use it to derive low level sql query at runtime.
	//
	//	Let’s have a look at both CrudRepository and the PagingAndSortingRepository repositories and the methods they define




	// ******************************************CrudRepository***********************************************

	//	As the name denotes the CrudRepository defines simple CRUD methods. Let’s have a look at few important methods from CrudRepository.
	//
	//	Learn more: about using CrudReository from Scratch at Spring Boot with Spring Data JPA.

	//	public interface CrudRepository<T, ID> extends Repository<T, ID> {
	//	    <S extends T> S save(S var1);
	//	    <S extends T> Iterable<S> saveAll(Iterable<S> var1);
	//	    Optional<T> findById(ID var1);
	//	    boolean existsById(ID var1);
	//	    Iterable<T> findAll();
	//	    Iterable<T> findAllById(Iterable<ID> var1);
	//	    long count();
	//	    void deleteById(ID var1);
	//	    void delete(T var1);
	//	    void deleteAll(Iterable<? extends T> var1);
	//	    void deleteAll();
	//	}




	// ******************************************Restrict Repository Methods***********************************************

	//	 As per Java inheritance policy the sub-interface inherits all the method from the super-interface. For example when a DogsRepository extends CrudRepository, it gets all of the methods we saw earlier. In some cases we may not want to expose all of those methods on our Entity.
	//
	//	 What if, you don’t want to provide delete or save methods on your repository?
	//	 Use @RepositoryDefinition. See the below examples
	//
	//	 @RepositoryDefinition(domainClass = User.class, idClass = Long.class)
	//	 public interface UserRepository {
	//	     Optional<User> findById(Long var1);
	//	     boolean existsById(Long var1);
	//	     Iterable<User> findAll();
	//	     Iterable<User> findAllById(Iterable<Long> var1);
	//	     User findDistinctFirstByAge(int age);
	//	 }
	//	 What happens here?
	//
	//	 @RepositoryDefinition tells spring about this Repository.
	//	 The annotation attributes tells spring about the entity class and primary key.
	//	 Only the required methods are included into the DogsRepository.
	//	 With restricted methods, the repository is safer to use.




	// ******************************************Defining a Custom JPQL Query***********************************************

	//	Creating a JPQL query with Spring Data JPA’s @Query annotation is pretty straightforward. You need to annotate a method on your repository interface with the @Query annotation and provide a String with the JPQL query statement.
	//
	//	Here you can see an example containing 2 queries that select Author entities by their firstName or by their firstName and lastName. Please ignore the method and query parameters for now. We will take a closer look at them in a later part of this article.

//	@Query("FROM Author WHERE firstName = ?1")
//	List<User> findByFirstName(String firstName);
//
//	@Query("SELECT a FROM Author a WHERE firstName = ?1 AND lastName = ?2")
//	List<User> findByFirstNameAndLastName(String firstName, String lastName);




	// ******************************************Sorting Your Query Results********************************************************************************************************************

	//    Sorting Your Query Results
	//    For some use cases, you might want to retrieve the query result in a specific order. Using Spring Data JPA, you can define the sorting of your query results in 2 ways:
	//    You can add an ORDER BY clause to your JPQL query or
	//    You can add a parameter of type Sort to your method signature.
	//    Using the ORDER BY Clause in JPQL
	//    You’re probably familiar with the first option. The ORDER BY clause is defined in the JPA standard, and it is very similar to the ORDER BY clause you know from SQL. You simply reference one or more entity attributes and use ASC or DESC to specify if you want to sort them in ascending or descending order. I explained the ORDER BY clause and all other parts of a JPQL query in more details my guide to JPQL.

//	@Query("FROM Author WHERE firstName = ?1 ORDER BY lastName ASC")
//	List<User> findByFirstNameOrderByLastname(String firstName);




	// *******************************************Using a Sort Object*******************************************************************************************************************

	//        With Spring Data JPA, you can also add a parameter of type Sort to your method definition. Spring Data JPA will then generate the required ORDER BY clause. That is the same approach as you can use in a derived query.
	//        When you want to call the findAuthors method, you need to provide a Sort object. Its constructor expects an enumeration that defines the sorting direction and one or more Strings that reference the entity attributes, which you want to use to order the result, by their name.
	//        Sort sort = new Sort(Direction.ASC, "firstName");
	//        List<User> authors = authorRepository.findByFirstName("Thorben", sort);

//	@Query("FROM Author WHERE firstName = ?1")
//	List<User> findByFirstName(String firstName, Sort sort);




	// ********************************************Paginating Your Query Results******************************************************************************************************************	

	//	In addition to sorting, Spring Data JPA also provides very comfortable support for pagination. If you add a method parameter of type Pageable to your repository method, Spring Data JPA generates the required code to handle the pagination of the query result.
	//	
	//	When you call the findByFirstName method, you need to provide an object that implements the Pageable interface. You can do that by calling the of method on the PageRequest method with the number of the page and the size of each page as parameters.
	//	Pageable pageable = PageRequest.of(0, 10);
	//	List<User> authors = authorRepository.findByFirstName("Thorben", pageable);

//	@Query("FROM Author WHERE firstName = ?1")
//	List<User> findByFirstName(String firstName, Pageable pageable);




	// ***********************************************SpEL Expressions for Entity Names and Advanced Like Expressions***************************************************************************************************************	    

	//	    In addition to the previously discussed query features, Spring Data JPA also supports SpEL expressions within your query. You can use it to avoid hard references to the name of an entity or to create advanced like expressions.
	//
	//	    Avoid Entity Name References
	//	    In the previous queries, I always referenced entities by their name. That prevents you from defining queries for generic repositories. It also causes a lot of work if you decide to rename an entity because you then need to update all queries that reference the old name of the entity.
	//
	//	    You can avoid that by using the entityName variable in a SpEL expression. I do that in the following query to avoid referencing the Author entity by its name.

	//	Spring Data JPA replaces the #{#entityName} expression with the entityName of the domain type of the repository. So, in this example, Spring Data JPA replaces #{#entityName} with Author.

//	@Query("FROM #{#entityName} WHERE firstName = ?1")
//	List findByFirstName1(String firstName);




	// ***********************************************Define Advanced Like Expressions***************************************************************************************************************

	//	Another great feature that you get with the SpEL expressions is the definition of advanced like expressions. You can, for example, append ‘%’ to the beginning and end of a parameter and change the provided bind parameter value to upper case.
	//	
	//	As you can see in the following log statements, Spring Data JPA called the toUpperCase() method on the value of the method parameter firstName and added a ‘%’ to the beginning and end of it. In the next step, it set the modified String as a bind parameter value.

//	@Query("FROM Author WHERE UPPER(firstName) LIKE %?#{[0].toUpperCase()}%")
//	List<User> findByFirstNameContainingIgnoreCase(String firstName);



	// ***********************************************Defining a Custom Native Query***************************************************************************************************************

	//	    Similar to the custom JPQL query, you can use the @Query annotation to specify a custom native SQL query. But you need to tell Spring Data JPA, that you are defining a native query, so that it can execute the query in the right way. You can do that by setting the nativeQuery attribute of the @Query annotation to true.
	//
	//	    Here you can see an example of a repository method that uses a native SQL query to load all Author entities with a give firstName.

//	@Query(value = "SELECT * FROM author WHERE first_name = :firstName", nativeQuery = true)
//	List<User> findAuthorsByFirstName(@Param("firstName") String firstName);



	// ***********************************************Parameter Handling***************************************************************************************************************

	//	    To use both kinds of queries with Spring Data JPA, you need to be familiar with bind parameters. Bind parameters act as placeholders in your query for which you can set values before the query gets executes. They are regularly used in the WHERE clause of a query. You should always prefer them over inlining a parameter value because bind parameters:
	//
	//	    prevent SQL injection vulnerabilities,
	//	    get automatically converted to the correct SQL type and
	//	    enable your persistence provider and database to optimize your query.
	//	    Spring Data JPA handles the bind parameters of JPQL and native SQL queries in the same way. For each query, you can choose if you want to use positional or named bind parameters.
	//
	//	    A positional bind parameter gets referenced by its position. In the query, positional bind parameters consist of a `?` followed by a number that specifies the position. Spring Data JPA then provides the required code to set the bind parameter values. It sets the value of each method parameter as the value of a bind parameter with the same position. So, the value of the first method parameter gets set as the value of the bind parameter at position 1, the value of the second method parameter as the value of the bind parameter at position 2 and so on.
	//
	//	    Named bind parameters specify a name for each parameter. In your query, named bind parameters start with a ‘:’ followed by the name of the parameter. That makes them much more expressive and easier to reference. Spring Data JPA can provide the required code to set the values of these bind parameters. But it needs a little bit of help to match the method parameters with the bind parameters in your query. You either need to annotate the method parameter with @Param and specify the name of the parameter, or you need to compile your application with Java 8 or higher and set the compiler flag -parameters.
	//
	//	    Here you can see an example of both bind parameter types.

//	@Query("FROM Author WHERE firstName = ?1")
//	List<User> findByFirstName2(String firstName);
//
//	@Query("SELECT a FROM Author a WHERE firstName = :firstName AND lastName = :lastName")
//	List<User> findByFirstNameAndLastName2(@Param("lastName") String firstName, @Param("firstName") String lastName);



	// ***********************************************Modifying Queries***************************************************************************************************************

	//	You can not only use the @Query annotation to define queries that read data from your database. You can also create queries that add, change, or remove records in your database. That enables you to implement bulk update or remove operations which can provide substantial performance improvements.
	//
	//	These queries require a slightly different JPA code. That’s why you need to tell Spring Data JPA that your query modifies data by annotating your repository method with an additional @Modifying annotation. It will then execute the provide JPQL or native query as an update operation.
	//
	//	I use this approach in the following code snippet to specify a query that adds a provided prefix to the firstName of all Authors.

//	@Query("UPDATE Author SET firstName = :prefix || firstName")
//	@Modifying
//	void addPrefixToFirstName(@Param("prefix") String prefix);

}
