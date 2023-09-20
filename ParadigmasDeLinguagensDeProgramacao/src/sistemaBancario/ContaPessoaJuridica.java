package sistemaBancario;

public class ContaPessoaJuridica extends Conta {
	@Override
	public float debitarValor(float saldoAtual, float novoDebito) {
		float novoSaldo = saldoAtual + (novoDebito * 0.15f);
		return novoSaldo;
	}
}
