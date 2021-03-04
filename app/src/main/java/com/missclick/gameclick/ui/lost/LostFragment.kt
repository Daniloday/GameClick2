package com.missclick.gameclick.ui.lost

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.missclick.gameclick.R

class LostFragment : Fragment() {

    companion object {
        fun newInstance(score : Int):Bundle{
            return Bundle().apply {
                putInt("score",score)
            }
        }
    }

    private lateinit var viewModel: LostViewModel
    var score : Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        score =  arguments?.getInt("score")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lost_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LostViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnRestart = view.findViewById<Button>(R.id.button_restart)
        val textScore = view.findViewById<TextView>(R.id.text_score)
        textScore.text = score.toString()
        btnRestart.setOnClickListener {
            findNavController().navigate(R.id.nav_main)
        }
    }

}