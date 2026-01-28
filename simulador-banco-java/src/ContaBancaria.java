import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {

    private String nomeCliente;
    private String tipoConta;
    private double saldo;
    private List<Transacao> historico;

    public ContaBancaria(String nomeCliente, String tipoConta, double saldoInicial) {
        this.nomeCliente = nomeCliente;
        this.tipoConta = tipoConta;
        this.saldo = saldoInicial;
        this.historico = new ArrayList<>();
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public void receberValor(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido.");
            return;
        }

        saldo += valor;
        historico.add(new Transacao("DEPÓSITO", valor, saldo));
        System.out.println("Depósito realizado com sucesso.");
    }

    public void transferirValor(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido.");
            return;
        }

        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        saldo -= valor;
        historico.add(new Transacao("TRANSFERÊNCIA", valor, saldo));
        System.out.println("Transferência realizada com sucesso.");
    }

    public void exibirHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
            return;
        }

        System.out.println("\n📄 Histórico de Transações:");
        for (Transacao transacao : historico) {
            System.out.println(transacao);
        }
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getTipoConta() {
        return tipoConta;
    }
}