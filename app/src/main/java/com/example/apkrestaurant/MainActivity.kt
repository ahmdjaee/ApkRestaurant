package com.example.apkrestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apkrestaurant.data.Menu
import com.example.apkrestaurant.data.MenuDatabase
import com.example.apkrestaurant.data.MenuRepository
import com.example.apkrestaurant.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding
    private lateinit var menuDatabase: MenuDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        setupWithNavController(binding.bottomNavigationView, navController)

        NavigationUI.setupActionBarWithNavController(this, navController)

        val inflater = LayoutInflater.from(this)
        val layout = inflater.inflate(R.layout.fragment_makanan, null)

        menuDatabase = MenuDatabase.getIntance(this)
        val recyclerView: RecyclerView = layout.findViewById(R.id.rvMakanan)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val menuList = listOf(
            Menu(1,"Nasi Goreng", 10000 )

        )


        val menuListAdapter = MenuListAdapter(menuList)
        recyclerView.adapter = menuListAdapter

        val menuRepository = MenuRepository(menuDatabase.menuDao())

        CoroutineScope(Dispatchers.Main).launch {
            val menuList = menuRepository.getMenuList()
            menuListAdapter.updateData(menuList)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}