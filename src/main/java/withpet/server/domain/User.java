package withpet.server.domain;

import withpet.server.enums.SnsType;

import javax.persistence.*;

@Entity
public class User extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private SnsType snsType;

    private String nickname;

    private String introduction;


}
