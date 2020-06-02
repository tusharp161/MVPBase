package com.tusharp161.basemvp.domain.model;

import com.squareup.moshi.Json;

public class SampleEntity {

    @Json(name = "asdf")
    String sampleString = "Usecase Testing Success";

    public String getSampleString() {
        return sampleString;
    }
}
