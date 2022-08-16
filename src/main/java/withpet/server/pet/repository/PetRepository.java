package withpet.server.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import withpet.server.pet.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {
}
