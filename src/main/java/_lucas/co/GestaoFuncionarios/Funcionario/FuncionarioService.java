package _lucas.co.GestaoFuncionarios.Funcionario;

import _lucas.co.GestaoFuncionarios.DepartamentoEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario create(FuncionarioCreateDTO createDTO){
        DepartamentoEnum departamento = DepartamentoEnum.valueOf(createDTO.departamento()) ;
        Funcionario func = new Funcionario(
                createDTO.nome(),
                createDTO.salario(),
                departamento,
                createDTO.cargo(),
                createDTO.dataAdmissao()
        );
        return this.funcionarioRepository.save(func);
    }

    public Funcionario getById(Long id){
        return this.funcionarioRepository.findById(id).orElseThrow();
    }

    public List<Funcionario> getAllFuncionarios(){
        return this.funcionarioRepository.findAll();
    }

    public Funcionario update(FuncionarioCreateDTO updateDTO, Long id){
        Funcionario func = getById(id);
        if(!updateDTO.dataAdmissao().isBlank()){
            func.setDataAdmissao(updateDTO.dataAdmissao());
        }
        if(!updateDTO.nome().isBlank()){
            func.setNome(updateDTO.nome());
        }
        if(!updateDTO.salario().isNaN()){
            func.setSalario(updateDTO.salario());
        }
        if(!updateDTO.cargo().isBlank()){
            func.setCargo(updateDTO.cargo());
        }
        if(!updateDTO.departamento().isBlank()){
            DepartamentoEnum departamento = DepartamentoEnum.valueOf(updateDTO.departamento()) ;
            func.setDepartamento(departamento);
        }
        return this.funcionarioRepository.save(func);
    }

    public void delete(Long id){
        Funcionario func = this.getById(id);
        this.funcionarioRepository.delete(func);
    }
}
