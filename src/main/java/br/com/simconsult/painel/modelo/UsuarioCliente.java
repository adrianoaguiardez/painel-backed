package br.com.simconsult.painel.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table
@Entity(name = "TBUSUARIO_CLIENTE")
public class UsuarioCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "InvSeqUsuarioCliente", sequenceName = "TBUSUARIO_CLIENTE_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InvSeqUsuarioCliente")
	@Column(name = "codigo")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "CODIGO_CLIENTE")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "CODIGO_USUARIO")
	private Usuario usuario;

	@Deprecated
	public UsuarioCliente() {
	}

	public UsuarioCliente(Long id, Cliente cliente, Usuario usuario) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
