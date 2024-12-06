package com.example.task_038

class ProductDataBase {
    companion object {
        val products = mutableListOf(
            Product(R.drawable.oil, "масло", 300),
            Product(R.drawable.milk, "молоко", 115),
            Product(R.drawable.meat, "мясо", 600),
            Product(R.drawable.bread, "хлеб", 70),
            Product(R.drawable.cheese, "сыр", 1000),
            Product(R.drawable.pasta, "макароны", 150),
            Product(R.drawable.kefir, "кефир", 100),
            Product(R.drawable.chicken, "курица", 1500),
            Product(R.drawable.eggs, "яйца", 120),
            Product(R.drawable.salt, "соль", 30)
        )
    }
}