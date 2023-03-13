package com.attrabit.ecom.service;

import com.attrabit.ecom.model.Pages;
import com.attrabit.ecom.repository.PagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagesService {
    @Autowired
    private PagesRepository pagesRepository;

    public List<Pages> getAllPages() {
        return pagesRepository.findAll();
    }

    public Optional<Pages> getPageById(Long id) {
        return pagesRepository.findById(id);
    }

    public Pages createPage(Pages page) {
        return pagesRepository.save(page);
    }

    public Pages updatePage(Long id, Pages page) {
        Optional<Pages> existingPage = pagesRepository.findById(id);
        if (existingPage.isPresent()) {
            Pages updatedPage = existingPage.get();
            updatedPage.setSlug(page.getSlug());
            updatedPage.setIsActive(page.getIsActive());
            updatedPage.setCreatedAt(page.getCreatedAt());
            updatedPage.setUpdatedAt(page.getUpdatedAt());
            updatedPage.setPageTranslations(page.getPageTranslations());
            return pagesRepository.save(updatedPage);
        } else {
            return null;
        }
    }

    public void deletePage(Long id) {
        pagesRepository.deleteById(id);
    }
}
