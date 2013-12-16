package com.centerorbit.hive_daq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by joe on 11/23/13.
 */
public class Management extends Activity {

    protected Integer num_super_past_visit;
    protected Integer num_deep_past_visit;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgmt);

        EditText text_deep = (EditText) findViewById(R.id.edit_text_deep);
        EditText text_super = (EditText) findViewById(R.id.edit_text_super);

        EditText text_food = (EditText) findViewById(R.id.edit_text_food);
        EditText text_brood = (EditText) findViewById(R.id.edit_text_brood);

        Button hive_type = (Button) findViewById(R.id.bt_change_hive_type);
        //TODO load string indicating hive type into button text
        hive_type.setText("Nucleus");

        // TODO load database numbers from previous visit into class fields
        this.num_super_past_visit = 1;
        this.num_deep_past_visit = 2;

        //load values into "number pickers"
        text_deep.setText(Integer.toString(this.num_deep_past_visit));
        text_super.setText(Integer.toString(this.num_super_past_visit));

        text_food.setText(Integer.toString(0));
        text_brood.setText(Integer.toString(0));

    }


    public void AddDeep(View view) {

        //get value currently in text field
        EditText text_deep = (EditText) findViewById(R.id.edit_text_deep);
        Integer num_deep = Integer.valueOf(text_deep.getText().toString());

        //increment and display new value of deeps for visit
        num_deep++;
        text_deep.setText(Integer.toString(num_deep));
        //TODO store new number of deeps in DB Visit Table

        // if net change is positive highlight "add button"
        if (num_deep>this.num_deep_past_visit)
        {
            Button add_deep = (Button) findViewById(R.id.bt_deep_added);
            add_deep.setBackgroundColor(0xFFFFBF00 );
            add_deep.invalidate();
        }
        if (num_deep>=this.num_deep_past_visit) //set "remove button" background to default
        {
            Button sub_deep = (Button) findViewById(R.id.bt_remove_deep);
            sub_deep.setBackgroundResource(android.R.drawable.btn_default);
            sub_deep.invalidate();
        }
    }

    public void RemoveDeep(View view) {
        EditText text_deep = (EditText) findViewById(R.id.edit_text_deep);
        Integer num_deep = Integer.valueOf(text_deep.getText().toString());

        if (num_deep!=0)
        {
            //decrement and display new value of deeps for visit
            num_deep--;
            text_deep.setText(Integer.toString(num_deep));
            //TODO store new number of deeps in DB Visit Table

            if (num_deep<this.num_deep_past_visit) // if net change is negative highlight "remove button"
            {
                Button sub_deep = (Button) findViewById(R.id.bt_remove_deep);
                sub_deep.setBackgroundColor(0xFFFFBF00 );
                sub_deep.invalidate();
            }

            if (num_deep<=this.num_deep_past_visit) //set "added button" background to default
            {
                Button add_deep = (Button) findViewById(R.id.bt_deep_added);
                add_deep.setBackgroundResource(android.R.drawable.btn_default);
                add_deep.invalidate();
            }
        }
    }

    public void AddSuper(View view) {

        //get value currently in text field
        EditText text_super = (EditText) findViewById(R.id.edit_text_super);
        Integer num_super = Integer.valueOf(text_super.getText().toString());

        //increment and display new value of supers for visit
        num_super++;
        text_super.setText(Integer.toString(num_super));
        //TODO store new number of supers in DB Visit Table

        // if net change is positive highlight "add button"
        if (num_super>this.num_super_past_visit)
        {
            Button add_super = (Button) findViewById(R.id.bt_super_added);
            add_super.setBackgroundColor(0xFFFFBF00 );
            add_super.invalidate();
        }

        if (num_super>=this.num_super_past_visit) //set "remove button" background to default
        {
            Button sub_super = (Button) findViewById(R.id.bt_remove_super);
            sub_super.setBackgroundResource(android.R.drawable.btn_default);
            sub_super.invalidate();
        }
    }

    public void RemoveSuper(View view) {
        EditText text_super = (EditText) findViewById(R.id.edit_text_super);
        Integer num_super = Integer.valueOf(text_super.getText().toString());

        if (num_super!=0)
        {
            //decrement and display new value of supers for visit
            num_super--;
            text_super.setText(Integer.toString(num_super));
            //TODO store new number of deeps in DB Visit Table

            if (num_super<this.num_super_past_visit) // if net change is negative highlight "remove button"
            {
                Button sub_super = (Button) findViewById(R.id.bt_remove_super);
                sub_super.setBackgroundColor(0xFFFFBF00 );
                sub_super.invalidate();
            }

            if (num_super<=this.num_super_past_visit) //set "added button" background to default
            {
                Button add_super = (Button) findViewById(R.id.bt_super_added);
                add_super.setBackgroundResource(android.R.drawable.btn_default);
                add_super.invalidate();
            }
        }
    }

    public void AddFood(View view) {

        //get value currently in text field
        EditText text_food = (EditText) findViewById(R.id.edit_text_food);
        Integer num_food = Integer.valueOf(text_food.getText().toString());

        //increment and display new value of frames of food added this visit
        num_food++;
        text_food.setText(Integer.toString(num_food));
        //TODO store new number of food in DB Visit Table

        // if net change is positive highlight "add button"
        if (num_food>0)
        {
            Button add_food = (Button) findViewById(R.id.bt_food_added);
            add_food.setBackgroundColor(0xFFFFBF00 );
            add_food.invalidate();
        }
        if (num_food>=0) //set "remove button" background to default
        {
            Button sub_food = (Button) findViewById(R.id.bt_remove_food);
            sub_food.setBackgroundResource(android.R.drawable.btn_default);
            sub_food.invalidate();
        }
    }

    public void RemoveFood(View view) {
        EditText text_food = (EditText) findViewById(R.id.edit_text_food);
        Integer num_food = Integer.valueOf(text_food.getText().toString());

        //decrement and display new value of frames of food removed this visit
        num_food--;
        text_food.setText(Integer.toString(num_food));
        //TODO store new number of foods in DB Visit Table

        if (num_food<0) // if net change is negative highlight "remove button"
        {
            Button sub_food = (Button) findViewById(R.id.bt_remove_food);
            sub_food.setBackgroundColor(0xFFFFBF00 );
            sub_food.invalidate();
        }

        if (num_food<=0) //set "added button" background to default
        {
            Button add_food = (Button) findViewById(R.id.bt_food_added);
            add_food.setBackgroundResource(android.R.drawable.btn_default);
            add_food.invalidate();
        }
    }

    public void AddBrood(View view) {

        //get value currently in text field
        EditText text_brood = (EditText) findViewById(R.id.edit_text_brood);
        Integer num_brood = Integer.valueOf(text_brood.getText().toString());

        //increment and display new value of frames of brood added this visit
        num_brood++;
        text_brood.setText(Integer.toString(num_brood));
        //TODO store new number of brood in DB Visit Table

        // if net change is positive highlight "add button"
        if (num_brood>0)
        {
            Button add_brood = (Button) findViewById(R.id.bt_brood_added);
            add_brood.setBackgroundColor(0xFFFFBF00 );
            add_brood.invalidate();
        }

        if (num_brood>=0) //set "remove button" background to default
        {
            Button sub_brood = (Button) findViewById(R.id.bt_remove_brood);
            sub_brood.setBackgroundResource(android.R.drawable.btn_default);
            sub_brood.invalidate();
        }
    }

    public void RemoveBrood(View view) {
        EditText text_brood = (EditText) findViewById(R.id.edit_text_brood);
        Integer num_brood = Integer.valueOf(text_brood.getText().toString());

        //decrement and display new value of frames of brood removed this visit
        num_brood--;
        text_brood.setText(Integer.toString(num_brood));
        //TODO store new number of deeps in DB Visit Table

        if (num_brood<0) // if net change is negative highlight "remove button"
        {
            Button sub_brood = (Button) findViewById(R.id.bt_remove_brood);
            sub_brood.setBackgroundColor(0xFFFFBF00 );
            sub_brood.invalidate();
        }

        if (num_brood<=0) //set "added button" background to default
        {
            Button add_brood = (Button) findViewById(R.id.bt_brood_added);
            add_brood.setBackgroundResource(android.R.drawable.btn_default);
            add_brood.invalidate();
        }
    }

    public void ChangeHiveType(View view) {
        Toast.makeText(this.getApplicationContext(), "TODO toggle hive type", Toast.LENGTH_SHORT).show();
    }

    public void DivdeColony(View view) {
        Toast.makeText(this.getApplicationContext(), "Create New colony", Toast.LENGTH_SHORT).show();

        //TODO send data to auto fill out most of new colony info.
        Intent intent = new Intent(this, CreateColony.class);
        startActivity(intent);
    }

    public void CombineColony(View view) {
        Toast.makeText(this.getApplicationContext(), "Combine with another colony", Toast.LENGTH_SHORT).show();

    }





    public void Take_note(View view) {
        Toast.makeText(this.getApplicationContext(), "Take a Note", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, VisitNote.class);
        startActivity(intent);
    }


}