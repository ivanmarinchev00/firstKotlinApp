package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.ActivityChooserView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rvTodos.adapter = todoAdapter
        rvTodos.layoutManager = LinearLayoutManager(this)
        btnAddTodo.setOnClickListener {
            val todoTile = etTodoTitle.text.toString()
            if(todoTile.isNotEmpty()){
                val todo = Todo(todoTile)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }
        btnDeleteTodo.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}