package uz.pdp.codingbat.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;


@Getter
@Setter
public class LanguageDTO {
    private Short id;

    private String title;

    private String url;
}
