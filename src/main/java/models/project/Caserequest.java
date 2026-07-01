package models.project;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Caserequest {

    @Expose
    private String title;
    @Expose
    private String code;
    @Expose
    private String description;
    @Expose
    private int severity;
    @Expose
    private int priority;
    @Expose
    private int is_flaky;
}
