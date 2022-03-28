package com.fc.entity;

import java.util.ArrayList;
import java.util.List;

public class TbMusicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbMusicExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMusicIdIsNull() {
            addCriterion("music_id is null");
            return (Criteria) this;
        }

        public Criteria andMusicIdIsNotNull() {
            addCriterion("music_id is not null");
            return (Criteria) this;
        }

        public Criteria andMusicIdEqualTo(Integer value) {
            addCriterion("music_id =", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdNotEqualTo(Integer value) {
            addCriterion("music_id <>", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdGreaterThan(Integer value) {
            addCriterion("music_id >", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("music_id >=", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdLessThan(Integer value) {
            addCriterion("music_id <", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdLessThanOrEqualTo(Integer value) {
            addCriterion("music_id <=", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdIn(List<Integer> values) {
            addCriterion("music_id in", values, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdNotIn(List<Integer> values) {
            addCriterion("music_id not in", values, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdBetween(Integer value1, Integer value2) {
            addCriterion("music_id between", value1, value2, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("music_id not between", value1, value2, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicNameIsNull() {
            addCriterion("music_name is null");
            return (Criteria) this;
        }

        public Criteria andMusicNameIsNotNull() {
            addCriterion("music_name is not null");
            return (Criteria) this;
        }

        public Criteria andMusicNameEqualTo(String value) {
            addCriterion("music_name =", value, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameNotEqualTo(String value) {
            addCriterion("music_name <>", value, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameGreaterThan(String value) {
            addCriterion("music_name >", value, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameGreaterThanOrEqualTo(String value) {
            addCriterion("music_name >=", value, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameLessThan(String value) {
            addCriterion("music_name <", value, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameLessThanOrEqualTo(String value) {
            addCriterion("music_name <=", value, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameLike(String value) {
            addCriterion("music_name like", value, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameNotLike(String value) {
            addCriterion("music_name not like", value, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameIn(List<String> values) {
            addCriterion("music_name in", values, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameNotIn(List<String> values) {
            addCriterion("music_name not in", values, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameBetween(String value1, String value2) {
            addCriterion("music_name between", value1, value2, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicNameNotBetween(String value1, String value2) {
            addCriterion("music_name not between", value1, value2, "musicName");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumNameIsNull() {
            addCriterion("music_album_name is null");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumNameIsNotNull() {
            addCriterion("music_album_name is not null");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumNameEqualTo(String value) {
            addCriterion("music_album_name =", value, "musicAlbumName");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumNameNotEqualTo(String value) {
            addCriterion("music_album_name <>", value, "musicAlbumName");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumNameGreaterThan(String value) {
            addCriterion("music_album_name >", value, "musicAlbumName");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumNameGreaterThanOrEqualTo(String value) {
            addCriterion("music_album_name >=", value, "musicAlbumName");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumNameLessThan(String value) {
            addCriterion("music_album_name <", value, "musicAlbumName");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumNameLessThanOrEqualTo(String value) {
            addCriterion("music_album_name <=", value, "musicAlbumName");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumNameLike(String value) {
            addCriterion("music_album_name like", value, "musicAlbumName");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumNameNotLike(String value) {
            addCriterion("music_album_name not like", value, "musicAlbumName");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumNameIn(List<String> values) {
            addCriterion("music_album_name in", values, "musicAlbumName");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumNameNotIn(List<String> values) {
            addCriterion("music_album_name not in", values, "musicAlbumName");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumNameBetween(String value1, String value2) {
            addCriterion("music_album_name between", value1, value2, "musicAlbumName");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumNameNotBetween(String value1, String value2) {
            addCriterion("music_album_name not between", value1, value2, "musicAlbumName");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumPicUrlIsNull() {
            addCriterion("music_album_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumPicUrlIsNotNull() {
            addCriterion("music_album_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumPicUrlEqualTo(String value) {
            addCriterion("music_album_pic_url =", value, "musicAlbumPicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumPicUrlNotEqualTo(String value) {
            addCriterion("music_album_pic_url <>", value, "musicAlbumPicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumPicUrlGreaterThan(String value) {
            addCriterion("music_album_pic_url >", value, "musicAlbumPicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("music_album_pic_url >=", value, "musicAlbumPicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumPicUrlLessThan(String value) {
            addCriterion("music_album_pic_url <", value, "musicAlbumPicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumPicUrlLessThanOrEqualTo(String value) {
            addCriterion("music_album_pic_url <=", value, "musicAlbumPicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumPicUrlLike(String value) {
            addCriterion("music_album_pic_url like", value, "musicAlbumPicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumPicUrlNotLike(String value) {
            addCriterion("music_album_pic_url not like", value, "musicAlbumPicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumPicUrlIn(List<String> values) {
            addCriterion("music_album_pic_url in", values, "musicAlbumPicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumPicUrlNotIn(List<String> values) {
            addCriterion("music_album_pic_url not in", values, "musicAlbumPicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumPicUrlBetween(String value1, String value2) {
            addCriterion("music_album_pic_url between", value1, value2, "musicAlbumPicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicAlbumPicUrlNotBetween(String value1, String value2) {
            addCriterion("music_album_pic_url not between", value1, value2, "musicAlbumPicUrl");
            return (Criteria) this;
        }

        public Criteria andMusicMp3UrlIsNull() {
            addCriterion("music_mp3_url is null");
            return (Criteria) this;
        }

        public Criteria andMusicMp3UrlIsNotNull() {
            addCriterion("music_mp3_url is not null");
            return (Criteria) this;
        }

        public Criteria andMusicMp3UrlEqualTo(String value) {
            addCriterion("music_mp3_url =", value, "musicMp3Url");
            return (Criteria) this;
        }

        public Criteria andMusicMp3UrlNotEqualTo(String value) {
            addCriterion("music_mp3_url <>", value, "musicMp3Url");
            return (Criteria) this;
        }

        public Criteria andMusicMp3UrlGreaterThan(String value) {
            addCriterion("music_mp3_url >", value, "musicMp3Url");
            return (Criteria) this;
        }

        public Criteria andMusicMp3UrlGreaterThanOrEqualTo(String value) {
            addCriterion("music_mp3_url >=", value, "musicMp3Url");
            return (Criteria) this;
        }

        public Criteria andMusicMp3UrlLessThan(String value) {
            addCriterion("music_mp3_url <", value, "musicMp3Url");
            return (Criteria) this;
        }

        public Criteria andMusicMp3UrlLessThanOrEqualTo(String value) {
            addCriterion("music_mp3_url <=", value, "musicMp3Url");
            return (Criteria) this;
        }

        public Criteria andMusicMp3UrlLike(String value) {
            addCriterion("music_mp3_url like", value, "musicMp3Url");
            return (Criteria) this;
        }

        public Criteria andMusicMp3UrlNotLike(String value) {
            addCriterion("music_mp3_url not like", value, "musicMp3Url");
            return (Criteria) this;
        }

        public Criteria andMusicMp3UrlIn(List<String> values) {
            addCriterion("music_mp3_url in", values, "musicMp3Url");
            return (Criteria) this;
        }

        public Criteria andMusicMp3UrlNotIn(List<String> values) {
            addCriterion("music_mp3_url not in", values, "musicMp3Url");
            return (Criteria) this;
        }

        public Criteria andMusicMp3UrlBetween(String value1, String value2) {
            addCriterion("music_mp3_url between", value1, value2, "musicMp3Url");
            return (Criteria) this;
        }

        public Criteria andMusicMp3UrlNotBetween(String value1, String value2) {
            addCriterion("music_mp3_url not between", value1, value2, "musicMp3Url");
            return (Criteria) this;
        }

        public Criteria andMusicArtistNameIsNull() {
            addCriterion("music_artist_name is null");
            return (Criteria) this;
        }

        public Criteria andMusicArtistNameIsNotNull() {
            addCriterion("music_artist_name is not null");
            return (Criteria) this;
        }

        public Criteria andMusicArtistNameEqualTo(String value) {
            addCriterion("music_artist_name =", value, "musicArtistName");
            return (Criteria) this;
        }

        public Criteria andMusicArtistNameNotEqualTo(String value) {
            addCriterion("music_artist_name <>", value, "musicArtistName");
            return (Criteria) this;
        }

        public Criteria andMusicArtistNameGreaterThan(String value) {
            addCriterion("music_artist_name >", value, "musicArtistName");
            return (Criteria) this;
        }

        public Criteria andMusicArtistNameGreaterThanOrEqualTo(String value) {
            addCriterion("music_artist_name >=", value, "musicArtistName");
            return (Criteria) this;
        }

        public Criteria andMusicArtistNameLessThan(String value) {
            addCriterion("music_artist_name <", value, "musicArtistName");
            return (Criteria) this;
        }

        public Criteria andMusicArtistNameLessThanOrEqualTo(String value) {
            addCriterion("music_artist_name <=", value, "musicArtistName");
            return (Criteria) this;
        }

        public Criteria andMusicArtistNameLike(String value) {
            addCriterion("music_artist_name like", value, "musicArtistName");
            return (Criteria) this;
        }

        public Criteria andMusicArtistNameNotLike(String value) {
            addCriterion("music_artist_name not like", value, "musicArtistName");
            return (Criteria) this;
        }

        public Criteria andMusicArtistNameIn(List<String> values) {
            addCriterion("music_artist_name in", values, "musicArtistName");
            return (Criteria) this;
        }

        public Criteria andMusicArtistNameNotIn(List<String> values) {
            addCriterion("music_artist_name not in", values, "musicArtistName");
            return (Criteria) this;
        }

        public Criteria andMusicArtistNameBetween(String value1, String value2) {
            addCriterion("music_artist_name between", value1, value2, "musicArtistName");
            return (Criteria) this;
        }

        public Criteria andMusicArtistNameNotBetween(String value1, String value2) {
            addCriterion("music_artist_name not between", value1, value2, "musicArtistName");
            return (Criteria) this;
        }

        public Criteria andSheetIdIsNull() {
            addCriterion("sheet_id is null");
            return (Criteria) this;
        }

        public Criteria andSheetIdIsNotNull() {
            addCriterion("sheet_id is not null");
            return (Criteria) this;
        }

        public Criteria andSheetIdEqualTo(Integer value) {
            addCriterion("sheet_id =", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdNotEqualTo(Integer value) {
            addCriterion("sheet_id <>", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdGreaterThan(Integer value) {
            addCriterion("sheet_id >", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sheet_id >=", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdLessThan(Integer value) {
            addCriterion("sheet_id <", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdLessThanOrEqualTo(Integer value) {
            addCriterion("sheet_id <=", value, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdIn(List<Integer> values) {
            addCriterion("sheet_id in", values, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdNotIn(List<Integer> values) {
            addCriterion("sheet_id not in", values, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdBetween(Integer value1, Integer value2) {
            addCriterion("sheet_id between", value1, value2, "sheetId");
            return (Criteria) this;
        }

        public Criteria andSheetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sheet_id not between", value1, value2, "sheetId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}