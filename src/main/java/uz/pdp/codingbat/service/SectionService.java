package uz.pdp.codingbat.service;

import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SectionDTO;

import java.util.List;

public interface SectionService {
    ApiResult add(SectionDTO sectionDTO);

    List<SectionDTO> getAll();

    SectionDTO get(Short id);

    ApiResult edit (Short id,
                    SectionDTO sectionDTO);

    ApiResult delete( Short id);
}
