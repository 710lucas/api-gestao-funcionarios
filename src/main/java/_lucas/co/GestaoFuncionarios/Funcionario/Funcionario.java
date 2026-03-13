package _lucas.co.GestaoFuncionarios.Funcionario;

import _lucas.co.GestaoFuncionarios.DepartamentoEnum;
import jakarta.persistence.*;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String cargo;

    @Enumerated(EnumType.STRING)
    private DepartamentoEnum departamento;

    private Double salario;

    private String dataAdmissao;

    public Funcionario() {
    }

    public Funcionario(String dataAdmissao, Double salario, DepartamentoEnum departamento, String cargo, String nome) {
        this.dataAdmissao = dataAdmissao;
        this.salario = salario;
        this.departamento = departamento;
        this.cargo = cargo;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public DepartamentoEnum getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoEnum departamento) {
        this.departamento = departamento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
}
