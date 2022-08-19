package uz.pdp.codingbat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.Language;
import uz.pdp.codingbat.entity.Section;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SectionDTO;
import uz.pdp.codingbat.repository.LanguageRepository;
import uz.pdp.codingbat.repository.SectionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService{

    private final SectionRepository sectionRepository;
    private final LanguageRepository languageRepository;

    @Override
    public ApiResult add(SectionDTO sectionDTO) {
        Language language = languageRepository.findById(sectionDTO.getLanguage_id()).orElseThrow(IllegalStateException::new);
        sectionRepository.save(sectionDTOToSection(sectionDTO, language, new Section()));
        return new ApiResult(true,"Added");
    }

    @Override
    public List<SectionDTO> getAll() {
        return sectionListToSectionDTOList(sectionRepository.findAll());
    }

    @Override
    public SectionDTO get(Short id) {
       return sectionToSectionDTO(new SectionDTO(),sectionRepository.findById(id).orElseThrow(IllegalStateException::new));
    }

    @Override
    public ApiResult edit(Short id, SectionDTO sectionDTO) {
        Section section = sectionRepository.findById(id).orElseThrow(IllegalStateException::new);
        Language language = languageRepository.findById(sectionDTO.getLanguage_id()).orElseThrow(IllegalStateException::new);
        sectionRepository.save(sectionDTOToSection(sectionDTO,language,section));
        return new ApiResult(true,"Edited");
    }

    @Override
    public ApiResult delete(Short id) {
        sectionRepository.delete(sectionRepository.findById(id).orElseThrow(IllegalStateException::new));
        return new ApiResult(true,"Deleted");
    }

    private Section sectionDTOToSection(SectionDTO sectionDTO, Language language, Section section) {
        section.setTitle(sectionDTO.getTitle());
        section.setDescription(sectionDTO.getDescription());
        section.setMaxRate(sectionDTO.getMaxRate());
        section.setUrl(sectionDTO.getUrl());
        section.setLanguage(language);
        return section;
    }
    private SectionDTO sectionToSectionDTO(SectionDTO sectionDTO, Section section) {
        sectionDTO.setLanguage_id(section.getLanguage().getId());
        sectionDTO.setId(section.getId());
        sectionDTO.setTitle(section.getTitle());
        sectionDTO.setDescription(section.getDescription());
        sectionDTO.setMaxRate(section.getMaxRate());
        sectionDTO.setUrl(section.getUrl());
        return sectionDTO;
    }

    private List<SectionDTO> sectionListToSectionDTOList(List<Section> sectionList) {
       return sectionList.stream().map(section ->
               sectionToSectionDTO(new SectionDTO(),section)).
               toList();
    }

}
