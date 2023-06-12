package com.example.apkrestaurant.data

class MenuRepository(private val menuDao: MenuDao) {
    suspend fun tambahMenu(menu: Menu){
        menuDao.tambahMenu(menu)
    }

    suspend fun getMenuList():List<Menu>{
        return menuDao.getMenuList()
    }
}