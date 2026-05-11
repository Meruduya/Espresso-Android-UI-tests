package ru.kkuzmichev.simpleappforespresso;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerActions.open;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class IdlingResourceTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(
                EspressoIdlingResources.idlingResource
        );
    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(
                EspressoIdlingResources.idlingResource
        );
    }

    @Test
    public void testOpenGallery() {
        // Открываем боковое меню
        onView(withId(R.id.drawer_layout))
                .perform(open());

        // Нажимаем Gallery
        ViewInteraction gallery = onView(withId(R.id.nav_gallery));
        gallery.perform(click());

        // Проверяем элемент с числом 7
        ViewInteraction itemSeven = onView(
                allOf(withId(R.id.item_number), withText("7"))
        );
        itemSeven.check(matches(withText("7")));

        // Проверяем что список это RecyclerView
        ViewInteraction recyclerView = onView(withId(R.id.recycle_view));
        recyclerView.check(CustomViewAssertions.isRecyclerView());

// Проверяем количество элементов = 10
        recyclerView.check(matches(CustomViewMatcher.recyclerViewItemCount(10)));
    }
}
