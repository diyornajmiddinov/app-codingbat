package uz.pdp.codingbat.service;

import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.CaseDTO;

import java.util.List;

public interface CaseService {

    ApiResult add(CaseDTO caseDTO);

    List<CaseDTO> getAll();

    CaseDTO get(Long id);

    ApiResult edit(Long id,CaseDTO caseDTO);

    ApiResult delete(@PathVariable Long id);
}

