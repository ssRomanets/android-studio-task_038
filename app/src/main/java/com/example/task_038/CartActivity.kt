package com.example.task_038

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.system.exitProcess

class CartActivity : AppCompatActivity() {

    val products = ProductDataBase.products
    var cartProducts: MutableList<Product> = mutableListOf()
    var outputResult = ""

    private lateinit var toolBarCart: Toolbar
    private lateinit var recyclerCartViewRV: RecyclerView
    private lateinit var toFinalPageButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        init()

        val maskProducts = intent.getStringExtra("maskProducts")

        for (i in maskProducts!!.indices)
        {
            if (maskProducts.get(i) == '1')
            {
                cartProducts.add(products[i])
                outputResult = outputResult + products[i].name+" "+products[i].price.toString()+"\n"
            }
        }

        setSupportActionBar(toolBarCart)
        title = "Корзина продуктов."

        toFinalPageButton.setOnClickListener{
            toFinalPageButton.animate().apply{
                rotationBy(360f)
                duration = 1000
            }.start()

            val intent = Intent(this, FinishActivity::class.java)
            intent.putExtra("outputResult", outputResult)
            startActivity(intent)
        }

        recyclerCartViewRV.layoutManager = LinearLayoutManager(this)
        val adapter = CustomAdapter(cartProducts)
        recyclerCartViewRV.adapter = adapter
        recyclerCartViewRV.setHasFixedSize(true)
    }

    fun init() {
        toolBarCart = findViewById(R.id.toolBarCart)
        recyclerCartViewRV = findViewById(R.id.recyclerCartViewRV)
        toFinalPageButton = findViewById(R.id.toFinalPageButton)
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