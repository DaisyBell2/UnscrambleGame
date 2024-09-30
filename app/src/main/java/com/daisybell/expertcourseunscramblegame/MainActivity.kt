package com.daisybell.expertcourseunscramblegame

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.daisybell.expertcourseunscramblegame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var uiState: GameUiState
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: GameViewModel

    val update: () -> Unit = {
        uiState.update(
            shuffleWordTextView = binding.shuffleWordTextView,
            textInputLayout = binding.inputLayout,
            textInputEditText = binding.inputEditText,
            skipVisibleEnabledButton = binding.skipButton,
            checkVisibleEnabledButton = binding.checkButton,
            nextVisibleEnabledButton = binding.nextButton,
        )
    }

    private var textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

        override fun afterTextChanged(s: Editable?) {
            uiState = viewModel.handleUserInput(text = s.toString())
            update.invoke()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.rootLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel = (application as UnscrambleApp).viewModel

        binding.skipButton.setOnClickListener {
            uiState = viewModel.skip()
            update.invoke()
        }
        binding.checkButton.setOnClickListener {
            uiState = viewModel.check(text = binding.inputEditText.text.toString())
            update.invoke()
        }
        binding.nextButton.setOnClickListener {
            uiState = viewModel.next()
            update.invoke()
        }

        uiState = viewModel.init(savedInstanceState == null)
        update.invoke()
    }

    override fun onResume() {
        super.onResume()
        binding.inputEditText.addTextChangedListener(textWatcher)
    }

    override fun onPause() {
        super.onPause()
        binding.inputEditText.removeTextChangedListener(textWatcher)
    }
}