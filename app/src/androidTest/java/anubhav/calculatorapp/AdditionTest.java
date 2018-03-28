package anubhav.calculatorapp;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AdditionTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void additionTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.button1), withText("Standard Calculator"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                        1),
                                0),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.num2), withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                        1),
                                11),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.plus), withText("+"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                        1),
                                16),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.num2), withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                        1),
                                11),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.equal), withText("="),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                        1),
                                20),
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction editText = onView(
                allOf(withId(R.id.editText2), withText("4.0"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        1),
                                1),
                        isDisplayed()));
        editText.check(matches(withText("4.0")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
