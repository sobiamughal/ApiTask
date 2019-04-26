package com.example.apitask;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchData extends AsyncTask<Void, Void, Void> {

    //is may hum url ko mangay gy
    //usko GET karay gy q k us sy data chayie hamey islia GET
    //threads banay gy q k hamara kam chalta rahay agr hum koi or kam kr ray hen to
    String data="";
    String singleParsed;
    String dataParsed;
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.myjson.com/bins/xstzw&quot");
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            //inputstream may srf read kara ray hen .. jaisey GET use kr ray hen khali data read karanay k lia.
            InputStream inputStream = httpURLConnection.getInputStream();
            //read hoy data ko dehkanay k lia use hota hai.
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //initialize variable
            String line = "";
            while (line != null){
                line=bufferedReader.readLine();
                data=data+line;
            }
            //JSOn ko print karanay k lia array use ho rai hai ... or array ko chalanay k lia for ka loop use kr ray hen.
            JSONArray jsonArray= new JSONArray(data);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                singleParsed = "Name:"+jsonObject.get("name")+"\n"+
            "Password:"+ jsonObject.get("passward")+"\n"+
            "Contact:"+ jsonObject.get("name")+"\n"+
            "Country:"+ jsonObject.get("name")+"\n";    //chuta wala name jo hai wo api wala hai .... jo sir dy gy wo lihkna ho gaa.
                switch (dataParsed = dataParsed + singleParsed + "\n"){

                }
            }

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.data.setText(this.dataParsed);
    }
}

