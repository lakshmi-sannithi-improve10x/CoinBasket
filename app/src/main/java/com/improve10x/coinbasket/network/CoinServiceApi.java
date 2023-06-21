package com.improve10x.coinbasket.network;

import com.improve10x.coinbasket.Constants;
import com.improve10x.coinbasket.model.Coin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CoinServiceApi {

    @GET(Constants.KEY_COINS_END_POINT)
    Call<List<Coin>> getCoins();

    @GET(Constants.KEY_COINS_END_POINT+"/{id}")
    Call<Coin> getCoinDetails(@Path("id")String id);
}
