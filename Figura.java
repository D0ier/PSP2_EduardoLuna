
public class Figura implements Figuras{
    private int numeroA;
    private int numeroB;
    private int numeroC;
    private String tipoFigura;

    public Figura() {
    }

    public Figura(int numeroA, int numeroB, int numeroC, String tipoFigura) {
        this.numeroA = numeroA;
        this.numeroB = numeroB;
        this.numeroC = numeroC;
        this.tipoFigura = tipoFigura;
    }

    public int getNumeroA() {
        return numeroA;
    }

    public int getNumeroB() {
        return numeroB;
    }

    public int getNumeroC() {
        return numeroC;
    }

    public String getTipoFigura() {
        return tipoFigura;
    }

    public void setNumeroA(int numeroA) {
        this.numeroA = numeroA;
    }

    public void setNumeroB(int numeroB) {
        this.numeroB = numeroB;
    }

    public void setNumeroC(int numeroC) {
        this.numeroC = numeroC;
    }

    public void setTipoFigura(String tipoFigura) {
        this.tipoFigura = tipoFigura;
    }

    public String detectarFigura() {
       if (numeroA <= 0 || numeroB < 0 || numeroC < 0) {
            return "Los valores no indican ninguna figura";
        }
        if (numeroB == 0 && numeroC == 0) {
            this.tipoFigura = "Círculo";
            return "La figura es un círculo";
        }
        if (numeroC == 0) {
            if (numeroA == numeroB) {
                this.tipoFigura = "Cuadrado";
                return "La figura es un cuadrado";
            }
            this.tipoFigura = "Rectángulo";
            return "La figura es un rectángulo";
        }
        if (numeroB == 0) {
            return "Los valores no indican ninguna figura";
        }
        if (numeroA + numeroB <= numeroC || numeroA + numeroC <= numeroB || numeroB + numeroC <= numeroA) {
            return "Los valores no indican ninguna figura";
        }
        if (numeroA == numeroB && numeroB == numeroC) {
            this.tipoFigura = "Triángulo equilátero";
            return "La figura es un triángulo equilátero";
        }
        if (numeroA == numeroB || numeroB == numeroC || numeroA == numeroC) {
            this.tipoFigura = "Triángulo isósceles";
            return "La figura es un triángulo isósceles";
        }   
        this.tipoFigura = "Triángulo escaleno";
        return "La figura es un triángulo escaleno";
    }   

    @Override
    public double calcularArea(){
         if (numeroA <= 0 || numeroB < 0 || numeroC < 0) {
            System.out.println("Determine una figura en la opción 1...");
            return 0.0;
        }
        if (numeroB == 0 && numeroC == 0) {
           return Math.PI * Math.pow(numeroA, 2);
        }
        if (numeroC == 0) {
            if (numeroA == numeroB) {
                return numeroA * numeroA;
            }
            return numeroA * numeroB;
        }
        if (numeroB == 0) {
            System.out.println("Determine una figura en la opción 1...");
            return 0.0;
        }
        if (numeroA + numeroB <= numeroC || numeroA + numeroC <= numeroB || numeroB + numeroC <= numeroA) {
            System.out.println("Determine una figura en la opción 1...");
            return 0.0;
        }
        if (numeroA == numeroB && numeroB == numeroC) {
            return (Math.sqrt(3) / 4) * Math.pow(numeroA, 2);
        }
        if (numeroA == numeroB || numeroB == numeroC || numeroA == numeroC) {
            if (numeroA == numeroB) {
                    Double altura = Math.sqrt(Math.pow(numeroA, 2) - (Math.pow(numeroC, 2) / 4.0));
                    return (altura * numeroC) / 2.0;
            }
            if (numeroB == numeroC) {
                    Double altura = Math.sqrt(Math.pow(numeroB, 2) - (Math.pow(numeroA, 2) / 4.0));
                    return (altura * numeroA) / 2.0;
            }  
            if (numeroC == numeroA) {
                    Double altura = Math.sqrt(Math.pow(numeroC, 2) - (Math.pow(numeroB, 2) / 4.0));
                    return (altura * numeroB) / 2.0;
            } 
        }   
        double s = (numeroA + numeroB + numeroC) / 2.0;
        return Math.sqrt(s * (s - numeroA) * (s - numeroB) * (s - numeroC));
    }
}
