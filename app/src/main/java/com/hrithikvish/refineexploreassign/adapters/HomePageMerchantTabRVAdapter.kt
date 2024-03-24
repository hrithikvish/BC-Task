package com.hrithikvish.refineexploreassign.adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hrithikvish.refineexploreassign.databinding.HomepageMerchantRvItemBinding
import com.hrithikvish.refineexploreassign.models.MerchantAccount

class HomePageMerchantTabRVAdapter(val context: Context): RecyclerView.Adapter<HomePageMerchantTabRVAdapter.MerchantViewHolder>() {

    private lateinit var merchantList: ArrayList<MerchantAccount>
    fun setMerchantList(merchantList: ArrayList<MerchantAccount>) {
        this.merchantList = merchantList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MerchantViewHolder {
        val binding =  HomepageMerchantRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MerchantViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MerchantViewHolder,
        position: Int
    ) {
        val merchant = merchantList.get(position)

        holder.name.text = merchant.name
        holder.locationAndRange.text = merchant.locationAndRange
        holder.desc.text = merchant.desc
        holder.img.visibility = View.VISIBLE
        holder.img.setImageBitmap(BitmapFactory.decodeResource(context.resources, merchant.img))

    }

    override fun getItemCount(): Int {
        return merchantList.size
    }

    class MerchantViewHolder(binding: HomepageMerchantRvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.name
        val locationAndRange = binding.locationAndRange
        val desc = binding.desc
        val img = binding.profileImage
    }
}
