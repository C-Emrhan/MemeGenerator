package de.htwberlin.webtech.MemeGenerator.web;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepository extends JpaRepository<Memes,Long> {


}