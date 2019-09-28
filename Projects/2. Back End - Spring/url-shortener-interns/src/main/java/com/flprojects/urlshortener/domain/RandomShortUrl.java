package com.flprojects.urlshortener.domain;

public interface RandomShortUrl extends ShortUrl{
    String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    char[] getRandomShortUrl();
}
