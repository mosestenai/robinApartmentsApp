package com.example.robin;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

import android.content.res.Configuration
import android.view.*
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class mainactivityfragment : Fragment() {
    lateinit var proceed: Button

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        proceed = view.findViewById(R.id.proceed)
        val toolbar: Toolbar= view.findViewById(R.id.toolbar_main)
        if(activity is AppCompatActivity) {
            (activity as AppCompatActivity).setSupportActionBar(toolbar)
            (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false);
        }

        drawer= view.findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(activity, drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        if(activity is AppCompatActivity) {
            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
            (activity as AppCompatActivity).actionBar?.setHomeButtonEnabled(true)
        }

        val navigationView: NavigationView = view.findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_item_one -> {
                    val transaction = activity?.supportFragmentManager?.beginTransaction()
                    transaction?.replace(R.id.fragment_container,loginfragment())
                    transaction?.disallowAddToBackStack()
                    transaction?.commit()
                }
                R.id.nav_item_two ->{
                    val transaction = activity?.supportFragmentManager?.beginTransaction()
                    transaction?.replace(R.id.fragment_container,signupfragment())
                    transaction?.disallowAddToBackStack()
                    transaction?.commit()
                }
                R.id.nav_item_six -> {
                    //starting an activity from  fragment
                   val intent = Intent(activity, addhostelActivity::class.java)
                    startActivity(intent)
                }
            }
            drawer.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true

        }


        //go to hostel search  page if proceed button is clicked
            proceed.setOnClickListener{

               val intent = Intent(activity, SearchActivity::class.java)
                startActivity(intent)
            }
            //go to register page if register button is clicked
           /* register.setOnClickListener {
                val transaction = activity?.supportFragmentManager?.beginTransaction()
                transaction?.replace(R.id.fragment_container,signupfragment())
                transaction?.disallowAddToBackStack()
                transaction?.commit()
            }*/
            //go to login page if login button is clicked

return
    }
    /*
    override fun onPostwCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        toggle.syncState()
    }*/


    override fun setInitialSavedState(state: SavedState?) {
        super.setInitialSavedState(state)
        toggle.syncState()

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onDestroyOptionsMenu() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else{
            super.onDestroyOptionsMenu()
        }
    }

/*
    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else {
            super.onBackPressed()
        }
    }*/


}