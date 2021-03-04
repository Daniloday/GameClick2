package com.missclick.gameclick.ui.win

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.missclick.gameclick.R

class WinFragment : Fragment() {

    private lateinit var loseViewModel: LoseViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        loseViewModel =
                ViewModelProvider(this).get(LoseViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_win, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        loseViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loseViewModel.lost(10)
    }
}