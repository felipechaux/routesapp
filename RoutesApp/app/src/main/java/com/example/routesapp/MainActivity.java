package com.example.routesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MainActivity extends AppCompatActivity   {


     EditText et1, et2;
     Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.txt_usuario);
        et2 = (EditText) findViewById(R.id.txt_contrasena);
        btn_login = (Button) findViewById(R.id.button_login);


    }


    public String enviarDatosGET(String usu, String pas){
        URL url = null;
        String linea = "";
        int respuesta = 0;
        StringBuilder  result = null;

        try {

            url = new URL("https://dev.itesting.co/Account/ValidaUsuario?UserName="+usu+"&Password="+pas);

            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
            respuesta = connection.getResponseCode();

            result= new StringBuilder();
            if (respuesta ==HttpsURLConnection.HTTP_OK){
                InputStream in = new BufferedInputStream(connection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while ((linea=reader.readLine())!=null){
                   result.append(linea) ;
                }

            }

        }
        catch(Exception e){}
        return result.toString();



    }

    public int obtDatosJSON (String response){
        int res =0;
        try {
            JSONArray json= new JSONArray(response);
            if (json.length()>0){
                res= 1;
            }

        }
        catch (Exception e){}
        return res;

    }




    public void LoginApp(View view) {
/*
        String usuario = et1.getText().toString();
        String contrasena = et2.getText().toString();


        if (usuario.length() == 0) {
            Toast.makeText(this, "Se requiere un usuario", Toast.LENGTH_SHORT).show();
        }

        if (contrasena.length() == 0) {
            Toast.makeText(this, "Se requiere una contraseña", Toast.LENGTH_SHORT).show();
        }

        if (contrasena.length() != 0 && usuario.length() != 0) {

            Toast.makeText(this, "Validando información...", Toast.LENGTH_SHORT).show();
        }


 */
    }


    public void Siguiente (View view)
        {

            String usuario = et1.getText().toString();
            String contrasena = et2.getText().toString();


            if (usuario.length() == 0) {
                Toast.makeText(this, "Se requiere un usuario", Toast.LENGTH_SHORT).show();
            }

            if (contrasena.length() == 0) {
                Toast.makeText(this, "Se requiere una contraseña", Toast.LENGTH_SHORT).show();
            }

            if (contrasena.length() != 0 && usuario.length() != 0) {

                Toast.makeText(this, "Validando información...", Toast.LENGTH_SHORT).show();


                Intent siguiente = new Intent(this, WelActivity.class);
                startActivity(siguiente);
            }




        }


    public void Next (View view)
    {

        String usuario = et1.getText().toString();
        String contrasena = et2.getText().toString();


        if (usuario.length() == 0) {
            Toast.makeText(this, "Se requiere un usuario", Toast.LENGTH_SHORT).show();
        }

        if (contrasena.length() == 0) {
            Toast.makeText(this, "Se requiere una contraseña", Toast.LENGTH_SHORT).show();
        }

        if (contrasena.length() != 0 && usuario.length() != 0) {

            Toast.makeText(this, "Validando información...", Toast.LENGTH_SHORT).show();


            Intent next = new Intent(this, WelActivity.class);
            startActivity(next);
        }



    }

    public static class HttpsTrustManager implements X509TrustManager {

        private static TrustManager[] trustManagers;
        private static final X509Certificate[] _AcceptedIssuers = new X509Certificate[]{};

        @Override
        public void checkClientTrusted(
                java.security.cert.X509Certificate[] x509Certificates, String s)
                throws java.security.cert.CertificateException {

        }

        @Override
        public void checkServerTrusted(
                java.security.cert.X509Certificate[] x509Certificates, String s)
                throws java.security.cert.CertificateException {

        }

        public boolean isClientTrusted(X509Certificate[] chain) {
            return true;
        }

        public boolean isServerTrusted(X509Certificate[] chain) {
            return true;
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return _AcceptedIssuers;
        }

        public static void allowAllSSL() {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {

                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }

            });

            SSLContext context = null;
            if (trustManagers == null) {
                trustManagers = new TrustManager[]{new HttpsTrustManager()};
            }

            try {
                context = SSLContext.getInstance("TLS");
                context.init(null, trustManagers, new SecureRandom());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }

            HttpsURLConnection.setDefaultSSLSocketFactory(context
                    .getSocketFactory());
        }

    }


        private void ValidarUsuario (String URL){



            StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    if (!response.isEmpty()){

                        Intent intent = new Intent(getApplicationContext(), WelActivity.class );
                        startActivity(intent);


                    }else {
                        Toast.makeText(MainActivity.this, "Usuario o Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    //Toast.makeText(MainActivity.this "Usuario o Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            } ) {
                @Override
                protected Map<String, String> getParams () throws AuthFailureError {
                    Map<String, String> parametros = new HashMap<String, String >();
                    parametros.put("UserName", et1.getText().toString());
                    parametros.put("Password", et2.getText().toString());

                    //return  super.getParams();
                    return parametros;
                }


            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);


        }


}



























