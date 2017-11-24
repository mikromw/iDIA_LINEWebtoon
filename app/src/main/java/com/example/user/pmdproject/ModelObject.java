package com.example.user.pmdproject;

public enum ModelObject {

    MONDAY(R.string.senin, R.layout.monday),
    TUESDAY(R.string.selasa, R.layout.tuesday),
    WEDNESDAY(R.string.rabu, R.layout.wednesday),
    THURSDAY(R.string.kamis, R.layout.thursday),
    FRIDAY(R.string.jumat, R.layout.friday),
    SATURDAY(R.string.sabtu, R.layout.saturday),
    SUNDAY(R.string.minggu, R.layout.sunday),
    COMPLETED(R.string.episode_lengkap, R.layout.completed);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId){
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
