package sistemaNotas;

public class AlunoRegular extends Aluno{
	@Override
	public float calcularNota(float n1, float n2, float n3) {
		float media = ((n1+n2+n3)/3)*1.25f;
		return media;
	}
}
