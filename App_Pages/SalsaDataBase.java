package com.zybooks.testworldsalsa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.time.LocalDateTime;
import java.util.ArrayList;

/** creates the salsa database */
public class SalsaDataBase extends SQLiteOpenHelper {

    public SalsaDataBase(Context context) {
        super(context, "SalsaDataBase.db", null, 1);
    }

    // user object for logged in person
     private static UsersObject loggedin;
    // function to get user logged in
     public static UsersObject getloggedin() {    return loggedin;}

    public  static UsersObject loggedOut() {
        loggedin = null;
         return null;
     }


    /**
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table  users2 (id integer primary key autoincrement, name text, email text, state  text, " +
                "continent text, city text, createDate datetime, updateDate datetime, username text, password text, informed INT)");

        db.execSQL("CREATE TABLE workshops ( id integer primary key autoincrement, " +
                "instructorID int, name text, type text, venue  text, showDate datetime)");

        db.execSQL("CREATE TABLE assignedworkshops ( id integer primary key autoincrement, " +
                "workshop_id int, userID int, name text, email text, showDate datetime, createDate datetime)");

        db.execSQL("CREATE TABLE competition ( id integer primary key autoincrement,  leveltype text, danceType  text, showDate datetime)");

        db.execSQL("CREATE TABLE competitionkids ( id integer primary key autoincrement, age text, type text, showDate datetime)");

        db.execSQL("CREATE TABLE assignedcompetitions ( id integer primary key autoincrement, competition_id int, userID, name text, partnersName text, phoneNumber text, email text, showDate datetime, createDate datetime)");

        db.execSQL("CREATE TABLE assignedKidscompetitions ( id integer primary key autoincrement, competition_id int, userID, name text, parentsName text, phoneNumber text, email text, showDate datetime, createDate datetime)");

        db.execSQL("CREATE TABLE tickets ( id integer primary key autoincrement, " + "name text, email text, userid int, createDate datetime, type INT)");

        db.execSQL("CREATE TABLE ticketType ( id integer primary key autoincrement, " + "name text)");

        db.execSQL("CREATE TABLE vendor_sponsor ( id integer primary key autoincrement, name text, phoneNumber text, email  text, business text, type text)");

        db.execSQL("CREATE TABLE singers ( id integer primary key autoincrement, name text, venue text, showDate datetime)");


        /** set the instructors database */
        //     db = this.getWritableDatabase();
        String[] instructors = {"Elena La Candela", "Ana Rodriguez", "Fausto Felix", "Bersy Cortez", "Tito y Tamara"};
        int number = 4;
        int day = 28;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < instructors.length; ++j) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("instructorID", number);
                contentValues.put("name", instructors[j]);
                contentValues.put("type", "Salsa");
                contentValues.put("venue", "main room");
                contentValues.put("showDate", "07/" + day + "/2023 08:00");

                db.insert("workshops", null, contentValues);
                number = number + 1;
            }
            day = day + 1;
        }

        /** set the singers database */
        String[] singers = {"Oscar de Leon", "Victor Manuel", "La Maxima 79"};
        int day2 = 28;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < singers.length; ++j) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", singers[j]);
                contentValues.put("venue", "main room");
                contentValues.put("showDate", "07/" + day2 + "/2023 08:00");

                db.insert("singers", null, contentValues);
            }
            day2 = day2 + 1;
        }

        /** set the ticket database */
        String[] ticketType = {"Saturday VIP", "Saturday", "Full Pass"};

        for (int j = 0; j < ticketType.length; ++j) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", ticketType[j]);
            db.insert("ticketType", null, contentValues);
        }


        /** set the competition databse */
        String dancetype = "salsa";
        String[] competition = {"Professional", "Amateur", "Pro/Am"};
        for (int i = 0; i < 4; ++i) {
            if (i == 1) {
                dancetype = "bachata";
            } else if (i >= 2) {
                dancetype = "chacha";
            }
            for (int j = 0; j < competition.length; ++j) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("leveltype", competition[j]);
                contentValues.put("danceType", dancetype);
                contentValues.put("showDate", "07/29/2023 08:00");

                db.insert("competition", null, contentValues);
            }
        }


        /** set the kids competition databse */
        String[] kids = {"17 and under", "12 and under", "8 and under"};
        for (int j = 0; j < kids.length; ++j) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("age", kids[j]);
            contentValues.put("type", "salsa");
            contentValues.put("showDate", "07/29/2023 08:00");

            db.insert("competitionkids", null, contentValues);
        }


    }

    /**
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users2");
        db.execSQL("drop table if exists workshops");
        db.execSQL("drop table if exists assignedworkshops");
        db.execSQL("drop table if exists competition");
        db.execSQL("drop table if exists competitionkids");
        db.execSQL("drop table if exists assignedcompetitions");
        db.execSQL("drop table if exists vendor_sponsor");
        db.execSQL("drop table if exists singers");
        db.execSQL("drop table if exists assignedKidscompetitions");
        db.execSQL("drop table if exists tickets");
        db.execSQL("drop table if exists ticketType");
        onCreate(db);
    }


    /** add new users to the database
     *
     * @param name users
     * @param email user
     * @param state user
     * @param continent a user
     * @param city users
     * @param createDate user
     * @param updateDate user
     * @param username user
     * @param password a user
     * @param informed users
     * @return a user
     */
    public long addUser(String name, String email, String state, String continent, String city, LocalDateTime createDate,
                        LocalDateTime updateDate, String username, String password, String informed) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("state", state);
        contentValues.put("continent", continent);
        contentValues.put("city", city);
        contentValues.put("createDate", String.valueOf(createDate));
        contentValues.put("updateDate", String.valueOf(updateDate));
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("informed", informed);
        long salsaID = db.insert("users2", null, contentValues);

        String[] args = {username, password};
        String name2;

        Cursor cursor = db.rawQuery("select id, name, email, username, password from users2 where username = ? and password = ?", args);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name3 = cursor.getString(1);
            String email3 = cursor.getString(2);
            String username3 = cursor.getString(3);
            String password3 = cursor.getString(4);

            loggedin = new UsersObject(id, name3, email3, username3, password3);
        }

        return salsaID;
    }

    /**add tickets that you bought
     *
     * @param name tickets
     * @param email tickets
     * @param userid tickets
     * @param createDate tickets
     * @param type tickets
     * @return tickets
     */
    public long addTickets(String name, String email, int userid, LocalDateTime createDate, int type) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("userid", userid);
        contentValues.put("createDate", String.valueOf(createDate));
        contentValues.put("type", type);

        long salsaID = db.insert("tickets", null, contentValues);

        return salsaID;
    }

    /**
     *  become a vendor sponsor
     * @param name vendor
     * @param phoneNumber vendor
     * @param email vendor
     * @param business sponsor
     * @param type sponsor
     * @return vendor sponsor
     */
    public long addVendorSponsors(String name, String phoneNumber, String email, String business, String type) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("type", type);
        contentValues.put("phoneNumber", phoneNumber);
        contentValues.put("business", business);

        long salsaID = db.insert("vendor_sponsor", null, contentValues);

        return salsaID;
    }

    /** competitions that you bought
     *
     * @param competition_id bought
     * @param userID competitions
     * @param name bought
     * @param partnersName bought
     * @param phoneNumber bought
     * @param email bought
     * @param showDate bought
     * @param createDate bought
     * @return competitions
     */
    public long addCompetitions(int competition_id, int userID, String name, String partnersName, String phoneNumber, String email, LocalDateTime showDate, LocalDateTime createDate) {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("competition_id", competition_id);
        contentValues.put("userID", userID);
        contentValues.put("name", name);
        contentValues.put("partnersName", partnersName);
        contentValues.put("phoneNumber", phoneNumber);
        contentValues.put("email", email);
        contentValues.put("showDate", String.valueOf(showDate));
        contentValues.put("createDate", String.valueOf(createDate));

        long salsaID = database.insert("assignedcompetitions", null, contentValues);
        return salsaID;
    }

    /** kids competition that you bought
     *
     * @param competition_id kids
     * @param userID kids
     * @param name kids
     * @param parentsName kids
     * @param phoneNumber kids
     * @param email kids
     * @param showDate kids
     * @param createDate kids
     * @return kids
     */
    public long addKidsCompetitions(int competition_id, int userID, String name, String parentsName, String phoneNumber, String email, LocalDateTime showDate, LocalDateTime createDate) {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("competition_id", competition_id);
        contentValues.put("userID", userID);
        contentValues.put("name", name);
        contentValues.put("parentsName", parentsName);
        contentValues.put("phoneNumber", phoneNumber);
        contentValues.put("email", email);
        contentValues.put("showDate", String.valueOf(showDate));
        contentValues.put("createDate", String.valueOf(createDate));

        long salsaID = database.insert("assignedKidscompetitions", null, contentValues);
        return salsaID;
    }


    /**you bought a workshop
     *
     * @param workshop_id bought
     * @param userID bought
     * @param name bought
     * @param email bought
     * @param showDate bought
     * @param createDate bought
     * @return bought workshops
     */
    public long addworkshops(int workshop_id, int userID, String name, String email, LocalDateTime showDate, LocalDateTime createDate) {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("workshop_id", workshop_id);
        contentValues.put("userID", userID);
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("showDate", String.valueOf(showDate));
        contentValues.put("createDate", String.valueOf(createDate));

        long salsaID = database.insert("assignedworkshops", null, contentValues);
        return salsaID;
    }

    /**
     * what type of workshop you have
     * @param workshopID workshop
     * @return workshop
     */
    public Cursor readWorkshops(int workshopID) {

        SQLiteDatabase dataBase = this.getReadableDatabase();
        String[] args = {String.valueOf(workshopID)};

        Cursor cursor = dataBase.rawQuery("select name, type from workshops where id = ?", args);

        return cursor;
    }


    /**
     * get the workshops you bought
     * @param userid workshops
     * @return workshops
     */
    public Cursor readAssignedWorkshops(int userid) {

        SQLiteDatabase dataBase = this.getReadableDatabase();
        String[] args = {String.valueOf(userid)};

        Cursor cursor = dataBase.rawQuery("select workshop_id from assignedworkshops where userID = ?", args);

        return cursor;
    }

    /**
     * get your bought tickets
     * @param userid tickets
     * @return tickets
     */
    public Cursor readAssignedTickets(int userid) {

        SQLiteDatabase dataBase = this.getReadableDatabase();
        String[] args = {String.valueOf(userid)};

        Cursor cursor = dataBase.rawQuery("select type, createDate from tickets where userID = ?", args);

        return cursor;
    }

    /**
     * read the tickets bought
     * @param ticketID tickets
     * @return tickets
     */
    public Cursor readTicketType(int ticketID) {

        SQLiteDatabase dataBase = this.getReadableDatabase();
        String[] args = {String.valueOf(ticketID)};

        Cursor cursor = dataBase.rawQuery("select name from ticketType where id = ?", args);

        return cursor;
    }

    /**
     * get correct username password
     * @param username correct
     * @param password correct
     * @return correct
     */
    public Boolean readLogIn(String username, String password) {

        SQLiteDatabase dataBase = this.getReadableDatabase();
        String[] args = {username, password};

        Cursor cursor = dataBase.rawQuery("select id, name, email, username, password from users2 where username = ? and password = ?", args);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name3 = cursor.getString(1);
            String email3 = cursor.getString(2);
            String username3 = cursor.getString(3);
            String password3 = cursor.getString(4);

            loggedin = new UsersObject(id, name3, email3, username3, password3);
        }

        if (cursor.getCount() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * get id to use for profile
     * @param username correct
     * @param password correct
     * @return correct
     */
    public Cursor readLogIn2(String username, String password) {

        SQLiteDatabase dataBase = this.getReadableDatabase();
        String[] args = {username, password};

        Cursor cursor = dataBase.rawQuery("select id from users2 where username = ? and password = ?", args);
            return cursor;
    }


    /**
     * get profile page information
     * @param username correct
     * @param password correct
     * @return correct
     */
    public Cursor readProfile(String username, String password) {

        SQLiteDatabase dataBase = this.getReadableDatabase();
        String[] args = {username, password};

        Cursor cursor = dataBase.rawQuery("select name, email, state, city, continent from users2 where username = ? and password = ?", args);

        return cursor;

    }

    /**
     * update username password
     * @param updateDate update
     * @param username update
     * @param password update
     * @return update
     */
    public int updateLogIn(LocalDateTime updateDate, String username, String password) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("updateDate", String.valueOf(updateDate));

        /** generic userid */
        String[] strings = {"1"};
        int updateerows = db.update("users2", contentValues, "id = ?", strings);
        return updateerows;
    }

    /**
     * delete bought workshop
     * @param userid delete
     * @return delete
     */
    public int deleteAssignedWorkshop(int userid) {
        SQLiteDatabase db = this.getWritableDatabase();
            String[] strings = {String.valueOf(userid)};
        int   deleterows = db.delete("assignedworkshops", "userID = ?", strings);
        return deleterows;
    }

}