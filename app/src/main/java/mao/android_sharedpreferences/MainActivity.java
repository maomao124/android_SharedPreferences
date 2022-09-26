package mao.android_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Class(类名): MainActivity
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/25
 * Time(创建时间)： 23:01
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class MainActivity extends AppCompatActivity
{

    /**
     * save按钮
     */
    private Button saveButton;
    /**
     * load按钮
     */
    private Button loadButton;

    /**
     * 学号编辑文本
     */
    private EditText idEditText;

    /**
     * 名称编辑文本
     */
    private EditText nameEditText;

    /**
     * 年龄编辑文本
     */
    private EditText ageEditText;

    /**
     * 体重编辑文本
     */
    private EditText weightEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = findViewById(R.id.Button_save);
        loadButton = findViewById(R.id.Button_load);

        nameEditText = findViewById(R.id.EditText_name);
        ageEditText = findViewById(R.id.EditText_age);
        weightEditText = findViewById(R.id.EditText_weight);

        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });

        loadButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                load();
            }
        });
    }


    /**
     * 保存
     */
    private void save()
    {
        try
        {

        }
        catch (Exception e)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("异常")
                    .setMessage("出现异常，请检查输入\n异常内容为：" + e.getMessage())
                    .setPositiveButton("确定", null)
                    .create()
                    .show();
        }


        SharedPreferences.Editor editor = getSharedPreferences("text", MODE_PRIVATE).edit();


        editor.commit();
        //异步
        //editor.apply();
    }

    /**
     * 加载
     */
    private void load()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("text", MODE_PRIVATE);
        long id = sharedPreferences.getLong("id", 0);
        String name = sharedPreferences.getString("name", "");
        int age = sharedPreferences.getInt("age", 0);
        float weight = sharedPreferences.getFloat("weight", 0.0f);

        idEditText.setText(String.valueOf(id));
        nameEditText.setText(name);
        ageEditText.setText(String.valueOf(age));
        weightEditText.setText(String.valueOf(weight));
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        save();
    }
}