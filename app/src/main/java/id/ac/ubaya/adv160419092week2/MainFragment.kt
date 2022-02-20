package id.ac.ubaya.adv160419092week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnStart.setOnClickListener{
            val playerName = txtName.text.toString()

            if(playerName != ""){
                val action = MainFragmentDirections.actionGameFragment(playerName)
                Navigation.findNavController(it).navigate(action)
            }
            else{
                Toast.makeText(context,"Please, enter your name!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}