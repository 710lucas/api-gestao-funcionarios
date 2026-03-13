package _lucas.co.GestaoFuncionarios.Funcionario;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public Funcionario create(@RequestBody FuncionarioCreateDTO dto){
        return funcionarioService.create(dto);
    }

    @GetMapping("/{id}")
    public Funcionario getById(@PathVariable Long id){
        return funcionarioService.getById(id);
    }

    @GetMapping
    public List<Funcionario> getAll(){
        return funcionarioService.getAllFuncionarios();
    }

    @PutMapping("/{id}")
    public Funcionario update(
            @RequestBody FuncionarioCreateDTO dto,
            @PathVariable Long id
    ){
        return funcionarioService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        funcionarioService.delete(id);
    }
}