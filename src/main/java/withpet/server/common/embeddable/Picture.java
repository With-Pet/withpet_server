package withpet.server.common.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Picture {
    private String originFileName;
    private String fileName;
    private String filePath;
}
