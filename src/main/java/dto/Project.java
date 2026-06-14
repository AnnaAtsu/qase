package dto;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    private String projectCode;
    private String projectName;
    private String description;
}
