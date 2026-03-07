package ytanii.booklist.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ytanii.booklist.model.SavedBook;
import ytanii.booklist.model.User;
import ytanii.booklist.repository.SavedBookRepository;
import ytanii.booklist.repository.UserRepository;

import java.util.List;
import java.util.function.Predicate;

@Service
public class SavedBookService {

    @Autowired
    private SavedBookRepository savedBookRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public SavedBook saveBookForUser(String google_book_id, String title, Long userId) {
        SavedBook newBook = new SavedBook();
        newBook.setGoogleBookId(google_book_id);
        newBook.setUserId(userId);
        newBook.setTitle(title);

        return savedBookRepository.save(newBook);
    }

    public List<SavedBook> fetchAllSavedBooksByUser(Long userId) {
        List<SavedBook> savedBooks = (List<SavedBook>) savedBookRepository.findAll();
        return savedBooks.stream().filter(book -> matchUserId(book,userId)).toList();
    }

    private boolean matchUserId(SavedBook book, Long userId) {
        return book.getUserId().equals(userId);
    }

    public void deleteSavedBook(Long userId) {
        savedBookRepository.deleteByUserId(userId);
    }

}
