package com.hrithikvish.refineexploreassign.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.hrithikvish.refineexploreassign.homeTabNavFragments.BusinessFragment
import com.hrithikvish.refineexploreassign.homeTabNavFragments.MerchantFragment
import com.hrithikvish.refineexploreassign.homeTabNavFragments.PersonalFragment

class HomeTabNavViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if(position == 0) {
            return "Personal"
        } else if (position == 1) {
            return "Business"
        } else {
            return "Merchant"
        }
    }

    override fun getItem(position: Int): Fragment {
        if(position == 0) {
            return PersonalFragment()
        } else if (position == 1) {
            return BusinessFragment()
        } else {
            return MerchantFragment()
        }
    }
}