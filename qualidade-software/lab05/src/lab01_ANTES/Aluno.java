package lab01_ANTES;


public class Aluno {
	private double nota1, nota2, nota3;

	public Aluno(double n1, double n2, double n3) {
		this.setNotas(n1, n2, n3);
	}

	public void setNotas(double nota1, double nota2, double nota3) {
		if (valida_nota(nota1)) {
			this.nota1 = nota1;
		}
		if (valida_nota(nota2)) {
			this.nota2 = nota2;
		}
		if (valida_nota(nota3)) {
			this.nota3 = nota3;
		}
	}

	public boolean valida_nota(double nota) {
		return nota < 0 || nota > 10;
	}

	public double calcula_media() {
		double media = (this.nota1 + this.nota2 + this.nota3) / 3.0;
		return media;
	}

	public String verificaSituacao() {
		double media = calcula_media();

		if (media >= 7) {
			return "aprovado!";
		} else if (media >= 5 && media <= 6.9) {
			return "em exame!";
		} else {
			return "reprovado!";
		}
	}

}
