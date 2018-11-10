package SistemaDesktop.model;

public class ArquivosMatricula {

    private String nomeArquivoFotos;
    private String nomeArquivoCsv;
    private String urlArquivoFotos;
    private String urlCsv;
    private int numeroMatriculas;
    private int quantidadeErros;

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

    public int getNumeroMatriculas() {
        return numeroMatriculas;
    }

    public void setNumeroMatriculas(int numeroMatriculas) {
        this.numeroMatriculas = numeroMatriculas;
    }

    public int getQuantidadeErros() {
        return quantidadeErros;
    }

    public void setQuantidadeErros(int quantidadeErros) {
        this.quantidadeErros = quantidadeErros;
    }

}
