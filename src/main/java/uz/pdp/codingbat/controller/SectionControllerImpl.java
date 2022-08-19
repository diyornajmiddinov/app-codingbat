package uz.pdp.codingbat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SectionDTO;
import uz.pdp.codingbat.service.SectionService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SectionControllerImpl implements SectionController{

    private final SectionService sectionService;
    @Override
    public ApiResult add(SectionDTO sectionDTO) {
        return sectionService.add(sectionDTO);
    }

    @Override
    public List<SectionDTO> getAll() {
        return sectionService.getAll();
    }

    @Override
    public SectionDTO get(Short id) {
        return sectionService.get(id);
    }

    @Override
    public ApiResult edit(Short id, SectionDTO sectionDTO) {
        return sectionService.edit(id,sectionDTO);
    }

    @Override
    public ApiResult delete(Short id) {
        return sectionService.delete(id);
    }
}
