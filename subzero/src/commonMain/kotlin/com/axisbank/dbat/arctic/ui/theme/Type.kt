
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.axisbank.dbat.arctic.font
import com.axisbank.dbat.arctic.ui.theme.Style
import com.axisbank.dbat.arctic.ui.theme.sz_color_typo_primary
import com.axisbank.dbat.arctic.ui.theme.sz_typo_character_spacing_alps
import com.axisbank.dbat.arctic.ui.theme.sz_typo_character_spacing_arctic
import com.axisbank.dbat.arctic.ui.theme.sz_typo_character_spacing_himalayas
import com.axisbank.dbat.arctic.ui.theme.sz_typo_character_spacing_hindukush
import com.axisbank.dbat.arctic.ui.theme.sz_typo_character_spacing_zero
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_bitterCold
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_blazing
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_blizzard
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_cold
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_cool
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frigid
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_frostbite
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_iceAge
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_mild
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_torrid
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_tropical
import com.axisbank.dbat.arctic.ui.theme.sz_typo_font_size_warm
import com.axisbank.dbat.arctic.ui.theme.sz_typo_line_height_deepFreeze
import com.axisbank.dbat.arctic.ui.theme.sz_typo_line_height_gelid
import com.axisbank.dbat.arctic.ui.theme.sz_typo_line_height_glacial
import com.axisbank.dbat.arctic.ui.theme.sz_typo_line_height_iceAge
import com.axisbank.dbat.arctic.ui.theme.sz_typo_line_height_quickFreeze
import com.axisbank.dbat.arctic.ui.theme.sz_typo_line_height_zero

@Composable
fun getStyle(): Style {

    val latoRegular = FontFamily(
        font(
            "Lato", "lato_regular", FontWeight.Normal, FontStyle.Normal
        )
    )
    val latoSemiBold = FontFamily(
        font(
            "Lato", "lato_semi_bold", FontWeight.Normal, FontStyle.Normal
        )
    )
    val latoBold = FontFamily(
        font(
            "lato", "lato_bold", FontWeight.Normal, FontStyle.Normal
        )
    )
    val latoBoldItalic = FontFamily(
        font(
            "lato", "lato_bold_italic", FontWeight.Normal, FontStyle.Normal
        )
    )
    return Style(
        //Display Styles
        SZ_Typo_Display_Bold_Large = TextStyle(
            fontFamily = latoBold,
            lineHeight = sz_typo_line_height_gelid,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_torrid,
            letterSpacing = (sz_typo_character_spacing_zero).sp
        ),
        SZ_Typo_Display_BoldItalic_Large = TextStyle(
            fontFamily = latoBoldItalic,
            lineHeight = sz_typo_line_height_gelid,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_torrid,
            letterSpacing = (sz_typo_character_spacing_zero).sp
        ),
        SZ_Typo_Display_Bold_Medium = TextStyle(
            fontFamily = latoBold,
            lineHeight = sz_typo_line_height_gelid,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_blazing,
            letterSpacing = (sz_typo_character_spacing_zero).sp
        ),
        SZ_Typo_Display_BoldItalic_Medium = TextStyle(
            fontFamily = latoBoldItalic,
            lineHeight = sz_typo_line_height_gelid,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_blazing,
            letterSpacing = (sz_typo_character_spacing_zero).sp
        ),
        SZ_Typo_Display_Bold_Small = TextStyle(
            fontFamily = latoBold,
            lineHeight = sz_typo_line_height_quickFreeze,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_tropical,
            letterSpacing = (sz_typo_character_spacing_zero).sp
        ),
        SZ_Typo_Display_BoldItalic_Small = TextStyle(
            fontFamily = latoBoldItalic,
            lineHeight = sz_typo_line_height_quickFreeze,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_tropical,
            letterSpacing = (sz_typo_character_spacing_zero).sp
        ),

        //Heading Styles
        SZ_Typo_Heading_Bold_ExtraLarge = TextStyle(
            fontFamily = latoBold,
            lineHeight = sz_typo_line_height_iceAge,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_warm,
            letterSpacing = (sz_typo_character_spacing_zero).sp
        ),
        SZ_Typo_Heading_BoldItalic_ExtraLarge = TextStyle(
            fontFamily = latoBoldItalic,
            lineHeight = sz_typo_line_height_iceAge,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_warm,
            letterSpacing = (sz_typo_character_spacing_zero).sp
        ),
        SZ_Typo_Heading_Bold_Large = TextStyle(
            fontFamily = latoBold,
            lineHeight = sz_typo_line_height_glacial,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_mild,
            letterSpacing = (sz_typo_character_spacing_zero).sp
        ),
        SZ_Typo_Heading_BoldItalic_Large = TextStyle(
            fontFamily = latoBoldItalic,
            lineHeight = sz_typo_line_height_glacial,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_mild,
            letterSpacing = (sz_typo_character_spacing_zero).sp
        ),
        SZ_Typo_Heading_Bold_Medium = TextStyle(
            fontFamily = latoBold,
            lineHeight = sz_typo_line_height_gelid,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_cool,
            letterSpacing = (sz_typo_character_spacing_himalayas).sp
        ),
        SZ_Typo_Heading_BoldItalic_Medium = TextStyle(
            fontFamily = latoBoldItalic,
            lineHeight = sz_typo_line_height_gelid,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_cool,
            letterSpacing = (sz_typo_character_spacing_himalayas).sp
        ),
        SZ_Typo_Heading_Bold_Small = TextStyle(
            fontFamily = latoBold,
            lineHeight = sz_typo_line_height_gelid,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_cold,
            letterSpacing = (sz_typo_character_spacing_himalayas).sp
        ),
        SZ_Typo_Heading_BoldItalic_Small = TextStyle(
            fontFamily = latoBoldItalic,
            lineHeight = sz_typo_line_height_gelid,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_cold,
            letterSpacing = (sz_typo_character_spacing_himalayas).sp
        ),
        SZ_Typo_Heading_Bold_ExtraSmall = TextStyle(
            fontFamily = latoBold,
            lineHeight = sz_typo_line_height_quickFreeze,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_bitterCold,
            letterSpacing = (sz_typo_character_spacing_himalayas).sp
        ),
        SZ_Typo_Heading_BoldItalic_ExtraSmall = TextStyle(
            fontFamily = latoBoldItalic,
            lineHeight = sz_typo_line_height_quickFreeze,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_bitterCold,
            letterSpacing = (sz_typo_character_spacing_himalayas).sp
        ),

        //Sub Heading Styles
        SZ_Typo_Subheading_SemiBold_Large = TextStyle(
            fontFamily = latoSemiBold,
            lineHeight = sz_typo_line_height_quickFreeze,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_frigid,
            letterSpacing = (sz_typo_character_spacing_hindukush).sp
        ),
        SZ_Typo_Subheading_SemiBold_Default = TextStyle(
            fontFamily = latoSemiBold,
            lineHeight = sz_typo_line_height_quickFreeze,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_frostbite,
            letterSpacing = (sz_typo_character_spacing_hindukush).sp
        ),

        //Body Styles
        SZ_Typo_Body_Regular_Large = TextStyle(
            fontFamily = latoRegular,
            lineHeight = sz_typo_line_height_glacial,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_bitterCold,
            letterSpacing = (sz_typo_character_spacing_himalayas).sp
        ),
        SZ_Typo_Body_Bold_Large = TextStyle(
            fontFamily = latoBold,
            lineHeight = sz_typo_line_height_glacial,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_bitterCold,
            letterSpacing = (sz_typo_character_spacing_himalayas).sp
        ),
        SZ_Typo_Body_Regular_Medium = TextStyle(
            fontFamily = latoRegular,
            lineHeight = sz_typo_line_height_gelid,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_frigid,
            letterSpacing = (sz_typo_character_spacing_hindukush).sp
        ),
        SZ_Typo_Body_Bold_Medium = TextStyle(
            fontFamily = latoBold,
            lineHeight = sz_typo_line_height_gelid,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_frigid,
            letterSpacing = (sz_typo_character_spacing_hindukush).sp
        ),
        SZ_Typo_Body_Regular_Small = TextStyle(
            fontFamily = latoRegular,
            lineHeight = sz_typo_line_height_gelid,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_frostbite,
            letterSpacing = (sz_typo_character_spacing_alps).sp
        ),
        SZ_Typo_Body_Bold_Small = TextStyle(
            fontFamily = latoBold,
            lineHeight = sz_typo_line_height_gelid,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_frostbite,
            letterSpacing = (sz_typo_character_spacing_alps).sp
        ),

        //Support Styles
        SZ_Typo_Support_Regular_Info = TextStyle(
            fontFamily = latoRegular,
            lineHeight = sz_typo_line_height_quickFreeze,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_blizzard,
            letterSpacing = (sz_typo_character_spacing_alps).sp
        ),
        SZ_Typo_Support_Regular_Footnote = TextStyle(
            fontFamily = latoRegular,
            lineHeight = sz_typo_line_height_deepFreeze,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_iceAge,
            letterSpacing = (sz_typo_character_spacing_alps).sp
        ),
        SZ_Typo_Support_Bold_TextButton = TextStyle(
            fontFamily = latoBold,
            lineHeight = sz_typo_line_height_zero,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_frostbite,
            letterSpacing = (sz_typo_character_spacing_arctic).sp
        ),
        SZ_Typo_Support_Regular_Metadata = TextStyle(
            fontFamily = latoRegular,
            lineHeight = sz_typo_line_height_zero,
            color = sz_color_typo_primary,
            fontSize = sz_typo_font_size_frostbite,
            letterSpacing = (sz_typo_character_spacing_alps).sp
        )
    )
}