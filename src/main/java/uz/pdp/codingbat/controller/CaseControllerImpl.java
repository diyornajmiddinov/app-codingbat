package uz.pdp.codingbat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.CaseDTO;
import uz.pdp.codingbat.service.CaseService;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class CaseControllerImpl implements CaseController{
    private final CaseService caseService;

    @Override
    public ApiResult add(CaseDTO caseDTO) {
        return caseService.add(caseDTO);
    }

    @Override
    public List<CaseDTO> getAll() {
        return caseService.getAll();
    }

    @Override
    public CaseDTO get(Long id) {
        return caseService.get(id);
    }

    @Override
    public ApiResult edit(Long id, CaseDTO caseDTO) {
        return caseService.edit(id,caseDTO);
    }

    @Override
    public ApiResult delete(Long id) {
        return caseService.delete(id);
    }
}
