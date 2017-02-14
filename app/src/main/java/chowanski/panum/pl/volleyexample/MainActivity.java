package chowanski.panum.pl.volleyexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSimpleRequestBtn();
    }

    private void initSimpleRequestBtn() {
        Button simpleRequestBtn = ((Button) findViewById(R.id.btnSimpleRequest));
        simpleRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleRequest();
            }
        });
    }

    private void simpleRequest() {
        // 1. Uzyskanie referencji do kolejki
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.github.com/users/kchowanski";

        // 2. Utworzenie żądania
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        VolleyLog.d(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e(error.getMessage());
            }
        });

        // 3. Dodanie żądania na kolejkę.
        queue.add(stringRequest);
    }
}
