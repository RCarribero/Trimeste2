package src.Tema6.Gestor;
public class cuenta {

    public int NumeroCuenta;
    public double Saldo;
    gestor gestor = new gestor(null, NumeroCuenta, NumeroCuenta);
    public cuenta() {
        
    }
    public cuenta(int NumeroCuenta,double Saldo){
        this.NumeroCuenta=NumeroCuenta;
        this.Saldo=Saldo;
    }
    public void asignarGestor(gestor gestor){
        this.gestor=gestor;
    }
    
    public int getNumeroCuenta() {
        return NumeroCuenta;
    }
    public void setNumeroCuenta(int numeroCuenta) {
        NumeroCuenta = numeroCuenta;
    }
    public double getSaldo() {
        return Saldo;
    }
    public void setSaldo(double saldo) {
        Saldo = saldo;
    }
    public gestor getGest() {
        return gestor;
    }
    public void setGest(gestor gestor) {
        this.gestor = gestor;
    }
    public void mostrarinformacion(){
        System.out.println(NumeroCuenta);
        System.out.println(Saldo);
        System.out.println(gestor.nombre);
        System.out.println(gestor.getTelefono());
    }

    public void realizarOperacion(double ingreso, String repuesta){
        if (ingreso>gestor.importeMaximo){
            System.out.println("el importe o retirada es mayor a "+ gestor.importeMaximo);
        }else if(repuesta.equalsIgnoreCase("Ingresar")){
            Saldo+=ingreso;
        }else if(repuesta.equalsIgnoreCase("Retirar")){
            Saldo-=ingreso;
        }
    }

    public void crearCuenta(int numero, double saldoInicial){
        NumeroCuenta=numero;
        Saldo=saldoInicial;
    }

}