package sistemaAutogestion.Domi.Entidades;


public class Producto implements Comparable { 
    private int id;
    private String nombre;
    private String descripcion;
    private int unidades;

    public Producto(int id,String nombre, String descripcion, int unidades) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidades = unidades > 0 ? unidades : 0;
    }
    public Producto(int id,String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidades = 0;
    }
    public Producto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidades = 0;
    }
    public Producto(int id){
        this.id = id;
        this.unidades = 0;
    }

    public Producto(String nom) {
        this.nombre = nom;
    }
   
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getUnidades(){
        return unidades;
    }
    public void agregarStock(int n){
        unidades += n;
    }
    
    @Override
    public String toString(){
        return "- nombre: " + nombre + ", descripción: " + descripcion + ", unidades: " + unidades;
    }
    @Override
    public boolean equals(Object o){
        Producto p = (Producto)o;
        String otherName = p.getNombre();
        return nombre.equals(otherName);
    }
    @Override
    public int compareTo(Object o) {
       Producto p = (Producto)o;
       int otherId = p.getId();
       if(id == otherId && nombre.equals(p.nombre))
           return 0;
       else if(id < otherId)
           return -1;
       else
           return 1;
    }
    
}
