package com.init.spring.jpa.h2.service;

import com.init.spring.jpa.h2.model.Tutorial;
import com.init.spring.jpa.h2.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {


    @Autowired
    private TutorialRepository tutorialRepository;


    public List<Tutorial> findAll(String title){
        List<Tutorial> tutorials = new ArrayList<Tutorial>();

        if (title == null)
            tutorialRepository.findAll().forEach(tutorials::add);
        else
            tutorialRepository.findByTitleContainingIgnoreCase(title).forEach(tutorials::add);

        return tutorials;
    }

    public Optional<Tutorial> findById(long id) {
        return tutorialRepository.findById(id);
    }

    public Tutorial save(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    public void deleteById(long id) {
        tutorialRepository.deleteById(id);
    }

    public void deleteAll(){
        tutorialRepository.deleteAll();
    }

    public List<Tutorial> findByPublished(boolean isPublished) {
        return tutorialRepository.findByPublished(true);
    }
}
