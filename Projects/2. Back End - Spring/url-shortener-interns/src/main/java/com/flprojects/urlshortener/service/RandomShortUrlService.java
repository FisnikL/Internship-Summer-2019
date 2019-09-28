package com.flprojects.urlshortener.service;

import com.flprojects.urlshortener.domain.RandomShortUrl;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class RandomShortUrlService implements RandomShortUrl {

    private int length;

    public RandomShortUrlService(){
        this(4);
    }

    public RandomShortUrlService(int length) {
        this.length = length;
    }

    public char[] getRandomShortUrl(){

        char[] randomShortUrl = new char[length];
        Random random = new Random();

        for(int i = 0; i < length; ++i){
            randomShortUrl[i] = chars.charAt(random.nextInt(length));
        }

        return randomShortUrl;
    }

    public long shortURLtoID()
    {
        char[] randomShortUrl = getRandomShortUrl();

        long id = 0;

        for (int i = 0; i < randomShortUrl.length ; i++)
        {
            if ('a' <= randomShortUrl[i] &&  randomShortUrl[i] <= 'z')
                id = id*62 +  randomShortUrl[i] - 'a';
            if ('A' <=  randomShortUrl[i] && randomShortUrl[i] <= 'Z')
                id = id*62 +  randomShortUrl[i] - 'A' + 26;
            if ('0' <=  randomShortUrl[i] &&  randomShortUrl[i] <= '9')
                id = id*62 +  randomShortUrl[i] - '0' + 52;
        }
        return id;
    }
}
