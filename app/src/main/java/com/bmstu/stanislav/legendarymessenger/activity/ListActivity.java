package com.bmstu.stanislav.legendarymessenger.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bmstu.stanislav.legendarymessenger.R;
import com.bmstu.stanislav.legendarymessenger.adapter.ListOfNumbersAdapter;
import com.bmstu.stanislav.legendarymessenger.pojo.ListItem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = (ListView) findViewById(R.id.listView);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, initData());

        ListOfNumbersAdapter adapter = new ListOfNumbersAdapter(this, initData());
        listView.setAdapter(adapter);
    }

    private LinkedList<ListItem> initData() {
        LinkedList<ListItem> linkedList = new LinkedList<>();

        List<String> units = new ArrayList<>();
        List<String> dozens = new ArrayList<>();
        List<String> hundreds = new ArrayList<>();

        units.add("один");
        units.add("два");
        units.add("три");
        units.add("четыре");
        units.add("пять");
        units.add("шесть");
        units.add("семь");
        units.add("восемь");
        units.add("девять");
        units.add("десять");
        units.add("одинадцать");
        units.add("двенадцать");
        units.add("тринадцать");
        units.add("четырнадцать");
        units.add("пятнадцать");
        units.add("шестнадцать");
        units.add("семнадцать");
        units.add("восемнадцать");
        units.add("девятнадцать");

        dozens.add("двадцать");
        dozens.add("тридцать");
        dozens.add("сорок");
        dozens.add("пятьдесят");
        dozens.add("шестьдесят");
        dozens.add("семьдесят");
        dozens.add("восемьдесят");
        dozens.add("девяносто");

        hundreds.add("сто");
        hundreds.add("двести");
        hundreds.add("триста");
        hundreds.add("четыреста");
        hundreds.add("пятьсот");
        hundreds.add("шестьсот");
        hundreds.add("семьсот");
        hundreds.add("восемьсот");
        hundreds.add("девятьсот");
        hundreds.add("тысяча");

        for (int i = -1; i < 9; i++) {
            String hundred = (i < 0) ? "" : hundreds.get(i) + " ";
            for (int j = -1; j < 8; j++) {
                String dozen = (j < 0) ? "" : dozens.get(j) + " ";
                int max = (j < 0) ? 19 : 9;
                for (int k = 0; k < max; k++) {
                    String unit = units.get(k);
                    linkedList.add(new ListItem(hundred + dozen + unit));
                }
                if (j < 7) linkedList.add(new ListItem(hundred + dozens.get(j + 1)));
            }
            linkedList.add(new ListItem(hundreds.get(i + 1)));
        }

        return linkedList;
    }
}
