package rian;

public class DiaristasContratadas {
    private Diarista diarista;
    private Moradia moradia;

    public DiaristasContratadas(Diarista diarista,Moradia moradia) {
        this.diarista= diarista;
        this.moradia = moradia;
    }

    public Diarista getDiarista() {
        return diarista;
    }

    public Moradia getMoradia() {
        return moradia;
    }
}
