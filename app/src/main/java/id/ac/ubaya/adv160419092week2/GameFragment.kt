package id.ac.ubaya.adv160419092week2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var score = 0
        var theAnswers = 0

        if(arguments != null){
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }
        theAnswers = playAgain()

        btnSubmitAnswer.setOnClickListener{
            val myAnswer = txtAnswer.text.toString().toInt()

            if(theAnswers.equals(myAnswer)){
                score += 1
                txtAnswer.text?.clear()
                Toast.makeText(context,"Correct!",Toast.LENGTH_SHORT).show()
                theAnswers = playAgain()

            }
            else{
                val action = GameFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }

    }

    fun playAgain():Int{
        val num1 = Random.nextInt(1, 100)
        txtAngka1.text = num1.toString()

        val num2 = Random.nextInt(1, 100)
        txtAngka2.text = num2.toString()

        val theAnswer = num1+num2
        return theAnswer
    }

}