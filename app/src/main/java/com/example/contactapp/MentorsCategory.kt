package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.contactapp.Adapters.FriendsCategoryAdapter
import com.example.contactapp.databinding.ActivityFriendsCategoryBinding
import com.example.contactapp.databinding.ActivityMentorsCategoryBinding

class MentorsCategory : AppCompatActivity() {

    private lateinit var binding : ActivityMentorsCategoryBinding
    private val adapter = FriendsCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMentorsCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpData(binding)
    }

    private fun setUpData(binding: ActivityMentorsCategoryBinding){
        binding.contactRV.adapter = adapter
        binding.contactRV.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.add_contact_dialogue, null)
        builder.setView(view)

        val nameEditText = view.findViewById<EditText>(R.id.nameEt)
        val numberEditTExt = view.findViewById<EditText>(R.id.numberEt)
        val saveBtn = view.findViewById<Button>(R.id.save_btn)
        numberEditTExt.addTextChangedListener(object: TextWatcher {

            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                saveBtn.isEnabled = s?.length == 11
            }

        })

        val alertDialog = builder.create()
        saveBtn.setOnClickListener {
            val contact = Contact(nameEditText.text.toString(), numberEditTExt.text.toString())
            //val contacts = mutableListOf(contact)
            adapter.addContactToList(contact)
            alertDialog.dismiss()
        }

        binding.fab.setOnClickListener{
            alertDialog.show()
        }

    }
}