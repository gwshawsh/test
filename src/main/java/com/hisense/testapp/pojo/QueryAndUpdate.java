package com.hisense.testapp.pojo;
/*
* hxh
* today
*/

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;

@Getter
@Setter
public class QueryAndUpdate {

    public Query query;
    public Update update;
}

