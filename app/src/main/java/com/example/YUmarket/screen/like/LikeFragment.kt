package com.example.YUmarket.screen.like

import com.example.YUmarket.databinding.FragmentLikeBinding
import com.example.YUmarket.model.like.LikeCategory
import com.example.YUmarket.screen.base.BaseFragment
import com.example.YUmarket.widget.adapter.ListFragmentPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class LikeFragment
    : BaseFragment<FragmentLikeBinding>() {

    private lateinit var viewPagerAdapter: ListFragmentPagerAdapter

    override fun getViewBinding(): FragmentLikeBinding =
        FragmentLikeBinding.inflate(layoutInflater)

    override fun initViews() {
        super.initViews()
        if (!::viewPagerAdapter.isInitialized) initViewPager()
    }

    private fun initViewPager() = with(binding) {
        val likeCategories = LikeCategory.values()

        val likeListFragments = likeCategories.map {
            LikeListFragment.newInstance(it)
        }

        viewPagerAdapter = ListFragmentPagerAdapter(
            this@LikeFragment,
            fragmentList = likeListFragments
        )

        likeFragmentViewPager.adapter = viewPagerAdapter
        likeFragmentViewPager.offscreenPageLimit = likeCategories.size

        TabLayoutMediator(likeFragmentTabLayout, likeFragmentViewPager) { tab, position ->
            tab.setText(likeCategories[position].likeCategoryId)
        }.attach()
    }
}