package br.gov.prefeitura.mimg.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil
{
    public static String formatar(String formato)
    {
    	Date data = new Date();

        return new SimpleDateFormat(formato).format(data);
    }
}