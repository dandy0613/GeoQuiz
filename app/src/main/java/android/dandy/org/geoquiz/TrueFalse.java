package android.dandy.org.geoquiz;

/**
 * Created by Dandy on 2016/3/7.
 */
public class TrueFalse {
    private int mQuestion;
    private boolean mCorrect;

    public TrueFalse(int question, boolean correct){
        this.mQuestion = question;
        this.mCorrect = correct;
    }

    public boolean isCorrect() {
        return mCorrect;
    }

    public void setCorrect(boolean correct) {
        this.mCorrect = correct;
    }


    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        this.mQuestion = question;
    }
}
