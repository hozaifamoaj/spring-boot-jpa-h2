package com.init.spring.jpa.h2.utils;

import com.init.spring.jpa.h2.model.Tutorial;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TemplateData {

    public static String title = "KSL";
    public static long id = 1;
    public static boolean isPublished = false;

    public static Tutorial tutorialBeforeDemo = Tutorial.builder()
            .title("KSL")
            .description("KONASL")
            .published(false)
            .build();

    public static Tutorial tutorialAfterDemo = Tutorial.builder()
            .id(id)
            .title("KSL")
            .description("KONASL")
            .published(false)
            .build();

    public static List<Tutorial> tutorials = Stream.of(Tutorial.builder().id(2).title("KSL").description("KONASL")
                    .published(false).build(), tutorialAfterDemo)
            .collect(Collectors.toList());
}
