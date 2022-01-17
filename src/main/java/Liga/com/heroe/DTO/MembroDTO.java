package Liga.com.heroe.DTO;

import Liga.com.heroe.Model.Membro;

public class MembroDTO {

	private Long id;
	private String nome;
	private String tipo;
	private String planeta;
	private String poder;
	
	public MembroDTO() {
	}

	public MembroDTO(Long id, String nome, String tipo, String planeta, String poder) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.planeta = planeta;
		this.poder = poder;
	}
	
	public MembroDTO(Membro entity) {
		id = entity.getId();
		nome = entity.getNome();
		tipo = entity.getTipo();
		planeta = entity.getPlaneta();
		poder = entity.getPoder();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPlaneta() {
		return planeta;
	}

	public void setPlaneta(String planeta) {
		this.planeta = planeta;
	}

	public String getPoder() {
		return poder;
	}

	public void setPoder(String poder) {
		this.poder = poder;
	}
}
