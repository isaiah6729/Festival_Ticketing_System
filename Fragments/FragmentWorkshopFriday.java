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
 * Use the {@link FragmentWorkshopFriday#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentWorkshopFriday extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentWorkshopFriday() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentWorkshopFriday.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentWorkshopFriday newInstance(String param1, String param2) {
        FragmentWorkshopFriday fragment = new FragmentWorkshopFriday();
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
        return inflater.inflate(R.layout.fragment_workshop_friday, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button elena = view.findViewById(R.id.bookElena);
        Button ana = view.findViewById(R.id.bookAna);
        Button fausto = view.findViewById(R.id.bookFausto);
        Button bersy = view.findViewById(R.id.bookBersy);
        Button tito = view.findViewById(R.id.bookTito);

        elena.setOnClickListener(workshop);
        ana.setOnClickListener(workshop);
        fausto.setOnClickListener(workshop);
        bersy.setOnClickListener(workshop);
        tito.setOnClickListener(workshop);
    }


   View.OnClickListener workshop =  new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         if ( v.getId() == R.id.bookElena) {
             try {

                 if (SalsaDataBase.getloggedin().getName() == null) {}

                 else {
                     bookClick1();
                 }
             }
             catch (NullPointerException e) {
                 DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
                 log.show(getChildFragmentManager(), "log");

             }
         }

         else   if ( v.getId() == R.id.bookAna) {
             try {

                 if (SalsaDataBase.getloggedin().getName() == null) {}

                 else {
                     bookClick2();
                 }
             } catch (NullPointerException e) {
                 DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
                 log.show(getChildFragmentManager(), "log");

             }
         }

         else   if ( v.getId() == R.id.bookBersy) {
             try {

                 if (SalsaDataBase.getloggedin().getName() == null) {}

                 else {
                     bookClick3();
                 }
             } catch (NullPointerException e) {
                 DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
                 log.show(getChildFragmentManager(), "log");

             }
         }

         else  if ( v.getId() == R.id.bookFausto) {
             try {

                 if (SalsaDataBase.getloggedin().getName() == null) {}

                 else {
                     bookClick4();
                 }
             } catch (NullPointerException e) {
                 DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
                 log.show(getChildFragmentManager(), "log");

             }
         }

         else   if ( v.getId() == R.id.bookTito) {
             try {

                 if (SalsaDataBase.getloggedin().getName() == null) {}

                 else {
                     bookClick5();
                 }
             } catch (NullPointerException e) {
                 DialogFragment_LogIn_First log = new DialogFragment_LogIn_First();
                 log.show(getChildFragmentManager(), "log");

             }
         }
        }
    };

    public void bookClick1() {
        int workshopnumber = 1;

        Intent transferElena = new Intent(getActivity(), CheckOutPage.class);
        transferElena.putExtra("elena", workshopnumber);
        startActivity(transferElena);
    }

    public void bookClick2() {
        int workshopnumber = 2;

        Intent transferana = new Intent(getActivity(), CheckOutPage.class);
        transferana.putExtra("ana", workshopnumber);
        startActivity(transferana);
    }

    public void bookClick3() {
        int workshopnumber = 4;

        Intent bersy = new Intent(getActivity(), CheckOutPage.class);
        bersy.putExtra("bersy", workshopnumber);
        startActivity(bersy);
    }

    public void bookClick4() {
        int workshopnumber = 3;

        Intent fausto = new Intent(getActivity(), CheckOutPage.class);
        fausto.putExtra("fausto", workshopnumber);
        startActivity(fausto);
    }

    public void bookClick5() {
        int workshopnumber = 5;

        Intent tito = new Intent(getActivity(), CheckOutPage.class);
        tito.putExtra("tito", workshopnumber);
        startActivity(tito);
    }

}