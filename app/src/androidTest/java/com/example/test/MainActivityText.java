package com.example.test;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityText {

    private static final String USER_TO_BE_TYPED = "User";
    private static final String PASSWORD_TO_BE_TYPED = "pass";

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void view_elements_are_displayed() {
        onView(withId(R.id.title)).check(matches(isDisplayed()));
        onView(withId(R.id.button)).check(matches(isDisplayed()));
    }

    @Test
    public void view_element_text_are_correct() {
        onView(withId(R.id.title)).check(matches(withText(R.string.test_mainactivity)));
        onView(withId(R.id.button)).check(matches(withText(R.string.next_button_text)));
    }

    @Test
    public void text_changes_when_nextButton_clicked() {
        onView(withId(R.id.button)).check(matches(isClickable()));
        onView(withId(R.id.button))
                .perform(click())
                .check(matches(withText(R.string.back_button_text)));
    }

    @Test
    public void login_form_behaviour() {
        onView(withId(R.id.editText_Username)).perform(typeText(USER_TO_BE_TYPED)).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.editText_Password)).perform(typeText(PASSWORD_TO_BE_TYPED)).perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.button)).check(matches(isClickable()));
        onView(withId(R.id.button))
                .perform(click())
                .check(matches(withText(R.string.logged)));
    }

    @Test
    public void intent_test() {
        onView(withId(R.id.button))
                .perform(click());
        onView(withId(R.id.secondActivity)).check(matches(isDisplayed()));
    }


    @Test
    public void intent_test_round_trip() {
        onView(withId(R.id.button))
                .perform(click());
        onView(withId(R.id.secondActivity)).check(matches(isDisplayed()));

        onView(withId(R.id.back_button))
                .perform(click());
        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()));
    }

    @Test
    public void large_test_function() {
        onView(withId(R.id.editText_Username)).perform(typeText(USER_TO_BE_TYPED)).perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.editText_Password)).perform(typeText(PASSWORD_TO_BE_TYPED)).perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.button))
                .perform(click());

        onView(withId(R.id.secondActivity)).check(matches(isDisplayed()));

        onView(withId(R.id.textView_second)).check(matches(withText("Wellcome Back " + USER_TO_BE_TYPED)));

        onView(withId(R.id.back_button))
                .perform(click());

        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()));

        onView(withId(R.id.editText_Username)).check(matches(withText("")));
        onView(withId(R.id.editText_Password)).check(matches(withText("")));
    }
}
