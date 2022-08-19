package uz.pdp.codingbat.payload;

import lombok.Data;
import uz.pdp.codingbat.entity.Problem;

import javax.persistence.*;
@Data
public class CaseDTO {

    private Long id;

    private String args;

    private String expected;

    private Integer problem_id;
}
