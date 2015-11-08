package mpoo.ufrpe.projetoalergia.negocio.infra;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Allan on 01/11/2015.
 */
public class Util {


    public static void validarStringEspaco(String componente, String item)throws ProjetoAlergiaException{
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(componente);
        if(matcher.find()){
            String messagem = "O "+item+" não deve conter espaço";
            throw new ProjetoAlergiaException(messagem);
        }
    }

    public static void isCPF(String CPF) throws ProjetoAlergiaException{

        char dig10, dig11;
        int sm, i, r, num, peso;
        sm = 0;
        peso = 10;

        for (i=0; i<9; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1; }
        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig10 = '0';
        else
            dig10 = (char)(r + 48);
        sm = 0;
        peso = 11;
        for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1; }
        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig11 = '0';
        else
            dig11 = (char)(r + 48);
        if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
            return ;
        else {
            String menssagem = "CPF inválido";
            throw new ProjetoAlergiaException(menssagem);
        }
    }



}
