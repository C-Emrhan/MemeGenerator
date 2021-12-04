package de.htwberlin.webtech.MemeGenerator.database;

import de.htwberlin.webtech.MemeGenerator.web.CreatedMeme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepository extends JpaRepository<CreatedMeme,String> {


}
