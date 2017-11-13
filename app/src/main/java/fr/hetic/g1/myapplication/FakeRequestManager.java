package fr.hetic.g1.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.neopixl.spitfire.listener.RequestListener;
import com.neopixl.spitfire.model.RequestData;
import com.neopixl.spitfire.request.BaseRequest;
import com.neopixl.spitfire.request.MultipartRequest;
import com.neopixl.spitfire.request.UploadFileRequest;

import java.io.ByteArrayOutputStream;

import fr.hetic.g1.myapplication.request.response.FakeLoginRequest;
import fr.hetic.g1.myapplication.request.response.RandomNamesResponse;

/**
 * Created by Florian ALONSO on 11/13/17.
 * For Neopixl
 */

public class FakeRequestManager extends Activity {

    public void fakePostRequest() {

        FakeLoginRequest fakeLoginRequest = new FakeLoginRequest();
        fakeLoginRequest.setEmail("florian@neopixl.com");
        fakeLoginRequest.setPassword("flori4n");


        BaseRequest<RandomNamesResponse> request =
                new BaseRequest.Builder<>(Request.Method.POST,
                        "http://monsitedexample.com", RandomNamesResponse.class)
                .object(fakeLoginRequest)
                .build();

        HeticApplication heticApplication = (HeticApplication) getApplication();
        heticApplication.getRequestQueue().add(request);
    }


    public void fakeUpload() {
        byte[] monImageBinary = {1,0,1,0,1,0};
        RequestData data = new RequestData(
                "monImage.jpg",
                monImageBinary,
                "image/jpeg");


        UploadFileRequest<Void> uploadFileRequest =
                new UploadFileRequest.Builder<>(Request.Method.PUT,
                        "http://monsitedexample.com", Void.class)
                        .partData(data)
                        .build();

        HeticApplication heticApplication = (HeticApplication) getApplication();
        heticApplication.getRequestQueue().add(uploadFileRequest);
    }


    public void fakeMultiUpload() {
        // EXEMPLE DE CONVERSION D'UNE IMAGE VERS UN TABLEAU DE BYTE
        //Bitmap bitmap = null;
        //ByteArrayOutputStream stream = new ByteArrayOutputStream();
        //bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        //byte[] byteArray = stream.toByteArray();


        byte[] monImageBinary = {1,0,1,0,1,0};
        RequestData data = new RequestData(
                "monImage.jpg",
                monImageBinary,
                "image/jpeg");

        byte[] monImageBinary2 = {1,0,1,0,1,0};
        RequestData data2 = new RequestData(
                "monImage2.jpg",
                monImageBinary,
                "image/jpeg");


        MultipartRequest<Void> multipartRequest =
                new MultipartRequest.Builder<>(Request.Method.PUT,
                        "http://monsitedexample.com",
                        Void.class)
                        .insertMultiPartData("profilePic", data)
                        .insertMultiPartData("coverPic", data2)
                        .object(new FakeLoginRequest())
                        .build();

        HeticApplication heticApplication = (HeticApplication) getApplication();
        heticApplication.getRequestQueue().add(multipartRequest);
    }
}
