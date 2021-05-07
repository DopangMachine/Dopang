package com.dopang.machine.equitytrading.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dopang.machine.equitytrading.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("FROM User WHERE firstName = ?1")
	List<User> findByFirstName(String firstName);

	@Query("SELECT user FROM User user WHERE firstName = ?1 AND lastName = ?2")
	List<User> findByFirstNameAndLastName(String firstName, String lastName);

	@Query("FROM User WHERE firstName = ?1 ORDER BY lastName ASC")
	List<User> findByFirstNameOrderByLastname(String firstName);

	@Query("FROM User WHERE firstName = ?1")
	List<User> findByFirstName(String firstName, Sort sort);

	@Query("FROM User WHERE firstName = ?1")
	List<User> findByFirstNamePagination(String firstName, Pageable pageable);

	@Query("FROM #{#entityName} WHERE firstName = ?1")
	List findByFirstName1(String firstName);

	@Query("FROM User WHERE UPPER(firstName) LIKE %?#{[0].toUpperCase()}%")
	List<User> findByFirstNameContainingIgnoreCase(String firstName);

	@Query(value = "SELECT * FROM user WHERE first_name = :firstName", nativeQuery = true)
	List<User> findUsersByFirstName(@Param("firstName") String firstName);

	@Query("SELECT a FROM User a WHERE firstName = :firstName AND lastName = :lastName")
	List<User> findByFirstNameAndLastName1(@Param("lastName") String firstName, @Param("firstName") String lastName);

	@Query("UPDATE User SET firstName = :prefix || firstName")
	@Modifying
	void addPrefixToFirstName(@Param("prefix") String prefix);
}
