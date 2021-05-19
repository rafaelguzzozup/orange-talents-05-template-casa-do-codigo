package br.com.zupacademy.guzzo.casadocodigo.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ErrorSaidaDto {
	private String titulo;
	private OffsetDateTime dataHora = OffsetDateTime.now();
	private List<CampoErrorDto> listaCamposComErro = new ArrayList<>();

	public ErrorSaidaDto(String titulo) {
		this.titulo = titulo;
	}

	public void adicionaCampoComErro(String campo, String mensagem) {
		CampoErrorDto campoErrorDto = new CampoErrorDto(campo, mensagem);
		listaCamposComErro.add(campoErrorDto);
	}

	public String getTitulo() {
		return titulo;
	}

	public OffsetDateTime getDataHora() {
		return dataHora;
	}

	public List<CampoErrorDto> getListaCamposComErro() {
		return listaCamposComErro;
	}

}
