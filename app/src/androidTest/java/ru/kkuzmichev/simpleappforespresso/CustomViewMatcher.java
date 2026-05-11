package ru.kkuzmichev.simpleappforespresso;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class CustomViewMatcher {

    public static Matcher<View> recyclerViewItemCount(int count) {
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {

            @Override
            public void describeTo(Description description) {
                description.appendText("RecyclerView с количеством элементов: " + count);
            }

            @Override
            protected boolean matchesSafely(RecyclerView view) {
                return view.getAdapter().getItemCount() == count;
            }
        };
    }
}
