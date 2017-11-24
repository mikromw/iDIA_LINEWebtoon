package com.example.user.pmdproject;

public enum Model_Object_Fav {

    RECENTS(R.string.terbaru, R.layout.recents),
    SUBSCRIBED(R.string.webtoon_favorit, R.layout.subscribed),
    DOWNLOADS(R.string.unduhan, R.layout.downloads),
    COMMENTS(R.string.komentar, R.layout.comments);

    private int mTitleResId;
    private int mLayoutResId;

    Model_Object_Fav(int titleResId, int layoutResId){
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }
    public int getLayoutResId() {
        return mLayoutResId;
    }
}