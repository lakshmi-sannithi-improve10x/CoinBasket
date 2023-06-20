package com.improve10x.coinbasket.network;

import com.improve10x.coinbasket.Constants;
import com.improve10x.coinbasket.model.Coin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinServiceApi {

    @GET(Constants.KEY_COINS_END_POINT)
    Call<List<Coin>> getCoins();
}
