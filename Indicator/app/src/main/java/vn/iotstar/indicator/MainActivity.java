package vn.iotstar.indicator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcIcon;
    ArrayList<IconModel> arrayList1;
    IconAdapter iconAdapter;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rcIcon = findViewById(R.id.rcIcon);
        arrayList1 = new ArrayList<>();
        arrayList1.add(new IconModel(R.drawable.icon1,"jfdjfdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.icon1, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.icon1, "sdfdf sfds"));
        arrayList1.add(new IconModel(R.drawable.icon1, "dfgfhyh sxdff"));
        arrayList1.add(new IconModel(R.drawable.icon1, "jfdjfdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.icon1, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.icon1, "sdfdf sfds"));
        arrayList1.add(new IconModel(R.drawable.icon1, "dfgfhyh sxdff"));
        arrayList1.add(new IconModel(R.drawable.icon1, "dfgfhyh sxdff"));
        arrayList1.add(new IconModel(R.drawable.icon1, "jfdjfdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.icon1, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.icon1, "sdfdf sfds"));
        arrayList1.add(new IconModel(R.drawable.icon1, "dfgfhyh sxdff"));
        arrayList1.add(new IconModel(R.drawable.icon1, "jfdjfdjf djfdh"));
        arrayList1.add(new IconModel(R.drawable.icon1, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.icon1, "sdfdf sfds"));
        arrayList1.add(new IconModel(R.drawable.icon1, "dfgfhyh sxdff"));
        arrayList1.add(new IconModel(R.drawable.icon1, "dfgfhyh sxdff"));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2,
        GridLayoutManager.HORIZONTAL,false);
        rcIcon.setLayoutManager(gridLayoutManager);
        iconAdapter = new IconAdapter(getApplicationContext(), arrayList1);
        rcIcon.setAdapter(iconAdapter);
        //rcIcon.addItemDecoration(new LinePagerIndicatorDecoration());


        searchView= findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange (String newText) {
                filterListener(newText);
                return true;
            }
        });
    }
    private void filterListener(String text) {
        List<IconModel> list = new ArrayList<>();
        for (IconModel iconModel: arrayList1){
        if(iconModel.getDesc().toLowerCase().contains(text.toLowerCase())){
            list.add(iconModel);
        }
    }
        if(list.isEmpty()){
            Toast.makeText( this,  "Không có dữ liệu", Toast.LENGTH_SHORT).show();
        }else{
            iconAdapter.setListenerList(list);
        }

    }



}