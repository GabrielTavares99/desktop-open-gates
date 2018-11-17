package SistemaDesktop.model;

import java.util.Date;

public class ArquivoCredenciamentoAluno {

    private String nomeArquivoFotos;
    private String nomeArquivoCsv;
    private String urlArquivoFotos;
    private String urlCsv;
    private int qtdCredenciamentosFeitos;
    private int qtdTotal;
    private int quantidadeErros;
    private Date data;
    public String getNomeArquivoFotos() {
        return nomeArquivoFotos;
    }

    public void setNomeArquivoFotos(String nomeArquivoFotos) {
        this.nomeArquivoFotos = nomeArquivoFotos;
    }

    public String getNomeArquivoCsv() {
        return nomeArquivoCsv;
    }

    public void setNomeArquivoCsv(String nomeArquivoCsv) {
        this.nomeArquivoCsv = nomeArquivoCsv;
    }

    public String getUrlArquivoFotos() {
        return urlArquivoFotos;
    }

    public void setUrlArquivoFotos(String urlArquivoFotos) {
        this.urlArquivoFotos = urlArquivoFotos;
    }

    public String getUrlCsv() {
        return urlCsv;
    }

    public void setUrlCsv(String urlCsv) {
        this.urlCsv = urlCsv;
    }

    public int getQtdCredenciamentosFeitos() {
        return qtdCredenciamentosFeitos;
    }

    public void setQtdCredenciamentosFeitos(int qtdCredenciamentosFeitos) {
        this.qtdCredenciamentosFeitos = qtdCredenciamentosFeitos;
    }

    public int getQuantidadeErros() {
        return quantidadeErros;
    }

    public void setQuantidadeErros(int quantidadeErros) {
        this.quantidadeErros = quantidadeErros;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQtdTotal() {
        return qtdTotal;
    }

    public void setQtdTotal(int qtdTotal) {
        this.qtdTotal = qtdTotal;
    }
}
