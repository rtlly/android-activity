package com.example.helloworld;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SelectContractActivity extends AppCompatActivity {
    static final int REQUEST_SELECT_CONTACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_contract);
    }

    public void selectContract(View view) {
        Uri uri = CommonDataKinds.Phone.CONTENT_URI;
        Intent intent = new Intent(Intent.ACTION_PICK, uri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_CONTACT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SELECT_CONTACT && resultCode == RESULT_OK) {
            Uri contactUri = data.getData();
            String[] projection = new String[]{CommonDataKinds.Phone.DISPLAY_NAME, CommonDataKinds.Phone.NUMBER};
            Cursor cursor = getContentResolver().query(contactUri, null,
                    null, null, null);
            System.out.println("cursor"+cursor);
            // If the cursor returned is valid, get the phone number
            if (cursor != null&&cursor.moveToFirst()) {
                //取得联系人姓名
                int nameFieldColumnIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                String name = cursor.getString(nameFieldColumnIndex);
                String phone =cursor.getString(cursor.getColumnIndex(CommonDataKinds.Phone.NUMBER));
                TextView textView = findViewById(R.id.contract);
                textView.setText(name .concat(" ").concat(phone));
                cursor.close();
            }

        }
    }
}
