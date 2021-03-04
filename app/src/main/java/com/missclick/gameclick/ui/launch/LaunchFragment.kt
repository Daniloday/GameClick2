package com.missclick.gameclick.ui.launch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.missclick.gameclick.R

class LaunchFragment : Fragment() {

    private lateinit var launchViewModel: LaunchViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        launchViewModel =
                ViewModelProvider(this).get(LaunchViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_launch, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        launchViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnPlay = view.findViewById<Button>(R.id.button_play)
        btnPlay.setOnClickListener {
            findNavController().navigate(R.id.nav_main)
        }
        val btnQuit = view.findViewById<Button>(R.id.button_quit)
        btnQuit.setOnClickListener {
            activity?.moveTaskToBack(true)
        }
    }


}