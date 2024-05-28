package com.init.spring.jpa.h2.service;

import com.init.spring.jpa.h2.repository.TutorialRepository;
import com.init.spring.jpa.h2.utils.TemplateData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TutorialServiceTests {

    @Autowired
    private TutorialService tutorialService;

    @MockBean
    private TutorialRepository tutorialRepository;

    @Test
    public void findAllWithNoTitleTest() {
        Mockito.when(tutorialRepository.findAll()).thenReturn(new ArrayList<>());
        Assertions.assertEquals(0, tutorialService.findAll(null).size());
    }

    @Test
    public void findAllWithTitleTest() {
        Mockito.when(tutorialRepository.findAll()).thenReturn(new ArrayList<>());
        Assertions.assertEquals(0, tutorialService.findAll(TemplateData.title).size());
    }

    @Test
    public void findByIdTest() {
        Mockito.when(tutorialRepository.findById(TemplateData.id)).thenReturn(Optional.ofNullable(TemplateData.tutorialAfterDemo));
        Assertions.assertEquals(1, tutorialService.findById(TemplateData.id).stream().toList().size());
    }

    @Test
    public void saveTest() {
        Mockito.when(tutorialRepository.save(TemplateData.tutorialBeforeDemo)).thenReturn(TemplateData.tutorialAfterDemo);
        Assertions.assertEquals(TemplateData.tutorialAfterDemo, tutorialService.save(TemplateData.tutorialBeforeDemo));
    }

    @Test
    public void deleteByIdTest() {
        tutorialService.deleteById(TemplateData.id);
        Mockito.verify(tutorialRepository, Mockito.times(1)).deleteById(TemplateData.id);
    }

    @Test
    public void deleteAllTest() {
        tutorialService.deleteAll();
        Mockito.verify(tutorialRepository, Mockito.times(1)).deleteAll();
    }

    @Test
    public void findByPublishedTest() {
        Mockito.when(tutorialRepository.findByPublished(TemplateData.isPublished)).thenReturn(TemplateData.tutorials);
        Assertions.assertEquals(2, tutorialService.findByPublished(TemplateData.isPublished).size());
    }
}
