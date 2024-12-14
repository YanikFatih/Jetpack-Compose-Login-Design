package com.example.mylogindesign

import android.content.res.Resources.Theme
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylogindesign.ui.theme.AppBarColor
import com.example.mylogindesign.ui.theme.AppBarColorDark
import com.example.mylogindesign.ui.theme.ButtonTextColor
import com.example.mylogindesign.ui.theme.GreyMain
import com.example.mylogindesign.ui.theme.MainColor
import com.example.mylogindesign.ui.theme.MyLoginDesignTheme
import com.example.mylogindesign.ui.theme.Pink80
import com.example.mylogindesign.ui.theme.Purple40
import com.example.mylogindesign.ui.theme.TextColor1
import com.example.mylogindesign.ui.theme.gabarito
import com.example.mylogindesign.ui.theme.nunito
import com.example.mylogindesign.ui.theme.outfit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginDesignTheme {
                LoginPage()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(darkTheme:Boolean = isSystemInDarkTheme()) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp //This values are used to keep better design view in different screens
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(stringResource(R.string.loginTitle), fontFamily = nunito, fontWeight = FontWeight.Bold, fontSize = (screenWidth/16).sp) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = if(darkTheme) AppBarColorDark else AppBarColor, //Dark theme difference for Appbar
                titleContentColor = ButtonTextColor
            )
        )
    }) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painterResource(R.drawable.profile),"")
            Text(stringResource(R.string.WelcomeText), color = TextColor1, fontFamily = outfit, fontWeight = FontWeight.Bold, fontSize = (screenWidth/18).sp)
            Button(
                modifier = Modifier.height((screenHeight/15).dp).width((screenWidth/1.5).dp),
                shape = RoundedCornerShape(12.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = if(darkTheme) AppBarColorDark else AppBarColor, //Dark theme difference for Login Button
                    contentColor = ButtonTextColor
                )
            ) {
                Text(stringResource(R.string.loginBtnText), color = ButtonTextColor, fontFamily = gabarito, fontSize = (screenWidth/20).sp)
            } // Button (Login)
            Text(stringResource(R.string.orContWithText), color = TextColor1, fontFamily = outfit, fontWeight = FontWeight.Bold, fontSize = (screenWidth/24).sp)
            Row(
                modifier = Modifier.fillMaxWidth().padding(start = (screenWidth/3).dp, end = (screenWidth/3).dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                MyIconBtn(Icons.Filled.MailOutline, screenHeight/22, screenWidth/12)
                MyIconBtn(Icons.Filled.Phone, screenHeight/22, screenWidth/12)
            } //Row
            Row(
                modifier = Modifier.fillMaxWidth().padding(start = (screenWidth/8).dp, end = (screenWidth/8).dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(stringResource(R.string.dontHaveAccountText), color = TextColor1, fontFamily = outfit, fontWeight = FontWeight.Bold, fontSize = (screenWidth/25).sp)
                Button(
                    modifier = Modifier.height((screenHeight/24).dp).width((screenWidth/3.5).dp),
                    onClick = {},
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GreyMain,
                        contentColor = ButtonTextColor
                    )
                ) {
                    Text(stringResource(R.string.createNowBtnText), color = ButtonTextColor, fontFamily = gabarito, fontSize = (screenWidth/29).sp)
                } // Button (Create now)
                //TextButton can be used instead
            } //Row
        } //Column
        
    }
}

@Composable
fun MyIconBtn(icon:ImageVector, height:Int, width:Int) { //creating own IconButton widget
    IconButton(onClick = {}) {
        Icon(icon,"", modifier = Modifier.height((height).dp).width((width).dp))
    }
}

@Preview(showBackground = true, locale = "tr") //"tr" added to test language in preview
@Composable
fun LoginPreview() {
    MyLoginDesignTheme {
        LoginPage()
    }
}