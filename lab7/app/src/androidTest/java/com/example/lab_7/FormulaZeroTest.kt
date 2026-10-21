package com.example.lab_7
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Test
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performClick

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    @Test
    fun navigate_to_drivers_add_clear_drivers_and_return_home() {

        // navigate to drivers screen
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        // verify formula zero drivers
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // enter a driver
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Max Verstappen")

        // add a driver
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify driver shows
        composeTestRule
            .onNodeWithText("Max Verstappen")
            .assertExists()

        // clear driver
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // verify that driver is gone
        composeTestRule
            .onNodeWithText("Max Verstappen")
            .assertDoesNotExist()

        // return back to home screen
        composeTestRule
            .onNodeWithTag("driversBackButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

}