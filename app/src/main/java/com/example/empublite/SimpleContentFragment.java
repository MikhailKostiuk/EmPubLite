package com.example.empublite;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewFragment;

public class SimpleContentFragment extends WebViewFragment {

    private static final String KEY_FILE="file";

    static SimpleContentFragment newInstance(String file) {
        SimpleContentFragment scf = new SimpleContentFragment();

        Bundle args = new Bundle();
        args.putString(KEY_FILE, file);
        scf.setArguments(args);

        return scf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = super.onCreateView(inflater, container, savedInstanceState);

        getWebView().getSettings().setJavaScriptEnabled(true);
        getWebView().getSettings().setSupportZoom(true);
        getWebView().getSettings().setBuiltInZoomControls(true);
        getWebView().loadUrl(getPage());

        return result;
    }

    private String getPage() {
        return getArguments().getString(KEY_FILE);
    }
}
