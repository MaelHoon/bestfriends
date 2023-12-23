package mael.hoon1222.bestfriends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import mael.hoon1222.bestfriends.chat.ChatListFragment
import mael.hoon1222.bestfriends.databinding.ActivityMainBinding
import mael.hoon1222.bestfriends.home.HomeFragment
import mael.hoon1222.bestfriends.profile.ProfileFragment
import mael.hoon1222.bestfriends.recommand.RecommandFragment
import mael.hoon1222.bestfriends.setting.SettingFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        val homeFragment = HomeFragment()
        val chatListFragment = ChatListFragment()
        val profileFragment = ProfileFragment()
        val recommandFragment = RecommandFragment()
        val settingFragment = SettingFragment()

        val bottomNavigationView = binding.bottomnavigation

        replaceFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.menu_home -> replaceFragment(homeFragment)
                R.id.menu_chat -> replaceFragment(chatListFragment)
                R.id.menu_profile -> replaceFragment(profileFragment)
                R.id.menu_recommand -> replaceFragment(recommandFragment)
                R.id.menu_setting -> replaceFragment(settingFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.fragmentContainer, fragment)
                commit()
            }
    }
}