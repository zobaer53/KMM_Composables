import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.axisbank.dbat.arctic.font

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp

    )
)

@Composable
fun getTypography(): Typography {

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
    return Typography(
        h1 = TextStyle(
            fontFamily = latoBold,
            fontWeight = FontWeight.Bold,
            fontSize = 52.sp,
        ),
        h2 = TextStyle(fontFamily = latoBold, fontWeight = FontWeight.Bold, fontSize = 24.sp),
        h3 = TextStyle(
            fontFamily = latoBold,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        ),
        h4 = TextStyle(
            fontFamily = latoBold,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        ),
        h5 = TextStyle(fontFamily = latoBold, fontWeight = FontWeight.Bold, fontSize = 14.sp),
        h6 = TextStyle(
            fontFamily = latoSemiBold,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
        ),
        subtitle1 = TextStyle(
            fontFamily = latoSemiBold,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
        ),
        subtitle2 = TextStyle(
            fontFamily = latoRegular,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
        ),
        body1 = TextStyle(
            fontFamily = latoRegular, fontWeight = FontWeight.Normal, fontSize = 14.sp
        ),
        body2 = TextStyle(fontFamily = latoRegular, fontSize = 10.sp),
//        button = TextStyle(
//            fontFamily = nunitoRegular,
//            fontWeight = FontWeight.Normal,
//            fontSize = 15.sp,
//            color =
//        ),
        caption = TextStyle(
            fontFamily = latoRegular, fontWeight = FontWeight.Normal, fontSize = 8.sp
        ),
        overline = TextStyle(
            fontFamily = latoRegular, fontWeight = FontWeight.Normal, fontSize = 12.sp
        )
    )
}