package com.example.apkrestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.apkrestaurant.data.Menu

class MenuListAdapter (private var menuList : List<Menu>):
    RecyclerView.Adapter<MenuListAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_adapter, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menu = menuList[position]
        holder.bind(menu)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    fun updateData(newMenuList: List<Menu>) {
        menuList = newMenuList
        notifyDataSetChanged()
    }

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(menu: com.example.apkrestaurant.data.Menu) {
            val tvNamaMenu = itemView.findViewById<TextView>(R.id.tvNamaMenu)
            tvNamaMenu.text = menu.namaMenu
        }
    }

}