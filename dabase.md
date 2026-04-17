# Tema AppDatabase Room y SharedPreferences

En los archivos build.gradel agregamos las siguientes dependencias:

Module app:

```gradle
// Room
def room_version = "2.8.4"

implementation "androidx.room:room-runtime:$room_version"
annotationProcessor "androidx.room:room-compiler:$room_version"
```

Ahora creamos la siguiente estructura de paquetes:
- Database
- DAOS
- Entitys

Lo primero que creamos son las entitys, estas son las clases que representan las tablas de la base de datos, por ejemplo:

```java

@Entity(tableName = "producto")
public class Producto {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nombre_producto")
    public String nombre;

    @ColumnInfo(name = "stock_producto")
    public double stock;

    @ColumnInfo(name = "precio_producto")
    public double precio;

}
```

| Anotación     | ¿Para qué sirve?                     | Ejemplo                                                                                                                                                |
| ------------- | ------------------------------------ | --------------------------- |
| `@Entity`     | Define una tabla                     | `@Entity(tableName = "clientes")`                                                                                                                      |
| `@PrimaryKey` | Clave primaria                       | `@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_cliente") int id;`                                                                            |
| `@ColumnInfo` | Nombre de columna, valor por defecto | `@ColumnInfo(name = "nombre_completo", defaultValue = "Sin nombre") String nombre;`                                                                    |
| `@Ignore`     | Campo que NO se guarda               | `@Ignore String temp;`                                                                                                                                 |
| `@Embedded`   | Inserta un objeto dentro de la tabla | `@Embedded Direccion direccion;`                                                                                                                       |
| `@ForeignKey` | Define relación con otra tabla       | `@Entity(foreignKeys = @ForeignKey(entity = Cliente.class, parentColumns = "id_cliente", childColumns = "cliente_id", onDelete = ForeignKey.CASCADE))` |
| `@Index`      | Crea índices para búsquedas rápidas  | `@Entity(indices = {@Index(value = "correo", unique = true)})`                                                                                         |


este entidad se pueda usar como modelo:
Nota: Enfoque de Arquitectura Recomendada (Separar Entidad de Modelo/POJO)

Ahora creamos el DAO, este es el encargado de definir las operaciones que se pueden realizar en la base de datos, por ejemplo:

```java
@Dao

public interface ProductoDao {

    @Insert
    void insertProducto(Producto producto);

    @Update
    void updateProducto(Producto producto);

    @Delete
    void deleteProducto(Producto producto);

    @query("SEECT * FROM producto WHERE id =:id")
    Producto getProductoById(int id);

    @Query("SELECT * FROM producto")
    List<Producto> getAllProductos();

}
```

Ahora creamos el AppDatabse:

```java

@Database(entities = {Producto.class}, version = 1, exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProductoDao productoDao();// se debe hacer el DAO antes 
}

```

Ahora solo Integramos la clase AppDatabase en la activity que vaos a usar

``` java

private AppDatabase database;

```

dentro del onCreate 

```java 

database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "nombre_base_datos").allowMainThreadQueries().build();

ProductoDao dao = database.productoDao();

// Ahora usamos el DAO pra realizar operaciones con la base de datos 

Producto producto = new Producto();
producto.nombre = "Producto 1";
producto.stock = 10;
producto.precio = 100;

dao.insertProducto(producto);
```
