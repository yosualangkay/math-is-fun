package org.pa.mathisfun

import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.pa.mathisfun.menu.MainActivity

@LargeTest
@RunWith(AndroidJUnit4::class)
class CariMateriTest {

    @Rule
    @JvmField
//    var mActivityTestRule = ActivityTestRule(SplashScreen::class.java)
    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun cariMateriTest() {
        val appCompatImageView = onView(
            allOf(
                withId(R.id.imagesemuamateri),
                childAtPosition(
                    allOf(
                        withId(R.id.layout_utama),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatImageView.perform(click())

        val actionMenuItemView = onView(
            allOf(
                withId(R.id.action_search), withContentDescription("Search"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.action_bar),
                        2
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        actionMenuItemView.perform(click())

        val searchAutoComplete = onView(
            allOf(
                withId(R.id.search_src_text),
                childAtPosition(
                    allOf(
                        withId(R.id.search_plate),
                        childAtPosition(
                            withId(R.id.search_edit_frame),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        searchAutoComplete.perform(replaceText("pola bilangan"), closeSoftKeyboard())

        val materialTextView = onView(
            allOf(
                withId(R.id.namaMateri), withText("Pola Bilangan"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.rvMateri),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialTextView.perform(click())
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
