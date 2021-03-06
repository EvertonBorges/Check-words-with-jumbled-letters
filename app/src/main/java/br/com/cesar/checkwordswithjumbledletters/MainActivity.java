package br.com.cesar.checkwordswithjumbledletters;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextFirstWord = findViewById(R.id.edit_text_first_word);
        final EditText editTextSecondWord = findViewById(R.id.edit_text_second_word);
        final Button buttonCheckWords = findViewById(R.id.button_check_words);
        final TextView textViewResult = findViewById(R.id.text_view_result);

        editTextFirstWord.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    editTextFirstWord.setText("");
                    editTextSecondWord.setText("");
                    textViewResult.setText("");
                }
            }
        });

        buttonCheckWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstWord = editTextFirstWord.getText().toString();
                String secondWord = editTextSecondWord.getText().toString();

                final boolean checkPartialPermutation = Utils.checkPartialPermutation(firstWord, secondWord);

                String textResult = getString(checkPartialPermutation ? R.string.result_true : R.string.result_false);
                textViewResult.setText(textResult);
            }
        });
    }

}