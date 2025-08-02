package com.elianan.teller.models

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.elianan.teller.R
import com.elianan.teller.ui.theme.ColourFamily
import com.elianan.teller.ui.theme.amethystFamilyDark
import com.elianan.teller.ui.theme.amethystFamilyLight
import com.elianan.teller.ui.theme.jadeFamilyDark
import com.elianan.teller.ui.theme.jadeFamilyLight
import com.elianan.teller.ui.theme.jasperFamilyDark
import com.elianan.teller.ui.theme.jasperFamilyLight
import com.elianan.teller.ui.theme.lapisLazuliFamilyDark
import com.elianan.teller.ui.theme.lapisLazuliFamilyLight
import com.elianan.teller.ui.theme.tigersEyeFamilyDark
import com.elianan.teller.ui.theme.tigersEyeFamilyLight

enum class Arcat(
    val nameStringId: Int,
    val iconId: Int,
    val colourFamilyLight: ColourFamily,
    val colourFamilyDark: ColourFamily
) {

    GRETCHEN(R.string.gretchen, R.drawable.sharp_house_24,
        amethystFamilyLight, amethystFamilyDark
    ),
    GREMLIN(R.string.gremlin, R.drawable.sharp_newsstand_24,
        jadeFamilyLight, jadeFamilyDark
    ),
    GREBE(R.string.grebe, R.drawable.sharp_savings_24,
        lapisLazuliFamilyLight, lapisLazuliFamilyDark
    ),
    GRENT(R.string.grent, R.drawable.sharp_account_balance_24,
        jasperFamilyLight, jasperFamilyDark
    ),
    GRELD(R.string.greld, R.drawable.sharp_money_bag_24,
        tigersEyeFamilyLight, tigersEyeFamilyDark
    );

    @Composable
    fun colour(): Color {
        return if (isSystemInDarkTheme()) colourFamilyDark.colour else colourFamilyLight.colour
    }
    @Composable
    fun onColour(): Color {
        return if(isSystemInDarkTheme()) colourFamilyDark.onColour else colourFamilyLight.onColour
    }
    @Composable
    fun containerColour(): Color {
        return if(isSystemInDarkTheme()) colourFamilyDark.colourContainer else colourFamilyLight.colourContainer
    }
    @Composable
    fun onContainerColour(): Color {
        return if(isSystemInDarkTheme()) colourFamilyDark.onColourContainer else colourFamilyLight.onColourContainer
    }

}