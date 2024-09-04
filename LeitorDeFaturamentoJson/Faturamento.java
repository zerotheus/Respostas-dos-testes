package LeitorDeFaturamentoJson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Faturamento {
    public static void main(String[] args) throws IOException {
        Faturamento faturamento = new Faturamento();
        faturamento.lerFaturamento();
    }

    public void lerFaturamento() {
        Double menorFaturamento = Double.MAX_VALUE;
        Double maiorFaturamento = Double.MIN_VALUE;
        int diasAcimaDaMedia = 0;
        Double totalFaturado = 0.0;
        int diasFaturados = 0;
        LinkedList<FaturamentoDeUmDia> faturamentos = new LinkedList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("LeitorDeFaturamentoJson\\dados.json");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String linha = "";
            while (linha != null) {
                linha = bufferedReader.readLine();
                if (linha == null) {
                    break;
                }
                if (linha.contains("dia")) {
                    FaturamentoDeUmDia faturamentoDeUmDia = gerarFaturamentoDeUmDia(linha, bufferedReader.readLine());
                    if (faturamentoDeUmDia.faturamento != 0) {
                        faturamentos.add(faturamentoDeUmDia);
                        diasFaturados++;
                        totalFaturado += faturamentoDeUmDia.faturamento;
                        if (faturamentoDeUmDia.faturamento < menorFaturamento) {
                            menorFaturamento = faturamentoDeUmDia.faturamento;
                        }
                        if (faturamentoDeUmDia.faturamento > maiorFaturamento) {
                            maiorFaturamento = faturamentoDeUmDia.faturamento;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < faturamentos.size(); i++) {
            if (faturamentos.get(i).faturamento > totalFaturado / diasFaturados) {
                diasAcimaDaMedia++;
            }
        }
        System.out.println("Menor faturamento foi: " + menorFaturamento);
        System.out.println("Maior faturamento foi: " + maiorFaturamento);
        System.out.println("Media de faturamento foi: " + totalFaturado / diasFaturados);
        System.out.println("A quantidade de dias acima da media mensal é " + diasAcimaDaMedia);

    }

    private FaturamentoDeUmDia gerarFaturamentoDeUmDia(String contendoDia, String contendoFaturado) {
        String dia = "";
        for (int i = contendoDia.length() - 2; contendoDia.charAt(i) != ' '; i--) {
            dia = contendoDia.charAt(i) + dia;
        }
        String faturamento = "";
        for (int i = contendoFaturado.length() - 1; contendoFaturado.charAt(i) != ' '; i--) {
            faturamento = contendoFaturado.charAt(i) + faturamento;
        }
        return new FaturamentoDeUmDia(Short.parseShort(dia), Double.parseDouble(faturamento));
    }
}
