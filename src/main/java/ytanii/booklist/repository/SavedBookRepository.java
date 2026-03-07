package ytanii.booklist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ytanii.booklist.model.SavedBook;

import java.util.List;

@Repository
public interface SavedBookRepository extends CrudRepository<SavedBook, Long> {
    void deleteByUserId(Long id);
}
