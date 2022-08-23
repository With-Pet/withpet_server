package withpet.server.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import withpet.server.pet.dto.PetDetail;
import withpet.server.pet.entity.Pet;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {
    // TODO: 2022-08-23 마지막 param은 notes가 아니라 profile(프로필 이미지 url)임
    @Query("select new withpet.server.pet.dto.PetDetail(" +
            "p.petId,p.name,p.type,p.kind,p.sex,p.isNeutered,p.weight,p.birth,p.notes,p.owner.userId,p.notes) " +
            "from Pet as p " +
            "where p.owner.userId=:id")
    public List<PetDetail> findByOwner(Long id);
}
