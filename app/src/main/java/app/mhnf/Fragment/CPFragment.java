package app.mhnf.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mhnf.com.R;


/**
 * NIM : 10116369
 * Nama : Muhammad Habib Nur Fauzan
 * Kelas : IF-8
 * Tanggal Pengerjaan : 9 Agustus 2019
 */

public class CPFragment extends Fragment {


    public CPFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cp, container, false);
    }

}
