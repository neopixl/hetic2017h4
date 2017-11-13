package fr.hetic.g2.myapplication;

import android.app.Activity;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.neopixl.spitfire.listener.RequestListener;
import com.neopixl.spitfire.model.RequestData;
import com.neopixl.spitfire.request.BaseRequest;
import com.neopixl.spitfire.request.MultipartRequest;

import fr.hetic.g2.myapplication.request.FakeLoginRequest;

/**
 * Created by Florian ALONSO on 11/13/17.
 * For Neopixl
 */

public class FakeRequestManager extends Activity {

    public void sendLoginRequest() {
        FakeLoginRequest fakeLoginRequest = new FakeLoginRequest();
        fakeLoginRequest.setEmail("florian@neopixl.com");
        fakeLoginRequest.setPassword("flori4n");


        BaseRequest<Void> loginRequest =
                new BaseRequest.Builder<>(Request.Method.POST,
                        "http://monsite.com/login"
                        , Void.class)
                .object(fakeLoginRequest)
                .build();

        HeticApplication heticApplication =
                (HeticApplication) getApplication();
        heticApplication.getRequestQueue().add(loginRequest);

    }

    public void sendFakeMultipleImage() {
        byte[] maPhotoDeProfil = {1,0,0,0,1,1,1,1,0};
        RequestData dataProfil = new RequestData(
                "jeSuisTropBeau.jpg",
                maPhotoDeProfil,
                "image/jpeg"
        );

        byte[] maPhotoDeCouverture = {1,1,1,1,1,1,0,1,1};
        RequestData dataCoverture = new RequestData(
                "mesVacancesALaPlage.png",
                maPhotoDeCouverture,
                "image/png"
        );


        MultipartRequest<Void> multipartRequest =
                new MultipartRequest.Builder<>(Request.Method.PUT
                        , "http://monsite.com/upload"
                        , Void.class)
                        .insertMultiPartData("profilPic", dataProfil)
                        .insertMultiPartData("coverPic", dataCoverture)
                .build();
    }
}
