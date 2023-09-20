package sistemaNotas;

public class Aluno {
	String nome;
	String tipoAluno;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipoAluno() {
		return tipoAluno;
	}
	
	public void setTipoAluno(String tipoAluno) {
		this.tipoAluno = tipoAluno;
	}
	
	public float calcularNota(float n1, float n2, float n3) {
		float media = (n1+n2+n3)/3;
		return media;
	}
}
