package uz.pdp.codingbat.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.entity.Language;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.LanguageDTO;

import java.util.List;

@RequestMapping("/language")
public interface LanguageController {
    //UD
    @PostMapping
    ApiResult add(@RequestBody LanguageDTO languageDTO);

    @GetMapping
    List<LanguageDTO> getAll();

    @GetMapping("/{id}")
    LanguageDTO get(@PathVariable Short id);

    @PutMapping("/{id}")
    ApiResult edit(@PathVariable Short id,
                   @RequestBody LanguageDTO languageDTO);

    @DeleteMapping("/{id}")
    ApiResult delete(@PathVariable Short id);   





}
