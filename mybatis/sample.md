---
id: sample
aliases: []
tags: []
---
```
<select id="getPaging" parameterType="map" resultMap="PagingMap">
    SELECT
    l.id,
    s.society_name,
    l.ro,
    l.transfer_date,
    l.submission_date,
    l.society_no,
    s.state_code,
    l.application_status_code
    FROM liquidation l
    JOIN society s ON l.society_id = s.id
    WHERE
    s.state_code = #{stateCode}
    AND l.application_status_code = 2
    <if test="categoryCode != null">
        AND s.category_code_jppm = #{categoryCode}
    </if>
    <if test="subCategoryCode != null">
        AND s.sub_category_code = #{subCategoryCode}
    </if>
    <if test="societyName != null">
        <bind name="wildcardName" value="'%' + societyName + '%'" />
        AND s.society_name LIKE #{wildcardName}
    </if>
    LIMIT #{offset}, #{limit}
</select>
```
