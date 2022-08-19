package uz.pdp.codingbat.service;

import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.LanguageDTO;

import java.util.List;


public interface LanguageService {

    ApiResult add(LanguageDTO languageDTO);

    List<LanguageDTO> getAll();

    LanguageDTO get(Short id);

    ApiResult edit(Short id, LanguageDTO languageDTO);

    ApiResult delete(Short id);

}
