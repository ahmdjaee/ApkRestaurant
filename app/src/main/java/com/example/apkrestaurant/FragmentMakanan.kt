package com.example.apkrestaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apkrestaurant.databinding.FragmentMakananBinding


class FragmentMakanan : Fragment() {
  private lateinit var binding: FragmentMakananBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentMakananBinding.inflate(layoutInflater,container,false)


        val adapter = MenuListAdapter(emptyList())
        val rvMakanan = binding.rvMakanan

        rvMakanan.adapter = adapter
        rvMakanan.layoutManager = LinearLayoutManager(requireContext())
        return inflater.inflate(R.layout.fragment_makanan, container, false)

    }


}