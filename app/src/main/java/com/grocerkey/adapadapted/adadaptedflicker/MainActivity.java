package com.grocerkey.adapadapted.adadaptedflicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.adadapted.android.sdk.ui.messaging.AaSdkContentListener;
import com.adadapted.android.sdk.ui.model.AdContentPayload;
import com.adadapted.android.sdk.ui.view.AaZoneView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements AaSdkContentListener {

    private AaZoneView _ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        _ad = (AaZoneView) findViewById(R.id.ad);
        _ad.init(getString(R.string.ad_adapted_zone_id));
    }

    @Override
    public void onContentAvailable(String s, AdContentPayload adContentPayload) {
        JSONObject json = adContentPayload.getPayload();

        try {
            JSONArray addToListItems = json.getJSONArray("add_to_list_items");
            int productId = Integer.valueOf(addToListItems.getString(0));
            Toast.makeText(this, "Clicked on ad: " + productId, Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        adContentPayload.acknowledge();
    }

    @Override
    protected void onStart() {
        super.onStart();
        _ad.onStart(this);
    }

    @Override
    protected void onStop() {
        _ad.onStop();
        super.onStop();
    }
}
