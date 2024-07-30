package io.github.miensoap.kishelper;

import io.github.miensoap.kishelper.core.KISClient;
import io.github.miensoap.kishelper.util.ConfigLoader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        KISClient kisClient = KISClient.getInstance();
        System.out.println(ConfigLoader.getAccessToken());
        System.out.println(kisClient.getOverseasDailyPrice("AMS", "SOXL", false).size());
    }
}
