package uz.pdp.codingbat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.Problem;
import uz.pdp.codingbat.entity.Section;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.ProblemDTO;
import uz.pdp.codingbat.repository.ProblemRepository;
import uz.pdp.codingbat.repository.SectionRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProblemServiceImpl implements ProblemService {

    private final ProblemRepository problemRepository;
    private final SectionRepository sectionRepository;

    @Override
    public ApiResult add(ProblemDTO problemDTO) {
        Section section = sectionRepository.findById(problemDTO.getSection_id()).orElseThrow(IllegalStateException::new);
        problemRepository.save(problemDTOToProblem(problemDTO,section,new Problem()));
        return new ApiResult(true,"Problem Saved");
    }



    @Override
    public List<ProblemDTO> getAll() {
        return  problemsToProblemDTOS(problemRepository.findAll());
    }



    @Override
    public ProblemDTO get(Integer id) {
        return problemToProblemDTO(problemRepository.findById(id).orElseThrow(IllegalStateException::new),new ProblemDTO());
    }

    @Override
    public ApiResult edit(Integer id, ProblemDTO problemDTO) {

        Problem problem = problemRepository.findById(id).orElseThrow(IllegalStateException::new);
        problemRepository.save( problemDTOToProblem(problemDTO, problem.getSection(), problem));
        return new ApiResult(true,"Problem Edited");
    }

    @Override
    public ApiResult delete(Integer id) {
        Problem problem = problemRepository.findById(id).orElseThrow(IllegalStateException::new);
        problemRepository.delete(problem);
        return new ApiResult(true,"Problem deleted");
    }

    private List<ProblemDTO> problemsToProblemDTOS(List<Problem> all) {
        return all.stream().map(problem -> problemToProblemDTO(problem,new ProblemDTO())).toList();
    }


    private ProblemDTO problemToProblemDTO(Problem problem, ProblemDTO problemDTO) {
        problemDTO.setDescription(problem.getDescription());
        problemDTO.setMethod(problem.getMethod());
        problemDTO.setTitle(problem.getTitle());
        problemDTO.setId(problem.getId());
        problemDTO.setSection_id(problem.getSection().getId());
        return problemDTO;
    }


    private Problem problemDTOToProblem(ProblemDTO problemDTO,Section section, Problem problem) {
        problem.setDescription(problemDTO.getDescription());
        problem.setTitle(problemDTO.getTitle());
        problem.setMethod(problemDTO.getMethod());
        problem.setSection(section);
        return problem;
    }
}
