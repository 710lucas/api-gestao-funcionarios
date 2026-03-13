package _lucas.co.GestaoFuncionarios.Funcionario;

public record FuncionarioCreateDTO(
        String nome,
        String cargo,
        String departamento,
        Double salario,
        String dataAdmissao
) {
}
