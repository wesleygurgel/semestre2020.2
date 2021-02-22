import android.content.Context
import android.content.res.TypedArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.adapterviewholder.Veiculo

class VeiculoAdapter (
    private var ctx: Context,
    private var veiculos: List<Veiculo>
    ): BaseAdapter() {

    private val logos: TypedArray by lazy {
        ctx.resources.obtainTypedArray(R.array.logos)
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val veiculo = veiculos[position]
        val row = LayoutInflater.from(ctx).inflate(R.layout.item_veiculo, parent, false)

        row.imgLogo.setImageDrawable(logos.getDrawable(veiculo.fabricante))




    }

    override fun getItem(position: Int): Any = veiculos[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = veiculos.size

}