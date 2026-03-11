package com.o7solutions.kmv_college_practise.BottomNavigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.o7solutions.kmv_college_practise.R
import com.o7solutions.kmv_college_practise.databinding.FragmentHomeBinding
import com.o7solutions.kmv_college_practise.realtime_database.Users

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentHomeBinding

//    created realtime database object
    var db = FirebaseDatabase.getInstance().getReference("users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        view.findViewById<Button>(R.id.chatScreen).setOnClickListener {



            db.child("normalUser").addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    val valueOfUser = snapshot.getValue(Users::class.java)
                    Toast.makeText(requireContext(), valueOfUser?.name, Toast.LENGTH_SHORT).show()
                }

                override fun onCancelled(error: DatabaseError) {
                }

            })
//
//            var bundle = Bundle().apply {
//
//                putString("email","jatin@gmail.com")
//                putInt("number",5)
//            }
//            findNavController().navigate(R.id.chatFragment,bundle)
        }

        binding.addUser.setOnClickListener {

            Toast.makeText(requireContext(), "button Clicked", Toast.LENGTH_SHORT).show()

            var user = Users(
                userId = System.currentTimeMillis().toString(), // auth.currentUser.uid
                name = "Jatin Mehmi",
                email = "jatinmehmi790@gmail.com" , // auth.currentUser.email
                timeStamp = System.currentTimeMillis().toString(),
                phnNum = "1234567890"
            )

            db.child("normalUser").setValue(user)
                .addOnSuccessListener {
                    Toast.makeText(requireContext(), "User Added!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e->
                    Toast.makeText(requireContext(), e.localizedMessage, Toast.LENGTH_SHORT).show()
                    Log.e("Data Exception",e.toString())

                }


        }


    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}