package br.com.tbmtextil.selecao.action;

import br.com.sankhya.extensions.actionbutton.AcaoRotinaJava;

import br.com.sankhya.extensions.actionbutton.ContextoAcao;
import br.com.sankhya.extensions.actionbutton.QueryExecutor;


public class SelecaoAluno implements AcaoRotinaJava{
	
	
	public Integer result = 0;
	

	@Override
	public void doAction(ContextoAcao contextoacao) throws Exception {
		
		         //Obtemos uma consulta para buscar os lançamentos
				QueryExecutor query = contextoacao.getQuery();
				
				query.nativeSelect("SELECT COUNT(*) AS QTD FROM AD_ALUNO");
				
				
				while (query.next()) {

					this.result = query.getInt("QTD");

					if (result == 0) {
						contextoacao.setMensagemRetorno("N�o existem mais Alunos na base!");
					}else{
						contextoacao.setMensagemRetorno("Quantidade Alunos Cadastrados:"+result);
					}
				}
				
				
				//preparamos a execução da query, incluindo o parâmetro CODVEICULO.
				
				//contextoacao.setMensagemRetorno("Resultado:"+contextoacao.getParam("NOME"));
				
				//query.setParam("AD_ALUNO", contextoacao.getParam("NOME"));
				
				 
				
				
	}

}
