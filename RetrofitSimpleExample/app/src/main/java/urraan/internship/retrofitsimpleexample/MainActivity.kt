package urraan.internship.retrofitsimpleexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import urraan.internship.retrofitsimpleexample.adapter.UserDataAdapter
import urraan.internship.retrofitsimpleexample.databinding.ActivityMainBinding
import urraan.internship.retrofitsimpleexample.repository.Repo

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var repository: Repo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        repository = Repo()
        //var userDataAdapter: UserDataAdapter? = null

        binding.btnLoadUser.setOnClickListener {
            lifecycleScope.launchWhenCreated {
                val response = repository.getUserData()
                if (response.isSuccessful && response.body() != null) {
                    binding.recyclerViewUserDataItem.apply {
                        val adapter = UserDataAdapter(response.body()!!)
                        this.adapter = adapter
                        layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            }
        }
    }
}