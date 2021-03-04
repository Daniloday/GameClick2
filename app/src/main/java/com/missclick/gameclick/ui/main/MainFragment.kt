package com.missclick.gameclick.ui.main

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.missclick.gameclick.R
import com.missclick.gameclick.ui.lost.LostFragment
import java.util.*

class MainFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mainViewModel =
                ViewModelProvider(this).get(MainViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        mainViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttons = mutableListOf<ImageView>()
        val btn0 : ImageView = view.findViewById(R.id.im_btn1)
        buttons.add(btn0)
        val btn1 : ImageView = view.findViewById(R.id.im_btn2)
        buttons.add(btn1)
        val btn2 : ImageView = view.findViewById(R.id.im_btn3)
        buttons.add(btn2)
        val btn3 : ImageView = view.findViewById(R.id.im_btn4)
        buttons.add(btn3)
        val btn4 : ImageView = view.findViewById(R.id.im_btn5)
        buttons.add(btn4)
        val btn5 : ImageView = view.findViewById(R.id.im_btn6)
        buttons.add(btn5)
        val btn6 : ImageView = view.findViewById(R.id.im_btn7)
        buttons.add(btn6)
        val btn7 : ImageView = view.findViewById(R.id.im_btn8)
        buttons.add(btn7)
        val btn8 : ImageView = view.findViewById(R.id.im_btn9)
        buttons.add(btn8)
        val pole = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)


        var visibleTime = 3.0
        var delTime = 1.0
        var score = 0
        val rightNow = Calendar.getInstance()
        val offset = (rightNow[Calendar.ZONE_OFFSET] +
                rightNow[Calendar.DST_OFFSET]).toLong()
        val sinceMidnight = (rightNow.timeInMillis + offset) %
                (24 * 60 * 60 * 1000)

        var time = System.currentTimeMillis()

        fun visible(i: Int){
            var image = (0..8).random()
            if (image == i){
                image = (image+1)/9
            }
            buttons[image].visibility = View.VISIBLE
        }
        fun next(i: Int){
            Handler().postDelayed({ visible(i) }, (delTime * 1000).toLong())
        }
        if (visibleTime > 100)
            mainViewModel.report(visibleTime.toInt())
        visible(10)
        for (i in 0..8) {
            buttons[i].setOnClickListener {
                buttons[i].visibility = View.INVISIBLE
                val offset1 = (rightNow[Calendar.ZONE_OFFSET] +
                        rightNow[Calendar.DST_OFFSET]).toLong()
                val sinceMidnight1 = (rightNow.timeInMillis + offset1) %
                        (24 * 60 * 60 * 1000)
                Log.e("time1",time.toString())
                Log.e("time2",System.currentTimeMillis().toString())
                Log.e("time2",(System.currentTimeMillis() - time).toString())
                if ((System.currentTimeMillis() - time + delTime) > visibleTime*1000){
                    findNavController().navigate(R.id.nav_lost,LostFragment.newInstance(score))
                }
                else time = System.currentTimeMillis()
                score += 1
                if (visibleTime > 0.6)
                    visibleTime -= 0.1
                delTime -= 0.05
                next(i)
            }
        }
    }
}