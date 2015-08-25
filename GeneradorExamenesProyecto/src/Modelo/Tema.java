package Modelo;

public class Tema 
{
    private int idTema;
    private String tema;

    public Tema() {
    }

    public Tema(int idTema, String tema) {
        this.idTema = idTema;
        this.tema = tema;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
    public void Ftemas(String materia)
    {
        switch (materia) {
            case "Sistemas Naturales":
                {
                    Tema t1 = new Tema(1, "Celula");
                    Tema t2 = new Tema(2, "Fotosintesis");
                    Tema t3 = new Tema(3, "Sistema Oseo");
                    break;
                }
            case "Biologia":
                {
                    Tema t1 = new Tema(1, "T1. Biolo");
                    Tema t2 = new Tema(2, "T2. Biolo");
                    Tema t3 = new Tema(3, "T3. Biolo");
                    break;
                }
        }
    } 
       
}
