package com.jy.revook_1111;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SearchFragment extends Fragment {

    private final String SEARCH_WITH_TITLE = "d_titl";
    private final String SEARCH_WITH_AUTHOR = "d_auth";
    private final String SEARCH_WITH_ISBN = "d_isbn";
    private final String SEARCH_WITH_PUBLISHER = "d_publ";

    private ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        ImageView img_recommand_1 = (ImageView) v.findViewById(R.id.img_recommand_1);
        Glide.with(container.getContext()).load(R.drawable.cardview_default).into(img_recommand_1);
        ImageView img_recommand_2 = (ImageView) v.findViewById(R.id.img_recommand_2);
        Glide.with(container.getContext()).load(R.drawable.cardview_default2).into(img_recommand_2);
        ImageView img_recommand_3 = (ImageView) v.findViewById(R.id.img_recommand_3);
        Glide.with(container.getContext()).load(R.drawable.cardview_default3).into(img_recommand_3);

        final EditText edittext_search = (EditText) v.findViewById(R.id.edittext_search);
        Button btn_search = (Button) v.findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(){
                    public void run(){
                        if(APISearchNaverBook.bookInfoList != null)
                        {
                            APISearchNaverBook.bookInfoList.clear();
                        }

                        APISearchNaverBook.search(edittext_search.getText().toString(), SEARCH_WITH_TITLE);

                        startActivity(new Intent(getActivity(), temp_bookCard.class));

                    }
                }.start();



            }
        });

        Button temp_move_to_bookinfo = (Button) v.findViewById(R.id.temp_move_to_bookinfo);
        temp_move_to_bookinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(),BookInfoActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

    public void bookSearch()
    {

    }
}
