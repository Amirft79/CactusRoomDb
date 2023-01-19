package ir.cactus.cactusroomdb.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.cactus.cactusroomdb.R
import ir.cactus.cactusroomdb.databinding.CustomLayoutBinding
import ir.cactus.cactusroomdb.entity.User

class UserAdapter:RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    private var user_list= emptyList<User>()










    class MyViewHolder(val binding:CustomLayoutBinding) :RecyclerView.ViewHolder (binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=CustomLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
           return user_list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=user_list[position]
        holder.binding.tvId.text=currentItem.user_id.toString()
        holder.binding.tvFirstName.text=currentItem.firstName.toString()
        holder.binding.tvLastName.text=currentItem.lastName.toString()
        holder.binding.tvAge.text=currentItem.age.toString()

    }

    fun setData(user:List<User>){
        this.user_list=user
        notifyDataSetChanged()
    }
}