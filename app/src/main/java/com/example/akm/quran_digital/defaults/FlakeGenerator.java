package com.example.akm.quran_digital.defaults;

import com.github.rholder.fauxflake.IdGenerators;
import com.github.rholder.fauxflake.api.IdGenerator;

/**
 * Created by AKM on 1/30/18.
 */

public class FlakeGenerator {

    public static String generate() {
        try {
            IdGenerator snowflake = IdGenerators.newSnowflakeIdGenerator();

            return snowflake.generateId(1000).asString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
