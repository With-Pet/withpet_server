package withpet.server.domain;

import withpet.server.enums.NoticeType;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Entity
public class Notice extends BaseEntity{
    @ElementCollection
    private List<Picture> pictureList;

    @Enumerated(EnumType.STRING)
    private NoticeType noticeType;
    private String content;
}
