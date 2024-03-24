package com.hrithikvish.refineexploreassign.homeTabNavFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrithikvish.refineexploreassign.R
import com.hrithikvish.refineexploreassign.adapters.HomePagePersonalTabRVAdapter
import com.hrithikvish.refineexploreassign.databinding.FragmentPersonalBinding
import com.hrithikvish.refineexploreassign.models.PersonalAccount

class PersonalFragment : Fragment() {

    lateinit var binding: FragmentPersonalBinding

    lateinit var personalTabRVAdapter: HomePagePersonalTabRVAdapter
    lateinit var personalList: ArrayList<PersonalAccount>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonalBinding.inflate(inflater, container, false)

        personalTabRVAdapter = HomePagePersonalTabRVAdapter(requireContext())
        personalList = ArrayList()
        populatePersonalAccountsList()
        personalTabRVAdapter.setPersonalList(personalList)
        personalTabRVAdapter.notifyDataSetChanged()

        binding.personalListRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.personalListRv.adapter = personalTabRVAdapter

        //
        return binding.root

    }

    private fun populatePersonalAccountsList() {

        for (i in 0 until 10) {
            personalList.add(
                PersonalAccount(
                    "Hrithik Vishwakarma",
                    "Mumbai | Student",
                    "Within 100 m",
                    "Hi community! I am open to new connections 😊",
                    "Coffee | Business | Friendship",
                    null
                )
            )
            personalList.add(
                PersonalAccount(
                    "Rahul Vishwakarma",
                    "Mumbai | Student",
                    "Within 200-300 m",
                    "Hi community! I am open to new connections 😊",
                    "Coffee | Business | Friendship",
                    null
                )
            )
            personalList.add(
                PersonalAccount(
                    "Aditya Kumar Sharma",
                    "Vasai | Graduate",
                    "Within 600-700 m",
                    "Hi community! I am open to new connections 😊",
                    "Coffee | Business | Friendship",
                    R.drawable.personal_img
                )
            )
        }

    }
}