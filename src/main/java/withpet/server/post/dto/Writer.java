package withpet.server.post.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Writer {
    private Long id;
    // TODO: 2022-08-24 User.profile ) Picture -> String
    private String profile; // private File profile;
    private String nickname;
}
