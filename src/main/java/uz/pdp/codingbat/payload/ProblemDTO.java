package uz.pdp.codingbat.payload;

import lombok.Data;
import uz.pdp.codingbat.entity.Section;

import javax.persistence.*;
@Data
public class ProblemDTO {

    private Integer id;

    private String title;

    private String description;

    private String method;

    private Short section_id;
}
