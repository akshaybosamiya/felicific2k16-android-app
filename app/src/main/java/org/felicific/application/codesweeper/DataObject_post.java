package org.felicific.application.codesweeper;

/**
 * Created by Jai on 08-Nov-15.
 */

public class DataObject_post {
    private String mDate;
    private String mTitle;
    private String mFees;
    private String mteam;
    private String mContact;
    private String mDescription;
    private String mRules;
    
    DataObject_post(String date, String title, String fees,String team,String contact,String desc,String rules){
        mDate = date;
        mTitle = title;
        mFees = fees;
        mteam=team;
        mContact = contact;
        mDescription=desc;
        mRules=rules;

    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmFees() {
        return mFees;
    }

    public void setmFees(String mFees) {
        this.mFees = mFees;
    }

    public String getmteam() {
        return mteam;
    }

    public void setmteam(String mteam) {
        this.mteam = mteam;
    }

    public String getmContact() {
        return mContact;
    }

    public void setmContact(String mContact) {
        this.mContact = mContact;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmRules() {
        return mRules;
    }

    public void setmRules(String mRules) {
        this.mRules = mRules;
    }


}