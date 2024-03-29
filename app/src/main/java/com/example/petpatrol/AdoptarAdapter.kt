package com.example.petpatrol

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.petpatrol.api.Post

class AdoptarAdapter(private var posts: MutableList<Post> = mutableListOf()) : RecyclerView.Adapter<AdoptarAdapter.ViewHolder>() {

    fun updateData(newPosts: List<Post>) {
        posts.clear()
        posts.addAll(newPosts)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val tvAnimal: TextView = view.findViewById(R.id.tvAnimal)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val ivPerrito: ImageView = view.findViewById(R.id.ivPerrito)
        val tvDescription: TextView = view.findViewById(R.id.tvDescription)
        val tvAge: TextView = view.findViewById(R.id.tvAge)
        val tvSize: TextView = view.findViewById(R.id.tvSize)
        val tvSexo: TextView = view.findViewById(R.id.tvSexo)
        val tvDistrito: TextView = view.findViewById(R.id.tvDistrito)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adoptar_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]


//        holder.tvAnimal.text = "Tipo de Post: ${getTipoPostDescription(post.tipo_post)}"
        holder.tvName.text = "Nombre: ${post.name_mascota}"

        holder.tvDescription.text = "Descripción: ${post.contenido_mascota}"

        holder.tvAge.text = "Edad: ${getEdadDescription(post.id_edad)}"
        holder.tvSize.text = "Tamaño: ${getSizeDescription(post.id_size)}"
        holder.tvSexo.text = "Sexo: ${getSexoDescription(post.id_sexo)}"
        holder.tvDistrito.text = "Distrito: ${getDistritoDescription(post.id_distrito)}"

        if (post.imageUrl.isNotEmpty()) {
            Glide.with(holder.ivPerrito.context).load(post.imageUrl).into(holder.ivPerrito)
        } else {
            // Carga una imagen predeterminada o deja el ImageView sin imagen
            holder.ivPerrito.setImageResource(R.drawable.ic_add_image_white)
        }
    }

    override fun getItemCount() = posts.size

//    private fun getTipoPostDescription(tipoPost: Int): String {
//        return when (tipoPost) {
//            1 -> "Adoptar"
//            2 -> "Ayudar"
//            3 -> "Cruce"
//            else -> "Desconocido"
//        }
//    }
    private fun getEdadDescription(idEdad: Int): String = when (idEdad) {
        1 -> "Cachorro"
        2 -> "Joven"
        3 -> "Adulto"
        else -> "Desconocido"
    }

    private fun getSizeDescription(idSize: Int): String = when (idSize) {
        1 -> "Pequeño"
        2 -> "Mediano"
        3 -> "Grande"
        else -> "Desconocido"
    }

    private fun getSexoDescription(idSexo: Int): String = when (idSexo) {
        1 -> "Macho"
        2 -> "Hembra"
        else -> "Desconocido"
    }

    private fun getDistritoDescription(idDistrito: Int): String = when (idDistrito) {
        1 -> "Iquitos"
        2 -> "Belen"
        3 -> "Punchana"
        4 -> "San Juan"
        else -> "Desconocido"
    }

}
