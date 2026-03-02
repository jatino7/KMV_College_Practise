package com.o7solutions.kmv_college_practise.BottomNavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.o7solutions.kmv_college_practise.R
import com.o7solutions.kmv_college_practise.RecyclerView.ChatAdapter
import com.o7solutions.kmv_college_practise.RecyclerView.Person

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChatFragment : Fragment(), ChatAdapter.OnItemClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private lateinit var chatAdapter: ChatAdapter
    var email = ""
    var num = 0

    var personsList = arrayListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            email = it.getString("email","")
            num = it.getInt("number")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chatAdapter = ChatAdapter(personsList,this)

//        yahan prr main recycler view ki linking krr raha hu adapter ke saath
        val recyclerView = view.findViewById<RecyclerView>(R.id.chat_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)

        recyclerView.adapter = chatAdapter

        Toast.makeText(requireContext(), email, Toast.LENGTH_SHORT).show()

        addData()
    }



    fun addData() {

//        Jahan prr main data add krr raha hu
        personsList.add(Person(
            "1","Ram","Hello","11:00 pm"
        ))
        personsList.add(Person(
            "1","Ram","Hello","11:00 pm"
        ))
        personsList.add(Person(
            "2","Rahul","Hello","11:00 pm"
        ))
        personsList.add(Person(
            "3","Ramandeep","Hello","11:00 pm"
        ))
        personsList.add(Person(
            "4","Ram Sharma","Hello","11:00 pm"
        ))
        personsList.add(Person(
            "5","Ram Kapoor","Hello","11:00 pm"
        ))
        personsList.add(Person(
            "6","Raman","Hello","11:00 pm"
        ))
        personsList.add(Person(
            "7","Dharam","Hello","11:00 pm"
        ))
        personsList.add(Person(
            "8","Raj","Hello","11:00 pm"
        ))

//        main jahan prr adapter ko bta raha hu ki list ke ander data add ho chuk hai
        chatAdapter.notifyDataSetChanged()
    }

    override fun onClick(position: Int) {

        Toast.makeText(requireContext(), personsList[position].id, Toast.LENGTH_SHORT).show()

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChatFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChatFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}