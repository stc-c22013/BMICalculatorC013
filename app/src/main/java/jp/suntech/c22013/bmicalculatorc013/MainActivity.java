package jp.suntech.c22013.bmicalculatorc013;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.text.Format;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //リスナオブジェクトの用意
        HelloListener listener = new HelloListener();

        //クリアボタンであるButtonオブジェクトの取得
        Button btClear = findViewById(R.id.btClear);
        Button btCount = findViewById(R.id.btCount);

        //クリアボタンにリスナを設定
        btClear.setOnClickListener(listener);
        btCount.setOnClickListener(listener);

    }

    private class HelloListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //入力欄であるEdittextオブジェクトを取得
            EditText input = findViewById(R.id.etAge);
            EditText input2 = findViewById(R.id.etHeight);
            EditText input3 = findViewById(R.id.etWeight);



            //メッセージを表示するTextViewオブジェクトを取得
            TextView output = findViewById(R.id.tvOutput1);
            TextView output2 = findViewById(R.id.tvOutput2);
            TextView output3 = findViewById(R.id.tvOutput3);
            TextView output4 = findViewById(R.id.tvOutput4);
            TextView output5 = findViewById(R.id.weight);


            int id = view.getId();
            String inputStr = input.getText().toString();
            String inputStr2 = input2.getText().toString();
            String inputStr3 = input3.getText().toString();


            if(id == R.id.btClear) {
                input.setText("");
                input2.setText("");
                input3.setText("");
                output.setText("");
                output2.setText("");
                output3.setText("");
                output4.setText("");
                output5.setText("");
            }

            else if(id == R.id.btCount){
                String Height = input2.getText().toString();
                double HeightNum = Double.parseDouble(Height);
                String Weight = input3.getText().toString();
                double WeightNum = Double.parseDouble(Weight);
                String AgeStr = input.getText().toString();
                double AgeNum = Double.parseDouble(AgeStr);

                double BMI = WeightNum / (HeightNum * 0.01 * HeightNum * 0.01);
                double BestWeight = 22 * (HeightNum * 0.01 * HeightNum * 0.01);

                String input4;

                float fWeight = (float)BestWeight;

                String textWeight = String.format("%.1f" ,fWeight);

                if(BMI >= 40){
                    input4 = "肥満(4度)";
                }
                else if(BMI >= 35){
                    input4 = "肥満(3度)";
                }
                else if(BMI >= 30){
                    input4 = "肥満(2度)";
                }
                else if(BMI >=25){
                    input4 = "肥満(1度)";
                }
                else if(BMI >= 18.5){
                    input4 = "普通体重";
                }
                else{
                    input4 = "低体重";
                }

                output.setText("あなたの肥満度は");
                output2.setText(input4);
                output3.setText("あなたの適正体重は");
                output4.setText(textWeight);
                output5.setText("kg");

                if(AgeNum<16) {
                    Dialog dialogFragment = new Dialog();
                    dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
                }


            }
        }
    }
}