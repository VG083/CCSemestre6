package sistemaBancario;

public class ContaPessoaFisica extends Conta {
	@Override
	public float sacarValor(float saldoAtual, float novoSaque) {
		float novoSaldo = saldoAtual - (novoSaque * 0.125f);
		return novoSaldo;
	}
}
