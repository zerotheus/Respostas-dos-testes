package Estados;

import java.util.LinkedList;

public class FaturamentoMensal {

    public static void main(String[] args) {
        LinkedList<FaturamentoDeUmEstado> faturamentos = new LinkedList<>();
        faturamentos.add(new FaturamentoDeUmEstado("SP", 67836.43));
        faturamentos.add(new FaturamentoDeUmEstado("RJ", 36678.66));
        faturamentos.add(new FaturamentoDeUmEstado("MG", 29229.88));
        faturamentos.add(new FaturamentoDeUmEstado("ES", 27165.48));
        faturamentos.add(new FaturamentoDeUmEstado("Outros", 19849.53));
        double total = 0;
        for (int i = 0; i < faturamentos.size(); i++) {
            total += faturamentos.get(i).faturamento;
        }
        for (int i = 0; i < faturamentos.size(); i++) {
            System.out.println(
                    "A porcentagem de " + faturamentos.get(i).estado + " É "
                            + faturamentos.get(i).faturamento / total * 100 + "%");
        }
    }

}
