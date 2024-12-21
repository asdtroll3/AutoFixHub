package com.carparts.AutoFixHub.data.controller;
import com.carparts.AutoFixHub.data.entity.TermekEntity;
import com.carparts.AutoFixHub.data.service.TermekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/carparts")
public class TermekController {
    @Autowired
    private TermekService termekService;

    @GetMapping
    public String getAllItems(Model model) {
        model.addAttribute("items", termekService.getAllItems());
        return "item-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("item", new TermekEntity());
        return "item-form";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute TermekEntity item) {
        termekService.saveItem(item);
        return "redirect:/carparts";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<TermekEntity> item = termekService.getItemById(id);
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
            return "item-form";
        }
        return "redirect:/carparts";
    }

    @PostMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, @ModelAttribute TermekEntity item) {
        item.setId(id);
        termekService.saveItem(item);
        return "redirect:/carparts";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        termekService.deleteItem(id);
        return "redirect:/carparts";
    }
}
