package com.example.YUmarket.screen.chat

import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import com.example.YUmarket.R
import com.example.YUmarket.databinding.FragmentLastesmessageBinding
import com.example.YUmarket.screen.base.BaseFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.auth.User
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder

class LastestMessagesFragment : BaseFragment<FragmentLastesmessageBinding>() {


    override fun getViewBinding(): FragmentLastesmessageBinding =
        FragmentLastesmessageBinding.inflate(layoutInflater)

    override fun observeData() {}


    override fun initViews() {
        super.initViews()


        val adapter = GroupAdapter<ViewHolder>()
        adapter.add(UserItem())

        binding.chatRecy.adapter = adapter

    }

    private fun fetchUsers() {
        val ref = FirebaseDatabase.getInstance().getReference("/user")
        ref.addListenerForSingleValueEvent(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
               snapshot.children.forEach{
                   Log.d("NewMessage",it.toString())
                   val user = it.getValue(User::class.java)
               }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }


}
//groupie
class UserItem: Item<ViewHolder>(){
    override fun bind(viewHolder: ViewHolder, p1: Int) {
        // will be called in our list for each user
    }

    override fun getLayout(): Int {
        return R.layout.user_item
    }

}