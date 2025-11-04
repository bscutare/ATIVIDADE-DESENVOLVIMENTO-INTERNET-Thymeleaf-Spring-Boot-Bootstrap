package org.example.controllers;


import org.example.models.Aluno;
import org.example.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
public class AlunoController {


    @Autowired
    private AlunoService alunoService;


    // ========== REST endpoints (mantidos) ==========
    @PostMapping(Aluno.API)
    @ResponseBody
    public Aluno add(@RequestBody @Valid Aluno aluno) {
        return alunoService.add(aluno);
    }


    @GetMapping(Aluno.API)
    @ResponseBody
    public List<Aluno> get() {
        return alunoService.get();
    }


    @PutMapping(Aluno.API + "/{id}")
    @ResponseBody
    public Aluno updateApi(@PathVariable Integer id, @RequestBody @Valid Aluno aluno) {
        aluno.setId(id);
        return alunoService.update(aluno);
    }


    @DeleteMapping(Aluno.API + "/{id}")
    @ResponseBody
    public void deleteApi(@PathVariable Integer id) {
        alunoService.deleteById(id);
    }


    // Form novo aluno
    @GetMapping("/aluno/novo")
    public String novoForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        model.addAttribute("action", "Cadastrar");
        return "aluno/form"; // templates/aluno/form.html
    }

    // ========== MVC (Thymeleaf) endpoints ==========
// Lista todos alunos (UI)
    @GetMapping({"/", "/alunos"})
    public String listar(Model model) {
        model.addAttribute("alunos", alunoService.get());
        return "aluno/list"; // templates/aluno/list.html
    }

    // Salvar (novo ou editar)
    @PostMapping("/aluno/salvar")
    public String salvar(@Valid @ModelAttribute("aluno") Aluno aluno, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("action", aluno.getId() == null ? "Cadastrar" : "Editar");
            return "aluno/form";
        }
        if (aluno.getId() == null) {
            alunoService.add(aluno);
        } else {
            alunoService.update(aluno);
        }
        return "redirect:/alunos";
    }


    // Editar: carrega form com dados do aluno
    @GetMapping("/aluno/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Optional<Aluno> opt = alunoService.getById(id);
        if (opt.isPresent()) {
            model.addAttribute("aluno", opt.get());
            model.addAttribute("action", "Editar");
            return "aluno/form";
        } else {
            return "redirect:/alunos";
        }
    }


    // Excluir aluno
    @GetMapping("/aluno/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        alunoService.deleteById(id);
        return "redirect:/alunos";
    }
}
