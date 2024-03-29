package team2.proto.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name="post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
@ToString(exclude = "hashtagList")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;
    @Column
    private Long price;
    @Column
    private Integer headCount; // 총 참여할 수 있는 인원 수

    @CreationTimestamp // 자동 생성을 위해 추가
    @Column(name = "create_date", updatable = false )
    private LocalDateTime createDate;
    @Column(name="updated_date")
    private LocalDateTime updateDate;

    @Column(name = "delete_yn", columnDefinition = "BIT DEFAULT 0")
    private Boolean deleteYn;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deadline;
    @Column
    private String receivePlace;
    @Column
    private String productUrl;

    @Column(name = "writer")
    private String writer;

    @OneToMany(mappedBy ="post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hashtag> hashtagList = new ArrayList<Hashtag>();


    @Builder
    public Post(String title, Long price, Integer headCount, LocalDateTime deadline, String receivePlace, String productUrl, String writer,Boolean deleteYn) {
        this.title = title;
        this.price = price;
        this.headCount = headCount;
        this.deadline = deadline;
        this.receivePlace = receivePlace;
        this.productUrl = productUrl;
        this.writer = writer ;
        this.deleteYn = deleteYn ;
    }

    public void resetHashtag() {
        this.hashtagList.clear();
    }
    public void addHashtag(Hashtag hashtag) {
        this.hashtagList.add(hashtag);
    }
}
