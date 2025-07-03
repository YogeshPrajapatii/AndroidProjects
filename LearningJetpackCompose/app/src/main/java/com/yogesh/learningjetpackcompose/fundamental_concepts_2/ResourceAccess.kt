package com.yogesh.learningjetpackcompose.fundamental_concepts_2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import com.yogesh.learningjetpackcompose.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ResourceAccess(){
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ){
        Text(text = stringResource(R.string.shortcut), color = colorResource(R.color.test))
    }
}

@Composable
fun AccessingImage(){
    Box(modifier= Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter)
    {
        Image(painter = painterResource(R.drawable.employee), contentDescription = "Employee Image")
        
    }
}




@Preview(showSystemUi = true)
@Composable
fun Preview(){
  /*  ResourceAccess()
    AccessingImage()*/
}