package ytanii.booklist.model;
import jakarta.persistence.*;
import java.time.Instant;


@Entity
@Table(name="saved_books")
public class SavedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;

    private String googleBookId;
    private String title;
    private String author;
    private String thumbnailUrl;
    private String publishedDate;
    private Instant createdAt;

    public String getGoogleBookId(){
        return this.googleBookId;
    }
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public String getThumbnailUrl(){
        return this.thumbnailUrl;
    }
    public String getPublishedDate(){
        return this.publishedDate;
    }
    public Instant getCreatedAt(){
        return this.createdAt;
    }
    public Long getId(){
        return this.id;
    }
    public Long getUserId() {
        return this.userId;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }
    public void setGoogleBookId(String googleBookId){
        this.googleBookId = googleBookId;
    }
    public void setThumbnailUrl(String thumbnailUrl){
        this.thumbnailUrl = thumbnailUrl;

    }
    public void setPublishedDate(String publishedDate){
        this.publishedDate = publishedDate;
    }
    public void setCreatedAt(Instant createdAt){
        this.createdAt = createdAt;
    }

}