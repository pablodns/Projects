package com.example.fragmentquoteactivity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Pablo Garcia on 27/03/2017.
 */
public class CompanyDetails extends Fragment{
    private TextView mQuoteView = null;
    private int mCurIdx = -1;
    private int mQuoteArrayLen;

    private static final String TAG ="CompanyDetails";

    public int getShownIndex(){
        return mCurIdx;
    }

    public void showQuoteAtIndex(int newIndex){
        if (newIndex < 0 || newIndex >=mQuoteArrayLen){
            return;
        }
        mCurIdx = newIndex;
        mQuoteView.setText(QuoteViewerActivity.mDescriptionArray[mCurIdx]);
    }

    @Override
    public  void onAttach(Context activity){
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.details, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstance){
        super.onActivityCreated(savedInstance);
        mQuoteView = (TextView) getActivity().findViewById(R.id.quoteView);
        mQuoteArrayLen = QuoteViewerActivity.mDescriptionArray.length;
    }

}
