package kr.hs.emirim.s2019s38.mirimcontestmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button btnRotation;
    Button btnShape;
    LinearLayout baseLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("컨텍스트 메뉴를 선택");
        baseLayout=findViewById(R.id.base_layout);
        btnRotation=findViewById(R.id.btn_bg);
        btnShape=findViewById(R.id.btn_shape);
        registerForContextMenu(btnRotation);
        registerForContextMenu(btnShape);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);

        MenuInflater inflater=getMenuInflater();

        if(v==btnRotation){
            menu.setHeaderTitle("배경색 변경");
            inflater.inflate(R.menu.menu1,menu);
        }
        if(v==btnShape){
            menu.setHeaderTitle("버튼 모양 변경");
            inflater.inflate(R.menu.menu2,menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.item_red:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case  R.id.item_yellow:
                baseLayout.setBackgroundColor(Color.YELLOW);
                return true;
            case  R.id.item_lightblue:
                baseLayout.setBackgroundColor(Color.rgb(0,255,255));
                return true;
            case R.id.item_rotation:
                btnRotation.setRotation(60);
                return true;
            case R.id.item_scale:
                btnRotation.setScaleX(2);
                btnRotation.setScaleY(2);
                btnShape.setScaleX(2);
                btnShape.setScaleY(2);
                return true;
        }

        return false;
    }
}