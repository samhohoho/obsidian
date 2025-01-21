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

```sql
<insert id="insertMany" parameterType="com.eroses.external.society.model.societyLiquidation.SocietyLiquidationAsset" keyProperty="id" useGeneratedKeys="true">
    INSERT INTO
    <include refid="tb"/>
    (<include refid="insertCols"/>)
    VALUES
    <foreach collection="list" separator="," item="asset">
        (<include refid="insertManyVals"/>)
    </foreach>
</insert>
```
```sql
<select id="getLiquidationFeedbackPaging" parameterType="map" resultMap="FeedbackPaging">
    SELECT
        l.id AS liquidation_id,
        l.transfer_date,
        l.submission_date,
        r.decision_date,
        l.application_status_code,
        sc.name AS committee_name
    FROM society_committee sc
    JOIN liquidation l ON l.society_id = sc.society_id
    LEFT JOIN ro_liquidation_approval r ON l.id = r.liquidation_id
    <where>
        sc.identification_no = #{identificationNo}
        <if test="committeeName != null">
            <bind name="wildcardCommitteeName" value="'%' + committeeName + '%'" />
            AND sc.name LIKE #{wildcardCommitteeName}
        </if>
    </where>
    ORDER BY
    <foreach item="value" index="key" collection="filters" separator=",">
        <if test="value != null">
            ${key} ${value}
        </if>
    </foreach>
    LIMIT #{offset}, #{limit}
</select>
```
```sql
<select id="getLiquidationFeedbackPaging" parameterType="map" resultMap="FeedbackPaging">
    SELECT
        l.id AS liquidation_id,
        l.transfer_date,
        l.submission_date,
        l.modified_date,
        CASE
            WHEN (l.application_status_code = 3 OR l.application_status_code = 4)
            THEN l.modified_date
            ELSE NULL
        END AS decision_date,
        l.application_status_code,
        sc.name AS secretary_name,
        lf.feedback,
        (#{identificationNo} = sc.identification_no) AS is_secretary
    FROM liquidation l
    JOIN society_committee sc ON (sc.society_id = l.society_id AND sc.designation_code = #{secretaryDesignationCode})
    LEFT JOIN liquidation_feedback lf ON (lf.liquidation_id = l.id AND lf.ic_no = #{identificationNo})
    <where>
        <if test="committeeName != null">
            <bind name="wildcardCommitteeName" value="'%' + committeeName + '%'" />
            AND sc.name LIKE #{wildcardCommitteeName}
        </if>
    </where>
    ORDER BY
    <foreach item="value" index="key" collection="filters" separator=",">
        <if test="value != null">
            ${key} ${value}
        </if>
    </foreach>
    LIMIT #{offset}, #{limit}
</select>
```
