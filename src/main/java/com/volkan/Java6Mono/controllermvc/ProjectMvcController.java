package com.volkan.Java6Mono.controllermvc;

import com.volkan.Java6Mono.models.MusteriModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ProjectMvcController {

    /**
     * http://localhost/musteri
     * @return
     */
    @GetMapping("/musteri")
    public ModelAndView musteriList() {
        ModelAndView modelAndView = new ModelAndView();
        MusteriModel model = MusteriModel.builder()
                        .baslik("Müşteri İşlemleri")
                                .adres("Ankarada bir yer")
                                        .menulistesi(Arrays.asList("Müşteri","Urun","Satış"))
                                                .musterilistesi(Arrays.asList("Muhammet","Deniz","Hakan"))
                                                        .build();
        modelAndView.setViewName("musteri");
        modelAndView.addObject(
                "model",
                model);
        return modelAndView;
    }
}
