package uz.pdp.codingbat.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.CaseDTO;
import uz.pdp.codingbat.payload.LanguageDTO;

import java.util.List;

public interface CaseController {
    @PostMapping
    ApiResult add(@RequestBody CaseDTO caseDTO);

    @GetMapping
    List<CaseDTO> getAll();

    @GetMapping("/{id}")
    CaseDTO get(@PathVariable Long id);

    @PutMapping("/{id}")
    ApiResult edit(@PathVariable Long id,
                   @RequestBody CaseDTO caseDTO);

    @DeleteMapping("/{id}")
    ApiResult delete(@PathVariable Long id);
}
