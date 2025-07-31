package ma.ensaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ensaf.model.MyBookList;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList, Integer> {
	

}
