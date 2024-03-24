package com.hrithikvish.refineexploreassign.adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hrithikvish.refineexploreassign.databinding.HomepageBusinessRvItemBinding
import com.hrithikvish.refineexploreassign.models.BusinessAccount

class HomePageBusinessTabRVAdapter(val context: Context): RecyclerView.Adapter<HomePageBusinessTabRVAdapter.BusinessViewHolder>() {

    private lateinit var businessList: ArrayList<BusinessAccount>
    fun setBusinessList(businessList: ArrayList<BusinessAccount>) {
        this.businessList = businessList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BusinessViewHolder {
        val binding =  HomepageBusinessRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BusinessViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: BusinessViewHolder,
        position: Int
    ) {
        val business = businessList.get(position)

        holder.name.text = business.name
        holder.locationAndRange.text = business.locationAndRange
        holder.chips.text = business.chips
        holder.desc.text = business.desc
        if(business.img != null) {
            holder.avatar.visibility = View.INVISIBLE
            holder.img.visibility = View.VISIBLE
            holder.img.setImageBitmap(BitmapFactory.decodeResource(context.resources, business.img))
        } else {
            holder.avatar.visibility = View.VISIBLE
            holder.img.visibility = View.INVISIBLE
            holder.avatar.avatarInitials = getInitials(business.name)
        }

    }

    override fun getItemCount(): Int {
        return businessList.size
    }

    class BusinessViewHolder(binding: HomepageBusinessRvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.name
        val locationAndRange = binding.locationAndRange
        val chips = binding.chips
        val desc = binding.desc
        val avatar = binding.avatarView
        val img = binding.profileImage
    }

    fun getInitials(name: String): String {
        val words = name.split(" ")
        val initials = StringBuilder()

        initials.append(words[0][0].uppercase())

        if (words.size > 1) {
            initials.append(words.last()[0].uppercase())
        }
        return initials.toString()
    }
}
