# RecycleView 

- primero creamos el modelo de datos, por ejemplo una clase Producto con sus atributos

- segundo creamos la vista XML para cada item del recycleView, por ejemplo item_producto.xml

- tercero creamos el Adapter, que es el encargado de adaptar los datos del modelo a la vista

en primer lugar hacemos la clase:

```java 

PruebaAdapter extends RecyclerView.Adapter<PruebaAdapter.viewHolder>

```
- #1 nombre de la clase
- #2 Extendemos de RecyclerView.Adapter<PruebaAdapter.viewHolder> 

```cuotation
Nota: la extension es la clase que vamos a usar para crear los items del recycleView + una clase que vamos a crear llamada viewHolder (o como le queramos poner)
```

Al hacer esto nos dara un error y lo que hacemos es implementar los metodos que nos faltan, en este caso son 3:

- onCreateViewHolder()
- onBindViewHolder()
- getItemCount()

Ahora creamos la clase viewHolder dentro de la clase PruebaAdapter, esta clase es la que se encarga de crear los objetos de la vista y asignarles los datos del modelo, por ejemplo:

```java
public class viewHolder extends RecyclerView.ViewHolder {}
```

Nos dara un error porque no hemos creado el constructor, entonces lo creamos:

```java
public viewHolder(@NonNull View itemView) {
    super(itemView);
    // aqui asignamos los objetos de la vista a las variables de la clase viewHolder
}
```

Ahora creamos un arreglo de datos que es el que le vamos a pasar al adapter para que lo muestre en el recycleView, por ejemplo:

```java
    private ArrayList<Producto> dataProducto;

    //constructor del adapter

    public PruebaAdapter(ArrayList<Producto> dataProducto) {
        this.dataProducto = dataProducto;
    }
```

Ahora en el viewHolder inicializamos los objetos de la vista, por ejemplo:

```java
    public TextView nombreProducto;
    public TextView precioProducto;

    public viewHolder(@NonNull View itemView) {
        super(itemView);
        nombreProducto = itemView.findViewById(R.id.nombreProducto);
        precioProducto = itemView.findViewById(R.id.precioProducto);
    }
```

Nota: si el R no reconoce importar ``` import com.example.recycleview.R;```

Ahora le damos las propiedades y datos a cada item

```java
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        
        Producto producto = dataProducto.get(position);
        holder.imageP.setImageResource(producto.image);
        holder.textoNombreP.setText(producto.nombre);
        holder.textoStockP.setText(String.valueOf(producto.stock));

    }
```
Nota: el holder es el que hizimos en la clase viewHolder y el position es la posicion del item en el arreglo de datos, entonces lo que hacemos es obtener el producto de esa posicion y asignarle los datos a los objetos de la vista.

Por ultimo hacemos el evento onCreateViewHolder() que es el que se encarga de crear los objetos de la vista, por ejemplo:

```java
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent,false);

        return new viewHolder(view);
    }
```

# definir el recycle view en el activity

#1 inizializar lo necesario

```java
    RecyclerView RecycleMascota;
    ArrayList<Mascota> mascotas;
    MascotaAdapter adapterMascota;
```

#2 asignar el recycle view a la variable

```java
    RecycleMascota = findViewById(R.id.RecycleMascota);
```
#3 llenar el arreglo de datos

```java
    mascotas = new ArrayList<>();
    mascotas.add(new Mascota("Firulais", R.drawable.firulais, 5));
    mascotas.add(new Mascota("Rex", R.drawable.rex, 3));
    mascotas.add(new Mascota("Luna", R.drawable.luna, 4));
    mascotas.add(new Mascota("Max", R.drawable.max, 2));
    mascotas.add(new Mascota("Bella", R.drawable.bella, 6));
```

#4 asignar el adapter al recycle view

```java

    adapterMascota = new MascotaAdapter(mascotas);

    // asignar el layout manager al recycle view

    RecycleMascota.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    RecycleMascota.setAdapter(adapterMascota);
```





# NOTIFICAR CAMBIOS EN EL ADAPTADOR

| Acción      | Método                   |
| ----------- | ------------------------ |
| Todo cambió | `notifyDataSetChanged()` |
| Agregar     | `notifyItemInserted()`   |
| Eliminar    | `notifyItemRemoved()`    |
| Modificar   | `notifyItemChanged()`    |
