package es.joseljg.ejemplo2firebases2324.recyclerview1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.joseljg.ejemplo2firebases2324.R;
import es.joseljg.ejemplo2firebases2324.clases.Producto;
import es.joseljg.ejemplo2firebases2324.recyclerview.ProductoViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaProductoAdapter1 extends RecyclerView.Adapter<ProductoViewHolder1> {
    private Context contexto;
    private ArrayList<Producto> productos;

    private LayoutInflater inflate;

    public ListaProductoAdapter1(Context contexto, ArrayList<Producto> productos) {
        this.contexto = contexto;
        this.productos = productos;
        inflate = LayoutInflater.from(this.contexto);
    }

    @NonNull
    @Override
    public ProductoViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = inflate.inflate(R.layout.item_rv_productos1, parent, false);
        ProductoViewHolder1 evh = new ProductoViewHolder1(mItemView, this);
        return evh;
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder1 holder, int position) {
        Producto p = this.getProductos().get(position);
        //----------------------------------------------------------------------
        holder.getTxt_item2_nombre().setText("nombre: " + p.getNombre());
        holder.getTxt_item2_cantidad().setText("cantidad: " + String.valueOf(p.getCantidad()));
        holder.getTxt_item2_precio().setText("precio: " + String.valueOf(p.getPrecio()));
    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }
}
