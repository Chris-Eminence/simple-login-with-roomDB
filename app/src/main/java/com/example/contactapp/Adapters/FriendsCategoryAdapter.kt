package com.example.contactapp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.Contact
import com.example.contactapp.databinding.ContactItemsBinding

class FriendsCategoryAdapter : RecyclerView.Adapter<FriendsCategoryAdapter.ContactViewHolder>() {

    private val contacts = mutableListOf<Contact>()

    fun addContactToList(contact: Contact){
        contacts.add(contact)
        notifyDataSetChanged()
    }

    fun setUpContacts(contact: List<Contact>){
        this.contacts.addAll(contacts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(ContactItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bindItem(contact)
    }

    inner class ContactViewHolder(private val binding: ContactItemsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindItem(contact: Contact){
            binding.contactName.text = contact.name
            binding.contactNumber.text = contact.number
        }
    }
}