package hermeslojanetbeans.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class ValidarCampo {

    public boolean validarCincoCampoTexto(String value_1,String value_2,String value_3,String value_4,String value_5){
     boolean result = false;
     if((value_1.length() > 0) && (value_1.isEmpty()) && 
       ((value_2.length() > 0) && (value_2.isEmpty())) && 
       ((value_3.length() > 0) && (value_3.isEmpty())) && 
       ((value_4.length() > 0) && (value_4.isEmpty())) && 
       ((value_5.length() > 0) && (value_5.isEmpty()))){
         return true;
     }else{
        JOptionPane.showMessageDialog(null, "Confira os campos Obrigatórios!!");
     }
     return result ;
    }

    public boolean validarCampoNumerico(int value){
        boolean result = false;
        if(value > 0 ){
            return true;
        }
        return result;
    }
    
    public boolean validarData(String dataInicio, String dataFim){
        boolean result = false;
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dtInicio = format.parse(dataInicio);
            Date dtFim = format.parse(dataFim);
            if(dtInicio.before(dtFim)){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Data está erroda !!");
        return result;
    }
    
     public String validarCpjCnpj(String valor){
        
        if((valor.length() == 18) & (isCnpj(valor))){
            return "CNPJ";
        }else if((valor.length() == 14)&(isCpf(valor))){
            return "CPF";
        }
        return null;
    }
    
    public boolean selectItemComboBox(int numero){
        boolean result = false;
        if(numero > 0){
            return true;
        }
        JOptionPane.showMessageDialog(null, "Tipo de Usuario não foi selecionado !!");
        return result;
    }
    
    public boolean isCpf(String cpf) {
    cpf = cpf.replace(".", "");
    cpf = cpf.replace("-", "");
    
    try{
      Long.parseLong(cpf);
    } catch(NumberFormatException e){
      return false;
    }

    int d1, d2;
    int digito1, digito2, resto;
    int digitoCPF;
    String nDigResult;

    d1 = d2 = 0;
    digito1 = digito2 = resto = 0;

    for (int nCount = 1; nCount < cpf.length() - 1; nCount++) {
      digitoCPF = Integer.valueOf(cpf.substring(nCount - 1, nCount)).intValue();

      // multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4
      // e assim por diante.
      d1 = d1 + (11 - nCount) * digitoCPF;

      // para o segundo digito repita o procedimento incluindo o primeiro
      // digito calculado no passo anterior.
      d2 = d2 + (12 - nCount) * digitoCPF;
    };

    // Primeiro resto da divisão por 11.
    resto = (d1 % 11);

    // Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11
    // menos o resultado anterior.
    if (resto < 2)
      digito1 = 0;
    else
      digito1 = 11 - resto;

    d2 += 2 * digito1;

    // Segundo resto da divisão por 11.
    resto = (d2 % 11);

    // Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11
    // menos o resultado anterior.
    if (resto < 2)
      digito2 = 0;
    else
      digito2 = 11 - resto;

    // Digito verificador do CPF que está sendo validado.
    String nDigVerific = cpf.substring(cpf.length() - 2, cpf.length());

    // Concatenando o primeiro resto com o segundo.
    nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

    // comparar o digito verificador do cpf com o primeiro resto + o segundo
    // resto.
    return nDigVerific.equals(nDigResult);
  }

  /**
   * Realiza a validação de um cnpj
   * 
   * @param cnpj String - o CNPJ pode ser passado no formato 99.999.999/9999-99 ou 99999999999999
   * @return boolean
   */
  public boolean isCnpj(String cnpj) {
    cnpj = cnpj.replace(".", "");
    cnpj = cnpj.replace("-", "");
    cnpj = cnpj.replace("/", "");
    
    try{
      Long.parseLong(cnpj);
    } catch(NumberFormatException e){
      return false;
    }
    
    // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
    if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111")
        || cnpj.equals("22222222222222") || cnpj.equals("33333333333333")
        || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
        || cnpj.equals("66666666666666") || cnpj.equals("77777777777777")
        || cnpj.equals("88888888888888") || cnpj.equals("99999999999999") || (cnpj.length() != 14))
      return (false);
    char dig13, dig14;
    int sm, i, r, num, peso; // "try" - protege o código para eventuais
                             // erros de conversao de tipo (int)
    try {
      // Calculo do 1o. Digito Verificador
      sm = 0;
      peso = 2;
      for (i = 11; i >= 0; i--) {
        // converte o i-ésimo caractere do CNPJ em um número: // por
        // exemplo, transforma o caractere '0' no inteiro 0 // (48 eh a
        // posição de '0' na tabela ASCII)
        num = (int) (cnpj.charAt(i) - 48);
        sm = sm + (num * peso);
        peso = peso + 1;
        if (peso == 10)
          peso = 2;
      }

      r = sm % 11;
      if ((r == 0) || (r == 1))
        dig13 = '0';
      else
        dig13 = (char) ((11 - r) + 48);

      // Calculo do 2o. Digito Verificador
      sm = 0;
      peso = 2;
      for (i = 12; i >= 0; i--) {
        num = (int) (cnpj.charAt(i) - 48);
        sm = sm + (num * peso);
        peso = peso + 1;
        if (peso == 10)
          peso = 2;
      }
      r = sm % 11;
      if ((r == 0) || (r == 1))
        dig14 = '0';
      else
        dig14 = (char) ((11 - r) + 48);
      // Verifica se os dígitos calculados conferem com os dígitos
      // informados.
      if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13)))
        return (true);
      else
        return (false);
    } catch (InputMismatchException erro) {
      return (false);
    }
  }
}
