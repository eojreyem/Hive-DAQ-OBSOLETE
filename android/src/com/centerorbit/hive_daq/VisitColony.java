package com.centerorbit.hive_daq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class VisitColony extends Activity
implements WeatherInterface {

    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
    private Uri fileUri;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_visit);

        Weather test = new Weather();
        test.getLatest(45.427960f, -93.141952f, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inspect_colony, menu);
		return true;
	}

    @Override
    public void weatherHasUpdated(JSONObject weather) {
        try{
            Double temperature = weather.getJSONObject("currently").getDouble("temperature");
            Double cloudCover = weather.getJSONObject("currently").getDouble("cloudCover");

            //TODO: yeah, Toast is great... but instead we should update the UI, and store in DB.
            Toast.makeText(this.getApplicationContext(), "The temp is: "+temperature.toString(), Toast.LENGTH_SHORT).show();
            Toast.makeText(this.getApplicationContext(), "The cloud cover is: "+cloudCover.toString(), Toast.LENGTH_SHORT).show();
        }
        catch (JSONException error){
            //Do nothing about it?
        }
    }

    @Override
    public void weatherFailedUpdate() {
        //TODO: Perhaps a real fail thing.
        Toast.makeText(this.getApplicationContext(), "Weather failed to update.", Toast.LENGTH_SHORT).show();
    }
    
    public void Queen_menu(View view) {
        Toast.makeText(this.getApplicationContext(), "Open QueenEval Menu", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, QueenEval.class);
        startActivity(intent);
    }

    public void Evaluation(View view) {
        Toast.makeText(this.getApplicationContext(), "Open Evaluation Form", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Evaluation.class);
        startActivity(intent);
    }

    public void Disease(View view) {
        Toast.makeText(this.getApplicationContext(), "Open Disease Menu", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Disease.class);
        startActivity(intent);
    }

    public void Management(View view) {
        Toast.makeText(this.getApplicationContext(), "Open Management Menu", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Management.class);
        startActivity(intent);
    }

    public void ColonyDetails(View view) {
        Toast.makeText(this.getApplicationContext(), "Open Colony Details", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ColonyDetail.class);
        startActivity(intent);
    }

    /** Create a file Uri for saving an image or video */
    private static Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(int type){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.




        String path = Environment.getExternalStorageDirectory().toString();
        File mediaStorageDir = new File(path, "/DCIM/AME/");
        // File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
        //         Environment.DIRECTORY_PICTURES), "MyCameraApp");

        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("/DCIM/AME/", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");

        } else if(type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_"+ timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }


    public void openCamera(View view) {
        // create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name

        // start the image capture Intent
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Image captured and saved to fileUri specified in the Intent
                Toast.makeText(this, "Image saved to: DCIM/AME", Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the image capture
            } else {
                // Image capture failed, advise user
            }
        }

        if (requestCode == CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Video captured and saved to fileUri specified in the Intent
                Toast.makeText(this, "Video saved to:\n" +
                        data.getData(), Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the video capture
            } else {
                // Video capture failed, advise user
            }
        }
    }


    public void Take_note(View view) {
        Toast.makeText(this.getApplicationContext(), "Take a Note", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, VisitNote.class);
        startActivity(intent);
    }



}
