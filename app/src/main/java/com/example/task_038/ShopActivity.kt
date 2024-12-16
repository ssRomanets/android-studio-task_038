package com.example.task_038

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlin.system.exitProcess
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson

class ShopActivity : AppCompatActivity() {

    var maskProducts = mutableListOf<Int>()
    val products = ProductDataBase.products

    private lateinit var toolBarShop: Toolbar
    private lateinit var recyclerViewRV: RecyclerView
    private lateinit var toCartShopButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        maskProducts.add(0)
        for ( i in products.indices)  maskProducts.add(0)

        val dialogBuilder = AlertDialog.Builder(this)

        init()

        setSupportActionBar(toolBarShop)
        title = "Продуктовый магазин."

        recyclerViewRV.layoutManager = LinearLayoutManager(this)

        val adapter = CustomAdapter(products)
        adapter.setOnProductClickListener( object :
            CustomAdapter.OnProductClickListener {
            override fun onProductClick(product: Product, position: Int) {
                dialogBuilder.setTitle("Подтверждение покупки")
                dialogBuilder.setPositiveButton("В корзину"){_, _ ->
                    maskProducts.set(position, maskProducts.get(position)+1)
                }
                dialogBuilder.setNegativeButton("Отмена"){dialog, which ->
                    if (maskProducts.get(position) > 0) {
                        maskProducts.set(position, maskProducts.get(position)-1)
                    }
                }
                dialogBuilder.create().show()
            }
        })
        recyclerViewRV.adapter = adapter
        recyclerViewRV.setHasFixedSize(true)

        toCartShopButton.setOnClickListener{
            toCartShopButton.animate().apply{
                rotationBy(360f)
                duration = 1000
            }.start()

            val stringData = Gson().toJson(maskProducts)
            val intent = Intent(this@ShopActivity, CartActivity::class.java)
            intent.putExtra("stringData", stringData)
            startActivity(intent)
        }
    }

    fun init() {
        toolBarShop = findViewById(R.id.toolBarShop)
        recyclerViewRV = findViewById(R.id.recyclerViewRV)
        toCartShopButton = findViewById(R.id.toCartShopButton)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitMenuMain->{
                moveTaskToBack(true);
                exitProcess(-1)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}