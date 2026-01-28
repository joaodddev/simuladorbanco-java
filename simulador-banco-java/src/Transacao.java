import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {

    private String tipo;
    private double valor;
    private double saldoApos;
    private LocalDateTime dataHora;

    public Transacao(String tipo, double valor, double saldoApos) {
        this.dataHora = LocalDateTime.now();
        this.tipo = tipo;
        this.valor = valor;
        this.saldoApos = saldoApos;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
         return "[" + dataHora.format(formatter) + "] "
                + tipo
                + " | Valor: R$ " + valor
                + " | Saldo após: R$ " + saldoApos;
    }
}