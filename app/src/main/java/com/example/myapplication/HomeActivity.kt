package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.database.Item
import com.example.myapplication.database.ItemDao
import com.example.myapplication.database.ItemRoomDatabase
import com.example.myapplication.databinding.ActivityHomeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    private val TAG = HomeActivity::class.java.simpleName
    private lateinit var mySpinner: Spinner
    private lateinit var myListView: ListView
    private lateinit var binding: ActivityHomeBinding
    private lateinit var dao: ItemDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mySpinner = findViewById(R.id.spinner)
        myListView = findViewById(R.id.listView)
        myListView.isClickable = true

        val database = ItemRoomDatabase.getDatabase(this)
        dao = database.itemDao()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnDbInsert.setOnClickListener {
            insertDataDb()
        }

        mySpinner.onItemSelectedListener = this
        myListView.setOnItemClickListener(this)
    }

    override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item: String = adapter?.getItemAtPosition(position).toString()
        Log.i(TAG, item)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // Handle case where nothing is selected, if necessary
    }

    override fun onItemClick(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item: String = adapter?.getItemAtPosition(position).toString()
        Log.i(TAG, item)
    }

    private fun insertDataDb() {
        GlobalScope.launch {
            val item = Item(21, "fruits", 11.11, 11)
            dao.insert(item)
        }
    }
}
