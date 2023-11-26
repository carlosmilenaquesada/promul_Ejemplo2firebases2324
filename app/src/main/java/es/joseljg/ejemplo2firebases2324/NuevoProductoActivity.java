package es.joseljg.ejemplo2firebases2324;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import es.joseljg.ejemplo2firebases2324.clases.Producto;
public class NuevoProductoActivity extends AppCompatActivity {

    private EditText edt_nuevo_idp;
    private EditText edt_nuevo_nombrep;
    private EditText edt_nuevo_cantidadp;
    private EditText edt_nuevo_preciop;

    private FirebaseDatabase database;
        public static final int NUEVA_IMAGEN = 1;
        Uri imagen_seleccionada = null;
    private FirebaseStorage storage;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_producto);
        edt_nuevo_idp = (EditText) findViewById(R.id.edt_nuevo_idp);
        edt_nuevo_nombrep = (EditText) findViewById(R.id.edt_detalles_cantidadp);
        edt_nuevo_cantidadp = (EditText) findViewById(R.id.edt_nuevo_cantidadp);
        edt_nuevo_preciop = (EditText) findViewById(R.id.edt_nuevo_preciop);
        //-------------------------------------------------------------------------
        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();
        myRef = database.getReference();
    }

    public void insertarProducto(View view)
    {
        String identificador = String.valueOf(edt_nuevo_idp.getText());
        String nombre = String.valueOf(edt_nuevo_nombrep.getText());
        int cantidad = Integer.valueOf(String.valueOf(edt_nuevo_cantidadp.getText()));
        double precio = Double.valueOf(String.valueOf(edt_nuevo_preciop.getText()));
        Producto p1 = new Producto(identificador,nombre,cantidad,precio);
        myRef.child("productos").child(p1.getIdProducto()).setValue(p1);
        Toast.makeText(this, "Producto añadido correctamente", Toast.LENGTH_LONG).show();
    }





}