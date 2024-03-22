package com.example.myfirstapp_opsc7411

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfirstapp_opsc7411.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var order = Order()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView7.setOnClickListener(this)
        binding.imageView6.setOnClickListener(this)
        binding.imageView5.setOnClickListener(this)
        binding.imageView4.setOnClickListener(this)
        binding.imageView3.setOnClickListener(this)
        binding.imageView2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.imageView2 -> order.productName = "Soy Latte"
            R.id.imageView3 -> order.productName = "Chocco Frapp"
            R.id.imageView4 -> order.productName = "Bottled Americano"
            R.id.imageView5 -> order.productName = "Rainbow Frapp"
            R.id.imageView6 -> order.productName = "Caramel Frapp"
            R.id.imageView7 -> order.productName = "Black Forest Frapp"
        }

        Toast.makeText(this@MainActivity, "MMM " + order.productName, Toast.LENGTH_SHORT).show()

        openIntent(this, order.productName, OrderDetailsActivity::class.java)
    }


}