package urraan.internship.retrofitsimpleexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import urraan.internship.retrofitsimpleexample.databinding.UserDataItemsBinding
import urraan.internship.retrofitsimpleexample.model.UserData

class UserDataAdapter(
    var userDataList: List<UserData>
) : RecyclerView.Adapter<UserDataAdapter.ViewHolder>() {
    class ViewHolder(
        val binding: UserDataItemsBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            UserDataItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            tvId.text = userDataList[position].id.toString()
            tvUserName.text = userDataList[position].name
            tvWebsite.text = userDataList[position].website
            tvEmail.text = userDataList[position].email
        }
    }

    override fun getItemCount(): Int = userDataList.size

}