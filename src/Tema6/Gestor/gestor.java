package src.Tema6.Gestor;

public class gestor {

        public String nombre;
        private int telefono;
        double importeMaximo=10000;
        
        public gestor(String nombre, int telefono, double importeMaximo) {
            this.nombre = nombre;
            this.telefono = telefono;
            this.importeMaximo = importeMaximo;
        }
        public gestor(String nombre, int telefono) {
            this.nombre = nombre;
            this.telefono = telefono;
            this.importeMaximo =10000;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setTelefono(int telefono) {
            this.telefono = telefono;
        }

        public void setImporteMaximo(double importeMaximo) {
            this.importeMaximo = importeMaximo;
        }

        public int getTelefono() {
            return telefono;
        }

        public double getImporteMaximo() {
            return importeMaximo;
        }
        
}
