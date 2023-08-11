package th.mfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {
    
    @Autowired
    private PositionRepository positionRepository;

    // create method for position
    @PostMapping("/positions")
    public ResponseEntity<Position> createPosition(@RequestBody Position position){
        positionRepository.save(position);
        return ResponseEntity.ok(position);
    }
}
