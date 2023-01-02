package com.example.phonesearchplatform.controller;

import com.example.phonesearchplatform.model.Phone;
import com.example.phonesearchplatform.service.inter.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping("/phones")
    public String listPhones(Model model) {
        model.addAttribute("phones", phoneService.findAll());
        return "phones";
    }

    @GetMapping("/phones/new")
    public String createForm(Model model) {
        Phone phone = new Phone();
        model.addAttribute("phone", phone);
        return "create_phone";
    }

    @PostMapping("/phones")
    public String save(@ModelAttribute("phone") Phone phone) {
        phoneService.create(phone);
        return "redirect:/phones";
    }

    @GetMapping("/phones/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("phone", phoneService.getById(id));
        return "edit_phone";
    }

    @PostMapping("/phones/{id}")
    public String update(@PathVariable Integer id,
                         @ModelAttribute("student") Phone phone) {

        phoneService.update(id, phone);
        return "redirect:/phones";
    }

    @GetMapping("/phones/{id}")
    public String delete(@PathVariable Integer id) {
        phoneService.deleteById(id);
        return "redirect:/phones";
    }
}
