import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myself223.card.data.room.models.CategoryModel
import com.myself223.card.databinding.InCategoryBinding

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val list = ArrayList<CategoryModel>()

    fun setList(list : List<CategoryModel>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }
    inner class CategoryViewHolder(private var binding: InCategoryBinding) : RecyclerView.ViewHolder(binding.root){

        fun OnBind(position: Int){
            binding.txtName.text = list[position].name.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            InCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.OnBind(position)
    }

}