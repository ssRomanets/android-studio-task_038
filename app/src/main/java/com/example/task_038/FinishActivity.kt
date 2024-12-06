package com.example.task_038

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlin.system.exitProcess

class FinishActivity : AppCompatActivity() {

    private lateinit var toolBarOrder: Toolbar
    private lateinit var textOrderTV: TextView
    private lateinit var textResultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        init()

        setSupportActionBar(toolBarOrder)
        title = "Чек продуктов."

        val outputResult = intent.getStringExtra("outputResult")
        textOrderTV.text = "Купленные продукты."
        textResultTV.text = outputResult
    }

    fun init() {
        toolBarOrder = findViewById(R.id.toolBarOrder)
        textOrderTV = findViewById(R.id.textOrderTV)
        textResultTV = findViewById(R.id.textResultTV)
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