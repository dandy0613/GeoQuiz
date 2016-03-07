package android.dandy.org.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.dandy.org.geoquiz.R;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageView mResultImage;
    private TextView mQuestionText;


    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_africa, false),
            new TrueFalse(R.string.question_americas, true),
            new TrueFalse(R.string.question_asia,true),
            new TrueFalse(R.string.question_mideast, false),
            new TrueFalse(R.string.question_oceans, true),
            new TrueFalse(R.string.question_turkey, true),
    };
    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mTrueButton = (Button)findViewById(R.id.true_button);
        mFalseButton = (Button)findViewById(R.id.false_button);
        mResultImage = (ImageView)findViewById(R.id.result_image);
        mQuestionText = (TextView)findViewById(R.id.quiz_text);
        updateQuestion();

        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
    }

    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionText.setText(question);
    }

    @Override
    public void onClick(View v) {
        boolean temp = false;
        switch (v.getId()){
            case R.id.true_button:
                temp = true;
                break;
            case R.id.false_button:
                temp = false;
                break;
        }
        if(temp == mQuestionBank[mCurrentIndex].isCorrect()){
            mResultImage.setImageResource(R.drawable.correct);
        }else{
            mResultImage.setImageResource(R.drawable.incorrect);
        }
        mCurrentIndex = (mCurrentIndex+1) % mQuestionBank.length;
        updateQuestion();
    }
}
