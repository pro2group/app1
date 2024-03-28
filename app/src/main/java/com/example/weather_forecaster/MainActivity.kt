package com.example.weather_forecaster

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        var field:EditText=findViewById(R.id.city)
        var res:TextView=findViewById(R.id.weather)
        var button:Button=findViewById(R.id.button)

        button.setOnClickListener{
            var first=field.text.toString().trim()
            if (first.isEmpty())
                Toast.makeText(this, "Not valid city", Toast.LENGTH_LONG)
            else
            {
                val key="d1eb562b76c4497588322110242803"
                var url="https://api.weatherapi.com/v1/forecast.json?"+
                        "key=$key"+
                        "&q=$first"+
                        "&days=1&aqi=no&alerts=no"
                val req= Volley.newRequestQueue(baseContext)
                val request= StringRequest(
                    Request.Method.GET,
                    url,
                    {
                        result ->
                        Log.d("Log","result:$result")
                    },
                    {
                        error ->Log.d("Log","error:$error")
                    }
                )
                req.add(request)
            }
        }

        }
    }
}