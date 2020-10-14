package com.kctv.api.model.place;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "store_theme")
public class ThemeEntity {

    @PrimaryKeyColumn(value = "theme_id",type = PrimaryKeyType.PARTITIONED,ordinal = 0)
    private String themeId;
    @Column("create_date")
    private String createDate;
    @Column("theme_thumbnail")
    private String themeThumbnail;
    @Column("theme_value")
    private String themeValue;


}
