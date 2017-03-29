package com.example.fragmentquoteactivity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.fragmentquoteactivity.titlesClass.ListSelectionListener;

public class QuoteViewerActivity extends Activity implements ListSelectionListener {

    public static String[] mTitleArray;
    public static String[] mDescriptionArray;
    private CompanyDetails mDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTitleArray = getResources().getStringArray(R.array.companies);
        mDescriptionArray = getResources().getStringArray(R.array.description);
        setContentView(R.layout.main);

        mDetailsFragment = (CompanyDetails) getFragmentManager().findFragmentById(R.id.companyDescription);
    }

    @Override
    public void onListSelection(int index){
        if(mDetailsFragment.getShownIndex() != index){
            mDetailsFragment.showQuoteAtIndex(index);
        }
    }
}
