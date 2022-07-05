package com.example.springboot.app.service;

import com.example.springboot.app.model.Language;

import java.util.List;

public interface LanguageService {
    Language createLanguage(Language language);

    Language updateLanguage(Language language);

    List<Language> getAllLanguage();

    Language getLanguageById(long languageId);

    void deleteLanguage(long languageId);
}
