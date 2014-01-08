package com.li9ht.hbtracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Fragment implements OnClickListener  {

	Button btnAddItem, btnShow, btnAddCat;
	TextView tvTerminal;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main, null);

		btnAddItem = (Button) v.findViewById(R.id.btnAddItem);
		btnAddCat = (Button) v.findViewById(R.id.btnAddCat);
		btnShow = (Button) v.findViewById(R.id.btnShow);
		tvTerminal = (TextView) v.findViewById(R.id.textView1);

        btnShow.setOnClickListener(this);
        btnAddCat.setOnClickListener(this);
        btnAddItem.setOnClickListener(this);

        return v;

	}

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnShow:
                showItem();
                break;
            case R.id.btnAddItem:
                addItem();
                break;
            case R.id.btnAddCat:
                addNewCat();
                break;
        }
    }

    public void showItem(){
        Category weight = Category.getSingle("Weight");

        List<Item> li = Item.getAllCat(weight);

        tvTerminal.setText("start\n");
        for (int i = 0; i < li.size(); i++) {
            System.out.println(li.get(i));
            tvTerminal.append(li.get(i).name + "\n");
        }

    }

    public void addItem(){
        Category weight = Category.getSingle("Weight");

        Item item = new Item();
        item.category = weight;
        item.name = "63.9";
        item.save();

        tvTerminal.setText(item.name.toString() + "added\n");
    }

    public void addNewCat(){
        Category weight = new Category();
        weight.name = "Weight";
        weight.save();
        tvTerminal.setText(weight.name.toString() + "added\n");
    }
}
