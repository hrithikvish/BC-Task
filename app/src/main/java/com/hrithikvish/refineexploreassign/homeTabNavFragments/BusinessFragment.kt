package com.hrithikvish.refineexploreassign.homeTabNavFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrithikvish.refineexploreassign.R
import com.hrithikvish.refineexploreassign.adapters.HomePageBusinessTabRVAdapter
import com.hrithikvish.refineexploreassign.databinding.FragmentBusinessBinding
import com.hrithikvish.refineexploreassign.models.BusinessAccount

class BusinessFragment : Fragment() {

    lateinit var binding: FragmentBusinessBinding

    lateinit var businessTabRVAdapter: HomePageBusinessTabRVAdapter
    lateinit var businessList: ArrayList<BusinessAccount>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBusinessBinding.inflate(inflater, container, false)

        businessTabRVAdapter = HomePageBusinessTabRVAdapter(requireActivity())
        businessList = ArrayList()
        populateBusinessAccountsList()
        businessTabRVAdapter.setBusinessList(businessList)
        businessTabRVAdapter.notifyDataSetChanged()

        binding.businessListRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.businessListRv.adapter = businessTabRVAdapter


        return binding.root
    }

    private fun populateBusinessAccountsList() {

        for (i in 0 until 10) {
            businessList.add(
                BusinessAccount(
                    "Hrithik Vishwakarma",
                    "Mumbai, within 4.8 KM",
                    "Hi community! I am available at your service!",
                    "Student | 1 years of experience",
                    null
                )
            )
            businessList.add(
                BusinessAccount(
                    "Aditya Kumar Sharma",
                    "Bangalore, within 21.2 KM",
                    "Hi community! I am available at your service!",
                    "QA Engineer | 3 years of experience",
                    R.drawable.business_img
                )
            )
        }

    }
}