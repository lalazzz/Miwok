package com.example.android.miwok;

import android.view.View;
import android.widget.Toast;

/**
 * Created by Michelle Tan on 28/2/2017.
 */


//implement the specific type like a View for the operator on click listener.
public class NumbersClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view)
    {
        Toast.makeText(view.getContext(),"Testing number activity",Toast.LENGTH_SHORT).show();
    }
}
