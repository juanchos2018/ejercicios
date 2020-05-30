package com.example.ejercicios;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.biometrics.BiometricManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;

public class Huellas extends AppCompatActivity {


    private Handler handler = new Handler();
    ImageView img1,img2;
    Uri uri1,uri2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huellas);

        img1=(ImageView)findViewById(R.id.image1);
        img2=(ImageView)findViewById(R.id.image2);
        Button biometricLoginButton = findViewById(R.id.biometric_login);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirgaleria1();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirgaleria2();
            }
        });


        biometricLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // showBiometricPrompt();
                FingerImageMatch ();
            }
        });
    }

    public  void FingerImageMatch ()  {

        img1.setDrawingCacheEnabled(true);
        img1.buildDrawingCache();
        Bitmap bitmap = ((BitmapDrawable) img1.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] path1= baos.toByteArray();
        String enoncebase64_1= Base64.encodeToString(path1, Base64.DEFAULT);
        Log.e("e1 ",enoncebase64_1);


        img2.setDrawingCacheEnabled(true);
        img2.buildDrawingCache();
        Bitmap bitmap1 = ((BitmapDrawable) img2.getDrawable()).getBitmap();
        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
        bitmap1.compress(Bitmap.CompressFormat.JPEG, 100, baos1);
        byte[] path2= baos1.toByteArray();
        String enoncebase64_2= Base64.encodeToString(path2, Base64.DEFAULT);
        Log.e("e2 ",enoncebase64_2);

       if (enoncebase64_1.equals(enoncebase64_2)){
           Toast.makeText(this, "Son igules", Toast.LENGTH_SHORT).show();
       }
       else {
           Toast.makeText(this, "No son iguales", Toast.LENGTH_SHORT).show();
       }

       // byte[] candidateImage = Files.readAllBytes(Paths.get("D:\\huella2.jpg"));
        //FingerprintTemplate probe = new FingerprintTemplate().dpi(500).create(path1);
        //FingerprintTemplate candidate = new FingerprintTemplate().dpi(500).create(path2);
        //double score = new FingerprintMatcher().index(probe).match(candidate);
        //double threshold = 40;
        //boolean matches = score >= threshold;
        //System.out.println(matches);
        //Log.e("asd ", String.valueOf(matches));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {

            if (requestCode==10 && resultCode==RESULT_OK && data!=null){

              uri1  =data.getData(); //return the uir of selected file
             img1.setImageURI(uri1);

            }

            else   if (requestCode==20 && resultCode==RESULT_OK && data!=null){
                Log.e("archivi ",data.getData().toString());
                 uri2=data.getData();
                  img2.setImageURI(uri2);


            }

            else{
                Toast.makeText(this, "No seleciono un archivo", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception ex){
            Toast.makeText(this, "Error "+ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void abrirgaleria1() {
         //TODO ESTO ES PARA ABRIR LA GALERIA DEL CELULAR
        try {
            Intent intent=new Intent(Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/");
            startActivityForResult(intent.createChooser(intent,"Seleccione"),10);// 10
        }
        catch (Exception ex){
            Toast.makeText(this, "Eror "+ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    private void abrirgaleria2() {
        //TODO ESTO ES PARA ABRIR LA GALERIA DEL CELULAR
        try {
            Intent intent=new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/");
            startActivityForResult(intent.createChooser(intent,"Seleccione"),20);// 10
        }
        catch (Exception ex){
            Toast.makeText(this, "Eror "+ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private void ogor(){
      //  FingerprintTemplate probe = new FingerprintTemplate(
      //          new FingerprintImage()
      //                  .dpi(500)
      //                  .decode(Files.readAllBytes(Paths.get("probe.jpeg"))));
      //  FingerprintTemplate candidate = new FingerprintTemplate(
      //          new FingerprintImage()
      //                  .dpi(500)
      //                  .decode(Files.readAllBytes(Paths.get("candidate.jpeg"))));
      //  double score = new FingerprintMatcher()
      //          .index(probe)
      //          .match(candidate);
      //  boolean matches = score >= 40;
    }
    private int[] getRgbFromBitmap(Bitmap bitmap)
    {
        int picw = bitmap.getWidth();
        int pich = bitmap.getHeight();

        int[] pix = new int[picw * pich];
        bitmap.getPixels(pix, 0, picw, 0, 0, picw, pich);

        int r, g, b;

        // pix: {-1, -65794, -1, -65794, -65794, -65794, -1, -1, -460552, ...}
        for (int aPix : pix) {
            r = (aPix) >> 16 & 0xff;
            g = (aPix) >> 8 & 0xff;
            b = (aPix) & 0xff;
        }

        return pix;
    }


//
  //  BiometricManager biometricManager = BiometricManager.from(this);
  //  switch (biometricManager.canAuthenticate()) {
  //      case BiometricManager.BIOMETRIC_SUCCESS:
  //          Log.d("App can authenticate using biometrics.");
  //          break;
  //      case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
  //          Log.e("No biometric features available on this device.");
  //          break;
  //      case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
  //          Log.e("Biometric features are currently unavailable.");
  //          break;
  //      case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
  //          Log.e("The user hasn't associated any biometric credentials " +
  //                  "with their account.");
  //          break;
  //  }

    private Executor executor = new Executor() {
        @Override
        public void execute(Runnable command) {
            handler.post(command);
        }
    };


    private void showBiometricPrompt() {
        BiometricPrompt.PromptInfo promptInfo =
                new BiometricPrompt.PromptInfo.Builder()
                        .setTitle("Biometric login for my app")
                        .setSubtitle("Log in using your biometric credential")
                        .setNegativeButtonText("Cancel")
                        .build();

        BiometricPrompt biometricPrompt = new BiometricPrompt(Huellas.this,
                executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode,
                                              @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(getApplicationContext(),
                        "Authentication error: " + errString, Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onAuthenticationSucceeded(
                    @NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                BiometricPrompt.CryptoObject authenticatedCryptoObject =
                        result.getCryptoObject();
                // User has verified the signature, cipher, or message
                // authentication code (MAC) associated with the crypto object,
                // so you can use it in your app's crypto-driven workflows.
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(getApplicationContext(), "Authentication failed",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
        biometricPrompt.authenticate(promptInfo);
    }
}
