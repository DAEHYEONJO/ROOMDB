package com.jodaehyeon.mmmmmm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.jodaehyeon.mmmmmm.databinding.ActivityMain3Binding
import com.jodaehyeon.mmmmmm.recyclerview.WordItemTouchHelperCallback
import com.jodaehyeon.mmmmmm.viewmodel.WordViewModel

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding : ActivityMain3Binding
    private val wordViewModel : WordViewModel by viewModels()
    private lateinit var itemTouchHelper: ItemTouchHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMain3Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initLayout()
        setObserver()
    }

    private fun initLayout(){
        binding.run {
            itemTouchHelper = ItemTouchHelper(WordItemTouchHelperCallback(wordViewModel))
            recyclerView.run {
                layoutManager = LinearLayoutManager(this@MainActivity3, LinearLayoutManager.VERTICAL, false)
                adapter = wordViewModel.wordAdapter
            }
            itemTouchHelper.attachToRecyclerView(binding.recyclerView)
        }
    }

    private fun setObserver(){
        wordViewModel.wordListLiveData.observe(this@MainActivity3){
            wordViewModel.wordAdapter.notifyDataSetChanged()
        }
    }
}