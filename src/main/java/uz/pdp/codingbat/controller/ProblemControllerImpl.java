package uz.pdp.codingbat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.ProblemDTO;
import uz.pdp.codingbat.service.ProblemService;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class ProblemControllerImpl implements ProblemController{

    private final ProblemService problemService;

    @Override
    public ApiResult add(ProblemDTO problemDTO) {
        return problemService.add(problemDTO);
    }

    @Override
    public List<ProblemDTO> getAll() {
        return problemService.getAll();
    }

    @Override
    public ProblemDTO get(Integer id) {
        return problemService.get(id);
    }

    @Override
    public ApiResult edit(Integer id, ProblemDTO problemDTO) {
        return problemService.edit(id,problemDTO);

}
    @Override
    public ApiResult delete(Integer id) {
        return problemService.delete(id);
    }
}
