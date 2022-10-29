package com.imashnake.coinsnd.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imashnake.coinsnd.R

@Composable
fun Home() {
    Box(Modifier.padding(dimensionResource(R.dimen.large_padding))) {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            for (coin in Coin.values()) {
                Coin(
                    coin = coin,
                    image = coin.image,
                    label = { value, symbol -> "$value$symbol" }
                )
            }
        }
    }
}

@Composable
fun Coin(
    coin: Coin,
    @DrawableRes image: Int,
    label: (coinValue: Int, coinSymbol: String) -> String
) {
    Box(Modifier.wrapContentSize()) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "${coin.value}${coin.symbol}"
        )
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .clip(CircleShape)
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .padding(dimensionResource(R.dimen.coin_label_padding))
                .padding(bottom = 2.dp)
        ) {
            Text(
                text = label(coin.value, coin.symbol),
                modifier = Modifier,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Preview
@Composable
fun CoinPreview() {
    Coin(
        coin = Coin.Quarter,
        image = R.drawable.quarter_25,
        label = { value, symbol -> "$value$symbol" }
    )
}

@Preview
@Composable
fun HomePreview() {
    Home()
}
