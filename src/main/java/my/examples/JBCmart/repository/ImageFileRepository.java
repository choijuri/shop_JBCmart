package my.examples.JBCmart.repository;

import my.examples.JBCmart.domain.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageFileRepository extends JpaRepository<ImageFile,Long>{

}
