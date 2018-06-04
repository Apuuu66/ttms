package com.kevin.pojo;

public class Studio {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column studio.studio_id
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    private Integer studioId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column studio.studio_name
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    private String studioName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column studio.studio_row_count
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    private Integer studioRowCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column studio.studio_col_count
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    private Integer studioColCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column studio.studio_introduction
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    private String studioIntroduction;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column studio.studio_flag
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    private Short studioFlag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column studio.studio_id
     *
     * @return the value of studio.studio_id
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    public Integer getStudioId() {
        return studioId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column studio.studio_id
     *
     * @param studioId the value for studio.studio_id
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column studio.studio_name
     *
     * @return the value of studio.studio_name
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    public String getStudioName() {
        return studioName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column studio.studio_name
     *
     * @param studioName the value for studio.studio_name
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    public void setStudioName(String studioName) {
        this.studioName = studioName == null ? null : studioName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column studio.studio_row_count
     *
     * @return the value of studio.studio_row_count
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    public Integer getStudioRowCount() {
        return studioRowCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column studio.studio_row_count
     *
     * @param studioRowCount the value for studio.studio_row_count
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    public void setStudioRowCount(Integer studioRowCount) {
        this.studioRowCount = studioRowCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column studio.studio_col_count
     *
     * @return the value of studio.studio_col_count
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    public Integer getStudioColCount() {
        return studioColCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column studio.studio_col_count
     *
     * @param studioColCount the value for studio.studio_col_count
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    public void setStudioColCount(Integer studioColCount) {
        this.studioColCount = studioColCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column studio.studio_introduction
     *
     * @return the value of studio.studio_introduction
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    public String getStudioIntroduction() {
        return studioIntroduction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column studio.studio_introduction
     *
     * @param studioIntroduction the value for studio.studio_introduction
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    public void setStudioIntroduction(String studioIntroduction) {
        this.studioIntroduction = studioIntroduction == null ? null : studioIntroduction.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column studio.studio_flag
     *
     * @return the value of studio.studio_flag
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    public Short getStudioFlag() {
        return studioFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column studio.studio_flag
     *
     * @param studioFlag the value for studio.studio_flag
     *
     * @mbg.generated Mon Jun 04 11:43:39 CST 2018
     */
    public void setStudioFlag(Short studioFlag) {
        this.studioFlag = studioFlag;
    }
}