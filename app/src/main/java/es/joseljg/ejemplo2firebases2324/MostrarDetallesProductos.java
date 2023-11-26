package es.joseljg.ejemplo2firebases2324;

import static es.joseljg.ejemplo2firebases2324.recyclerview1.ProductoViewHolder1.EXTRA_DETALLES_PRODUCTO;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import es.joseljg.ejemplo2firebases2324.clases.Producto;
import es.joseljg.ejemplo2firebases2324.recyclerview1.ProductoViewHolder1;

public class MostrarDetallesProductos extends AppCompatActivity {
    private Producto p;
    private EditText edt_detalles_idp;
    private EditText edt_detalles_nombrep;
    private EditText edt_detalles_cantidadp;

    private EditText edt_detalles_preciop;

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_detalles_producto);

        Intent intent = getIntent();
        if (intent != null) {
            intent.getSerializableExtra(ProductoViewHolder1.EXTRA_DETALLES_PRODUCTO);
        } else {
            p = new Producto();
        }

        edt_detalles_idp = (EditText) findViewById(R.id.edt_detalles_idp);
        edt_detalles_cantidadp = (EditText) findViewById(R.id.edt_detalles_preciop);
        edt_detalles_nombrep = (EditText) findViewById(R.id.edt_detalles_nombrep);
        edt_detalles_preciop = (EditText) findViewById(R.id.edt_detalles_preciop);
        //----------------------
        edt_detalles_idp.setText(p.getIdProducto());
        edt_detalles_cantidadp.setText(p.getCantidad());
        edt_detalles_nombrep.setText(p.getNombre());
        edt_detalles_preciop.setText(String.valueOf(p.getPrecio()));

        //---------------------------------------------------------------------

    }

    public void borrar_detalles(View view) {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("productos");
        myRef.child(p.getIdProducto()).removeValue();
        Toast.makeText(this, "Producto borrado", Toast.LENGTH_LONG).show();
        finish();
    }

    public void editar_detalles(View view) {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("productos");
        String id = String.valueOf(edt_detalles_idp.getText());
        String nombre = String.valueOf(edt_detalles_nombrep.getText());
        int cantidad = Integer.valueOf(String.valueOf(edt_detalles_cantidadp.getText()));
        double precio = Double.valueOf(String.valueOf(edt_detalles_preciop.getText()));
        Producto p1 = new Producto(id, nombre, cantidad, precio);
        Map<String, Object> productos = new HashMap<>();
        productos.put(id, p1);

        myRef.updateChildren(productos);
        Toast.makeText(this, "Procuto actualizado correctamente", Toast.LENGTH_LONG).show();
        finish();
    }
}