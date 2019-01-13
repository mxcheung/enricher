package enricher.elastic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import enricher.elastic.domain.MessageDoc;

public interface MessageDocRepository extends JpaRepository<MessageDoc, Long> {

	MessageDoc findByName(String name);

}
