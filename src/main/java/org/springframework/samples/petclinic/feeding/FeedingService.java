package org.springframework.samples.petclinic.feeding;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedingService {

    @Autowired FeedingRepository feedingRepository;

    public List<Feeding> getAll(){
        List<Feeding> f = feedingRepository.findAll();
        return f;
    }

    public List<FeedingType> getAllFeedingTypes(){
        List<FeedingType> f = feedingRepository.findAllFeedingTypes();
        return f;
    }

    public FeedingType getFeedingType(String typeName) {
        FeedingType f = feedingRepository.findFeedingTypeByName(typeName);
        return f;
    }

    public Feeding save(Feeding f) throws UnfeasibleFeedingException {
        return feedingRepository.save(f);
    }

    
}
