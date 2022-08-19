package uz.pdp.codingbat.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.ProblemDTO;
import uz.pdp.codingbat.payload.SectionDTO;
import uz.pdp.codingbat.service.SectionService;

import java.util.List;

@RequestMapping("/problem")
public interface ProblemController {
    @PostMapping
    ApiResult add(@RequestBody ProblemDTO problemDTO);

    @GetMapping
    List<ProblemDTO> getAll();

    @GetMapping("/{id}")
    ProblemDTO get(@PathVariable Integer id);

    @PutMapping("/{id}")
    ApiResult edit(@PathVariable Integer id, @RequestBody ProblemDTO problemDTO);

    @DeleteMapping("/{id}")
    ApiResult delete(@PathVariable Integer id);
}
