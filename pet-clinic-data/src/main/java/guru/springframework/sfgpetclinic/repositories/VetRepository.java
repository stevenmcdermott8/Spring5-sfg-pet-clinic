package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

/**
 * stevmc created on 2/17/20
 */
public interface VetRepository extends CrudRepository<Vet, Long> {
}
