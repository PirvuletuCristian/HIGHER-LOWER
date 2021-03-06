package com.example.higherlower;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private TextView tvQuestion, tvScore, tvRandomNumber, tvAnswerInfo;

    private Button btnLower, btnHigher, btnInainte;

    int totalQuestions;
    int qCounter = 0, number = 0;
    int correctAnswer, score = 0;

    private QuestionModel currentQuestion;

    private List<QuestionModel> questionList;

    Random random = new Random();



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionList = new ArrayList<>();
        tvQuestion = findViewById(R.id.textInfo);
        tvScore = findViewById(R.id.textScore);
        tvRandomNumber =findViewById(R.id.randomNumber);
        tvAnswerInfo = findViewById(R.id.answerInfo);


        btnLower = findViewById(R.id.btnLower);
        btnHigher = findViewById(R.id.btnHigher);
        btnInainte = findViewById(R.id.backToQuiz);

        addQuestions();
        totalQuestions = questionList.size();
        showNextQuestion();
        correctAnswer = currentQuestion.getCorrectAnswer();
        tvAnswerInfo.setText(currentQuestion.getInfo());
        tvScore.setText("Score: 0");
        btnInainte.setVisibility(View.INVISIBLE);
        tvAnswerInfo.setVisibility(View.INVISIBLE);
        number = RandomMicMare();


        btnLower.setOnClickListener(v -> {

            if (number > correctAnswer) {
                score++;
                tvScore.setText("Score: " + score);

            } else{
                finish();
            }
            btnLower.setVisibility(View.INVISIBLE);
            btnHigher.setVisibility(View.INVISIBLE);
            btnInainte.setVisibility(View.VISIBLE);
            tvScore.setVisibility(View.INVISIBLE);
            tvQuestion.setVisibility(View.INVISIBLE);
            tvRandomNumber.setVisibility(View.INVISIBLE);
            tvAnswerInfo.setVisibility(View.VISIBLE);
        });

        btnHigher.setOnClickListener(v -> {

            if (number < correctAnswer) {
                score++;
                tvScore.setText("Score: " + score);

            }else{
                finish();
                }
            btnLower.setVisibility(View.INVISIBLE);
            btnHigher.setVisibility(View.INVISIBLE);
            btnInainte.setVisibility(View.VISIBLE);
            tvScore.setVisibility(View.INVISIBLE);
            tvQuestion.setVisibility(View.INVISIBLE);
            tvRandomNumber.setVisibility(View.INVISIBLE);
            tvAnswerInfo.setVisibility(View.VISIBLE);
        });

        btnInainte.setOnClickListener(v -> {

            btnLower.setVisibility(View.VISIBLE);
            btnHigher.setVisibility(View.VISIBLE);
            btnInainte.setVisibility(View.INVISIBLE);
            tvScore.setVisibility(View.VISIBLE);
            tvQuestion.setVisibility(View.VISIBLE);
            tvRandomNumber.setVisibility(View.VISIBLE);
            tvAnswerInfo.setVisibility(View.INVISIBLE);

            showNextQuestion();
        });

    }

    @SuppressLint("SetTextI18n")
    private void showNextQuestion() {

        if(qCounter < totalQuestions){
            currentQuestion = questionList.get(NextRandom());
            tvQuestion.setText(currentQuestion.getQuestion());
            correctAnswer = currentQuestion.getCorrectAnswer();
            tvAnswerInfo.setText(currentQuestion.getInfo());


            if(qCounter <= 5){
                number = RandomMicMare();
            }
            else if(qCounter <= 10){
                number = RandomMicMare2();
            }
            else {
                number = RandomMicMare3();
            }
            tvRandomNumber.setText("" + number);
            qCounter++;

        }else{
            btnInainte.setText("Sfarsit");
            btnInainte.setOnClickListener(v -> finish());
        }
    }

    private void addQuestions() {
        questionList.add(new QuestionModel("ceva", 1, "ceva"));
        questionList.add(new QuestionModel("Cati ani a durat razboiul de 100 de ani?", 116, "R??zboiul de 100 de Ani a fost purtat ??ntre Anglia ??i Fran??a ??n intervalul 1337-1453. R??zboiul de 100 de Ani nu a fost un conflict continuu, ci o serie de ostilit????i ??ntrerupte de perioade lungi de pace ??ntre Casa de Plantagenet, conduc??tori ai Regatului Angliei ??i Casa de Valois, asupra dreptului de a conduce Regatul Fran??ei. Fiecare parte a atras mul??i alia??i ??n r??zboi. A fost unul dintre cele mai notabile conflicte din Evul Mediu, ??n care cinci genera??ii de regi din dou?? dinastii rivale au luptat pentru tronul celui mai mare regat din Europa de Vest."));
        questionList.add(new QuestionModel("In ce an a inceput cel de-al doilea Razboi Mondial?", 1939, "Al Doilea R??zboi Mondial a fost un r??zboi global care a durat din 1939 p??n?? ??n 1945, de??i unele conflicte asociate lui au ??nceput ??i mai devreme. El a implicat marea majoritate a ????rilor lumii.  A fost cel mai ??ntins r??zboi din istorie, ??i a implicat direct mai mult de 100 de milioane de oameni din peste 30 de ????ri"));
        questionList.add(new QuestionModel("In ce an a inceput primul razboi mondial?", 1914, "R??zboiul cel Mare, R??zboiul Na??iunilor, denumit, ??n timpul celui de Al Doilea R??zboi Mondial, Primul R??zboi Mondial, a fost un conflict militar de dimensiuni mondiale. A fost un r??zboi global declan??at ??n Europa, care a durat de la 28 iulie 1914 p??n?? pe 11 noiembrie 1918"));
        questionList.add(new QuestionModel("Cate state are SUA", 50, "Statele Unite ale Americii (sau abreviat S.U.A.), este numele unei republici constitu??ionale federale, const??nd din 50 de state ??i un district federal (Districtul federal Columbia sau D.C.)."));
        questionList.add(new QuestionModel("In ce an a intrat Romania in Uniunea Europeana?", 2007, "Aderarea Rom??niei la Uniunea European?? a avut loc la 1 ianuarie 2007. Aceast?? dat?? a fost propus?? la summitul de la Salonic din 2003 ??i confirmat?? la Bruxelles pe 18 iunie 2004. Raportul de ??ar?? privind progresele Rom??niei din octombrie 2004 a afirmat de asemenea data de 1 ianuarie 2007 ca dat?? de aderare pentru Rom??nia ??i Bulgaria. Cele dou?? ????ri au semnat Tratatul de aderare pe 25 aprilie 2005 la Aba??ia Neum??nster din Luxemburg."));
        questionList.add(new QuestionModel("Cate strofe are poezia 'Luceafarul' de Mihai Eminescu?", 98, "???Luceaf??rul??? este una dintre cele mai cunoscute poezii ale lui Mihai Eminescu, ??nceput?? ??nc?? din 1873, dar scris?? ??i finisat?? de-a lungul multor ani p??n?? la publicarea sa ??n aprilie 1883 ??n Almanahul societ????ii studen??e??ti Rom??nia Jun?? din Viena. Poemul este format din 98 de strofe."));
        questionList.add(new QuestionModel("In ce an s-a scufundat Titanicul?", 1912, "RMS Titanic a fost cel mai mare pachebot din lume c??nd a plecat ??n c??l??toria sa inaugural?? din Southampton, Anglia cu destina??ia New York, pe 10 aprilie 1912. La patru zile de la plecare, la ora 23:40 ??n data de 14 aprilie 1912, s-a ciocnit de un aisberg ??i s-a scufundat la ora 2:20 ??n diminea??a urm??toare. ??n urma naufragiului ??i-au pierdut via??a 1514 persoane din 2228[1] ??n unul din cele mai cumplite dezastre maritime pe timp de pace din istorie."));
        questionList.add(new QuestionModel("In ce an s-a dizolvat Uniunea Sovietica?", 1991, "Uniunea Republicilor Sovietice Socialiste, cunoscut?? ??i ca Uniunea Sovietic??), a fost un stat ??ntins pe o mare parte din Nordul Eurasiei, ??i care a existat din 1922 p??n?? ??n 1991."));
        questionList.add(new QuestionModel("In ce an a fost asasinat John F. Kennedy?", 1963, "John Fitzgerald Kennedy, cunoscut ??i ca John F. Kennedy, a fost cel de-al treizeci ??i cincilea pre??edinte al Statelor Unite ale Americii. A servit din 1961 p??n?? la asasinarea sa survenit?? ??n ziua de 22 noiembrie 1963, la Dallas, Texas. "));
        questionList.add(new QuestionModel("Cate litere are alfabetul limbii romane", 31, "Alfabetul limbii rom??ne este totalitatea literelor folosite pentru scrierea limbii rom??ne. ??n prezent con??ine 31 de litere ??i folose??te cele 26 de caractere ale alfabetului latin la care se adaug?? o serie de 5 caractere suplimentare formate prin aplicarea de semne diacritice."));
        questionList.add(new QuestionModel("Cati bytes are un Kilobyte?", 1024, "Kilobyte este folosit ??n sistemul binar pentru a exprima capacitatea de memorie. De asemenea, majoritatea aplica??iilor software (inclusiv sistemele de operare din familia Windows) folosesc aceast?? valoare pentru a indica dimensiunea unui fi??ier sau spa??iul disponibil pe hard disk. 1 kilobyte = 1 024 byte."));
        questionList.add(new QuestionModel("Cati m?? are un hectar?", 10000, "Hectarul (abreviat ha) este o unitate de m??sur?? a suprafe??ei. Un hectar este egal cu 10.000 m??."));
    }


    public int NextRandom()
    {
        int index = 0;
        Random rand = new Random();
        int previousIndex = index;
        index = rand.nextInt(totalQuestions);

        while (index == previousIndex)
        {
            index = rand.nextInt(totalQuestions);
        }
        return index;
    }
    public int RandomMicMare(){
         int nr = 0;
        int x = random.nextInt(2);
        int y = random.nextInt(5);
        if(x == 0){
            nr = (correctAnswer+1) + y;
        }
        if(x == 1){
            nr = (correctAnswer-1) - y;
        }
        return nr;
    }

    public int RandomMicMare2(){
        int nr = 0;
        int x = random.nextInt(2);
        int y = random.nextInt(3);
        if(x == 0){
            nr = (correctAnswer+1) + y;
        }
        if(x == 1){
            nr = (correctAnswer-1) - y;
        }
        return nr;
    }

    public int RandomMicMare3(){
        int nr = 0;
        int x = random.nextInt(2);
        int y = random.nextInt(2);
        if(x == 0){
            nr = (correctAnswer+1) + y;
        }
        if(x == 1){
            nr = (correctAnswer-1) - y;
        }
        return nr;
    }


}