package withpet.server.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Picture{
    private String originFileName;
    private String fileName;
    private String filePath;
}
