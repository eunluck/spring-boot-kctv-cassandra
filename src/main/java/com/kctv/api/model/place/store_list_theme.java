package com.kctv.api.model.place;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


@Table
@Data
public class store_list_theme {

    @PrimaryKeyColumn(value = "theme_id",type = PrimaryKeyType.PARTITIONED,ordinal = 0)
    private String theme_id;
    @PrimaryKeyColumn(value = "store_id",type = PrimaryKeyType.CLUSTERED,ordinal = 1)
    private String store_id;
    @Column("create_date")
    private String create_date;
    @Column("store_category")
    private String store_category;
    @Column("store_description")
    private String store_description;
    @Column("store_name")
    private String store_name;
    @Column("theme_value")
    private String theme_value;

}
