package es.joseljg.ejemplo2firebases2324.recyclerview1;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import es.joseljg.ejemplo2firebases2324.MostrarDetallesProductos;
import es.joseljg.ejemplo2firebases2324.R;
import es.joseljg.ejemplo2firebases2324.clases.Producto;

public class ProductoViewHolder1 extends RecyclerView.ViewHolder implements View.OnClickListener {

    public static final String EXTRA_DETALLES_PRODUCTO = "es.joseljg.ejemplo2firebases2324.mostrardetallesproductos.producto";
    private TextView txt_item2_nombre;
    private TextView txt_item2_cantidad;
    private TextView txt_item2_precio;

    private ListaProductoAdapter1 lpa;

    public ProductoViewHolder1(@NonNull View itemView, ListaProductoAdapter1 lpa) {
        super(itemView);
        txt_item2_nombre = (TextView) itemView.findViewById(R.id.txt_item2_nombre);
        txt_item2_cantidad = (TextView) itemView.findViewById(R.id.txt_item2_cantidad);
        txt_item2_precio = (TextView) itemView.findViewById(R.id.txt_item2_precio);
        this.lpa = lpa;
        itemView.setOnClickListener(this);
    }

    public TextView getTxt_item2_nombre() {
        return txt_item2_nombre;
    }

    public void setTxt_item2_nombre(TextView txt_item2_nombre) {
        this.txt_item2_nombre = txt_item2_nombre;
    }

    public TextView getTxt_item2_cantidad() {
        return txt_item2_cantidad;
    }

    public void setTxt_item2_cantidad(TextView txt_item2_cantidad) {
        this.txt_item2_cantidad = txt_item2_cantidad;
    }

    public TextView getTxt_item2_precio() {
        return txt_item2_precio;
    }

    public void setTxt_item2_precio(TextView txt_item2_precio) {
        this.txt_item2_precio = txt_item2_precio;
    }

    @Override
    public void onClick(View view) {
        int posicion = getAdapterPosition();
        Producto p = lpa.getProductos().get(posicion);
        Intent intent = new Intent(lpa.getContexto(), MostrarDetallesProductos.class);
        intent.putExtra(EXTRA_DETALLES_PRODUCTO, p);
        lpa.getContexto().startActivity(intent);
    }
}
