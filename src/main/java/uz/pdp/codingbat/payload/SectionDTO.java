package uz.pdp.codingbat.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionDTO {

    private Short id;

    private String title;

    private String url;

    private Short maxRate;

    private String description;

    private Short language_id;
}
