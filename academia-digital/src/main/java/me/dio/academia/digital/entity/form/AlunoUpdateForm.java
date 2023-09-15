package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoUpdateForm {

  @NotEmpty
  private String nome;
  @NotEmpty
  private String bairro;
  @NotNull
  @Past
  private LocalDate dataDeNascimento;
}
