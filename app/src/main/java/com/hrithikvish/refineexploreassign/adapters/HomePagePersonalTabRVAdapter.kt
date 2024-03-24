package com.hrithikvish.refineexploreassign.adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hrithikvish.refineexploreassign.databinding.HomepagePersonalRvItemBinding
import com.hrithikvish.refineexploreassign.models.PersonalAccount


class HomePagePersonalTabRVAdapter(val context: Context): RecyclerView.Adapter<HomePagePersonalTabRVAdapter.PersonalViewHolder>() {

    private lateinit var personList: ArrayList<PersonalAccount>
    fun setPersonalList(personList: ArrayList<PersonalAccount>) {
        this.personList = personList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonalViewHolder {
        val binding =  HomepagePersonalRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonalViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PersonalViewHolder,
        position: Int
    ) {
        val person = personList.get(position)

        holder.name.text = person.name
        holder.location.text = person.location
        holder.range.text = person.range
        holder.chips.text = person.chips
        holder.desc.text = person.desc
        if(person.img != null) {
            holder.avatar.visibility = View.INVISIBLE
            holder.img.visibility = View.VISIBLE
            holder.img.setImageBitmap(BitmapFactory.decodeResource(context.resources, person.img))
        } else {
            holder.avatar.visibility = View.VISIBLE
            holder.img.visibility = View.INVISIBLE
            holder.avatar.avatarInitials = getInitials(person.name)
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    class PersonalViewHolder(binding: HomepagePersonalRvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.name
        val location = binding.location
        val range = binding.range
        val chips = binding.chips
        val desc = binding.desc
        val img = binding.profileImage
        val avatar = binding.avatarView
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
