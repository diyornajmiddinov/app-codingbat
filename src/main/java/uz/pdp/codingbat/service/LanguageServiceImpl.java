package uz.pdp.codingbat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.pdp.codingbat.entity.Language;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.LanguageDTO;
import uz.pdp.codingbat.repository.LanguageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class LanguageServiceImpl implements LanguageService{

    private final LanguageRepository languageRepository;

    @Override
    public ApiResult add(LanguageDTO languageDTO) {
        languageRepository.save(languageDTOToLanguage(languageDTO,new Language()));
        return new ApiResult(true,"Language Saved");
    }



    @Override
    public List<LanguageDTO> getAll() {
       return listLanguageToListLanguageDTO(languageRepository.findAll(),new ArrayList<>());
    }

    @Override
    public LanguageDTO get(Short id) {
        return languageToLanguageDTO(languageRepository.findById(id).orElseThrow(IllegalAccessError::new),new LanguageDTO());
    }

    @Override
    public ApiResult edit(Short id, LanguageDTO languageDTO) {
        Language language = languageRepository.findById(id).orElseThrow(IllegalStateException::new);
        language.setUrl(languageDTO.getUrl());
        language.setTitle(languageDTO.getTitle());
        languageRepository.save(language);
        return new ApiResult(true,"Language Saved");
    }

    @Override
    public ApiResult delete(Short id) {
       languageRepository.delete(languageRepository.findById(id).orElseThrow(IllegalAccessError::new));
       return new ApiResult(true,"Language Deleted");
    }
    private List<LanguageDTO> listLanguageToListLanguageDTO(List<Language> all, List<Language> languages) {
      return all.stream()
                .map(language -> languageToLanguageDTO
                                (language, new LanguageDTO()
                                )).collect(Collectors.toList());

    }

    private Language languageDTOToLanguage(LanguageDTO languageDTO,Language language) {
        language.setId(languageDTO.getId());
        language.setUrl(languageDTO.getUrl());
        language.setTitle(languageDTO.getTitle());
        return language;
    }


    private LanguageDTO languageToLanguageDTO(Language language, LanguageDTO languageDTO) {
        languageDTO.setTitle(language.getTitle());
        languageDTO.setId(language.getId());
        languageDTO.setUrl(language.getUrl());
        return languageDTO;
    }


}
