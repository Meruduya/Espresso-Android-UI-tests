package ru.kkuzmichev.simpleappforespresso;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.ViewAssertion;

import static org.junit.Assert.assertTrue;

public class CustomViewAssertions {

    public static ViewAssertion isRecyclerView() {
        return (view, noViewFoundException) -> {
            if (noViewFoundException != null) throw noViewFoundException;
            assertTrue("View не является RecyclerView", view instanceof RecyclerView);
        };
    }
}