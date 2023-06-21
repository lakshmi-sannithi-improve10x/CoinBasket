package com.improve10x.coinbasket;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.improve10x.coinbasket.model.Coin;
import com.improve10x.coinbasket.network.CoinApi;
import com.improve10x.coinbasket.network.CoinServiceApi;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public  void getCoinList() throws IOException {
        CoinServiceApi coinServiceApi = new CoinApi().createCoinServiceApi();
        Call<List<Coin>> call = coinServiceApi.getCoins();
        List<Coin> coins = call.execute().body();
        assertNotNull(coins);
        assertFalse(coins.isEmpty());
        System.out.println(new Gson().toJson(coins));
    }

   @Test
   public void  getCoinDetails() throws IOException {
        CoinServiceApi coinServiceApi = new CoinApi().createCoinServiceApi();
        Call<Coin> call = coinServiceApi.getCoinDetails("btc-bitcoin");
        Coin coin = call.execute().body();
        assertNotNull(coin);
        System.out.println(new Gson().toJson(coin));
    }
}