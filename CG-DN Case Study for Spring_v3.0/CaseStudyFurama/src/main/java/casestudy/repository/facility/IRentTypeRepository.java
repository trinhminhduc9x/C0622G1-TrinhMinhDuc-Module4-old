package casestudy.repository.facility;

import casestudy.model.facility.FacilityType;
import casestudy.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
}
