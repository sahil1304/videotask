package com.sj.video;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=findViewById(R.id.listview);

        String strJson="{ \n" +
                "\"MediaItems\":\n" +
                " [{ \n" +
                "\"Title\": \"Anupam Kher in conversation with Johnny Lever\",\n" +
                "\"Image\":\"https://img.republicworld.com/republic-prod/shows/promolarge/xxhdpi/tr:w-425,h-233/150375812059a18728c0d9b.jpeg\",\n" +
                " \"Url\": \"http://uds.ak.o.brightcove.com/5384493731001/5384493731001_5552873278001_5552856451001.mp4?pubId=5384493731001&videoId=5552856451001\"\n" +
                "}, \n" +
                "{ \n" +
                "\"Title\": \"In Conversation with Chef Vikas Khanna\", \n" +
                "\"Image\":\"https://img.republicworld.com/republic-prod/shows/promolarge/xxhdpi/tr:w-425,h-233/150497447759b4168d9557d.jpeg\", \n" +
                "\"Url\": \"https://manifest.prod.boltdns.net/manifest/v1/hls/v4/clear/5384493731001/9ae886bf-c6e9-4b7d-94be-afaa7c848d7a/10s/master.m3u8?fastly_token=NWY0ZmE1OTBfNjVkN2ZlY2JkN2RhNTgzM2RhMjUxZjU5ZGJlZTU0MTFlYTMxY2I0ODljNzI5ZjJmYTYxNjUxOWFjN2I3NDVlYg%3D%3D\"\n" +
                "}, \n" +
                "{ \n" +
                "\"Title\": \"Nation Wants To Know: Union minister Rajnath Singh Speaks To Bharat\",\n" +
                "\"Image\":\"https://img.republicworld.com/republic-prod/shows/promolarge/xxhdpi/tr:w-425,h-233/15509400745c7177aa10252.jpeg\", \n" +
                "\"Url\": \"https://manifest.prod.boltdns.net/manifest/v1/hls/v4/clear/5384493731001/cf26a7ed-219c-4608-b9c2-b9665d9adf35/10s/master.m3u8?fastly_token=NWY0ZTEyYThfNWZlZjhhOWY4NjIxOWZhMDFhZmM5Y2RjMWM4ZjQ0OWMyYWRlNWJjNTRkZmQzMjlmZWFkOGI3M2JjZDNhYzM5ZQ%3D%3D\"\n" +
                "},\n" +
                " {\n" +
                " \"Title\": \"Nation Wants To Know: Gautam Gambhir Speaks To Arnab\", \n" +
                "\"Image\":\"https://img.republicworld.com/republic-prod/shows/promolarge/xxhdpi/tr:w-425,h-233/15467004525c30c6a42b547.jpeg\", \n" +
                "\"Url\": \"https://manifest.prod.boltdns.net/manifest/v1/hls/v4/clear/5384493731001/33780241-39b5-4a0f-909c-b92b860c5b5c/10s/master.m3u8?fastly_token=NWY0ZTE2OWZfZjM0NDZkZTA5ZWQ2NjJmZWI0YjZmOTJmMjA5YzdjYjc0NDhjMGU4YzBmMDQ5MzRiODNiYzZiZWUzMTdiZjQ4NQ%3D%3D\"\n" +
                "}, \n" +
                "{ \n" +
                "\"Title\": \"Nation Wants To Know: Union minister Col Rajyavardhan Rathore Speaks To Arnab\",\n" +
                "\"Image\":\"https://img.republicworld.com/republic-prod/shows/promolarge/xxhdpi/tr:w-425,h-233/15473142655c3a2459d525a.jpeg\", \n" +
                "\"Url\": \"https://manifest.prod.boltdns.net/manifest/v1/hls/v4/clear/5384493731001/701d3530-abce-4a5c-9169-8c0b2b4c4429/10s/master.m3u8?fastly_token=NWY0ZTBlZjFfNTVkYmY0OGI1Y2Y3ZjRjMjgzMzBkNGZhNGI5MmUzY2VjYjdiYzdjNTZhOWIwYzUzZGFiZjgwZTg2ZWQ0ZmJmNA%3D%3D\"\n" +
                "}, \n" +
                "{\n" +
                " \"Title\": \"#ISROChiefSpeaksToArnab\",\n" +
                "\"Image\":\"https://img.republicworld.com/republic-prod/shows/promolarge/xxhdpi/tr:w-425,h-233/15944845855f09e769daee4.jpeg\", \n" +
                "\"Url\": \"https://manifest.prod.boltdns.net/manifest/v1/hls/v4/clear/5384493731001/5e0a8be8-d371-4fbe-8511-019c0c63d235/10s/master.m3u8?fastly_token=NWY0ZTBmODFfMTY5ZmNlNDkyN2JhYzBiMmFiYjNjOTA1ZDYxNzE5N2FjZTkzNTFiNzYyYThiZjljZjA5ZmY0M2E5NzcxYTBjZQ%3D%3D\"\n" +
                "}] \n" +
                "} \n";
        String data = "";
        try {
            // Create the root JSONObject from the JSON string.
            JSONObject  jsonRootObject = new JSONObject(strJson);

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.optJSONArray("MediaItems");

            //Iterate the jsonArray and print the info of JSONObjects
            String[] Title=new String[jsonArray.length()];
            String[] Image=new String[jsonArray.length()];
            String[] Url=new String[jsonArray.length()];
            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Title[i] = jsonObject.optString("Title").toString();
                Image[i] = jsonObject.optString("Image").toString();
                Url[i] = jsonObject.optString("Url").toString();

            }
            final CustomView customListView = new CustomView(MainActivity.this, Title,Image,Url);
            listview.setAdapter(customListView);

        } catch (JSONException e) {e.printStackTrace();}
    }
}
