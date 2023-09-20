package sistemaBancario;

public class Conta {
	String nomePortador;
	String nConta;
	String nAgencia;
	String tipoConta;
	public String getNomePortador() {
		return nomePortador;
	}
	public void setNomePortador(String nomePortador) {
		this.nomePortador = nomePortador;
	}
	public String getnConta() {
		return nConta;
	}
	public void setnConta(String nConta) {
		this.nConta = nConta;
	}
	public String getnAgencia() {
		return nAgencia;
	}
	public void setnAgencia(String nAgencia) {
		this.nAgencia = nAgencia;
	}
	public String getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public float debitarValor(float saldoAtual, float novoDebito) {
		float novoSaldo = saldoAtual + novoDebito;
		return novoSaldo;
	}
	public float sacarValor(float saldoAtual, float novoSaque) {
		float novoSaldo = saldoAtual - novoSaque;
		return novoSaldo;
	}
	
}
