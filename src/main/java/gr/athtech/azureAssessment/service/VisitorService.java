package gr.athtech.azureAssessment.service;

import gr.athtech.azureAssessment.model.Visitor;
import gr.athtech.azureAssessment.repository.VisitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorService {

    private VisitorRepository visitorRepository;

    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public void saveVisitor(Visitor visitor) {
        visitorRepository.save(visitor);
    }

    public List<Visitor> findVisitors() {
        return visitorRepository.findAll();
    }
}
