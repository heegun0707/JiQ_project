package com.qplus.qplus.ui.market;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.qplus.qplus.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class MarketCafeActivity<StoreItem, sss1> extends AppCompatActivity {

    StorageReference storageRef;
    FirebaseStorage storage;
    FirebaseFirestore firebaseFirestore;
    FirebaseUser firebaseUser;

    ArrayList<QueryDocumentSnapshot> sendDocument;

    ListView listview;
    MarketListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_cafe);

        ImageView gohome;
     //이동
        gohome = findViewById(R.id.gohome);

        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Adapter 생성
        adapter = new MarketListViewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.market_listview);

        MarketListClick marketListClick = new MarketListClick(getApplicationContext());
        marketListClick.MarketListClickBuy(adapter,listview,"Cafe");

        /*// db에서 갖고오기
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("MarketList").document("Cafe").get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        DocumentSnapshot document = task.getResult();


                        // Adapter 생성
                        adapter = new MarketListViewAdapter();

                        // 리스트뷰 참조 및 Adapter달기
                        listview = (ListView) findViewById(R.id.market_listview);
                        listview.setAdapter(adapter);

                        for(int i = 1; i<7; i++ ) {
                            adapter.addItem(document.get("GoodsImg-" + i).toString(), document.get("GoodsName-" + i).toString(), document.get("Stamp-" + i).toString()+" 개");
                        }

                        *//*Log.e("아이템이름","" + document.get("GoodsName-"+1).toString() );
                        Log.e("아이템개수","" + document.get("Stamp-"+1).toString() );*//*
                        Log.e("아이템이미지","" + document.get("GoodsImg-"+5).toString() );


                    }
                });*/


    }
}
