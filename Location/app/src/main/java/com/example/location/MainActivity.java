package com.example.location;

import android.Manifest;
import android.app.Activity;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URLEncoder;

public class MainActivity extends Activity {
    private final String TAG = "MapLocation";

    private static final String DATA_MIMETYPE = ContactsContract.Data.MIMETYPE;
    private static final Uri DATA_CONTENT_URI = ContactsContract.Data.CONTENT_URI;
    private static final String DATA_CONTACT_ID = ContactsContract.Data.CONTACT_ID;
    private static final String CONTACTS_ID = ContactsContract.Contacts._ID;
    private static final Uri CONTACTS_CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;
    private static final String STRUCTURED_POSTAL_CONTENT_ITEM_TYPE = ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE;
    private static final String STRUCTURED_POSTAL_FORMATTED_ADDRESS = ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS;
    private static final int REQUEST_CODE_ASK_PERMISISIONS = 123;
    private static final int PICK_CONTACT_REQUEST = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button find = (Button) findViewById(R.id.btn_find);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt_Location = (TextView) findViewById(R.id.txt_location);
                String address = txt_Location.getText().toString();
                if (!address.equals("")) {
                    try {
                        String map = "http://maps.google.co.in/maps?q=" + address;
                        startActivity(viewOnMap(map));
                    } catch (Exception e) {
                        CharSequence error = e.toString();
                        Toast toast = Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } else {
                    CharSequence insertAddress = "Inserte la dirección" + address;
                    Toast toast = Toast.makeText(getApplicationContext(), insertAddress, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        Button findByContact = (Button) findViewById(R.id.btn_findByContact);
        findByContact.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    int hasReadContactsPermission = checkSelfPermission(Manifest.permission.READ_CONTACTS);
                    if(hasReadContactsPermission != PackageManager.PERMISSION_GRANTED){
                        requestPermissions(new String[] {Manifest.permission.READ_CONTACTS}, REQUEST_CODE_ASK_PERMISISIONS);
                        return;
                    }
                    Intent intent = new Intent(Intent.ACTION_PICK, CONTACTS_CONTENT_URI);
                    startActivityForResult(intent, PICK_CONTACT_REQUEST);

                }catch(Exception e){
                    Log.e(TAG, e.toString());
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String [] permissions, int [] grantResults){
        switch(requestCode){
            case REQUEST_CODE_ASK_PERMISISIONS:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(Intent.ACTION_PICK, CONTACTS_CONTENT_URI);
                    startActivityForResult(intent, PICK_CONTACT_REQUEST);
                }else{
                Toast.makeText(MainActivity.this, "No se permitió leer contactos.", Toast.LENGTH_SHORT).show();
            } break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        Log.i(TAG, "This is the result of PICK_CONTACT_REQUEST"+ PICK_CONTACT_REQUEST);
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_CONTACT_REQUEST){
            ContentResolver cr = getContentResolver();
            Cursor cursor = cr.query(data.getData(), null, null, null, null);

            if (null != cursor && cursor.moveToFirst()){
                String id = cursor.getString(cursor.getColumnIndex(CONTACTS_ID));
                String where = DATA_CONTACT_ID + "= ?" + " AND " + DATA_MIMETYPE + "= ? ";
                String [] whereParameters = new String [] {id, STRUCTURED_POSTAL_CONTENT_ITEM_TYPE};
                Cursor addCur = cr.query(DATA_CONTENT_URI, null, where, whereParameters, null);

                if(null != addCur && addCur.moveToFirst()){
                    String formatAddress = addCur.getString(addCur.getColumnIndex(STRUCTURED_POSTAL_FORMATTED_ADDRESS));
                    if (null != formatAddress){
                        //Process text for network transmission
                        formatAddress = formatAddress.replace(' ', '+');
                        //Create intent object
                        Intent geoIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + formatAddress));
                        //Use intent to start gMaps
                        startActivity(geoIntent);
                    }
                }
             }
        }
    }

    public Intent viewOnMap(String map) {
        return new Intent(Intent.ACTION_VIEW, Uri.parse(map));
    }

    public void onClickExit(View v) {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
