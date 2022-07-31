package withpet.server.domain;

import withpet.server.enums.NoticeType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Notice extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private NoticeType noticetype;
    private String content;
}
