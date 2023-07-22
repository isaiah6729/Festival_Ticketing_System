package Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zybooks.testworldsalsa.CheckOutPage;
import com.zybooks.testworldsalsa.R;
import com.zybooks.testworldsalsa.SalsaDataBase;

import DialogFragments.DialogFragment_LogIn_First;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentWorkshopSaturday#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentWorkshopSaturday extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentWorkshopSaturday() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentWorkshopSaturday.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentWorkshopSaturday newInstance(String param1, String param2) {
        FragmentWorkshopSaturday fragment = new FragmentWorkshopSaturday();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workshop_saturday, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    Button elena = view.findViewById(R.id.bookElena2);
        Button ana = view.findViewById(R.id.bookAna2);
        Button fausto = view.findViewById(R.id.bookFausto2);
        Button bersy = view.findViewById(R.id.bookBersy2);
        Button tito = view.findViewById(R.id.bookTito2);

        elena.setOnClickListener(workshop1);
        ana.setOnClickListener(workshop1);
        fausto.setOnClickListener(workshop1);
        bersy.setOnClickListener(workshop1);
        tito.setOnClickListener(workshop1);
    }


  View.OnClickListener workshop1 = new View.OnClickListener() {
      @Override
      public void onClick(View v) {

              if ( v.getId() == R.id.bookElena2) {
                  try {

                      if (SalsaDataBase.getloggedin().getName() == null) {}

                      else {
                          bookClick6();
                      }
                  }
                  catch (NullPointerException e) {
                      DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
                      log.show(getChildFragmentManager(), "log");

                  }
              }

              else   if ( v.getId() == R.id.bookAna2) {

                  try {

                      if (SalsaDataBase.getloggedin().getName() == null) {}

                      else {
                          bookClick7();
                      }
                  }
                  catch (NullPointerException e) {
                      DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
                      log.show(getChildFragmentManager(), "log");

                  }
              }

              else   if ( v.getId() == R.id.bookFausto2) {

                  try {

                      if (SalsaDataBase.getloggedin().getName() == null) {}

                      else {
                          bookClick9();
                      }
                  }
                  catch (NullPointerException e) {
                      DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
                      log.show(getChildFragmentManager(), "log");

                  }
              }

              else  if ( v.getId() == R.id.bookBersy2) {
                  try {

                      if (SalsaDataBase.getloggedin().getName() == null) {}

                      else {
                          bookClick8();
                      }
                  }
                  catch (NullPointerException e) {
                      DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
                      log.show(getChildFragmentManager(), "log");

                  }
              }

              else   if ( v.getId() == R.id.bookTito2) {
                  try {

                      if (SalsaDataBase.getloggedin().getName() == null) {}
                      else {
                          bookClick10();
                      }
                  }
                  catch (NullPointerException e) {
                      DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
                      log.show(getChildFragmentManager(), "log");

                  }
              }

      }
  };


    public void bookClick6() {
        int workshopnumber = 6;

        Intent transferElena = new Intent(getActivity(), CheckOutPage.class);
        transferElena.putExtra("elena", workshopnumber);
        startActivity(transferElena);
    }

    public void bookClick7() {
        int workshopnumber = 7;

        Intent transferana = new Intent(getActivity(), CheckOutPage.class);
        transferana.putExtra("ana", workshopnumber);
        startActivity(transferana);
    }

    public void bookClick8() {
        int workshopnumber = 9;

        Intent bersy = new Intent(getActivity(), CheckOutPage.class);
        bersy.putExtra("bersy", workshopnumber);
        startActivity(bersy);
    }

    public void bookClick9() {
        int workshopnumber = 8;

        Intent fausto = new Intent(getActivity(), CheckOutPage.class);
        fausto.putExtra("fausto", workshopnumber);
        startActivity(fausto);
    }

    public void bookClick10() {
        int workshopnumber = 10;

        Intent tito = new Intent(getActivity(), CheckOutPage.class);
        tito.putExtra("tito", workshopnumber);
        startActivity(tito);
    }
}