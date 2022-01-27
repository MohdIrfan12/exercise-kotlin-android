package com.mia.legacy.ui


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.mia.legacy.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LauncherActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(LauncherActivity::class.java)

    @Test
    fun launcherActivityTest() {

        val materialButton = onView(
            allOf(
                withId(R.id.btnContinue), withText("Continue"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment_container),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val appCompatEditText = onView(
            allOf(
                withId(R.id.etUserName),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment_container),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(longClick())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(50)

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.etUserName),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment_container),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("mnamsnam"), closeSoftKeyboard())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.etUserName), withText("mnamsnam"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment_container),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(click())

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.etPassword),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment_container),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(replaceText(""), closeSoftKeyboard())


        val materialButton2 = onView(
            allOf(
                withId(R.id.btnContinue), withText("Continue"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment_container),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton2.perform(click())

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.etPassword),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment_container),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText5.perform(replaceText("namnsma"), closeSoftKeyboard())

        val materialButton3 = onView(
            allOf(
                withId(R.id.btnContinue), withText("Continue"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment_container),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton3.perform(click())

        val appCompatEditText6 = onView(
            allOf(
                withId(R.id.etProfession),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment_container),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText6.perform(replaceText("namnsman"), closeSoftKeyboard())

        val appCompatEditText7 = onView(
            allOf(
                withId(R.id.etSummary),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment_container),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText7.perform(replaceText("ansmanmns"), closeSoftKeyboard())


        val materialButton4 = onView(
            allOf(
                withId(R.id.btnContinue), withText("Continue"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.nav_host_fragment_container),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton4.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
