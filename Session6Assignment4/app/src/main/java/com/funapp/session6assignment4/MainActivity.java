package com.funapp.session6assignment4;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView contactList;
    String[] contacts = {"Pushpa", "Latha", "Arjun", "Kiran", "Arnav"};
    String[] phonenum = {"11111111", "222222222", "33333333", "44444444", "55555555"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //binding the id of listview to the java file
        contactList = (ListView) findViewById(R.id.listView);

        CustomAdapter adapter = new CustomAdapter(this, contacts, phonenum);
// contacts are loaded from the adapter to the the list view
        contactList.setAdapter(adapter);
// context menu registeration
        registerForContextMenu(contactList);


        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selecteditem = contacts[+position];
                Toast.makeText(MainActivity.this, selecteditem, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select the Action");
        menu.add(0, v.getId(), 0, "Call");
        menu.add(0, v.getId(), 0, "Send SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
// Calling
        if (item.getTitle() == "Call") {
            Toast.makeText(MainActivity.this, "Calling", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Intent.ACTION_CALL);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return true;
            }
            startActivity(i);

        }
// Sending SMS
        else if (item.getTitle() == "Send SMS"){
            Intent sms = new Intent(Intent.ACTION_VIEW);
            sms.putExtra("sms_body", "Enter Text");
            sms.setType("vnd.android-dir/mms-sms");
            startActivity(sms);


        }else{
            return false;
        }
        return super.onContextItemSelected(item);
    }

}
