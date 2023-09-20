package sistemaNotas;

public class AlunoEspecial extends Aluno{
	@Override
	public float calcularNota(float n1, float n2, float n3) {
		float media = ((n1+n2+n3)/3)*1.75f;
		return media;
	}
}
