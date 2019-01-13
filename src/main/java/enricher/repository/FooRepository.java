package enricher.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import enricher.domain.Foo;

public interface FooRepository extends JpaRepository<Foo, Long> {

	Foo findByName(String name);

}
