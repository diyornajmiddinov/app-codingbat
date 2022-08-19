package uz.pdp.codingbat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.Case;
import uz.pdp.codingbat.entity.Problem;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.CaseDTO;
import uz.pdp.codingbat.repository.CaseRepository;
import uz.pdp.codingbat.repository.ProblemRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CaseServiceImpl implements CaseService{

    private final CaseRepository caseRepository;
    private final ProblemRepository problemRepository;

    @Override
    public ApiResult add(CaseDTO caseDTO) {
        Problem problem = problemRepository.findById(caseDTO.getProblem_id()).orElseThrow(IllegalStateException::new);
        caseRepository.save(caseDTOToCase(caseDTO, problem, new Case()));
        return new ApiResult(true, "Added");
    }

    @Override
    public List<CaseDTO> getAll() {
        return caseListToCaseDTOList(caseRepository.findAll());
    }

    @Override
    public CaseDTO get(Long id) {
        return caseToCaseDTO(new CaseDTO(),caseRepository.findById(id).orElseThrow(IllegalStateException::new));
    }

    @Override
    public ApiResult edit(Long id, CaseDTO caseDTO) {
        Case casee = caseRepository.findById(id).orElseThrow(IllegalStateException::new);
        Problem problem = problemRepository.findById(caseDTO.getProblem_id()).orElseThrow(IllegalStateException::new);
        caseRepository.save(caseDTOToCase(caseDTO,problem,casee));
        return new ApiResult(true,"Edited");
    }

    @Override
    public ApiResult delete(Long id) {
        caseRepository.delete(caseRepository.findById(id).orElseThrow(IllegalStateException::new));
        return new ApiResult(true,"Deleted");
    }
    private Case caseDTOToCase(CaseDTO caseDTO, Problem problem, Case casee) {
        casee.setArgs(caseDTO.getArgs());
        casee.setExpected(caseDTO.getExpected());
        casee.setProblem(problem);
        return casee;
    }
    private CaseDTO caseToCaseDTO(CaseDTO caseDTO, Case casee) {
        caseDTO.setProblem_id(casee.getProblem().getId());
        caseDTO.setId(casee.getId());
        caseDTO.setArgs(casee.getArgs());
        caseDTO.setExpected(casee.getExpected());
        return caseDTO;
    }
    private List<CaseDTO> caseListToCaseDTOList(List<Case> caseList) {
        return caseList.stream().map(casee ->
                caseToCaseDTO(new CaseDTO(), casee)).toList();
    }
}
