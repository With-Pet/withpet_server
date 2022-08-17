package withpet.server.common.embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Picture {
    private String originFileName;
    private String fileName;
    private String filePath;
}
