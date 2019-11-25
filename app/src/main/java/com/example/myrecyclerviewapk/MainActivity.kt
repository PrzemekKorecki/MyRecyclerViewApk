package com.example.myrecyclerviewapk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.mycardview.*

class MainActivity : AppCompatActivity() {

    var personsList = ArrayList<PersonData>()

    lateinit var adapterRecView:RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapterRecView = RecyclerAdapter(personsList){person:PersonData, position:Int->
            lblName.text = person.name
            lblPhoneNumber.text = person.phoneNumber
        }

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.adapter = adapterRecView

        btnAdd.setOnClickListener(){
            var person = PersonData()
            person.name = txtName.text.toString()
            person.phoneNumber = txtPhoneNumber.text.toString()
            personsList.add(person)
            adapterRecView.notifyDataSetChanged()

            //Toast.makeText(this, personsList.size.toString(), Toast.LENGTH_LONG).show()

            //SUGAR ORM********************
        }

    }
}
