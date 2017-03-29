package com.example.fragmentquoteactivity;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Pablo Garcia on 27/03/2017.
 */

public class titlesClass extends ListFragment {
    private ListSelectionListener mListener = null;
    public static final String TAG = "titlesClass";

    public interface ListSelectionListener{
        public void onListSelection(int index);
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id){
        Log.i(TAG, "Pos= "+pos+" ID = " +id);
        getListView().setItemChecked(pos, true);
        mListener.onListSelection(pos);
    }


    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            mListener = (ListSelectionListener)  activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "must implement OnArticleSelectedList");
        }
    }

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return super.onCreateView(inflater, container, savedInstance);
    }

    @Override
    public void onActivityCreated(Bundle savedInstance){
        super.onActivityCreated(savedInstance);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.titles, QuoteViewerActivity.mTitleArray));
    }

}
