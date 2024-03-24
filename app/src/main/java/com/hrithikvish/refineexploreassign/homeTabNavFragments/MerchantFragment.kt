package com.hrithikvish.refineexploreassign.homeTabNavFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrithikvish.refineexploreassign.R
import com.hrithikvish.refineexploreassign.adapters.HomePageMerchantTabRVAdapter
import com.hrithikvish.refineexploreassign.databinding.FragmentMerchantBinding
import com.hrithikvish.refineexploreassign.models.MerchantAccount

class MerchantFragment : Fragment() {

    lateinit var binding: FragmentMerchantBinding

    lateinit var merchantTabRVAdapter: HomePageMerchantTabRVAdapter
    lateinit var merchantList: ArrayList<MerchantAccount>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMerchantBinding.inflate(inflater, container, false)

        merchantTabRVAdapter = HomePageMerchantTabRVAdapter(requireContext())
        merchantList = ArrayList()
        populateMerchantAccountsList()
        merchantTabRVAdapter.setMerchantList(merchantList)
        merchantTabRVAdapter.notifyDataSetChanged()

        binding.merchantListRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.merchantListRv.adapter = merchantTabRVAdapter


        return binding.root
    }

    private fun populateMerchantAccountsList() {

        for (i in 0 until 10) {
            merchantList.add(
                MerchantAccount(
                    "Mc Donalds",
                    "Vasai-Virar, within 8.5 KM",
                    "Hi community! We have great deals for you. Check us out!!",
                    R.drawable.merchant_img
                )
            )
            merchantList.add(
                MerchantAccount(
                    "Hrithik Android and Web Solutions",
                    "Mumbai, within 17.0 KM",
                    "Hi community! I am available at your service!",
                    R.drawable.merchant_img2
                )
            )
        }

    }
}